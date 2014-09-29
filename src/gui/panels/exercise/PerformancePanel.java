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
	private static final long serialVersionUID = -123013009970299793L;

	private JLabel lblSuccessTitle;
	private JLabel lblLastSuccessTitle;
	private JLabel lblLastFailTitle;
	private JLabel lblLastSuccess;
	private JLabel lblSuccess;
	private JLabel lblLastFail;
	private JPanel panel;
	private PerfIndicator pi;

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
	}

	public void updateInfo(Phrase phr)
	{
		if (phr.core.reverse)
		{
			lblSuccess.setText(new Integer(phr.perf.revSuccess).toString());
			lblLastSuccess.setText(TimeCalc.calcPrettyTime(phr.perf.revLastSuccess));
			lblLastFail.setText(TimeCalc.calcPrettyTime(phr.perf.revLastFail));
			pi = new PerfIndicator(phr.perf.revSuccess, phr.perf.max);
		}
		else
		{
			lblSuccess.setText(new Integer(phr.perf.success).toString());
			lblLastSuccess.setText(TimeCalc.calcPrettyTime(phr.perf.lastSuccess));
			lblLastFail.setText(TimeCalc.calcPrettyTime(phr.perf.lastFail));
			pi = new PerfIndicator(phr.perf.success, phr.perf.max);
		}
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(pi);
		add(panel, "1, 4, 3, 1, fill, fill");
	}
	
	class PerfIndicator extends JPanel
	{
		private static final long serialVersionUID = -287247801336202957L;
		private int success;
		private int max;
		
		public PerfIndicator(int success, int max)
		{
			super();
			this.success = success;
			this.max = max;
		}

		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			doDrawing(g);
		}
		
		private void doDrawing(Graphics g)
		{
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.red);

			Dimension size = getSize();
			Insets insets = getInsets();

			int w = size.width  - insets.left - insets.right;
			int h = size.height - insets.top  - insets.bottom;
			int middle = w/2;
			
			g2d.setColor(Color.BLACK);
			g2d.drawLine(0, h/2, w, h/2);
			g2d.drawLine(w/2, 0, w/2, h);
			
			int barLength = 0;
			int barHeight = 0;
			if (max != 0)
			{
				barLength = (int)((double)middle/(double)max * (double)(success < 0 ? -1 * success : success));
				barHeight = h-11;
			}
				
			if (success > 0)
			{
				g2d.setColor(Color.GREEN);
				g2d.fillRect(middle+1, 5, barLength, barHeight);
			}
			else if (success < 0)
			{
				g2d.setColor(Color.RED);
				g2d.fillRect(middle - barLength, 5, barLength, barHeight);
			}
			else
			{
				g2d.setColor(Color.BLUE);
				g2d.fillRect(middle -5, 5, 10, barHeight);
			}
		}
	}
}
