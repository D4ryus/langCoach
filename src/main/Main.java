package main;

import gui.frames.MainFrame;

import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import database.DBObject;

public class Main
{
	public static void main(String[] args) throws SQLException
	{
		setLook();

		LangCoach brain = new LangCoach(DBObject.start());
		brain.setMainFrame(new MainFrame(brain));
	}

	public static void setLook()
	{
	try {
//		for( LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
//			System.out.println("look and feels: " + info.getClassName());

		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
	}
	catch (UnsupportedLookAndFeelException e) { }
	catch (ClassNotFoundException e) { }
	catch (InstantiationException e) { }
	catch (IllegalAccessException e) { }
	}
}
