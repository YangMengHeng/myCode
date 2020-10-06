package gundamGUI;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gundamTools.GundamGUITools;
import gundamdata.gundamData;

public class GUILogin extends Dialog{
	//Button, Shop, User, Admin
	private Button shop;
	private Button user;
	private Button admin;
	private Button exit;
	//Search the data
	private gundamData gd;
	//GirdLayout, FL
	private GridLayout gr;
	//Current AccountNumber
	private int num;
	
	public GUILogin(Frame upper, boolean sign, boolean temp, int num){
		super(upper, sign);
		this.num = num;
		this.Initialize(temp);
		this.addComponent(temp);
		this.addListener(temp);
	}
	public void Initialize(boolean temp) {
		this.shop = new Button("SHOP");
		this.exit = new Button("EXIT");
		this.gr = new GridLayout(0, 1);
		
		this.shop.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.exit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.gr.setVgap(0);
		this.setLayout(gr);
		if(temp == true) {
			this.admin = new Button("ADMIN");
			this.admin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		}
		else {
			this.user = new Button("USER");
			this.user.setFont(new Font("Times New Roman", Font.BOLD, 20));
		}
		this.setBounds(800, 400, 260, 260);
		GundamGUITools.setTitleImage(this, "images/±³¾°-mainframe.png");
		this.setTitle("LoginChose");
		this.setFont(new Font("Times New Roman", Font.BOLD + Font.ITALIC, 30));
	}
	public void addComponent(boolean temp) {
		this.add(shop);
		if(temp == true) {
			this.add(admin);
		}
		else this.add(user);
		this.add(exit);
	}
	public void addListener(boolean temp) {
		if(temp == true) {
			this.admin.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent act) {
					TransitAdmin();
				}
			});
		}
		else {
			this.user.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent act) {
					Transit();
				}
			});
		}
		this.exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				Close();
			}
		});
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				Close();
			}
		});
		this.shop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				SHOP(num);
			}
		});
	}
	public void SHOP(int num) {
		GUIShop so = new GUIShop(num);
		this.setVisible(false);
		so.setVisible(true);
		Close();
	}
	public void Close() {
		this.dispose();
	}
	public void dis() {
		this.setVisible(false);
	}
	public void Transit() {
		this.setVisible(false);
		GUIUser us = new GUIUser(num);
		us.setVisible(true);
		Close();
	}
	public void TransitAdmin(){
		this.setVisible(false);
		GUIAdmin ad = new GUIAdmin(num);
		ad.setVisible(true);
		Close();
	}
}
