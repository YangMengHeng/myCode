package gundamGUI;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gundamTools.GundamGUITools;
import gundamdata.Admin;
import gundamdata.User;
import gundamdata.gundamData;

public class GUILoginRegister extends Frame{
	//MainFrame Button, login, register, link, help, exit
		private Button loginB;
		private Button registerB;
		private Button exitB;
		private Button helpB;
		//Label Sign, account, password, title
		private Label accountL;
		private Label passwrodL;
		private Label Title;
		//TextField acc, pass
		private TextField acc;
		private TextField pass;
		//BorderLayout Panel, north, east, west
		private Panel westP;
		private Panel eastP;
		private Panel northP;
		//Current AccountNumber
		private int num;
		
	public GUILoginRegister() throws NullPointerException{
		//SetLayout
		this.setLayout(new BorderLayout());
		GundamGUITools.center(this);
		GundamGUITools.setTitleImage(this, "images/Icon.png");
		//Initialize Member
		this.Initialize();
		this.setTitle("GUNDAMCLUB");
		this.setBounds(225, 175, 1400, 720);
		this.setVisible(true);
		this.setResizable(false);
		//AddComponent
		this.addComponent();
		//addListener
		this.addListener();
	}
	//Initialize Member
	private void Initialize(){
		this.accountL = new Label("Account");
		this.passwrodL = new Label("Password");
		this.Title = new Label("GUNDAMCLUB");
		this.loginB = new Button("Login");
		this.registerB = new Button("Register");
		this.exitB = new Button("Exit");
		this.helpB = new Button("Help");
		this.westP = this.getWestPanel();
		this.eastP = this.getEastPanel();
		this.northP = this.getNorthPanel();
		
		this.accountL.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.passwrodL.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.loginB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.registerB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.helpB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.exitB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.Title.setFont(new Font("Times New Roman", Font.BOLD + Font.ITALIC, 30));
	}
	//AddComponent into MainFrame
	private void addComponent() {
		this.add(westP, BorderLayout.WEST);
		this.add(eastP, BorderLayout.CENTER);
		this.add(northP, BorderLayout.NORTH);
	}
	//Panel Design
	public Panel getNorthPanel() {
		Panel panel = new Panel();
		Color c = new Color(255, 215, 0);//Color-gold
		
		this.Title.setAlignment(FlowLayout.CENTER);
		panel.setSize(1380, 40);
		panel.setLayout(new BorderLayout());
		panel.add(this.Title, BorderLayout.CENTER);
		panel.setForeground(c);
		c = new Color(0, 0, 0);//Color-Black
		panel.setBackground(c);
		
		return panel;
	}
	public Panel getWestPanel() {
		Panel panel = new Panel();
		
		panel.add(new JLabel(new ImageIcon("images/±³¾°-mainframe.png")));
		 
		return panel;
	}
	public Panel getEastPanel(){
		Panel panel = new Panel();
		Panel p = new Panel();
		Label l = new Label("Freedom");
		this.acc = new TextField(20);
		this.pass = new TextField(20);
		FlowLayout temp = new FlowLayout(FlowLayout.CENTER, 10, 10);
		GridLayout g = new GridLayout(0, 1);

		pass.setEchoChar('*');
		l.setFont(new Font("Times New Roman", Font.BOLD, 30));
		l.setVisible(true);
		g.setHgap(20);
		g.setVgap(60);
		p.setLayout(g);
		p.add(this.loginB);
		p.add(this.registerB);
		p.add(this.helpB);
		p.add(this.exitB);
		panel.setLayout(temp);
		panel.add(this.accountL);
		panel.add(this.acc);
		panel.add(this.passwrodL);
		panel.add(this.pass);
		panel.add(l);
		panel.add(p);
		
		return panel;
	}
	public void addListener() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		this.loginB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				LOGIN();
			}
		});
		this.pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent act) {
				LOGIN();
			}
		});
		this.registerB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				GUIRegister reg = new GUIRegister(null, true);
				reg.setVisible(true);
			}
		});
		this.helpB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				GUIHelp help = new GUIHelp(null, true);
				help.setVisible(true);
			}
		});
		this.exitB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				System.exit(0);
			}
		});
	}
	private int Check() {
		gundamData gd = new gundamData(true);
		gundamData gd2;
		int temp = -1;
		String acc = new String(this.acc.getText());
		String pas = new String(this.pass.getText());
		String t;
		String t1;
		
		for(int i = 0; i < Admin.Count; i++) {
			t = gd.admin.get(i).getAccount();
			t1 = gd.admin.get(i).getAccP();
			if((acc.equals(t)) && (pas.equals(t1))) {
				temp = 1;
				this.num = i;
				return temp;
			}
		}
		if(temp != 1) {
			for(int k = 0; k < User.Count; k++) {
				t = gd.user.get(k).getUserA();
				t1 = gd.user.get(k).getUserP();
				if((acc.equals(t)) && (pas.equals(t1))) {
					temp = 0;
					this.num = k;
					return temp;
				}
			}
		}
		String t2 = new String("The account or password you entered is wrong! Please check and re-enter!");
		GUIDialogError gde = new GUIDialogError("ErrorNotice", t2);
		return temp;
	}
	public void CloseMainPage() {
		this.dispose();
	}
	public void LOGIN() {
		GUILogin lo;
		int t =  Check();
		if(t == 0) {
			lo = new GUILogin(null, true, false, this.num);
			this.setVisible(false);
			lo.setVisible(true);
			CloseMainPage();
		}
		if(t == 1) {
			lo = new GUILogin(null, true, true, this.num);
			this.setVisible(false);
			lo.setVisible(true);
			CloseMainPage();
		}
		else return;
	}
}