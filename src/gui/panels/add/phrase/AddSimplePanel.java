package gui.panels.add.phrase;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JTextField;

import database.Language;

public class AddSimplePanel extends AddPhrasePanel
{
	private static final long serialVersionUID = 349470299657912290L;

	private JTextField txt;

	public AddSimplePanel(Language lang)
	{
		super(lang);

		setLayout(new GridLayout(1, 0, 0, 0));

		txt = new JTextField();
		add(txt);
		txt.setColumns(10);
	}

	@Override
	public String getText()
	{
		if((txt.getText() == null) || (txt.getText().equals("")))
			return null;
		else
			return txt.getText();
	}

	@Override
	public void clear()
	{
		txt.setText("");
	}

	@Override
	public Component[] getComponents()
	{
		Component[] comp = new Component[1];
		comp[0] = txt;
		return comp;
	}
}
