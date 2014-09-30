package gui.frames;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import main.LangCoach;
import main.TabOrder;

import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import database.Language;

public class AddLanguageFrame extends JFrame
{
	private static final long	serialVersionUID	= 4625157064823406311L;
	private JPanel	contentPane;
	private JTextField txt0;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;
	private LangCoach coach;
	private LinkedList<Component> tabOrder = new LinkedList<Component>();
	private AddDictionaryFrame dictFrame;
	private int lang;

	public AddLanguageFrame(LangCoach coach, AddDictionaryFrame dictFrame, int lang)
	{
		this.coach = coach;
		this.dictFrame = dictFrame;
		this.lang = lang;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setMinimumSize(new Dimension(544, 324));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(50dlu;min):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(50dlu;min):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default:grow"),}));

		JLabel lblLanguageId = new JLabel("Language ID:");
		lblLanguageId.setToolTipText("Language ID is a language identifier like EN or DE");
		contentPane.add(lblLanguageId, "2, 2");

		JLabel lblName = new JLabel("Name:");
		lblName.setToolTipText("Name descriptes the language, so English would be a good choice for EN");
		contentPane.add(lblName, "4, 2");

		JPanel panel = new JPanel();
		panel.setToolTipText("Personal Pronoun for the new Language, have to be filled! (example EN: i, you, he she it, we, you, they)");
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Personal Pronouns", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, "2, 6, 3, 1, fill, fill");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,}));

		JLabel lblNewLabel_2 = new JLabel("First Person Singular:");
		panel.add(lblNewLabel_2, "2, 2, fill, top");

		JLabel lblFirstPersonPlural = new JLabel("First Person Plural:");
		panel.add(lblFirstPersonPlural, "4, 2, fill, top");

		txt2 = new JTextField();
		panel.add(txt2, "2, 4, fill, top");
		txt2.setColumns(10);

		txt5 = new JTextField();
		panel.add(txt5, "4, 4, fill, top");
		txt5.setColumns(10);

		JLabel lblSecondPersonSingular = new JLabel("Second Person Singular:");
		panel.add(lblSecondPersonSingular, "2, 6, fill, top");

		JLabel lblSecondPersonPlural = new JLabel("Second Person Plural:");
		panel.add(lblSecondPersonPlural, "4, 6, fill, top");

		txt3 = new JTextField();
		panel.add(txt3, "2, 8, fill, top");
		txt3.setColumns(10);

		txt6 = new JTextField();
		panel.add(txt6, "4, 8, fill, top");
		txt6.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Third Person Singular:");
		panel.add(lblNewLabel_3, "2, 10, fill, top");

		JLabel lblThirdPersonPlural = new JLabel("Third Person Plural:");
		panel.add(lblThirdPersonPlural, "4, 10, fill, top");

		txt4 = new JTextField();
		panel.add(txt4, "2, 12, fill, top");
		txt4.setColumns(10);

		txt7 = new JTextField();
		panel.add(txt7, "4, 12, fill, top");
		txt7.setColumns(10);

		txt0 = new JTextField();
		contentPane.add(txt0, "2, 4, fill, default");
		txt0.setColumns(10);

		txt1 = new JTextField();
		contentPane.add(txt1, "4, 4, fill, default");
		txt1.setColumns(10);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { clickedConfirm(); }});
		contentPane.add(btnConfirm, "2, 8, 3, 1");

		tabOrder.add(txt0);
		tabOrder.add(txt1);
		tabOrder.add(txt2);
		tabOrder.add(txt3);
		tabOrder.add(txt4);
		tabOrder.add(txt5);
		tabOrder.add(txt6);
		tabOrder.add(txt7);
		tabOrder.add(btnConfirm);

		setFocusTraversalPolicy(new TabOrder(tabOrder));
		tabOrder.getFirst().requestFocus();

		JRootPane rootPane = SwingUtilities.getRootPane(btnConfirm);
		rootPane.setDefaultButton(btnConfirm);
	}

	private void clickedConfirm()
	{
		this.setEnabled(false);
		txt0.setText(txt0.getText().toUpperCase());
		if (txt0.getText().length() != 2
		 || txt1.getText().length() == 0
		 || txt2.getText().length() == 0
		 || txt3.getText().length() == 0
		 || txt4.getText().length() == 0
		 || txt5.getText().length() == 0
		 || txt6.getText().length() == 0
		 || txt7.getText().length() == 0 )
		{
			this.setEnabled(true);
			tabOrder.getFirst().requestFocus();
			return;
		}
		Language selected = Language.createNew(coach.getCon(), txt0.getText(), txt1.getText(),
									txt2.getText() + "#" + txt3.getText() + "#"
								  + txt4.getText() + "#" + txt5.getText() + "#"
								  + txt6.getText() + "#" + txt7.getText() + "#" );

		if (dictFrame != null)
		{
			if (lang == 1)
				dictFrame.updateLang1(selected);
			else if (lang == 2)
				dictFrame.updateLang2(selected);
		}

		this.dispose();
	}
}
