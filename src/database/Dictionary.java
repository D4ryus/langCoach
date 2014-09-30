package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dictionary extends DBObject
{

	public String name;
	public String desrc;
	public String lang1;
	public String lang2;
	public static final DBObject.TableInfo tableInfo = new DBObject.TableInfo(
		"Dictionaries",
			new String[] {
				"ID,    INT            GENERATED ALWAYS AS IDENTITY, ",
				"Name,  VARCHAR(128)   NOT NULL, ",
				"Descr, VARCHAR(1024), ",
				"Lang1, CHAR(2)        NOT NULL, ",
				"Lang2, CHAR(2)        NOT NULL, ",
			}, new String[] {
				"Lang1, Languages",
				"Lang2, Languages"
			});

	public Dictionary(Connection con, String id)
	{
		super(con, id);
	}

	public static Dictionary createNew(Connection con, String name, String desc, String lang1, String lang2)
	{
		Dictionary dict = null;
		try
		{
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO " + tableInfo.tableName
					+ " (Name, Descr, Lang1, Lang2) VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			ps.setString(2, desc);
			ps.setString(3, lang1);
			ps.setString(4, lang2);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			dict = new Dictionary(con, rs.getString(1));
			ps.close();
		}
		catch(SQLException sqle)
		{
			if (sqle.getSQLState().equals("42X05")) // table does not exist
			{
				DBObject.createTable(con, tableInfo);
				return Dictionary.createNew(con, name, desc, lang1, lang2);
			}
		}
		return dict;
	}
	
	@Override
	public String toString()
	{
		return name;
	}

	@Override
	public void fillMembers(ResultSet rs) throws SQLException
	{
		 super.fillMembers(rs);

		 name = rs.getString("Name");
		 desrc = rs.getString("Descr");
		 lang1 = rs.getString("Lang1");
		 lang2 = rs.getString("Lang2");
	}

	@Override
	public String getTableName()
	{
		return tableInfo.tableName;
	}

	private Language language1 = null;
	public Language getLanguage1()
	{
		if (language1 == null)
			language1 = new Language(con, this.lang1);

		return language1;
	}

	private Language language2 = null;
	public Language getLanguage2()
	{
		if (language2 == null)
			language2 = new Language(con, this.lang2);

		return language2;
	}

	public static Dictionary[] getDictionaries(Connection con)
	{
		String[] ids = DBObject.getIDs(con, tableInfo);

		Dictionary[] dicts = new Dictionary[ids.length];
		for(int i = 0; i < dicts.length; i++)
			dicts[i] = new Dictionary(con, ids[i]);
		return dicts;
	}

	public static Dictionary getTop(Connection con)
	{
		int ID = 0;
		try
		{
			PreparedStatement ps = con.prepareStatement("SELECT ID FROM " + tableInfo.tableName + " {LIMIT 1} ");

			ResultSet rs = ps.executeQuery();
			rs.next();

			ID = rs.getInt(1);

			rs.close();
		}
		catch (SQLException sqle)
		{
			return null;
		}

		return new Dictionary(con, String.valueOf(ID));
	}
}
