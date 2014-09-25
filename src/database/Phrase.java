package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Phrase extends DBObject
{
	public int dic;
	public boolean conjug;
	public String phrase1;
	public String phrase2;
	public User user;
	public CorePhrase core;
	public Performance perf;
	public static final DBObject.TableInfo tableInfo = new DBObject.TableInfo(
			"Phrases",
				new String[] {
					"ID,      INT          GENERATED ALWAYS AS IDENTITY, ",
					"Dic,     INT          NOT NULL, ",
					"Conjug,  BOOLEAN      NOT NULL, ",
					"Phrase1, VARCHAR(512) NOT NULL, ",
					"Phrase2, VARCHAR(512) NOT NULL, "
				}, new String[] {
					"Dic, Dictionaries"
				});

	public Phrase(Connection con, CorePhrase core, User user)
	{
		super(con, String.valueOf(core.id));
		this.core = core;
		this.user = user;

		if (core.perfID == 0)
			this.perf = Performance.createNew(con, Integer.parseInt(user.getID()), core.id);
		else
			this.perf = new Performance(con, new Integer(core.perfID).toString());

		core.perfID = Integer.parseInt(this.perf.getID());
		core.revPhrase.perfID = core.perfID;
	}

	public Phrase(Connection con, String id)
	{
		super(con, id);
	}

	public static Phrase createNew(Connection con, int dic, boolean conj, String phrase1, String phrase2)
	{
		Phrase phrase = null;
		try
		{
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO " + tableInfo.tableName
					+ " (Dic, Conjug, Phrase1, Phrase2) VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, dic);
			ps.setBoolean(2, conj);
			ps.setString(3, phrase1);
			ps.setString(4, phrase2);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			phrase = new Phrase(con, rs.getString(1));
			ps.close();
		}
		catch(SQLException sqle)
		{
			if (sqle.getSQLState().equals("42X05")) // table does not exist
			{
				DBObject.createTable(con, tableInfo);
				return Phrase.createNew(con, dic, conj, phrase1, phrase2);
			}
		}
		return phrase;
	}

	public static class CorePhrase
	{
		public int id;
		public int perfID;
		public int success;
		public boolean reverse;
		public CorePhrase revPhrase;

		public CorePhrase(int id, int success, int perfID, boolean reverse)
		{
			this.id = id;
			this.success = success;
			this.perfID = perfID;
			this.reverse = reverse;
		}

		public Phrase getFullPhrase(Connection con, User user)
		{
			return new Phrase(con, this, user);
		}
	}

	public void fillMembers(ResultSet rs) throws SQLException
	{
		 super.fillMembers(rs);

		 dic = rs.getInt("Dic");
		 conjug = rs.getBoolean("Conjug");
		 phrase1 = rs.getString("Phrase1");
		 phrase2 = rs.getString("Phrase2");
	}

	public int saveToDB()
	{
		int rows = super.saveToDB();

		if(perf != null)
			perf.saveToDB();
		else
			System.out.println("perf is null on Phrase.saveToDB");

		return rows;
	}

	public void setDict(Dictionary dict)
	{
		this.dict = dict;
	}

	private Dictionary dict = null;
	public Dictionary getDict()
	{
		if (dict == null)
			dict = new Dictionary(con, new Integer(dic).toString());

		return dict;
	}

	public String getTableName()
	{
		return tableInfo.tableName;
	}

	public static CorePhrase[] getPhrases(Connection con, Dictionary dict, User user)
	{
		LinkedList<CorePhrase> data = new LinkedList<CorePhrase>();
		try
		{
			PreparedStatement ps = con.prepareStatement(
					"SELECT Phrases.ID, Success, RevSuccess, Performances.ID " +
					"FROM Phrases " +
					"LEFT OUTER JOIN Performances ON Phrases.ID = Phrase AND UserID = ? " +
					"WHERE Phrases.Dic = ?");

			ps.setString(1, user.getID());
			ps.setString(2, dict.getID());

			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				CorePhrase phrase = new CorePhrase(rs.getInt(1), rs.getInt(2), rs.getInt(4), false);
				CorePhrase revPhrase = new CorePhrase(rs.getInt(1), rs.getInt(3), rs.getInt(4), true);

				phrase.revPhrase = revPhrase;
				revPhrase.revPhrase = phrase;

				data.add(phrase);
				data.add(revPhrase);
			}

			rs.close();
		}
		catch(SQLException sqle)
		{
			if (sqle.getSQLState().equals("42X05")) // table does not exist
			{
				if(sqle.getMessage().contains(Performance.tableInfo.tableName.toUpperCase()))
				{
					DBObject.createTable(con, Performance.tableInfo);
				}
				else if (sqle.getMessage().contains(Phrase.tableInfo.tableName.toUpperCase()))
				{
					DBObject.createTable(con, Phrase.tableInfo);
				}
				else
				{
					System.out.println("MESSAGE: "  + sqle.getMessage());
					System.out.println("ERROR CODE: " + sqle.getSQLState());
				}
			}
		}

		return (CorePhrase[]) data.toArray(new CorePhrase[data.size()]);
	}
}
