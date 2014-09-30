package gui.panels.add.phrase;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import database.Language;
import javax.swing.JCheckBox;

//public class AddNumberPanel extends JPanel
public class AddNumberPanel extends AddPhrasePanel
{
	private static final long serialVersionUID = -6205930465861648297L;
	private JTextField txt0;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;
	private JTextField txt8;
	private JTextField txt9;
	private JTextField txt10;
	private JTextField txt11;
	private JTextField txt12;
	private JTextField txt13;
	private JTextField txt14;
	private JTextField txt15;
	private JTextField txt16;
	private JTextField txt17;
	private JTextField txt18;
	private JTextField txt19;
	private JTextField txt20;
	private JTextField txt30;
	private JTextField txt40;
	private JTextField txt50;
	private JTextField txt60;
	private JTextField txt70;
	private JTextField txt80;
	private JTextField txt90;
	private JTextField txt100;
	private JTextField txt200;
	private JTextField txt300;
	private JTextField txt400;
	private JTextField txt500;
	private JTextField txt600;
	private JTextField txt700;
	private JTextField txt800;
	private JTextField txt900;
	private JTextField txt1000;
	private JTextField txt2000;
	private JTextField txt3000;
	private JTextField txt4000;
	private JTextField txt5000;
	private JTextField txt6000;
	private JTextField txt7000;
	private JTextField txt8000;
	private JTextField txt9000;
	private JTextField txtCon_20_90;
	private JTextField txtCon_100_900;
	private JTextField txtCon_1000_9000;

	public AddNumberPanel(Language lang)
//		public AddNumberPanel()
		{
		super(lang);
		setLayout(new GridLayout(0, 5, 0, 0));
		
		JPanel numberPanel_1_9 = new JPanel();
		add(numberPanel_1_9);
		numberPanel_1_9.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label_37 = new JLabel("0:");
		label_37.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1_9.add(label_37);
		
		txt0 = new JTextField();
		numberPanel_1_9.add(txt0);
		txt0.setColumns(10);
		
		JLabel label_18 = new JLabel("1:");
		label_18.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1_9.add(label_18);
		
		txt1 = new JTextField();
		txt1.setColumns(10);
		numberPanel_1_9.add(txt1);
		
		JLabel label_19 = new JLabel("2:");
		label_19.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1_9.add(label_19);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		numberPanel_1_9.add(txt2);
		
		JLabel label_20 = new JLabel("3:");
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1_9.add(label_20);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		numberPanel_1_9.add(txt3);
		
		JLabel label_21 = new JLabel("4:");
		label_21.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1_9.add(label_21);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		numberPanel_1_9.add(txt4);
		
		JLabel label_22 = new JLabel("5:");
		label_22.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1_9.add(label_22);
		
		txt5 = new JTextField();
		txt5.setColumns(10);
		numberPanel_1_9.add(txt5);
		
		JLabel label_23 = new JLabel("6:");
		label_23.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1_9.add(label_23);
		
		txt6 = new JTextField();
		txt6.setColumns(10);
		numberPanel_1_9.add(txt6);
		
		JLabel label_24 = new JLabel("7:");
		label_24.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1_9.add(label_24);
		
		txt7 = new JTextField();
		txt7.setColumns(10);
		numberPanel_1_9.add(txt7);
		
		JLabel label_25 = new JLabel("8:");
		label_25.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1_9.add(label_25);
		
		txt8 = new JTextField();
		txt8.setColumns(10);
		numberPanel_1_9.add(txt8);
		
		JLabel label_26 = new JLabel("9:");
		label_26.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1_9.add(label_26);
		
		txt9 = new JTextField();
		txt9.setColumns(10);
		numberPanel_1_9.add(txt9);
		
		JLabel lblBlank6 = new JLabel("");
		numberPanel_1_9.add(lblBlank6);
		
		JPanel numberPanel_10_19 = new JPanel();
		add(numberPanel_10_19);
		numberPanel_10_19.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label_27 = new JLabel("10:");
		label_27.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_10_19.add(label_27);
		
		txt10 = new JTextField();
		numberPanel_10_19.add(txt10);
		txt10.setColumns(10);
		
		JLabel label_28 = new JLabel("11:");
		label_28.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_10_19.add(label_28);
		
		txt11 = new JTextField();
		numberPanel_10_19.add(txt11);
		txt11.setColumns(10);
		
		JLabel label_29 = new JLabel("12:");
		label_29.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_10_19.add(label_29);
		
		txt12 = new JTextField();
		numberPanel_10_19.add(txt12);
		txt12.setColumns(10);
		
		JLabel label_30 = new JLabel("13:");
		label_30.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_10_19.add(label_30);
		
		txt13 = new JTextField();
		numberPanel_10_19.add(txt13);
		txt13.setColumns(10);
		
		JLabel label_31 = new JLabel("14:");
		label_31.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_10_19.add(label_31);
		
		txt14 = new JTextField();
		numberPanel_10_19.add(txt14);
		txt14.setColumns(10);
		
		JLabel label_32 = new JLabel("15:");
		label_32.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_10_19.add(label_32);
		
		txt15 = new JTextField();
		numberPanel_10_19.add(txt15);
		txt15.setColumns(10);
		
		JLabel label_33 = new JLabel("16:");
		label_33.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_10_19.add(label_33);
		
		txt16 = new JTextField();
		numberPanel_10_19.add(txt16);
		txt16.setColumns(10);
		
		JLabel label_34 = new JLabel("17:");
		label_34.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_10_19.add(label_34);
		
		txt17 = new JTextField();
		numberPanel_10_19.add(txt17);
		txt17.setColumns(10);
		
		JLabel label_35 = new JLabel("18:");
		label_35.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_10_19.add(label_35);
		
		txt18 = new JTextField();
		numberPanel_10_19.add(txt18);
		txt18.setColumns(10);
		
		JLabel label_36 = new JLabel("19:");
		label_36.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_10_19.add(label_36);
		
		txt19 = new JTextField();
		numberPanel_10_19.add(txt19);
		txt19.setColumns(10);
		
		JLabel lblBlank8 = new JLabel("");
		numberPanel_10_19.add(lblBlank8);
		
		JPanel numberPanel_20_90 = new JPanel();
		add(numberPanel_20_90);
		numberPanel_20_90.setLayout(new GridLayout(0, 2, 0, 0));
		
		JCheckBox chckbxSwaped_20_90 = new JCheckBox("swaped");
		numberPanel_20_90.add(chckbxSwaped_20_90);
		
		JLabel lblBlank1 = new JLabel("");
		numberPanel_20_90.add(lblBlank1);
		
		JLabel lblBlank2 = new JLabel("");
		numberPanel_20_90.add(lblBlank2);
		
		JLabel lblBlank3 = new JLabel("");
		numberPanel_20_90.add(lblBlank3);
		
		JLabel label_10 = new JLabel("20:");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_20_90.add(label_10);
		
		txt20 = new JTextField();
		txt20.setColumns(10);
		numberPanel_20_90.add(txt20);
		
		JLabel label_11 = new JLabel("30:");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_20_90.add(label_11);
		
		txt30 = new JTextField();
		txt30.setColumns(10);
		numberPanel_20_90.add(txt30);
		
		JLabel label_12 = new JLabel("40:");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_20_90.add(label_12);
		
		txt40 = new JTextField();
		txt40.setColumns(10);
		numberPanel_20_90.add(txt40);
		
		JLabel label_13 = new JLabel("50:");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_20_90.add(label_13);
		
		txt50 = new JTextField();
		txt50.setColumns(10);
		numberPanel_20_90.add(txt50);
		
		JLabel label_14 = new JLabel("60:");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_20_90.add(label_14);
		
		txt60 = new JTextField();
		txt60.setColumns(10);
		numberPanel_20_90.add(txt60);
		
		JLabel label_15 = new JLabel("70:");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_20_90.add(label_15);
		
		txt70 = new JTextField();
		txt70.setColumns(10);
		numberPanel_20_90.add(txt70);
		
		JLabel label_16 = new JLabel("80:");
		label_16.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_20_90.add(label_16);
		
		txt80 = new JTextField();
		txt80.setColumns(10);
		numberPanel_20_90.add(txt80);
		
		JLabel label_17 = new JLabel("90:");
		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_20_90.add(label_17);
		
		txt90 = new JTextField();
		txt90.setColumns(10);
		numberPanel_20_90.add(txt90);
		
		JLabel lblCon_20_90 = new JLabel("connective:");
		lblCon_20_90.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_20_90.add(lblCon_20_90);
		
		txtCon_20_90 = new JTextField();
		numberPanel_20_90.add(txtCon_20_90);
		txtCon_20_90.setColumns(10);
		
		JPanel numberPanel_100_900 = new JPanel();
		add(numberPanel_100_900);
		numberPanel_100_900.setLayout(new GridLayout(0, 2, 0, 0));
		
		JCheckBox chckbxSwaped_100_900 = new JCheckBox("swaped");
		numberPanel_100_900.add(chckbxSwaped_100_900);
		
		JLabel lblBlank5 = new JLabel("");
		numberPanel_100_900.add(lblBlank5);
		
		JLabel label = new JLabel("100:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_100_900.add(label);
		
		txt100 = new JTextField();
		txt100.setColumns(10);
		numberPanel_100_900.add(txt100);
		
		JLabel label_1 = new JLabel("200:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_100_900.add(label_1);
		
		txt200 = new JTextField();
		txt200.setColumns(10);
		numberPanel_100_900.add(txt200);
		
		JLabel label_2 = new JLabel("300:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_100_900.add(label_2);
		
		txt300 = new JTextField();
		txt300.setColumns(10);
		numberPanel_100_900.add(txt300);
		
		JLabel label_3 = new JLabel("400:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_100_900.add(label_3);
		
		txt400 = new JTextField();
		txt400.setColumns(10);
		numberPanel_100_900.add(txt400);
		
		JLabel label_4 = new JLabel("500:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_100_900.add(label_4);
		
		txt500 = new JTextField();
		txt500.setColumns(10);
		numberPanel_100_900.add(txt500);
		
		JLabel label_5 = new JLabel("600:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_100_900.add(label_5);
		
		txt600 = new JTextField();
		txt600.setColumns(10);
		numberPanel_100_900.add(txt600);
		
		JLabel label_6 = new JLabel("700:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_100_900.add(label_6);
		
		txt700 = new JTextField();
		txt700.setColumns(10);
		numberPanel_100_900.add(txt700);
		
		JLabel label_7 = new JLabel("800:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_100_900.add(label_7);
		
		txt800 = new JTextField();
		txt800.setColumns(10);
		numberPanel_100_900.add(txt800);
		
		JLabel label_8 = new JLabel("900:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_100_900.add(label_8);
		
		txt900 = new JTextField();
		txt900.setColumns(10);
		numberPanel_100_900.add(txt900);
		
		JLabel lblCon_100_900 = new JLabel("connective:");
		lblCon_100_900.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_100_900.add(lblCon_100_900);
		
		txtCon_100_900 = new JTextField();
		numberPanel_100_900.add(txtCon_100_900);
		txtCon_100_900.setColumns(10);
		
		JPanel numberPanel_1000_9000 = new JPanel();
		numberPanel_1000_9000.setEnabled(false);
		add(numberPanel_1000_9000);
		numberPanel_1000_9000.setLayout(new GridLayout(0, 2, 0, 0));
		
		JCheckBox chckbxSwaped_1000_9000 = new JCheckBox("swaped");
		numberPanel_1000_9000.add(chckbxSwaped_1000_9000);
		
		JLabel lblBlank7 = new JLabel("");
		numberPanel_1000_9000.add(lblBlank7);
		
		JLabel lbl1 = new JLabel("1000:");
		lbl1.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1000_9000.add(lbl1);
		
		txt1000 = new JTextField();
		numberPanel_1000_9000.add(txt1000);
		txt1000.setColumns(10);
		
		JLabel lbl2 = new JLabel("2000:");
		lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1000_9000.add(lbl2);
		
		txt2000 = new JTextField();
		numberPanel_1000_9000.add(txt2000);
		txt2000.setColumns(10);
		
		JLabel lbl3 = new JLabel("3000:");
		lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1000_9000.add(lbl3);
		
		txt3000 = new JTextField();
		numberPanel_1000_9000.add(txt3000);
		txt3000.setColumns(10);
		
		JLabel lbl4 = new JLabel("4000:");
		lbl4.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1000_9000.add(lbl4);
		
		txt4000 = new JTextField();
		numberPanel_1000_9000.add(txt4000);
		txt4000.setColumns(10);
		
		JLabel lbl5 = new JLabel("5000:");
		lbl5.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1000_9000.add(lbl5);
		
		txt5000 = new JTextField();
		numberPanel_1000_9000.add(txt5000);
		txt5000.setColumns(10);
		
		JLabel lbl6 = new JLabel("6000:");
		lbl6.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1000_9000.add(lbl6);
		
		txt6000 = new JTextField();
		numberPanel_1000_9000.add(txt6000);
		txt6000.setColumns(10);
		
		JLabel lbl7 = new JLabel("7000:");
		lbl7.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1000_9000.add(lbl7);
		
		txt7000 = new JTextField();
		numberPanel_1000_9000.add(txt7000);
		txt7000.setColumns(10);
		
		JLabel lbl8 = new JLabel("8000:");
		lbl8.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1000_9000.add(lbl8);
		
		txt8000 = new JTextField();
		numberPanel_1000_9000.add(txt8000);
		txt8000.setColumns(10);
		
		JLabel lbl9 = new JLabel("9000:");
		lbl9.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1000_9000.add(lbl9);
		
		txt9000 = new JTextField();
		numberPanel_1000_9000.add(txt9000);
		txt9000.setColumns(10);
		
		JLabel lblCon_1000_9000 = new JLabel("connective:");
		lblCon_1000_9000.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel_1000_9000.add(lblCon_1000_9000);
		
		txtCon_1000_9000 = new JTextField();
		numberPanel_1000_9000.add(txtCon_1000_9000);
		txtCon_1000_9000.setColumns(10);
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
		Component[] comp = new Component[49];
		comp[0]  = txt0;
		comp[1]  = txt1;
		comp[2]  = txt2;
		comp[3]  = txt3;
		comp[4]  = txt4;
		comp[5]  = txt5;
		comp[6]  = txt6;
		comp[7]  = txt7;
		comp[8]  = txt8;
		comp[9]  = txt9;
		comp[10] = txt10;
		comp[11] = txt11;
		comp[12] = txt12;
		comp[13] = txt13;
		comp[14] = txt14;
		comp[15] = txt15;
		comp[16] = txt16;
		comp[17] = txt17;
		comp[18] = txt18;
		comp[19] = txt19;
		comp[20] = txt20;
		comp[21] = txt30;
		comp[22] = txt40;
		comp[23] = txt50;
		comp[24] = txt60;
		comp[25] = txt70;
		comp[26] = txt80;
		comp[27] = txt90;
		comp[28] = txtCon_20_90;
		comp[29] = txt100;
		comp[30] = txt200;
		comp[31] = txt300;
		comp[32] = txt400;
		comp[33] = txt500;
		comp[34] = txt600;
		comp[35] = txt700;
		comp[36] = txt800;
		comp[37] = txt900;
		comp[38] = txtCon_100_900;
		comp[39] = txt1000;
		comp[40] = txt2000;
		comp[41] = txt3000;
		comp[42] = txt4000;
		comp[43] = txt5000;
		comp[44] = txt6000;
		comp[45] = txt7000;
		comp[46] = txt8000;
		comp[47] = txt9000;
		comp[48] = txtCon_1000_9000;
		return comp;
	}
}