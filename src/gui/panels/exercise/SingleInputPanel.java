package gui.panels.exercise;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SingleInputPanel extends JPanel
{
	private static final long serialVersionUID = -7242762774295151235L;
	private JTextField txt;
	private JLabel lblSolution;

	public SingleInputPanel()
	{
		txt = new JTextField();
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		txt.addFocusListener(new FocusAdapter() { public void focusGained(FocusEvent arg0) { txt.selectAll(); }});
		setLayout(new GridLayout(0, 1, 0, 0));
		add(txt);

		lblSolution = new JLabel();
		lblSolution.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolution.setForeground(Color.BLUE);
		add(lblSolution);
	}

	public Component[] getComponents()
	{
		Component[] comp = new Component[1];
		comp[0] = txt;
		return comp;
	}

	public void setSolution(String text)
	{
		lblSolution.setText(text);
	}

	public String getAnswer()
	{
		return txt.getText();
	}

	public void highlight()
	{
		txt.setForeground(Color.RED);
	}
}
