package gui.panels.exercise;

import java.util.Random;

import database.Performance;
import database.Phrase;

public class RandomPanel extends ExercisePanel
{
	private static final long serialVersionUID = 7924202935590774312L;
	private SingleInputPanel inPanel;
	private SingleOutputPanel outPanel;
	
	public RandomPanel(Phrase phrase, Performance perf)
	{	
		super(phrase);
		
		inPanel = new SingleInputPanel();
		inPanel.setSolution(getPhrase().phrase1);
		inPanel.setBounds(10, 19, 490, 135);
		add(inPanel);

		outPanel = new SingleOutputPanel();
		outPanel.setText(getPhrase().phrase2);
		outPanel.setBounds(10, 174, 490, 135);
		add(outPanel);
	}
	
	public boolean verify()
	{
		if(new Random().nextBoolean())
			return true;
		
		inPanel.highlight();
		repaint();
		
		return false;
	}
}
