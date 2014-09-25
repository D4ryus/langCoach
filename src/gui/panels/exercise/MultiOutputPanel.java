package gui.panels.exercise;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class MultiOutputPanel extends JPanel
{
	private static final long serialVersionUID = -5771120577646633431L;

	private JLabel lblQuestion0;
	private JLabel lblQuestion1;
	private JLabel lblQuestion2;
	private JLabel lblQuestion3;
	private JLabel lblQuestion4;
	private JLabel lblQuestion5;
	 
	private JLabel lblConjug0;
	private JLabel lblConjug1;
	private JLabel lblConjug2;
	private JLabel lblConjug3;
	private JLabel lblConjug4;
	private JLabel lblConjug5;
	
	private JLabel[] lblConjugComps;
	private JLabel[] lblQuestionComps;
	
	public MultiOutputPanel()
	{
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("default:grow"),
				RowSpec.decode("42px"),
				RowSpec.decode("42px"),
				RowSpec.decode("42px"),
				RowSpec.decode("default:grow"),}));
		
		lblConjug0 = new JLabel("New label");
		lblConjug0.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConjug0.setForeground(Color.gray);
		add(lblConjug0, "1, 2, fill, fill");
		
		lblQuestion0 = new JLabel("New label");
		lblQuestion0.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblQuestion0, "3, 2, fill, fill");
		
		lblConjug3 = new JLabel("New label");
		lblConjug3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConjug3.setForeground(Color.gray);
		add(lblConjug3, "5, 2, fill, fill");
		
		lblQuestion3 = new JLabel("New label");
		lblQuestion3.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblQuestion3, "7, 2, fill, fill");
		
		lblConjug1 = new JLabel("New label");
		lblConjug1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConjug1.setForeground(Color.gray);
		add(lblConjug1, "1, 3, fill, fill");
		
		lblQuestion1 = new JLabel("New label");
		lblQuestion1.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblQuestion1, "3, 3, fill, fill");
		
		lblConjug4 = new JLabel("New label");
		lblConjug4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConjug4.setForeground(Color.gray);
		add(lblConjug4, "5, 3, fill, fill");
		
		lblQuestion4 = new JLabel("New label");
		lblQuestion4.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblQuestion4, "7, 3, fill, fill");
		
		lblConjug2 = new JLabel("New label");
		lblConjug2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConjug2.setForeground(Color.gray);
		add(lblConjug2, "1, 4, fill, fill");
		
		lblQuestion2 = new JLabel("New label");
		lblQuestion2.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblQuestion2, "3, 4, fill, fill");
		
		lblConjug5 = new JLabel("New label");
		lblConjug5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConjug5.setForeground(Color.gray);
		add(lblConjug5, "5, 4, fill, fill");
		
		lblQuestion5 = new JLabel("New label");
		lblQuestion5.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblQuestion5, "7, 4, fill, fill");
		
		lblConjugComps   = new JLabel[]{     lblConjug0,   lblConjug1,   lblConjug2,   lblConjug3,   lblConjug4,   lblConjug5};
		lblQuestionComps = new JLabel[]{   lblQuestion0, lblQuestion1, lblQuestion2, lblQuestion3, lblQuestion4, lblQuestion5};
	}
	
	public void setText(String[] text)
	{
		for(int i = 0; i < 6; i++)
			lblQuestionComps[i].setText(text[i]);
	}
	
	public void setConjug(String[] text)
	{
		for(int i = 0; i < 6; i++)
			lblConjugComps[i].setText(text[i]);
	}
}