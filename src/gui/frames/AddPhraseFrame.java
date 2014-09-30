package gui.frames;

import gui.panels.add.phrase.AddConjugPanel;
import gui.panels.add.phrase.AddNumberPanel;
import gui.panels.add.phrase.AddPhrasePanel;
import gui.panels.add.phrase.AddSimplePanel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import main.LangCoach;
import main.TabOrder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import database.Dictionary;
import database.Phrase;

public class AddPhraseFrame extends JFrame
{
	private static final long serialVersionUID = 5512396493144935047L;
	private JPanel contentPane;
	private JComboBox<Dictionary> cmbDict;
	private JComboBox<String> cmbType;
	private JPanel mainPanel;
	private JButton btnConfirm;
	private AddPhrasePanel panelTop;
	private AddPhrasePanel panelBot;
	private Phrase.Type type = Phrase.Type.simple;

	private Dictionary frameDictionary;
	private LangCoach coach;

	private LinkedList<Component> tabOrder;

	public AddPhraseFrame(LangCoach coach)
	{
		this.coach = coach;
		this.setTitle("Add Phrase");
		frameDictionary = coach.getDict();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));

		cmbDict = new JComboBox<>(Dictionary.getDictionaries(coach.getCon()));
		cmbDict.setSelectedItem(frameDictionary);
		cmbDict.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { clickedChangeDict(); }});
		contentPane.add(cmbDict, "2, 2, fill, default");

		cmbType = new JComboBox<String>(new String[]{"simple", "conjugation", "number"});
		cmbType.setSelectedItem("simple");
		cmbType.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { clickedChangeType(); }});
		contentPane.add(cmbType, "4, 2");
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { clickedConfirm(); }});
		contentPane.add(btnConfirm, "2, 9, 3, 1");

		mainPanel = new JPanel();
		contentPane.add(mainPanel, "2, 4, 3, 4, fill, fill");
		mainPanel.setLayout(new GridLayout(0, 1, 0, 0));

		updateLayout();

		JRootPane rootPane = SwingUtilities.getRootPane(btnConfirm);
		rootPane.setDefaultButton(btnConfirm);

		setMinimumSize(new Dimension(430, 360));
	}
	
	private void clickedChangeType()
	{
		if (cmbType.getSelectedItem().equals("simple"))
			type = Phrase.Type.simple;
		else if(cmbType.getSelectedItem().equals("conjugation"))
			type = Phrase.Type.conjugation;
		else if (cmbType.getSelectedItem().equals("number"))
			type = Phrase.Type.number;

		updateLayout();
	}

	private void clickedChangeDict()
	{
		frameDictionary = (Dictionary) cmbDict.getSelectedItem();
		updateLayout();
	}

	private void updateLayout()
	{
		if (panelTop != null)
			mainPanel.remove(panelTop);
		if (panelBot != null)
			mainPanel.remove(panelBot);

		switch (type)
		{
		case conjugation:
			panelTop = new AddConjugPanel(frameDictionary.getLanguage1());
			panelBot = new AddConjugPanel(frameDictionary.getLanguage2());
			break;
		case simple:
			panelTop = new AddSimplePanel(frameDictionary.getLanguage1());
			panelBot = new AddSimplePanel(frameDictionary.getLanguage2());
			break;
		case number:
			panelTop = new AddNumberPanel(frameDictionary.getLanguage1());
			panelBot = new AddNumberPanel(frameDictionary.getLanguage2());
			break;
		}
		mainPanel.add(panelTop);
		mainPanel.add(panelBot);
		tabOrder = new LinkedList<Component>();
		for (Component i : panelTop.getComponents())
			tabOrder.add(i);
		for (Component i : panelBot.getComponents())
			tabOrder.add(i);
		tabOrder.add(btnConfirm);
		setFocusTraversalPolicy(new TabOrder(tabOrder));
		tabOrder.getFirst().requestFocus();

		this.setVisible(true);
	}

	private void clickedConfirm()
	{
		String phr1 = panelTop.getText();
		String phr2 = panelBot.getText();
		
		if (phr1 != null && phr2 != null)
		{		
			panelTop.clear();
			panelBot.clear();
			Phrase.createNew(coach.getCon(), Integer.parseInt(frameDictionary.getID()), type, phr1, phr2);
			if (tabOrder != null)
				tabOrder.getFirst().requestFocus();
			coach.updateCorePhrases();
			System.out.println("Confirmed!");
		}
	}
}
