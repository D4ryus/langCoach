package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class User extends DBObject
{
	public String name;
	public Timestamp lastLog;
	public int logins;
	public static final DBObject.TableInfo tableInfo = new DBObject.TableInfo(
		"Users",
			new String[] {
				"ID,       INT          GENERATED ALWAYS AS IDENTITY",
				"Name,     VARCHAR(128) NOT NULL",
				"LastLog,  TIMESTAMP",
				"Logins,   INT"
			}, new String[] {
			});

	public User(Connection con, String id)
	{
		super(con, id);
	}

	public static User createNew(Connection con, String name)
	{
		User user = null;
		try
		{
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO " + tableInfo.tableName
					+ " (Name, LastLog, Logins) VALUES (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			ps.setTimestamp(2, null);
			ps.setInt(3, 0);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			user = new User(con, rs.getString(1));
			ps.close();
		}
		catch (Exception e)
		{
			System.out.println("could not insert into User, exception occured: " + e);
		}
		return user;
	}

	public String toString()
	{
		return name;
	}

	public void fillMembers(ResultSet rs) throws SQLException
	{
		 super.fillMembers(rs);

		 name = rs.getString("Name");
		 lastLog = rs.getTimestamp("LastLog");
		 logins = rs.getInt("Logins");
	}

	public PreparedStatement getUpdateStmt() throws SQLException
	{
		PreparedStatement ps = con.prepareStatement(
			"UPDATE " + getTableName() + " SET " +
				"Name = ? , "    +
		        "LastLog = ? , " +
				"Logins = ? "    +
			    "WHERE ID = ?"
			   );
		ps.setString(1, name);
		ps.setTimestamp(2, lastLog);
		ps.setInt(3, logins);
		ps.setString(4, getID());
		return ps;
	}

	public String getTableName()
	{
		return tableInfo.tableName;
	}

	public static User getLatest(Connection con)
	{
		User user = null;
		try
		{
			ResultSet result = con.createStatement().executeQuery(
					"SELECT ID FROM " + tableInfo.tableName + " ORDER BY LastLog DESC { LIMIT 1 }");

			result.next();
			user = new User(con, result.getString(1));

			result.close();
		}
		catch(SQLException sqle)
		{
			if (sqle.getSQLState().equals("42X05")) // table does not exist
				DBObject.createTable(con, tableInfo);
		}

		return user;
	}

	public static User[] getUsers(Connection con)
	{
		String[] ids = DBObject.getIDs(con, tableInfo);

		User[] users = new User[ids.length];
		for(int i = 0; i < users.length; i++)
			users[i] = new User(con, ids[i]);
		return users;
	}
}
