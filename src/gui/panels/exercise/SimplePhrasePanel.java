package gui.panels.exercise;

import java.awt.Component;

import database.Phrase;

public class SimplePhrasePanel extends ExercisePanel
{
	private static final long serialVersionUID = -2598447311795280099L;
	private SingleInputPanel answerPanel;
	private SingleOutputPanel questionPanel;

	public SimplePhrasePanel(Phrase phrase)
	{
		super(phrase);

		questionPanel = new SingleOutputPanel();
		questionPanel.setSize(490, 135);

		answerPanel = new SingleInputPanel();
		answerPanel.setSize(490, 135);

		add(questionPanel);
		add(answerPanel);
		add(perfPanel);



		if(getPhrase().core.reverse)
			questionPanel.setText(getPhrase().phrase2);
		else
			questionPanel.setText(getPhrase().phrase1);
	}


	public Component[] getComponents()
	{
		return answerPanel.getComponents();
	}

	public boolean verify()
	{
		String sol;

		if (getPhrase().core.reverse)
			sol = getPhrase().phrase1;
		else
			sol = getPhrase().phrase2;

		boolean answerCorrect = answerPanel.getAnswer().equals(sol);

		updatePerfData(answerCorrect);
		if (!answerCorrect)
		{
			answerPanel.setSolution(sol);
			answerPanel.highlight();
		}

		getPhrase().perf.saveToDB();
		repaint();
		return answerCorrect;
	}
}
