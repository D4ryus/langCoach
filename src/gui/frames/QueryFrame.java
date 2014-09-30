package gui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

import main.LangCoach;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class QueryFrame extends JFrame
{
	private static final long serialVersionUID = 4624712861462297395L;
	private JTextArea queryField;
	private JTextArea logField;
	private QueryTableModel qtm;

	public QueryFrame(LangCoach brain)
	{
		super("Query Console");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(478, 535);

		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(60dlu;default):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:min(60dlu;pref):grow(4)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("min(60dlu;default):grow(4)"),
				FormSpecs.RELATED_GAP_ROWSPEC,}));
		JScrollPane textScroll = new JScrollPane(queryField = new JTextArea());
		getContentPane().add(textScroll, "2, 2, 3, 1, fill, fill");

		JButton btnQuery = new JButton("Evaluate");
		btnQuery.setMnemonic('e');
		btnQuery.addActionListener(new ActionListener(){ @Override public void actionPerformed(ActionEvent e) { clicked_eval(); }});
		getContentPane().add(btnQuery, "6, 2");

		JScrollPane scrollPane = new JScrollPane(logField = new JTextArea());
		getContentPane().add(scrollPane, "2, 6, 5, 1, fill, fill");
		qtm = new QueryTableModel(brain.getCon(), logField);

		JTable table = new JTable(qtm);
		JScrollPane scrollpane = new JScrollPane(table);
		getContentPane().add(scrollpane, "2, 4, 5, 1, fill, fill");

		JRootPane rootPane = SwingUtilities.getRootPane(btnQuery);
		rootPane.setDefaultButton(btnQuery);

		setVisible(true);
	}
	
	private void clicked_eval()
	{
		String query = queryField.getText().trim();
		switch (query)
		{
		case "lsp":
			query = getTableQuery("PHRASES");
			break;
		case "lsperf":
			query = getTableQuery("PERFORMANCES");
			break;
		case "lsd":
			query = getTableQuery("DICTIONARIES");
			break;
		case "lsu":
			query = getTableQuery("USERS");
			break;
		case "lsl":
			query = getTableQuery("LANGUAGES");
			break;
		case "lsa":
			query = "SELECT * FROM SYS.SYSTABLES";
			break;
		}
		queryField.setText(query);
		qtm.setQuery(query);
	}
	
	private String getTableQuery(String table)
	{
		return "SELECT * FROM " + table + " ORDER BY ID DESC";
	}
}

class QueryTableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 2806305929134147461L;
	Vector<String[]> tmp;
	int				 columns;
	String[]		 headers;
	Connection		 con;
	Statement		 statement;
	JTextArea 		 logField;

	public QueryTableModel(Connection con, JTextArea logField)
	{
		this.logField = logField;
		tmp = new Vector<String[]>();

		try
		{
			this.con = con;
			statement = con.createStatement();
		}
		catch (Exception e)
		{
			System.out.println("Could not connect to database.");
			e.printStackTrace();
		}
	}

	public void setQuery(String q)
	{
		tmp = new Vector<String[]>();
		try
		{
			ResultSet rs = statement.executeQuery(q);
			ResultSetMetaData meta = rs.getMetaData();
			columns = meta.getColumnCount();

			headers = new String[columns];
			for (int i = 1; i <= columns; i++)
				headers[i - 1] = meta.getColumnName(i);

			while (rs.next())
			{
				String[] record = new String[columns];
				for (int i = 0; i < columns; i++)
					record[i] = rs.getString(i + 1);

				tmp.addElement(record);
			}
			fireTableChanged(null);
		}
		catch (Exception e)
		{
			tmp = new Vector<String[]>();
			logField.setText(logField.getText()
					+ "\nError! time: " + System.currentTimeMillis() + ",\n"
					+ e.getMessage());
		}
	}

	@Override
	public String getColumnName(int i)
	{
		return headers[i];
	}

	@Override
	public int getColumnCount()
	{
		return columns;
	}

	@Override
	public int getRowCount()
	{
		return tmp.size();
	}

	@Override
	public Object getValueAt(int row, int col)
	{
		return ((String[]) tmp.elementAt(row))[col];
	}
}
