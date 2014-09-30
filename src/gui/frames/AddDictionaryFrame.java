package gui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import main.LangCoach;

import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import database.Dictionary;
import database.Language;

public class AddDictionaryFrame extends JFrame
{
	private static final long serialVersionUID = -5732317379981275652L;
	private JPanel	contentPane;
	private JTextField txtName;
	private JTextField txtDescription;
	private JComboBox<Language> boxLang1;
	private JComboBox<Language> boxLang2;
	private LangCoach coach;

	public AddDictionaryFrame(LangCoach coach)
	{
		this.coach = coach;
		this.setTitle("Add Dictionary");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,}));

		JLabel lblLang1 = new JLabel("Language 1:");
		contentPane.add(lblLang1, "2, 2");

		JButton btnAddLang1 = new JButton("Add");
		btnAddLang1.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent arg0) { clickedAddLang1(); }});
		contentPane.add(btnAddLang1, "4, 2");

		JLabel lblLang2 = new JLabel("Language 2:");
		contentPane.add(lblLang2, "6, 2");

		JButton btnAddLang2 = new JButton("Add");
		btnAddLang2.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent arg0) { clickedAddLang2(); }});
		contentPane.add(btnAddLang2, "8, 2");

		JLabel lblName = new JLabel("Name:");
		lblName.setToolTipText("Name descripes the Dictionary, 'English - German for Beginners' for example");
		contentPane.add(lblName, "2, 6, 7, 1");

		JLabel lblDescription = new JLabel("Description:");
		contentPane.add(lblDescription, "2, 10, 7, 1");

		Language langs[] = Language.getLanguages(coach.getCon());

		boxLang1 = new JComboBox<Language>(langs);
		contentPane.add(boxLang1, "2, 4, 3, 1, fill, default");

		boxLang2 = new JComboBox<Language>(langs);
		contentPane.add(boxLang2, "6, 4, 3, 1, fill, default");

		if(langs.length >= 2)
		{
			boxLang1.setSelectedItem(langs[0]);
			boxLang2.setSelectedItem(langs[1]);
		}

		txtName = new JTextField();
		contentPane.add(txtName, "2, 8, 7, 1, fill, default");
		txtName.setColumns(10);

		txtDescription = new JTextField();
		contentPane.add(txtDescription, "2, 12, 7, 2, fill, default");
		txtDescription.setColumns(10);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { clickedConfirm(); } });
		contentPane.add(btnConfirm, "2, 15, 7, 1");

		JRootPane rootPane = SwingUtilities.getRootPane(btnConfirm);
		rootPane.setDefaultButton(btnConfirm);
	}

	public void updateLang1(Language selected)
	{
		boxLang1.addItem(selected);
		boxLang1.setSelectedItem(selected);
	}

	public void updateLang2(Language selected)
	{
		boxLang2.addItem(selected);
		boxLang2.setSelectedItem(selected);
	}

	private void clickedAddLang1()
	{
		AddLanguageFrame frame = new AddLanguageFrame(coach, this, 1);
		frame.setVisible(true);
	}

	private void clickedAddLang2()
	{
		AddLanguageFrame frame = new AddLanguageFrame(coach, this, 2);
		frame.setVisible(true);
	}

	private void clickedConfirm()
	{
		this.setEnabled(false);
		Language lang1 = (Language) boxLang1.getSelectedItem();
		Language lang2 = (Language) boxLang2.getSelectedItem();

		if ((lang1.getID().equals(lang2.getID()))
		  || txtName.getText().length() == 0
		  || txtDescription.getText().length() == 0 )
		{
			this.setEnabled(true);
			return;
		}

		coach.setDict(Dictionary.createNew(
				coach.getCon(), txtName.getText(), txtDescription.getText(), lang1.getID(), lang2.getID()));
		this.dispose();
	}
}
