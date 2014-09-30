package gui.frames;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import main.LangCoach;

import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import database.Dictionary;

public class ChangeDictionaryFrame extends JFrame
{
	private static final long	serialVersionUID	= -3695592846221432832L;
	private JPanel	contentPane;
	private LangCoach coach;
	private JComboBox<Dictionary> comboBox;

	public ChangeDictionaryFrame(LangCoach coach)
	{
		this.coach = coach;
		this.setTitle("Change Dictionary");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 110);
		this.setMinimumSize(new Dimension(250, 110));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));

		comboBox = new JComboBox<Dictionary>(Dictionary.getDictionaries(coach.getCon()));
		contentPane.add(comboBox, "2, 2, 5, 1, fill, default");

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { clickedOk(); }});
		contentPane.add(btnOk, "2, 4");

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { clickedCancel(); }});
		contentPane.add(btnCancel, "4, 4");

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { clickedAdd(); }});
		contentPane.add(btnAdd, "6, 4");

		JRootPane rootPane = SwingUtilities.getRootPane(btnOk);
		rootPane.setDefaultButton(btnOk);
	}

	private void clickedOk()
	{
		coach.setDict((Dictionary) comboBox.getSelectedItem());
		this.dispose();
	}

	private void clickedCancel()
	{
		this.dispose();
	}

	private void clickedAdd()
	{
		coach.addDictionary();
		this.dispose();
	}
}
