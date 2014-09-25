package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class Performance extends DBObject
{
	public int userID;
	public int phrase;
	public int success;
	public int revSuccess;
	public Timestamp lastSuccess;
	public Timestamp revLastSuccess;
	public Timestamp lastFail;
	public Timestamp revLastFail;
	public int max;
	public static final DBObject.TableInfo tableInfo = new DBObject.TableInfo(
		"Performances",
			new String[] {
				"ID,             INT GENERATED ALWAYS AS IDENTITY",
				"UserID,         INT",
				"Phrase,         INT",
				"Success,        INT",
				"RevSuccess,     INT",
				"LastSuccess,    TIMESTAMP",
				"RevLastSuccess, TIMESTAMP",
				"LastFail,       TIMESTAMP",
				"RevLastFail,    TIMESTAMP"
			}, new String[] {
				"UserID, Users",
				"Phrase, Phrases"
		});	
	
	public Performance(Connection con, String id)
	{
		super(con, id);
	}
	
	public static Performance createNew(Connection con, int userID, int phrase)
	{
		Performance perf = null;
		try
		{
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO " + tableInfo.tableName
					+ " (UserID, Phrase, Success, RevSuccess, LastSuccess, RevLastSuccess , LastFail, RevLastFail) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, userID);
			ps.setInt(2, phrase);
			ps.setInt(3, 0);
			ps.setInt(4, 0);
			ps.setTimestamp(5, null);
			ps.setTimestamp(6, null);
			ps.setTimestamp(7, null);
			ps.setTimestamp(8, null);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			perf = new Performance(con, rs.getString(1));
			ps.close();
		}
		catch(SQLException sqle)
		{
			if (sqle.getSQLState().equals("42X05")) // table does not exist
			{
				DBObject.createTable(con, tableInfo);
				return Performance.createNew(con, userID, phrase);
			}
		}
		return perf;
	}

	public void fillMembers(ResultSet rs) throws SQLException
	{
		super.fillMembers(rs);
		
		userID         = rs.getInt("UserID");
		phrase         = rs.getInt("Phrase");
		success        = rs.getInt("Success");
		revSuccess     = rs.getInt("RevSuccess");
		lastSuccess    = rs.getTimestamp("LastSuccess");
		revLastSuccess = rs.getTimestamp("RevLastSuccess");
		lastFail       = rs.getTimestamp("LastFail");
		revLastFail    = rs.getTimestamp("RevLastFail");
	}
	
	public PreparedStatement getUpdateStmt() throws SQLException
	{
		PreparedStatement ps = con.prepareStatement(
			"UPDATE " + getTableName() + " SET " +
		        "Success = ? , "        + 
				"RevSuccess = ? , "     +
				"LastSuccess = ? , "    +
				"RevLastSuccess = ? , " +
				"LastFail = ? , "       +
				"RevLastFail = ? "      +
			    "WHERE UserID = ? AND Phrase = ?"
			   );
		ps.setInt(1, success);
		ps.setInt(2, revSuccess);
		ps.setTimestamp(3, lastSuccess);
		ps.setTimestamp(4, revLastSuccess);
		ps.setTimestamp(5, lastFail);
		ps.setTimestamp(6, revLastFail);
		ps.setInt(7, userID);
		ps.setInt(8, phrase);
		return ps;
	}
	
	private Phrase phraseObj = null;
	public Phrase getPhrase()
	{
		if(phraseObj == null)
			phraseObj = new Phrase(con, new Integer(phrase).toString());
		return phraseObj;
	}
	
	public static Performance getLatest(Connection con)
	{
		Performance perf = null;
		try
		{
			ResultSet result = con.createStatement().executeQuery(
					"SELECT ID FROM " + tableInfo.tableName + " ORDER BY LastFail DESC { LIMIT 1 }");

			result.next();
			perf = new Performance(con, result.getString(1));

			result.close();
		}
		catch(SQLException sqle)
		{
			if (sqle.getSQLState().equals("42X05")) // table does not exist
				DBObject.createTable(con, tableInfo);
		}
		return perf;
	}

	public String getTableName()
	{
		return tableInfo.tableName;
	}
	
	private User user = null;
	public User getUser()
	{
		if(user == null)
			user = new User(con, new Integer(userID).toString());
		return user;
	}
}