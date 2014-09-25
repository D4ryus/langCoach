package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBObject
{
	protected Connection con;
	private String id;

	public static String dbName = "DB";
	public static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	public static String connectionURL = "jdbc:derby:" + dbName + ";create=true";

	protected DBObject(Connection con, String id)
	{
		this.con = con;
		this.id = id;

		loadFromDB();
	}

	public static boolean createTable(Connection con, TableInfo tableInfo)
	{

		String tableCreate = "CREATE TABLE " + tableInfo.tableName + " ( ";

		for(String i : tableInfo.columns)
		{
			String[] tmp = i.split(",");
			tableCreate += " " + tmp[0] + " " + tmp [1] + " , ";
		}

		for(String i : tableInfo.foreignKeys)
		{
			String[] tmp = i.split(",");
			tableCreate += " FOREIGN KEY (" + tmp[0] + ") REFERENCES  " + tmp [1] + " , ";
		}
		tableCreate += " PRIMARY KEY (ID) )";

		try
		{
			Statement stmt = con.createStatement();
			stmt.execute(tableCreate);
			stmt.close();
		}
		catch (SQLException sqle)
		{
			System.out.println("DBObject createTable(" + tableInfo.tableName + "): "
							 + "Unhandled SQLException, create string:\n"
							 + tableCreate + "\n\n Exception: \n" + sqle + "\n\n");
			return false;
		}
		return true;
	}

	protected static class TableInfo
	{
		public String tableName;
		public String[] columns;
		public String[] foreignKeys;

		public TableInfo(String tableName, String[] columns, String[] foreignKeys)
		{
			this.tableName = tableName;
			this.columns = columns;
			this.foreignKeys = foreignKeys;
		}
	};

	public void fillMembers(ResultSet rs) throws SQLException
	{
		 id = rs.getString("ID");
	}

	public PreparedStatement getSelectStmt() throws SQLException
	{
		PreparedStatement ps = con.prepareStatement("SELECT * FROM " + getTableName() + " WHERE ID = ?");

		ps.setString(1, id);

		return ps;
	}

	public void loadFromDB()
	{
		try
		{
			PreparedStatement ps = getSelectStmt();
			ResultSet rs = ps.executeQuery();

			if (rs.next())
				fillMembers(rs);

			rs.close();
		}
		catch (SQLException sqle)
		{ }
	}

	public PreparedStatement getUpdateStmt() throws SQLException
	{
		System.out.println("call on getUpdateString() in DBObject (not implemented!)");
		return null;
	}

	public int saveToDB()
	{
		int rows = 0;
		try
		{
			PreparedStatement ps = getUpdateStmt();
			rows = ps.executeUpdate();
			ps.close() ;
		}
		catch (SQLException sqle)
		{
			System.out.println("could not update on " + getTableName() + ": " + sqle);
		}
		return rows;
	}

	public static String[] getIDs(Connection con, TableInfo tableInfo)
	{
		ArrayList<String> data = new ArrayList<String>();

		try
		{
			PreparedStatement ps = con.prepareStatement("SELECT ID FROM " + tableInfo.tableName);

			ResultSet rs = ps.executeQuery();

			while (rs.next())
				data.add(rs.getString("ID"));

			rs.close();
		}
		catch (SQLException sqle)
		{
			if (sqle.getSQLState().equals("42X05"))
			{
				System.out.println("Creating table " + tableInfo.tableName);

				createTable(con, tableInfo);
			}
			else
			{
				System.out.println(sqle);
				System.out.println("Incorrect table definition. Drop table "
								+ tableInfo.tableName + " and rerun this program");
				System.exit(0);
			}
		}

		return (String[]) data.toArray(new String[data.size()]);
	}

	public static boolean clearTable(Connection con, TableInfo tableInfo)
	{
		System.out.println("Cleaning " + tableInfo.tableName + " in given database...");

		try
		{
			con.createStatement().executeUpdate("DELETE FROM " + tableInfo.tableName);
			return true;
		}
		catch (Exception e)
		{
			System.out.println("could not clear table " + tableInfo.tableName + e);
			return false;
		}
	}

	public static void dropTable(Connection con, TableInfo tableInfo)
	{
		System.out.println("Deleting " + tableInfo.tableName + " in given database...");

		try
		{
			con.createStatement().executeUpdate("DROP TABLE " + tableInfo.tableName);
		}
		catch (Exception e)
		{
			System.out.println("could not drop table " + tableInfo.tableName + e);
		}
	}

	public static int entries(Connection con, TableInfo tableInfo)
	{
		int ret = 0;

		try
		{
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM " + tableInfo.tableName);

			ResultSet rs = ps.executeQuery();
			rs.next();
			ret = rs.getInt(1);

			rs.close();
		}
		catch (SQLException sqle)
		{
			if (sqle.getSQLState().equals("42X05"))
			{
				System.out.println("Creating table " + tableInfo.tableName);
				createTable(con, tableInfo);
				ret = 0;
			}
			else
			{
				System.out.println(sqle);
				System.out.println("Incorrect table definition. Drop table "
								+ tableInfo.tableName + " and rerun this program");
				System.exit(0);
			}
		}

		return ret;
	}

	public static Connection start()
	{
		Connection con = null;
		try
		{
			con = DriverManager.getConnection(connectionURL);
			System.out.println("Connected to database " + dbName);
		}
		catch (Exception e)
		{
			System.out.println("could not connect to database: " + e);
			System.exit(0);
		}
		return con;
	}

	public static void kill(Connection con)
	{
		try
		{
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("could not close connection, exception occured: " + e);
		}
		System.out.println("Closed connection");
		if (driver.equals("org.apache.derby.jdbc.EmbeddedDriver"))
		{
			boolean gotSQLExc = false;
			try
			{
				DriverManager.getConnection("jdbc:derby:;shutdown=true");
			}
			catch (SQLException se)
			{
				if (se.getSQLState().equals("XJ015"))
				{
					gotSQLExc = true;
				}
			}
			if (!gotSQLExc)
			{
				System.out.println("Database did not shut down normally");
			}
			else
			{
				System.out.println("Database shut down normally");
			}
		}
	}

	public final String getID()
	{
		return id;
	}

	public String toString()
	{
		return null;
	}

	public String getTableName()
	{
		return null;
	}
}
