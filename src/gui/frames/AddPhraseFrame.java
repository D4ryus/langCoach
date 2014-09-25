package gui.frames;

import gui.panels.add.phrase.AddConjugPanel;
import gui.panels.add.phrase.AddPhrasePanel;
import gui.panels.add.phrase.AddSimplePanel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import main.LangCoach;
import main.TabOrder;

import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import database.Dictionary;
import database.Phrase;

public class AddPhraseFrame extends JFrame
{
	private static final long serialVersionUID = 5512396493144935047L;
	private JPanel contentPane;
	private JComboBox<Dictionary> comboBox;
	private JPanel mainPanel;
	private JButton btnConfirm;
	private AddPhrasePanel panelTop;
	private AddPhrasePanel panelBot;
	private JToggleButton conjugButton;
	private boolean conjugFlag = false;
	
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
		
		comboBox = new JComboBox<>(Dictionary.getDictionaries(coach.getCon()));
		comboBox.setSelectedItem(frameDictionary);
		comboBox.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { clickedChangeDict(); }});
		contentPane.add(comboBox, "2, 2, fill, default");
		
		conjugButton = new JToggleButton("Conjugation");
		conjugButton.addItemListener(new ItemListener() { public void itemStateChanged(ItemEvent ev) { toggleConjug(ev); }});
		contentPane.add(conjugButton, "4, 2");
				
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
	
	private void toggleConjug(ItemEvent e)
	{
		if(e.getStateChange() == ItemEvent.SELECTED)
			conjugFlag = true;
		else if(e.getStateChange() == ItemEvent.DESELECTED)
			conjugFlag = false;
			
		updateLayout();
	}
	
	private void clickedChangeDict()
	{
		frameDictionary = (Dictionary) comboBox.getSelectedItem();
		updateLayout();
	}
	
	private void updateLayout()
	{
		if(panelTop != null)
			mainPanel.remove(panelTop);
		if(panelBot != null)
			mainPanel.remove(panelBot);
		
		if(conjugFlag)
		{
			panelTop = new AddConjugPanel(frameDictionary.getLanguage1());
			panelBot = new AddConjugPanel(frameDictionary.getLanguage2());
		}
		else
		{
			panelTop = new AddSimplePanel(frameDictionary.getLanguage1());
			panelBot = new AddSimplePanel(frameDictionary.getLanguage2());
		}
		mainPanel.add(panelTop);
		mainPanel.add(panelBot);
		tabOrder = new LinkedList<Component>();
		for(Component i : panelTop.getComponents())
			tabOrder.add(i);
		for(Component i : panelBot.getComponents())
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
		
		if(phr1 != null && phr2 != null)
		{
			panelTop.clear();
			panelBot.clear();
			Phrase.createNew(coach.getCon(), Integer.parseInt(frameDictionary.getID()), conjugFlag, phr1, phr2);
			if (tabOrder != null)
				tabOrder.getFirst().requestFocus();
			System.out.println("Confirmed!");
		}
	}
}
