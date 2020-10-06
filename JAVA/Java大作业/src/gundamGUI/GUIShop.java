package gundamGUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gundamTools.GundamGUITools;
import gundamdata.Admin;
import gundamdata.Shop;
import gundamdata.User;
import gundamdata.gundamData;

public class GUIShop extends JFrame{
	//JLabel, title
	private Label Title;
	//SHOP JPanel, every good will have one
	private JPanel[] shop;
	//Button, Link, exit, search, user
	private Button search;
	private Button Link;
	private Button EXIT;
	private Button user;
	//Shop connectors
	private gundamData gd;
	//BorderLayout br
	private BorderLayout br;
	//current User Number
	private int num;
	
	public GUIShop(int num) {
		JPanel p = new JPanel();
		this.setSize(GundamGUITools.getScreenWidth() - 100, GundamGUITools.getScreenHeight());
		this.setResizable(false);
		
		this.num = num;
		this.gd = new gundamData("gundamprc");
		this.br = new BorderLayout();
		this.Title = new Label("SHOP");
		this.search = new Button("Search");
		this.Link = new Button("Link");
		this.EXIT = new Button("EXIT");
		this.user = new Button("PersonalPage");
		this.shop = new JPanel[Shop.Count + 1];

		this.Title.setFont(new Font("Times New Roman", Font.BOLD+Font.ITALIC, 40));
		this.search.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.Link.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.EXIT.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.user.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.Title.setAlignment(FlowLayout.CENTER);
		this.br.setVgap(20);
		this.setLayout(br);
		this.setTitle("Shop");
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
		p.setLayout(fl);
		p.add(this.search);
		p.add(this.user);
		p.add(this.Link);
		p.add(this.EXIT);
		this.add(this.Title, BorderLayout.NORTH);
		this.add(p, BorderLayout.SOUTH);
		this.add(getCenterp(), BorderLayout.CENTER);
		GundamGUITools.setTitleImage(this, "images/Icon.png");
		
		this.Link.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				LINK();
			}
		});
		this.user.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				USER();
			}
		});
		this.search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				SEARCH();
			}
		});
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				CLOSE();
			}
		});
		this.EXIT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				CLOSE();
			}
		});
	}
	public JPanel getCenterp() {
		JPanel p = new JPanel();
		JLabel[] shopp;
		shopp = new JLabel[Shop.Count + 1];
		shopP[] sp = new shopP[Shop.Count + 1];
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
	
		p.setSize(1600, 900);
		
		
		for(int i = 0 ; i < Shop.Count; i++) {
			Shop so = gd.shop.get(i);
			String t = "photos/" + so.getIdentifier() + ".jpg";
			ImageIcon ico = new ImageIcon(t);
			shopp[i] = new JLabel(ico);
			shopp[i].setBorder(BorderFactory.createBevelBorder(1));
			sp[i] = new shopP(shopp[i]);
			p.add(sp[i]);
			
			sp[i].browse.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent act) {
					BROWSE(so);
				}
			});
		}
	
		return p;
	}
	public void SHOPDialog(Shop s) {
		SHOP sp = new SHOP(null, true, s);
	}
	public void CLOSE() {
		this.dispose();
	}
	public void BROWSE(Shop sh) {
		SHOP sp = new SHOP(null, false, sh);
		sp.setVisible(true);
	}
	public void LINK() {
		Desktop dst = Desktop.getDesktop();
		try {
			dst.browse(new URI("https://www.taobao.com/"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void SEARCH() {
		Search sch = new Search(null, true);
		sch.setVisible(true);
	}
	public void USER() {
		GUIUser us = new GUIUser(this.num);
		this.setVisible(false);
		us.setVisible(true);
		CLOSE();
	}
	class shopP extends JPanel{
		public Button browse;
		public BorderLayout brl;
		
		public shopP(JLabel t) {
			this.setSize(300, 320);
			this.browse = new Button("Browse");
			this.browse.setFont(new Font("Times New Roman", Font.BOLD, 20));
			this.brl = new BorderLayout();
			this.brl.setVgap(0);
			this.setLayout(brl);
			this.add(this.browse, BorderLayout.SOUTH);
			this.add(t, BorderLayout.NORTH);
		}
	}
}

class SHOP extends JDialog{
	private Shop sh;
	//Button, buy good, cancel, contact seller
	private Button buy;
	private Button cancel;
	private Button contactSeller;
	//Label, ProductArea, Seller, Series, Gundam, Identifier, Proportion, ProductCapacity, Price, Camp, picture
	private Label proArea;
	private Label seller;
	private Label series;
	private Label gundam;
	private Label id;
	private Label pro;
	private Label proCapacity;
	private Label price;
	private Label camp;
	private Label title;
	private JLabel picture;
	private BorderLayout br;
	
	public SHOP(JFrame upper, boolean sign, Shop sh) {
		super(upper, sign);
		this.sh = sh;
		this.setTitle(sh.getIdentifier() + " " + sh.getGundam());
		this.setSize(800, 800);
		GundamGUITools.center(this);
		GundamGUITools.setTitleImage(this, "images/Icon.png");
		
		this.Initialize();
		this.addComponent();
		this.addListener();
	}
	public void Initialize() {
		this.buy = new Button("Buy");
		this.cancel = new Button("Cancel");
		this.contactSeller = new Button("Seller");
		
		this.proArea = new Label("ProductArea:" + sh.getProductArea());
		this.seller = new Label("Seller:" + sh.getBrand());
		this.series = new Label("Series:" + sh.getSeries());
		this.gundam = new Label("Gundam:" + sh.getGundam());
		this.id = new Label("IDentifier" + sh.getIdentifier());
		this.pro = new Label("Proportion:" + sh.getProportion());
		this.proCapacity = new Label("Capacity:" + sh.getProductCapacity());
		this.price = new Label("Pricd:" + sh.getPrice());
		this.title = new Label(sh.getGundam());
		if(sh.getCamp() == 1) {
			this.camp = new Label("Camp:free");
		}
		else this.camp = new Label("Camp:fee");
		String t = "photos/" + sh.getGundam() + ".jpg";
		ImageIcon ico = new ImageIcon(t);
		picture = new JLabel(ico);
		picture.setBorder(BorderFactory.createEtchedBorder(1));
		
		this.br = new BorderLayout();
		br.setHgap(10);
		this.setLayout(br);
		
		this.proArea.setFont(new Font("楷体", Font.BOLD, 20));
		this.seller.setFont(new Font("楷体", Font.BOLD, 20));
		this.series.setFont(new Font("楷体", Font.BOLD, 20));
		this.gundam.setFont(new Font("楷体", Font.BOLD, 20));
		this.id.setFont(new Font("楷体", Font.BOLD, 20));
		this.pro.setFont(new Font("楷体", Font.BOLD, 20));
		this.proCapacity.setFont(new Font("楷体", Font.BOLD, 20));
		this.price.setFont(new Font("楷体", Font.BOLD, 20));
		this.title.setFont(new Font("楷体", Font.BOLD, 30));
	}
	public void addComponent() {
		Panel p = new Panel();
		
		p.add(this.buy);
		p.add(this.cancel);
		p.add(this.contactSeller);
		
		this.add(this.title, BorderLayout.NORTH);
		this.add(p, BorderLayout.SOUTH);
		p = new Panel();
		p.add(this.proArea);
		p.add(this.seller);
		p.add(this.series);
		p.add(gundam);
		p.add(id);
		p.add(pro);
		p.add(proCapacity);
		p.add(price);
		p.add(camp);
		this.add(p, BorderLayout.WEST);
		this.add(this.picture, BorderLayout.CENTER);
	}
	public void addListener() {
		
	}
}

class Search extends Dialog{
	public JLabel se;
	public TextField set;
	
	public Search(Frame up, boolean sign) {
		super(up, sign);
		this.setSize(400, 150);
		this.setTitle("SearchMenu");
		GundamGUITools.center(this);
		GundamGUITools.setTitleImage(this, "images/Icon.png");
		this.se = new JLabel("GundamName:");
		this.set = new TextField(30);
		this.se.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.setLayout(new BorderLayout());
		Panel p = new Panel();
		p.add(this.se);
		p.add(this.set);
		this.add(p, BorderLayout.CENTER);
		
		this.set.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				searching();
			}
		});
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				close();
			}
		});
	}
	public void searching() {
		String t = set.getText();
		gundamData gd = new gundamData("gundamprc");
		
		for(int i = 0; i < Shop.Count; i++) {
			Shop sp1 = gd.shop.get(i);
			String sname = sp1.getGundam();
			if(sname.indexOf(t) != -1) {
				SHOP sp = new SHOP(null, false, sp1);
				this.setVisible(false);
				sp.setVisible(true);
				close();
				return;
			}
		}
		
		GUIDialogError gde = new GUIDialogError("SearchError", "Don't have such as a good "
				+ "called the Name!");
		set.setText("");
	}
	public void close() {
		this.dispose();
	}
}