package gui.panels.exercise;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SingleOutputPanel extends JPanel
{
	private static final long serialVersionUID = 635884127725227294L;
	
	private JLabel lbl;

	public SingleOutputPanel()
	{
		setLayout(new GridLayout(0, 1, 0, 0));
		
		lbl = new JLabel();
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl);
	}
	
	public void setText(String text)
	{
		lbl.setText(text);
	}
}
