package gui.panels.exercise;

import java.awt.Component;

import database.Phrase;

public class SimplePhrasePanel extends ExercisePanel
{
	private static final long serialVersionUID = -2598447311795280099L;
	protected SingleInputPanel answerPanel;
	protected SingleOutputPanel questionPanel;

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

		setText();
	}

	public void setText()
	{
		if(getPhrase().core.reverse)
			questionPanel.setText(getPhrase().phrase2);
		else
			questionPanel.setText(getPhrase().phrase1);
	}

	@Override
	public Component[] getComponents()
	{
		return answerPanel.getComponents();
	}

	@Override
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
