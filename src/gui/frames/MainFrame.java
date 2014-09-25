package gui.frames;

import gui.panels.exercise.ConjugPanel;
import gui.panels.exercise.EmptyPanel;
import gui.panels.exercise.ExercisePanel;
import gui.panels.exercise.SimplePhrasePanel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import main.LangCoach;
import main.TabOrder;

import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import database.Phrase;

public class MainFrame extends JFrame
{
	private static final long serialVersionUID = -4184140183903292400L;
	
	private JPanel  mainPanel;
	private JButton btnChangeUser;
	private JButton btnChangeDictionary;
	private JButton btnAddPhrase;
	private JButton btnCheck;
	private ExercisePanel exPanel;
	
	private LangCoach coach;
	private JButton btnOpenQueryConsole;
	
	public MainFrame(LangCoach coach)
	{

		this.coach = coach;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel();
		setContentPane(mainPanel);
		setMinimumSize(new Dimension(650, 600));
		
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setFocusCycleRoot(true);
		btnChangeUser = new JButton("Change User " + coach.getUser());
		btnChangeUser.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { clickedChangeUser(); }});
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow(3)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("100px"),
				FormSpecs.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,}));
		btnChangeUser.setMnemonic('u');
		btnChangeUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnChangeUser.setFocusable(false);
		mainPanel.add(btnChangeUser, "6, 2, 3, 1, fill, fill");
		
		btnChangeDictionary = new JButton("Change Dictionary " + coach.getDict());
		btnChangeDictionary.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { clickedChangeDict(); }});
		btnChangeDictionary.setMnemonic('d');
		btnChangeDictionary.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnChangeDictionary.setFocusable(false);
		mainPanel.add(btnChangeDictionary, "2, 2, 3, 1, fill, fill");
		
		btnCheck = new JButton("Verify Answer");
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCheck.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { clickedCheck(); }});
		mainPanel.add(btnCheck, "6, 4, 3, 1, fill, fill");
		
		btnAddPhrase = new JButton("Add a new Phrase");
		btnAddPhrase.setMnemonic('a');
		btnAddPhrase.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { clickedAdd(); }});
		btnAddPhrase.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddPhrase.setFocusable(false);
		if(coach.getDict() == null)
			btnAddPhrase.setEnabled(false);
		mainPanel.add(btnAddPhrase, "2, 6, 3, 1, fill, fill");
		
		btnOpenQueryConsole = new JButton("Open Query Console");
		btnOpenQueryConsole.setMnemonic('o');
		btnOpenQueryConsole.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { clickedOpenQueryConsole(); }});
		btnOpenQueryConsole.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mainPanel.add(btnOpenQueryConsole, "6, 6, 3, 1, fill, fill");
		
		JRootPane rootPane = SwingUtilities.getRootPane(btnCheck); 
		rootPane.setDefaultButton(btnCheck);
		
		setVisible(true);
		nextPhrase();
	}
	
	public void nextPhrase()
	{
		if(exPanel != null)
			remove(exPanel);
		
		btnCheck.setEnabled(false);
		
		Phrase phr = coach.getRandomPhraseOld();
		
		LinkedList<Component> tabOrder = new LinkedList<Component>();
		
		if (phr == null)
		{
			exPanel = new EmptyPanel(null);
			btnCheck.setText("Next Phrase");
			btnCheck.setMnemonic('n');
		}
		else
		{
			if (phr.conjug)
				exPanel = new ConjugPanel(phr);
			else
				exPanel = new SimplePhrasePanel(phr);
			
			exPanel.getPerfPanel().updateInfo(phr);
			
			for(Component i : exPanel.getComponents())
				tabOrder.add(i);
			
			btnCheck.setText("Verify Answer");
			btnCheck.setMnemonic('v');
		}
		
		tabOrder.add(btnCheck);
		
		add(exPanel, "2, 4, 3, 1");
		btnCheck.setEnabled(true);
		setFocusTraversalPolicy(new TabOrder(tabOrder));
		tabOrder.getFirst().requestFocus();
		
		revalidate();
	}
	
	public void enableAddPhrase()
	{
		btnAddPhrase.setEnabled(true);
	}
	
	public void updateDictBtnText()
	{
		btnChangeDictionary.setText("Change Dictionary " + coach.getDict());
	}
	
	public void updateUserBtnText()
	{
		btnChangeUser.setText("Change User " + coach.getUser());
	}
	
	private void clickedAdd()
	{
		coach.addPhrase();
	}
	
	private void clickedChangeUser()
	{
		coach.ChangeUser();
	}
	
	private void clickedChangeDict()
	{
		coach.ChangeDictionary();

	}
	
	private void clickedOpenQueryConsole()
	{
		coach.OpenQueryConsole();
	}
	
	private void clickedCheck()
	{
		if (btnCheck.getText().startsWith("N"))
		{
			nextPhrase();
		}
		else
		{
			if (exPanel.verify())
			{
				nextPhrase();
			}
			else
			{
				btnCheck.setText("Next Phrase");
				btnCheck.setMnemonic('n');
			}
		}
	}
}