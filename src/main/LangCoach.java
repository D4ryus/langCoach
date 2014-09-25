package main;

import gui.frames.AddDictionaryFrame;
import gui.frames.AddPhraseFrame;
import gui.frames.ChangeDictionaryFrame;
import gui.frames.ChangeUserFrame;
import gui.frames.MainFrame;
import gui.frames.QueryFrame;

import java.sql.Connection;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import database.Dictionary;
import database.Phrase;
import database.Phrase.CorePhrase;
import database.User;

public class LangCoach
{
	private Connection con;
	private User user;
	private Dictionary dict;
	private MainFrame mainFrame;
	private CorePhrase[] phrases;
	
	public LangCoach(Connection con)
	{
		this.con = con;
		
		user = User.getLatest(con);
		if (user == null)
			user = addUser(true);
		
		dict = Dictionary.getTop(con);
	}
	
	public void updateCorePhrases()
	{
		if	(dict != null)
			phrases = Phrase.getPhrases(con, dict, user);
	}
	
	public void OpenQueryConsole()
	{
		QueryFrame frame = new QueryFrame(this);
		frame.setVisible(true);
	}
	
	public void ChangeUser()
	{
		ChangeUserFrame frame = new ChangeUserFrame(this);
		frame.setVisible(true);
	}
	
	public void ChangeDictionary()
	{
		ChangeDictionaryFrame frame = new ChangeDictionaryFrame(this);
		frame.setVisible(true);
	}
	
	public void addPhrase()
	{
		AddPhraseFrame frame = new AddPhraseFrame(this);
		frame.setVisible(true);
	}
	
	public void addDictionary()
	{
		AddDictionaryFrame frame = new AddDictionaryFrame(this);
		frame.setVisible(true);
	}
	
	public User addUser(boolean newDB)
	{
		String input = null;
		
		if (newDB)
		{
			input = JOptionPane.showInputDialog(new JFrame(),
					"Could not find any User, please add a new one. Username: ",
					"Add User", JOptionPane.PLAIN_MESSAGE);
			if(input == null)
				System.exit(0);
			while (input.equals(""))
			{
				JOptionPane.showMessageDialog(new JFrame(),
					    "Cannot create LangDB without any user.",
					    "Thats not how this works",
					    JOptionPane.ERROR_MESSAGE);
				
				input = JOptionPane.showInputDialog(new JFrame(),
						"Username: ", "adding a new User", JOptionPane.PLAIN_MESSAGE);
				if(input == null)
					System.exit(0);
			}

		}
		else
		{
			input = JOptionPane.showInputDialog(new JFrame(),
					"Username: ", "Add User", JOptionPane.PLAIN_MESSAGE);
			if (input == null)
				return null;
			
			while(input.equals(""))
			{
				input = JOptionPane.showInputDialog(new JFrame(),
						"Username: ", "Add User", JOptionPane.PLAIN_MESSAGE);
				if (input == null)
					return null;
			}
		}
		return User.createNew(con, input);
	}

	public void setMainFrame(MainFrame frame)
	{
		mainFrame = frame;
		mainFrame.setTitle("User: " + user.name
				+ " - Logins: " + user.logins
				+ " - LastLogin: " + TimeCalc.calcPrettyTime(user.lastLog));
	}

	public void setDict(Dictionary newDict)
	{
		if (newDict == null || (dict != null && newDict.getID().equals(dict.getID())))
			return;
		
		this.dict = newDict;
		mainFrame.enableAddPhrase();
		mainFrame.updateDictBtnText();
		mainFrame.nextPhrase();
	}
	
	public void setUser(User newUser)
	{
		if (newUser == null || newUser.getID().equals(user.getID()))
			return;
		
		if (    (newUser.lastLog == null)
			 || (System.currentTimeMillis() - newUser.lastLog.getTime()) > 600_000)
		{ // if lastlog is older then 10 min or first login
			newUser.logins++;
		}
		
		mainFrame.setTitle("User: " + newUser.name
					+ " - Logins: " + newUser.logins
					+ " - LastLogin: " + TimeCalc.calcPrettyTime(newUser.lastLog));
		
		newUser.lastLog = new java.sql.Timestamp(System.currentTimeMillis());
		newUser.saveToDB();
		this.user = newUser;
		updateCorePhrases();
		mainFrame.updateUserBtnText();
		mainFrame.nextPhrase();
	}
	
	private static int max = 0;
	private static int sum = 0;
	public Phrase getRandomPhraseNew()
	{
		Phrase ret = null;
		
		if (phrases == null)
			updateCorePhrases();
		if (phrases == null)
			return ret;
		
		if (max == 0 || sum == 0)
		{
			for (CorePhrase i : phrases)
				if (max < (i.success < 0 ? i.success * (-1) : i.success))
					max = (i.success < 0 ? i.success * (-1) : i.success);
			
			for (int i = 0; i < phrases.length; i++)
			{
				if (phrases[i].success > 0)
					sum += (1.0 / (double)phrases[i].success) * (double)max;
				else if (phrases[i].success < 0)
					sum += -1 * phrases[i].success * max;
				else
					sum += 1;
			}
		}
		
		return ret;
	}

	public Phrase getRandomPhraseOld()
	{
		Phrase ret = null;
		
		if (phrases == null)
			updateCorePhrases();
		if (phrases == null)
			return ret;
		
		int count = phrases.length;
		if (count > 0)
		{
			int[] tmp = new int[count];
			max = 1;
			
			for (CorePhrase i : phrases)
				if (max < (i.success < 0 ? i.success * (-1) : i.success))
					max = (i.success < 0 ? i.success * (-1) : i.success);
			
			for (int i = 0; i < count; i++)
			{
				if (i != 0)
					tmp[i] = tmp[i-1];
				else
					tmp[i] = 0;
				
				if (phrases[i].success > 0)
					tmp[i] += (1.0 / (double)phrases[i].success) * (double)max;
				else if (phrases[i].success < 0)
					tmp[i] += -1 * phrases[i].success * max;
				else
					tmp[i] += 1;
			}
			
			int rand = new Random().nextInt(tmp[count -1]);
			
			for (int i = 0; i < count; i++)
			{
				if (tmp[i] > rand)
				{
					ret = phrases[i].getFullPhrase(con, user);
					break;
				}
			}
			ret.setDict(dict);
		}
		
		if (ret != null)
			ret.perf.max = max;
		return ret;
	}
	
	public Connection getCon()
	{
		return con;
	}
	
	public Dictionary getDict()
	{
		return dict;
	}
	
	public User getUser()
	{
		return user;
	}
}