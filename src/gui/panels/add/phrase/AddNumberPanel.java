package gui.panels.add.phrase;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import database.Language;

//public class AddNumberPanel extends JPanel
//{
//	public AddNumberPanel() {
public class AddNumberPanel extends AddPhrasePanel
{
	private static final long	serialVersionUID	= -6205930465861648297L;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;
	private JTextField txt8;
	private JTextField txt9;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	
	public AddNumberPanel(Language lang) {
		super(lang);
		setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel numberPanel1 = new JPanel();
		add(numberPanel1);
		numberPanel1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label_18 = new JLabel("1:");
		label_18.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel1.add(label_18);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		numberPanel1.add(textField_18);
		
		JLabel label_19 = new JLabel("2:");
		label_19.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel1.add(label_19);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		numberPanel1.add(textField_19);
		
		JLabel label_20 = new JLabel("3:");
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel1.add(label_20);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		numberPanel1.add(textField_20);
		
		JLabel label_21 = new JLabel("4:");
		label_21.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel1.add(label_21);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		numberPanel1.add(textField_21);
		
		JLabel label_22 = new JLabel("5:");
		label_22.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel1.add(label_22);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		numberPanel1.add(textField_22);
		
		JLabel label_23 = new JLabel("6:");
		label_23.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel1.add(label_23);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		numberPanel1.add(textField_23);
		
		JLabel label_24 = new JLabel("7:");
		label_24.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel1.add(label_24);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		numberPanel1.add(textField_24);
		
		JLabel label_25 = new JLabel("8:");
		label_25.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel1.add(label_25);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		numberPanel1.add(textField_25);
		
		JLabel label_26 = new JLabel("9:");
		label_26.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel1.add(label_26);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		numberPanel1.add(textField_26);
		
		JPanel numberPanel2 = new JPanel();
		add(numberPanel2);
		numberPanel2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label_9 = new JLabel("10:");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel2.add(label_9);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		numberPanel2.add(textField_9);
		
		JLabel label_10 = new JLabel("20:");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel2.add(label_10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		numberPanel2.add(textField_10);
		
		JLabel label_11 = new JLabel("30:");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel2.add(label_11);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		numberPanel2.add(textField_11);
		
		JLabel label_12 = new JLabel("40:");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel2.add(label_12);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		numberPanel2.add(textField_12);
		
		JLabel label_13 = new JLabel("50:");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel2.add(label_13);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		numberPanel2.add(textField_13);
		
		JLabel label_14 = new JLabel("60:");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel2.add(label_14);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		numberPanel2.add(textField_14);
		
		JLabel label_15 = new JLabel("70:");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel2.add(label_15);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		numberPanel2.add(textField_15);
		
		JLabel label_16 = new JLabel("80:");
		label_16.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel2.add(label_16);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		numberPanel2.add(textField_16);
		
		JLabel label_17 = new JLabel("90:");
		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel2.add(label_17);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		numberPanel2.add(textField_17);
		
		JPanel numberPanel3 = new JPanel();
		add(numberPanel3);
		numberPanel3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label = new JLabel("100:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel3.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		numberPanel3.add(textField);
		
		JLabel label_1 = new JLabel("200:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel3.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		numberPanel3.add(textField_1);
		
		JLabel label_2 = new JLabel("300:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel3.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		numberPanel3.add(textField_2);
		
		JLabel label_3 = new JLabel("400:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel3.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		numberPanel3.add(textField_3);
		
		JLabel label_4 = new JLabel("500:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel3.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		numberPanel3.add(textField_4);
		
		JLabel label_5 = new JLabel("600:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel3.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		numberPanel3.add(textField_5);
		
		JLabel label_6 = new JLabel("700:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel3.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		numberPanel3.add(textField_6);
		
		JLabel label_7 = new JLabel("800:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel3.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		numberPanel3.add(textField_7);
		
		JLabel label_8 = new JLabel("900:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel3.add(label_8);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		numberPanel3.add(textField_8);
		
		JPanel numberPanel4 = new JPanel();
		add(numberPanel4);
		numberPanel4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbl1 = new JLabel("1000:");
		lbl1.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel4.add(lbl1);
		
		txt1 = new JTextField();
		numberPanel4.add(txt1);
		txt1.setColumns(10);
		
		JLabel lbl2 = new JLabel("2000:");
		lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel4.add(lbl2);
		
		txt2 = new JTextField();
		numberPanel4.add(txt2);
		txt2.setColumns(10);
		
		JLabel lbl3 = new JLabel("3000:");
		lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel4.add(lbl3);
		
		txt3 = new JTextField();
		numberPanel4.add(txt3);
		txt3.setColumns(10);
		
		JLabel lbl4 = new JLabel("4000:");
		lbl4.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel4.add(lbl4);
		
		txt4 = new JTextField();
		numberPanel4.add(txt4);
		txt4.setColumns(10);
		
		JLabel lbl5 = new JLabel("5000:");
		lbl5.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel4.add(lbl5);
		
		txt5 = new JTextField();
		numberPanel4.add(txt5);
		txt5.setColumns(10);
		
		JLabel lbl6 = new JLabel("6000:");
		lbl6.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel4.add(lbl6);
		
		txt6 = new JTextField();
		numberPanel4.add(txt6);
		txt6.setColumns(10);
		
		JLabel lbl7 = new JLabel("7000:");
		lbl7.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel4.add(lbl7);
		
		txt7 = new JTextField();
		numberPanel4.add(txt7);
		txt7.setColumns(10);
		
		JLabel lbl8 = new JLabel("8000:");
		lbl8.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel4.add(lbl8);
		
		txt8 = new JTextField();
		numberPanel4.add(txt8);
		txt8.setColumns(10);
		
		JLabel lbl9 = new JLabel("9000:");
		lbl9.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel4.add(lbl9);
		
		txt9 = new JTextField();
		numberPanel4.add(txt9);
		txt9.setColumns(10);
	}

	public String getText()
	{
		return "test";
	}

	public void clear()
	{
		
	}

	public Component[] getComponents()
	{
		Component[] comp = new Component[36];
		comp[0]  = txt1;
		comp[1]  = txt2;
		comp[2]  = txt3;
		comp[3]  = txt4;
		comp[4]  = txt5;
		comp[5]  = txt6;
		comp[6]  = txt7;
		comp[7]  = txt8;
		comp[8]  = txt9;
		comp[9]  = textField;
		comp[10] = textField_1;
		comp[11] = textField_2;
		comp[12] = textField_3;
		comp[13] = textField_4;
		comp[14] = textField_5;
		comp[15] = textField_6;
		comp[16] = textField_7;
		comp[17] = textField_8;
		comp[18] = textField_9;
		comp[19] = textField_10;
		comp[20] = textField_11;
		comp[21] = textField_12;
		comp[22] = textField_13;
		comp[23] = textField_14;
		comp[24] = textField_15;
		comp[25] = textField_16;
		comp[26] = textField_17;
		comp[27] = textField_18;
		comp[28] = textField_19;
		comp[29] = textField_20;
		comp[30] = textField_21;
		comp[31] = textField_22;
		comp[32] = textField_23;
		comp[33] = textField_24;
		comp[34] = textField_25;
		comp[35] = textField_26;
		return comp;
	}
}