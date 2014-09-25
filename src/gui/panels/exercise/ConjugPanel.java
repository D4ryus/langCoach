package gui.panels.exercise;

import java.awt.Component;

import database.Phrase;

public class ConjugPanel extends ExercisePanel
{
	private static final long serialVersionUID = 7894745475514305718L;
	private MultiInputPanel answerPanel;
	private MultiOutputPanel questionPanel;
	
	public ConjugPanel(Phrase phrase)
	{	
		super(phrase);
		
		answerPanel = new MultiInputPanel();
		questionPanel = new MultiOutputPanel();
		
		if(getPhrase().core.reverse)
		{
			answerPanel.setConjug(phrase.getDict().getLanguage1().persPron.split("#"));
			questionPanel.setConjug(phrase.getDict().getLanguage2().persPron.split("#"));
			questionPanel.setText(getPhrase().phrase2.split("#"));
		}
		else
		{
			answerPanel.setConjug(phrase.getDict().getLanguage2().persPron.split("#"));
			questionPanel.setConjug(phrase.getDict().getLanguage1().persPron.split("#"));
			questionPanel.setText(getPhrase().phrase1.split("#"));
		}
		
		add(questionPanel);
		add(answerPanel);
		add(perfPanel);
	}
	
	public Component[] getComponents()
	{
		return answerPanel.getComponents();
	}
	
	public boolean verify()
	{
		boolean answerCorrect = true;
		boolean[] hl  = new boolean[6];
		String[]  ans = answerPanel.getText();
		String[]  sol;
		
		if(getPhrase().core.reverse)
			sol = getPhrase().phrase1.split("#");
		else
			sol = getPhrase().phrase2.split("#");
		
		for(int i = 0; i < 6; i ++)
		{
			if(ans[i].equals(sol[i]))
			{
				hl[i] = true;
			}
			else
			{
				hl[i] = false;
				answerCorrect = false;
			}
		}
		
		updatePerfData(answerCorrect);
		if (!answerCorrect)
		{
			answerPanel.setSolution(sol);
			answerPanel.highlight(hl);
		}
		
		repaint();
		
		return answerCorrect;
	}
}
