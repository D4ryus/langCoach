package gui.panels.exercise;

import main.LangCoach;
import database.Phrase;

public class NumberPanel extends SimplePhrasePanel
{
	private static final long serialVersionUID = -3278926543134734548L;
	
	private String phr1;
	private String phr2;
	
	private String[] swpPhr1;
	private String[] conPhr1;
	private String[] nrPhr1_9;
	private String[] nrPhr1_19;
	private String[] nrPhr1_90;
	private String[] nrPhr1_900;
	private String[] nrPhr1_9000;

	private String[] swpPhr2;
	private String[] conPhr2;
	private String[] nrPhr2_9;
	private String[] nrPhr2_19;
	private String[] nrPhr2_90;
	private String[] nrPhr2_900;
	private String[] nrPhr2_9000;

	public NumberPanel(Phrase phr)
	{
		super(phr);
	}
	
	@Override
	public void setText()
	{
		parsePhrase();
		selectRandomNumber();

		if(getPhrase().core.reverse)
			questionPanel.setText(phr2);
		else
			questionPanel.setText(phr1);
	}
	
	private void selectRandomNumber()
	{
		phr1 = "";
		phr2 = "";
		
		int tmp = getRand(nrPhr1_9000);
		if (tmp != -1)
		{
			phr1 += nrPhr1_9000[tmp];
			phr1 += conPhr1[2];
			phr2 += nrPhr2_9000[tmp];
			phr2 += conPhr2[2];
		}
		tmp = getRand(nrPhr1_900);
		if (tmp != -1)
		{
			phr1 += nrPhr1_900[tmp];
			phr1 += conPhr1[1];
			phr2 += nrPhr2_900[tmp];
			phr2 += conPhr2[1];
		}
		
		if (LangCoach.RANDOM.nextBoolean())
		{
			int teentmp = getRand(nrPhr1_90);
			int nrtmp = getRand(nrPhr1_9);
			
			if (teentmp != -1 && nrtmp != -1)
			{
				if (swpPhr1[0].equals("+"))
				{
					phr1 += nrPhr1_9[nrtmp];
					phr1 += conPhr1[0];
					phr1 += nrPhr1_90[teentmp];
				}
				else
				{
					phr1 += nrPhr1_90[teentmp];
					phr1 += conPhr1[0];
					phr1 += nrPhr1_9[nrtmp];
				}
				
				if (swpPhr2[0].equals("+"))
				{
					phr2 += nrPhr2_9[nrtmp];
					phr2 += conPhr2[0];
					phr2 += nrPhr2_90[teentmp];
				}
				else
				{
					phr2 += nrPhr2_90[teentmp];
					phr2 += conPhr2[0];
					phr2 += nrPhr2_9[nrtmp];
				}
			}
		}
		else
		{
			tmp = getRand(nrPhr1_19);
			if (tmp != -1)
			{
				phr1 += nrPhr1_19[tmp];
				phr1 += conPhr1[0];
				phr2 += nrPhr2_19[tmp];
				phr2 += conPhr2[0];
			}
		}
	}
	
	private int getRand(String[] nr)
	{
		int ret = -1;
		int tries = 3;
		int rand = LangCoach.RANDOM.nextInt(nr.length + 1);
		for (int i = 0; i < tries; i ++)
		{
			if (rand == nr.length)
				break;
			
			if (nr[rand].equals("-"))
			{
				rand = LangCoach.RANDOM.nextInt(nr.length);
				continue;
			}
			ret = rand;
		}
		return ret;
	}
	
	public void parsePhrase()
	{
		swpPhr1     = new String[3];
		conPhr1     = new String[3];
		nrPhr1_9    = new String[10];
		nrPhr1_19   = new String[10];
		nrPhr1_90   = new String[8];
		nrPhr1_900  = new String[9];
		nrPhr1_9000 = new String[9];
		
		swpPhr2     = new String[3];
		conPhr2     = new String[3];
		nrPhr2_9    = new String[10];
		nrPhr2_19   = new String[10];
		nrPhr2_90   = new String[8];
		nrPhr2_900  = new String[9];
		nrPhr2_9000 = new String[9];
		
		String[] tmp1 = getPhrase().phrase1.split("[#]");
		String[] tmp2 = getPhrase().phrase2.split("[#]");
		
		System.arraycopy(tmp1,  0, swpPhr1,     0, swpPhr1.length);
		System.arraycopy(tmp1,  3, nrPhr1_9,    0, nrPhr1_9.length);
		System.arraycopy(tmp1, 13, nrPhr1_19,   0, nrPhr1_19.length);
		System.arraycopy(tmp1, 23, nrPhr1_90,   0, nrPhr1_90.length);
		System.arraycopy(tmp1, 31, conPhr1,     0, 1);
		System.arraycopy(tmp1, 32, nrPhr1_900,  0, nrPhr1_900.length);
		System.arraycopy(tmp1, 41, conPhr1,     1, 1);
		System.arraycopy(tmp1, 42, nrPhr1_9000, 0, nrPhr1_9000.length);
		System.arraycopy(tmp1, 51, conPhr1,     2, 1);
		
		System.arraycopy(tmp2,  0, swpPhr2,     0, swpPhr2.length);
		System.arraycopy(tmp2,  3, nrPhr2_9,    0, nrPhr2_9.length);
		System.arraycopy(tmp2, 13, nrPhr2_19,   0, nrPhr2_19.length);
		System.arraycopy(tmp2, 23, nrPhr2_90,   0, nrPhr2_90.length);
		System.arraycopy(tmp2, 31, conPhr2,     0, 1);
		System.arraycopy(tmp2, 32, nrPhr2_900,  0, nrPhr2_900.length);
		System.arraycopy(tmp2, 41, conPhr2,     1, 1);
		System.arraycopy(tmp2, 42, nrPhr2_9000, 0, nrPhr2_9000.length);
		System.arraycopy(tmp2, 51, conPhr2,     2, 1);
		
		for (int i = 0; i < conPhr1.length; i++)
			if (conPhr1[i].equals("-"))
				conPhr1[i] = "";
		
		for (int i = 0; i < conPhr2.length; i++)
			if (conPhr2[i].equals("-"))
				conPhr2[i] = "";
	}
	
	@Override
	public boolean verify()
	{
		String sol;

		if (getPhrase().core.reverse)
			sol = phr1;
		else
			sol = phr2;

		boolean answerCorrect = answerPanel.getAnswer().equals(sol);

		updatePerfData(answerCorrect);
		if (!answerCorrect)
		{
			answerPanel.setSolution(sol);
			answerPanel.highlight();
		}

		getPhrase().perf.saveToDB();
		repaint();
		return answerCorrect;
	}
}