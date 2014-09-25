package gui.panels.add.phrase;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import database.Language;

public class AddConjugPanel extends AddPhrasePanel
{
	private static final long serialVersionUID = 8467020798496326537L;

	private JLabel lbl0;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;

	private JTextField txt0;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;

	private Component[] tabComponents;

	public AddConjugPanel(Language lang)
	{
		super(lang);
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("4dlu:grow"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("4dlu:grow"),}));

		lbl0 = new JLabel("New label");
		add(lbl0, "2, 2, right, default");

		txt0 = new JTextField();
		add(txt0, "4, 2, fill, default");
		txt0.setColumns(10);

		lbl3 = new JLabel("New label");
		add(lbl3, "6, 2, right, default");

		txt3 = new JTextField();
		add(txt3, "8, 2, fill, default");
		txt3.setColumns(10);

		lbl1 = new JLabel("New label");
		add(lbl1, "2, 4, right, default");

		txt1 = new JTextField();
		add(txt1, "4, 4, fill, default");
		txt1.setColumns(10);

		lbl4 = new JLabel("New label");
		add(lbl4, "6, 4, right, default");

		txt4 = new JTextField();
		add(txt4, "8, 4, fill, default");
		txt4.setColumns(10);

		lbl2 = new JLabel("New label");
		add(lbl2, "2, 6, right, default");

		txt2 = new JTextField();
		add(txt2, "4, 6, fill, default");
		txt2.setColumns(10);

		lbl5 = new JLabel("New label");
		add(lbl5, "6, 6, right, default");

		txt5 = new JTextField();
		add(txt5, "8, 6, fill, default");
		txt5.setColumns(10);

		tabComponents = new Component[6];

		tabComponents[0] = txt0;
		tabComponents[1] = txt1;
		tabComponents[2] = txt2;
		tabComponents[3] = txt3;
		tabComponents[4] = txt4;
		tabComponents[5] = txt5;

		setConjug(lang.persPron.split("#"));
	}

	public String getText()
	{
		if(checkInput())
			return txt0.getText() + "#"
				 + txt1.getText() + "#"
				 + txt2.getText() + "#"
				 + txt3.getText() + "#"
				 + txt4.getText() + "#"
				 + txt5.getText();
		else
			return null;
	}

	public void setConjug(String[] text)
	{
		lbl0.setText(text[0]);
		lbl1.setText(text[1]);
		lbl2.setText(text[2]);
		lbl3.setText(text[3]);
		lbl4.setText(text[4]);
		lbl5.setText(text[5]);
	}

	public boolean checkInput()
	{
		if((txt0.getText() == null) || (txt0.getText().equals(""))) return false;
		if((txt1.getText() == null) || (txt1.getText().equals(""))) return false;
		if((txt2.getText() == null) || (txt2.getText().equals(""))) return false;
		if((txt3.getText() == null) || (txt3.getText().equals(""))) return false;
		if((txt4.getText() == null) || (txt4.getText().equals(""))) return false;
		if((txt5.getText() == null) || (txt5.getText().equals(""))) return false;
		return true;
	}

	public void clear()
	{
		txt0.setText("");
		txt1.setText("");
		txt2.setText("");
		txt3.setText("");
		txt4.setText("");
		txt5.setText("");
	}

	public Component[] getComponents()
	{
		return tabComponents;
	}
}
