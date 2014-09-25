package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Language extends DBObject
{
	public String name;
	public String persPron;
	public static final DBObject.TableInfo tableInfo = new DBObject.TableInfo(
		"Languages",
			new String[] {
				"ID,       CHAR(2)      NOT NULL",
				"Name,     VARCHAR(128) NOT NULL",
				"PersPron, VARCHAR(128) NOT NULL"
			}, new String[] {});
	
	public Language(Connection con, String id)
	{
		super(con, id);
	}
		
	public static Language createNew(Connection con, String id, String name, String persPron)
	{
		Language lang = null;
		try
		{
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO " + tableInfo.tableName
					+ " VALUES (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, persPron);
			ps.executeUpdate();
			ps.close();
			lang = new Language(con, id);
		}
		catch(SQLException sqle)
		{
			if (sqle.getSQLState().equals("42X05")) // table does not exist
			{
				DBObject.createTable(con, tableInfo);
				return Language.createNew(con, id, name, persPron);
			}
		}
		return lang;
	}

	public String toString()
	{
		return name;
	}
	
	public void fillMembers(ResultSet rs) throws SQLException
	{
		 super.fillMembers(rs);
		 
		 name = rs.getString("Name");
		 persPron = rs.getString("PersPron");
	}
	
	public String getTableName()
	{
		return tableInfo.tableName;
	}
	
	public static Language[] getLanguages(Connection con)
	{
		String[] ids = DBObject.getIDs(con, tableInfo);

		Language[] langs = new Language[ids.length];
		for(int i = 0; i < langs.length; i++)
			langs[i] = new Language(con, ids[i]);
		return langs;
	}
}