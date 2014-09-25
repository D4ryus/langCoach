package gui.panels.exercise;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import database.Phrase;

public class ExercisePanel extends JPanel
{
	private static final long serialVersionUID = -2421869537396882145L;
	private Phrase phrase;
	private String borderTitel  = "Exercise Panel";
	private TitledBorder border = new TitledBorder(null, borderTitel, TitledBorder.LEADING, TitledBorder.TOP, null, null);
	protected PerformancePanel perfPanel;
	
	public ExercisePanel(Phrase phrase)
	{
		this.phrase = phrase;
		setBorder(border);
		setLayout(new GridLayout(0, 1, 0, 0));
		setPreferredSize(new Dimension(450, 350));
		perfPanel = new PerformancePanel();
	}
	
	public Component[] getComponents()
	{
		return null;
	}
	
	public void setToolTip(String text)
	{
		this.setToolTipText(text);
	}
	
	public Phrase getPhrase()
	{
		return phrase;
	}
	
	public PerformancePanel getPerfPanel()
	{
		return perfPanel;
	}
	
	public void updatePerfData(boolean answerCorrect)
	{
		if (phrase.core.reverse)
		{
			if(answerCorrect)
			{	
				phrase.perf.revSuccess++;
				phrase.perf.revLastSuccess = new java.sql.Timestamp(System.currentTimeMillis());
			}
			else
			{	
				phrase.perf.revSuccess--;
				phrase.perf.revLastFail = new java.sql.Timestamp(System.currentTimeMillis());
			}
			phrase.core.success = phrase.perf.revSuccess;
		} 
		else 
		{	
			if (answerCorrect)
			{
				phrase.perf.success++;
				phrase.perf.lastSuccess = new java.sql.Timestamp(System.currentTimeMillis());
			}
			else
			{
				phrase.perf.success--;
				phrase.perf.lastFail = new java.sql.Timestamp(System.currentTimeMillis());
			}
			phrase.core.success = phrase.perf.success;
		}
		phrase.perf.saveToDB();
	}
	
	public boolean verify()
	{
		return false;
	}
}
