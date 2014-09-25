package gui.panels.exercise;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class MultiInputPanel extends JPanel
{
	private static final long serialVersionUID = 23258599132522588L;
	private JTextField txtAnswer0;
	private JTextField txtAnswer1;
	private JTextField txtAnswer2;
	private JTextField txtAnswer3;
	private JTextField txtAnswer4;
	private JTextField txtAnswer5;
	private JLabel     lblConjug0;
	private JLabel     lblConjug1;
	private JLabel     lblConjug2;
	private JLabel     lblConjug3;
	private JLabel     lblConjug4;
	private JLabel     lblConjug5;
	private JLabel     lblSolution0;
	private JLabel     lblSolution1;
	private JLabel     lblSolution2;
	private JLabel     lblSolution3;
	private JLabel     lblSolution4;
	private JLabel     lblSolution5;
	
	private Component[]  comps;
	private JTextField[] txtComps;
	private JLabel[]     lblConjugComps;
	private JLabel[]     lblSolutionComps;
	
	public MultiInputPanel()
	{
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("7dlu:grow"),
				RowSpec.decode("21px"),
				RowSpec.decode("21px"),
				RowSpec.decode("21px"),
				RowSpec.decode("21px"),
				RowSpec.decode("21px"),
				RowSpec.decode("21px"),
				RowSpec.decode("7dlu:grow"),}));
		
		lblConjug0 = new JLabel("New label");
		lblConjug0.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblConjug0, "2, 2, fill, fill");
		
		txtAnswer0 = new JTextField();
		txtAnswer0.setColumns(10);
		txtAnswer0.addFocusListener(new FocusAdapter() { public void focusGained(FocusEvent arg0) { txtAnswer0.selectAll(); }});
		add(txtAnswer0, "4, 2, fill, fill");
		
		lblConjug3 = new JLabel("New label");
		lblConjug3.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblConjug3, "6, 2, fill, fill");
		
		txtAnswer3 = new JTextField();
		txtAnswer3.setColumns(10);
		txtAnswer3.addFocusListener(new FocusAdapter() { public void focusGained(FocusEvent arg0) { txtAnswer3.selectAll(); }});
		add(txtAnswer3, "8, 2, fill, fill");
		
		lblSolution0 = new JLabel("");
		lblSolution0.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolution0.setForeground(Color.BLUE);
		add(lblSolution0, "4, 3, fill, fill");
		
		lblSolution3 = new JLabel("");
		lblSolution3.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolution3.setForeground(Color.BLUE);
		add(lblSolution3, "8, 3, fill, fill");
		
		lblConjug1 = new JLabel("New label");
		lblConjug1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblConjug1, "2, 4, fill, fill");
		
		txtAnswer1 = new JTextField();
		txtAnswer1.setColumns(10);
		txtAnswer1.addFocusListener(new FocusAdapter() { public void focusGained(FocusEvent arg0) { txtAnswer1.selectAll(); }});
		add(txtAnswer1, "4, 4, fill, fill");
		
		lblConjug4 = new JLabel("New label");
		lblConjug4.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblConjug4, "6, 4, fill, fill");
		
		txtAnswer5 = new JTextField();
		txtAnswer5.setColumns(10);
		txtAnswer5.addFocusListener(new FocusAdapter() { public void focusGained(FocusEvent arg0) { txtAnswer5.selectAll(); }});
		
		txtAnswer2 = new JTextField();
		txtAnswer2.setColumns(10);
		txtAnswer2.addFocusListener(new FocusAdapter() { public void focusGained(FocusEvent arg0) { txtAnswer2.selectAll(); }});
		
		txtAnswer4 = new JTextField();
		txtAnswer4.setColumns(10);
		txtAnswer4.addFocusListener(new FocusAdapter() { public void focusGained(FocusEvent arg0) { txtAnswer4.selectAll(); }});
		add(txtAnswer4, "8, 4, fill, fill");
		
		lblSolution1 = new JLabel("");
		lblSolution1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolution1.setForeground(Color.BLUE);
		add(lblSolution1, "4, 5, fill, fill");
		
		lblSolution4 = new JLabel("");
		lblSolution4.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolution4.setForeground(Color.BLUE);
		add(lblSolution4, "8, 5, fill, fill");
		
		lblConjug2 = new JLabel("New label");
		lblConjug2.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblConjug2, "2, 6, fill, fill");
		add(txtAnswer2, "4, 6, fill, fill");
		
		lblConjug5 = new JLabel("New label");
		lblConjug5.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblConjug5, "6, 6, fill, fill");
		add(txtAnswer5, "8, 6, fill, fill");
		
		lblSolution2 = new JLabel("");
		lblSolution2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolution2.setForeground(Color.BLUE);
		add(lblSolution2, "4, 7, fill, fill");
		
		lblSolution5 = new JLabel("");
		lblSolution5.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolution5.setForeground(Color.BLUE);
		add(lblSolution5, "8, 7, fill, fill");
		
		
		comps            = new Component[]{  txtAnswer0,   txtAnswer1,   txtAnswer2,   txtAnswer3,   txtAnswer4,   txtAnswer5};
		txtComps         = new JTextField[]{ txtAnswer0,   txtAnswer1,   txtAnswer2,   txtAnswer3,   txtAnswer4,   txtAnswer5};
		lblConjugComps   = new JLabel[]{     lblConjug0,   lblConjug1,   lblConjug2,   lblConjug3,   lblConjug4,   lblConjug5};
		lblSolutionComps = new JLabel[]{   lblSolution0, lblSolution1, lblSolution2, lblSolution3, lblSolution4, lblSolution5};
	}
	
	public Component[] getComponents()
	{
		return comps;
	}
	
	public void highlight(boolean[] hl)
	{
		for(int i = 0; i < 6; i++)
			if(!hl[i])
				txtComps[i].setForeground(Color.RED);
			else
				txtComps[i].setForeground(Color.GREEN);
	}
	
	public void setConjug(String[] text)
	{
		for(int i = 0; i < 6; i++)
			lblConjugComps[i].setText(text[i]);
	}
	
	public void setSolution(String[] text)
	{
		for(int i = 0; i < 6; i++)
			lblSolutionComps[i].setText(text[i]);
	}
	
	public String[] getText()
	{
		String[] ret = new String[6];
		
		for(int i = 0; i < 6; i++)
			ret[i] = txtComps[i].getText();
		
		return ret;
	}
}