package gundamGUI;

import java.awt.GridLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;

import gundamTools.GundamGUITools;
import gundamdata.User;
import gundamdata.gundamData;

public class GUIRegister extends Dialog{
	//Label, account, password, name, contact, addr
	private Label accountL;
	private Label passwordL;
	private Label nameL;
	private Label contactL;
	private Label addrL;
	private Label Title;
	//Button, enter, cancel
	private Button enterB;
	private Button cancelB;
	//TextField, account, password, name, contact, addr
	private TextField accountT;
	private TextField passwordT;
	private TextField nameT;
	private TextField contactT;
	private TextField addrT;
	//GridLayout
	private GridLayout grid;
	public GUIRegister(Frame frame, boolean sign){
		super(frame, sign);
		this.Initialize();
		this.addComponent();
		this.addListener();
	}
	public void Initialize() {
		this.Title = new Label("Register");
		this.accountL = new Label("Account:");
		this.passwordL = new Label("Password:");
		this.nameL = new Label("YourName:");
		this.contactL = new Label("YourContact:");
		this.addrL = new Label("YourAddr:");
		this.accountL.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.passwordL.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.nameL.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.contactL.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.addrL.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.Title.setFont(new Font("Times New Roman", Font.BOLD, 40));
		this.Title.setAlignment(FlowLayout.CENTER);
		
		this.enterB = new Button("Enter");
		this.cancelB = new Button("Cancel");
		this.enterB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.cancelB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		this.setTitle("GundamClubRegister");
		this.setSize(500, 600);
		GundamGUITools.center(this);
		GundamGUITools.setTitleImage(this, "images/Icon-reg.png");
		this.setResizable(false);
	}
	public void addListener() {
		this.enterB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				boolean b = CheckRegData();
				if(b == true) {
					GUITips gde = new GUITips("Congratulations!", " You had been Registered! Pls Enter the account.");
					SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
					Date date = new Date(System.currentTimeMillis());
					User user = new User(User.Count + 1, accountT.getText(), passwordT.getText(), nameT.getText(), 
							contactT.getText(),addrT.getText(), 0, date.toString(), "");
					gundamData gd = new gundamData("user");
					if(!gd.addData(user)) {
						System.out.println("Error Code:2132");
					}
					Close();
				}
				else {
					GUIDialogError gde = new GUIDialogError("ErrorWarning", "Pls Browse The Help Tips.");
					accountT.setText("");
					passwordT.setText("");
					nameT.setText("");
					contactT.setText("");
					addrT.setText("");
				}
			}
		});
		this.cancelB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				Close();
			}
		});
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				Close();
			}
		});
	}
	public void addComponent() {
		this.accountT = new TextField(30);
		this.passwordT = new TextField(30);
		this.contactT = new TextField(30);
		this.addrT = new TextField(30);
		this.nameT = new TextField(30);
		Panel panel = new Panel();
		this.grid = new GridLayout(7,1);
		grid.setVgap(10);
		this.setLayout(this.grid);
		this.add(this.Title);
		panel.add(this.accountL);
		panel.add(this.accountT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.passwordL);
		panel.add(this.passwordT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.nameL);
		panel.add(this.nameT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.contactL);
		panel.add(this.contactT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.addrL);
		panel.add(this.addrT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.enterB);
		panel.add(this.cancelB);
		this.add(panel);
	}
	public void Close() {
		this.dispose();
	}
	private boolean CheckRegData() {
		if(accountT.getText().length() > 20 || passwordT.getText().length() > 20 || 
				accountT.getText().length() <= 0 || passwordT.getText().length() <= 0 ||
				nameT.getText().length() <= 0 || nameT.getText().length() > 8 ||
				contactT.getText().length() <= 0 || addrT.getText().length() <= 0) {
			return false;
		}
		
		return true;
	}
}
