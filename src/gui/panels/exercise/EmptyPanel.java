package gui.panels.exercise;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import database.Phrase;

public class EmptyPanel extends ExercisePanel
{
	private static final long serialVersionUID = -2494126709570654389L;

	public EmptyPanel(Phrase phrase)
	{
		super(phrase);
		
		JLabel lbl = new JLabel("no Phrase found :(");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl);
		
		System.out.println("empty");
	}
}
