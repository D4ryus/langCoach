package gui.panels.exercise;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import main.TimeCalc;

import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import database.Phrase;

public class PerformancePanel extends JPanel
{
	private static final long	serialVersionUID	= -123013009970299793L;
	
	private JLabel lblSuccessTitle;
	private JLabel lblLastSuccessTitle;
	private JLabel lblLastFailTitle;
	private JLabel lblLastSuccess;
	private JLabel lblSuccess;
	private JLabel lblLastFail;
	private JPanel panel;

	public PerformancePanel()
	{
		setBorder(new TitledBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Performance Indicator", TitledBorder.LEADING, TitledBorder.TOP, null, null),
				"Performance Indicator", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLACK));
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		lblSuccessTitle = new JLabel("Success Indicator");
		lblSuccessTitle.setToolTipText("Success");
		lblSuccessTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSuccessTitle, "1, 1, fill, fill");
		
		lblLastSuccessTitle = new JLabel("Last Success");
		lblLastSuccessTitle.setToolTipText("Last Success");
		lblLastSuccessTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblLastSuccessTitle, "2, 1, fill, fill");
						
		lblLastFailTitle = new JLabel("Last Fail");
		lblLastFailTitle.setToolTipText("Last Fail");
		lblLastFailTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblLastFailTitle, "3, 1, fill, fill");
		
		lblSuccess = new JLabel("New Label");
		lblSuccess.setToolTipText("Reverse Success");
		lblSuccess.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSuccess, "1, 2, fill, fill");
		
		lblLastSuccess = new JLabel("New label");
		lblLastSuccess.setToolTipText("Last Reverse Success");
		lblLastSuccess.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblLastSuccess, "2, 2, fill, fill");
		
		lblLastFail = new JLabel("New label");
		lblLastFail.setToolTipText("Last Reverse Fail");
		lblLastFail.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblLastFail, "3, 2, fill, fill");
		
		PerfIndicator pi = new PerfIndicator();
		panel = new JPanel();
		panel.add(pi);
		add(panel, "1, 4, 3, 1, fill, fill");
		panel.setLayout(new GridLayout(0, 1, 0, 0));
	}
	
	class PerfIndicator extends JPanel {

		private static final long	serialVersionUID	= -287247801336202957L;

		private void doDrawing(Graphics g) {

	        Graphics2D g2d = (Graphics2D) g;

	        g2d.setColor(Color.red);

	        for (int i = 0; i <= 1000; i++) {

	            Dimension size = getSize();
	            Insets insets = getInsets();

	            int w = size.width  - insets.left - insets.right;
	            int h = size.height - insets.top  - insets.bottom;

	            Random r = new Random();
	            int x = Math.abs(r.nextInt()) % w;
	            int y = Math.abs(r.nextInt()) % h;
	            g2d.drawLine(x, y, x, y);
	            g2d.drawLine(0, h/2, w, h/2);
	        }
	    }

	    @Override
	    public void paintComponent(Graphics g) {
	        
	        super.paintComponent(g);
	        doDrawing(g);
	    }
	}
	
	public void updateInfo(Phrase phr)
	{
		if (phr.core.reverse)
		{
			lblSuccess.setText(new Integer(phr.perf.revSuccess).toString());
			lblLastSuccess.setText(TimeCalc.calcPrettyTime(phr.perf.revLastSuccess));
			lblLastFail.setText(TimeCalc.calcPrettyTime(phr.perf.revLastFail));
		}
		else
		{
			lblSuccess.setText(new Integer(phr.perf.success).toString());
			lblLastSuccess.setText(TimeCalc.calcPrettyTime(phr.perf.lastSuccess));
			lblLastFail.setText(TimeCalc.calcPrettyTime(phr.perf.lastFail));
		}
	}
}
