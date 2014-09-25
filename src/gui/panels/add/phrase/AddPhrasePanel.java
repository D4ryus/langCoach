package gui.panels.add.phrase;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import database.Language;

public class AddPhrasePanel extends JPanel
{
	private static final long serialVersionUID = -6641999063790237418L;
	Language lang;
	
	TitledBorder border;;
	
	public AddPhrasePanel(Language lang)
	{
		this.lang = lang;
		border = new TitledBorder(null, lang.getID() + " - " + lang.name,
				TitledBorder.LEADING, TitledBorder.TOP, null, null);
		setBorder(border);
	}
	
	public void setLang(Language lang)
	{
		this.lang = lang;
		border.setTitle(lang.getID() + " - " + lang.name);
	}
	
	public String getText()
	{
		return null;
	}
	
	public void clear()
	{
		
	}
	
	public void gainFocus()
	{
		
	}
	
	public Component[] getComponents()
	{
		return null;
	}
}
