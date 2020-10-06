package gundamGUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dialog;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gundamTools.GundamGUITools;
import gundamdata.Admin;
import gundamdata.Shop;
import gundamdata.User;
import gundamdata.gundamData;

public class GUIAdmin extends JFrame{
	//Label, AdminName, Account, Addr, Contact, OpeTime, Capital, Goods, Title
	private Label adminN;
	private Label adminA;
	private Label adminAddr;
	private Label adminC;
	private Label ot;
	private Label cap;
	private Label goods;
	private Label Title;
	//Button, AddGoods, DeleteGoods, UpdateGoods, RectifyPassword, Exit, CashOut, Register
	private Button addGoods;
	private Button deleteGoods;
	private Button updateGoods;
	private Button rectifyPassword;
	private Button EXIT;
	private Button cashOut;
	private Button Register;
	private Button Link;
	//TextArea, forGoods, 
	private TextArea Goods;
	//Current Admin
	private Admin ad;
	//BorderLayout br
	private BorderLayout br;
	
	public GUIAdmin(int num) {
		this.Initialize(num);
		this.addComponent();
		this.addListener();
	}
	public void Initialize(int num) {
		this.setBounds(375, 150, 1200, 800);
		gundamData gd = new gundamData("admin");
		ad = gd.admin.get(num);
		GundamGUITools.setTitleImage(this, "images/Icon.png");
		this.setTitle(ad.getAdminName() + "'s WonderfulHome");
		this.adminN = new Label("Name:" + ad.getAdminName());
		this.adminA = new Label("Account:" + ad.getAccount());
		this.adminAddr = new Label("Address:" + ad.getAddr());
		this.adminC = new Label("Contact" + ad.getContact());
		this.ot  = new Label("OpenTime:" + ad.getOpenTime());
		this.cap = new Label("Capital:" + ad.getCapital());
		this.goods = new Label("Goods:");
		this.Title = new Label(ad.getAdminName() + "'s WonderfulHome");
		this.Link = new Button("Editor");
		
		this.Title.setFont(new Font("¿¬Ìå", Font.BOLD + Font.ITALIC, 40));
		this.adminN.setFont(new Font("¿¬Ìå", Font.BOLD, 30));
		this.adminA.setFont(new Font("¿¬Ìå", Font.BOLD, 30));
		this.adminAddr.setFont(new Font("¿¬Ìå", Font.BOLD, 30));
		this.adminC.setFont(new Font("¿¬Ìå", Font.BOLD, 30));
		this.ot.setFont(new Font("¿¬Ìå", Font.BOLD, 30));
		this.cap.setFont(new Font("¿¬Ìå", Font.BOLD, 30));
		this.goods.setFont(new Font("¿¬Ìå", Font.BOLD, 30));
		this.adminN.setAlignment(FlowLayout.CENTER);
		this.adminA.setAlignment(FlowLayout.CENTER);
		this.adminAddr.setAlignment(FlowLayout.CENTER);
		this.adminC.setAlignment(FlowLayout.CENTER);
		this.ot.setAlignment(FlowLayout.CENTER);
		this.cap.setAlignment(FlowLayout.CENTER);
		this.goods.setAlignment(FlowLayout.CENTER);
		this.Title.setAlignment(FlowLayout.CENTER);
		
		this.addGoods = new Button("AddGood");
		this.deleteGoods = new Button("DeleteGood");
		this.updateGoods = new Button("UpdateGood");
		this.rectifyPassword = new Button("RectifyPassword");
		this.cashOut = new Button("CashOut");
		this.Register = new Button("Register");
		this.EXIT = new Button("EXIT");
		
		this.addGoods.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.deleteGoods.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.updateGoods.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.rectifyPassword.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.cashOut.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.Register.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.EXIT.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.Link.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		this.br = new BorderLayout();
		this.br.setHgap(60);
		this.br.setVgap(30);
		this.setResizable(false);
		this.add(this.Title, BorderLayout.NORTH);
		
		JLabel img = new JLabel(new ImageIcon("photos/VS1.png"));
		img.setSize(this.getWidth(), this.getHeight());
		this.getLayeredPane().add(img, new Integer(Integer.MIN_VALUE));
		JPanel jp = (JPanel)this.getContentPane();
		jp.setOpaque(false);
	}
	public void addComponent() {
		JPanel p = new JPanel();
		FlowLayout f = new FlowLayout(FlowLayout.CENTER);
		
		this.setLayout(this.br);
		f.setHgap(10);
		f.setVgap(30);
		p.setLayout(f);
		p.add(this.addGoods);
		p.add(this.deleteGoods);
		p.add(this.updateGoods);
		p.add(this.rectifyPassword);
		p.add(this.Register);
		p.add(this.Link);
		p.add(this.EXIT);
		p.setOpaque(false);
		this.add(this.Title, BorderLayout.NORTH);
		this.add(p, BorderLayout.SOUTH);
		p = getCenterP();
		p.setOpaque(false);
		this.add(p, BorderLayout.CENTER);
	}
	public void addListener() {
		this.addGoods.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				ADDGOOD();
			}
		});
		this.deleteGoods.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				DELETEGOOD();
			}
		});
		this.updateGoods.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				UPDATEGOOD();
			}
		});
		this.rectifyPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				RECTIFY();
			}
		});
		this.cashOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				CASHOUT();
			}
		});
		this.Register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				REGISTER();
			}
		});
		this.Link.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				LINK();
			}
		});
		this.EXIT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				CloseAd();
			}
		});
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				CloseAd();
			}
		});
	}
	public JPanel getCenterP() {
		JPanel p = new JPanel();
		JPanel pa = new JPanel();
		GridLayout gr = new GridLayout(3, 2);
		BorderLayout gr1 = new BorderLayout();
		this.Goods = new TextArea(30, 30);
		this.Goods.setText(ad.getGoods());
		this.Goods.setEditable(false);
		this.Goods.setSize(800, 300);
		
		gr.setVgap(40);
		gr.setHgap(30);
		p.setSize(1200, 200);
		p.setLayout(gr);
		p.add(this.adminA);
		p.add(this.adminN);
		p.add(this.adminC);
		p.add(this.adminAddr);
		p.add(this.cap);
		p.add(this.ot);
		p.setOpaque(false);
		pa.setSize(1200, 600);
		pa.add(p);
		
		p = new JPanel();
		gr1.setVgap(10);
		p.setSize(1200, 400);
		p.setLayout(gr1);
		p.add(this.goods, BorderLayout.CENTER);
		p.add(this.Goods, BorderLayout.SOUTH);
		p.setOpaque(false);
		pa.add(p);
		
		return pa;
	}
	public void LINK() {
		Desktop dst = Desktop.getDesktop();
		try {
			dst.browse(new URI("file:///G:/GUNDAMHTML5/index/Personal.html"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void REGISTER() {
		if(ad.getNum() != 1) {
			GUIDialogError gde = new GUIDialogError("Error", 
					"You don't have power to register! Pls call @ÆìÄ¾°×ÔÕ(19979405286)!");
			return;
		}
		Register reg = new Register(null, true);
		reg.setVisible(true);
	}
	public void ADDGOOD() {
		addGood ag = new addGood(null, true, this.ad);
		ag.setVisible(true);
	}
	public void DELETEGOOD() {
		deGood dg = new deGood(null, true);
		dg.setVisible(true);
	}
	public void UPDATEGOOD() {
		updateGood ug = new updateGood(null, true, this.ad);
		ug.setVisible(true);
	}
	public void RECTIFY() {
		RectifyPassword rfp = new RectifyPassword(null, true);
		rfp.setVisible(true);
	}
	public void CASHOUT() {
		cashout olc = new cashout(null, true);
		olc.setVisible(true);
	}
	public void CloseAd() {
		this.dispose();
	}
	//RectifyPassword index class
	class RectifyPassword extends Dialog{
		//TextField, Label, input old pass, new pass
		private TextField oldp;
		private TextField newp;
		private Label old;
		private Label n;
		
		public RectifyPassword(Frame upper, boolean sign) {
			super(upper, sign);
			this.old = new Label("oldPassword:");
			this.n = new Label("newPassword:");
			this.oldp = new TextField(20);
			this.newp = new TextField(20);
			this.old.setFont(new Font("Times New Roman", Font.BOLD, 30));
			this.n.setFont(new Font("Times New Roman", Font.BOLD, 30));
			this.setTitle("Rectify");
			this.setBounds(650, 475, 600, 175);
			this.setResizable(false);
			GundamGUITools.setTitleImage(this, "images/Icon.png");
			
			Panel p = new Panel();
			p.add(this.old);
			p.add(this.oldp);
			FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
			this.setLayout(fl);
			this.add(p);
			p = new Panel();
			p.add(this.n);
			p.add(this.newp);
			this.add(p);
			
			this.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent we) {
					CLOSE();
				}
			});
			this.newp.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent act) {
					Update();
				}
			});
		}
		public void Update() {
			if(!this.oldp.getText().equals(ad.getAccP())) {
				GUIDialogError gde = new GUIDialogError("PasswordError", "Input the old right Password! Pls input again!");
				this.newp.setText("");
				this.oldp.setText("");
				return;
			}
			ad.setAdminP(this.newp.getText());
			gundamData gd = new gundamData("admin");
			gd.updateData(ad);
			GUITips gt = new GUITips("Success", "The password had been rectified!");
			CLOSE();
		}
		public void CLOSE() {
			this.dispose();
		}
	}
}

class cashout extends Dialog{
	//Pay Image
	private JLabel img;
	
	public cashout(Frame upper, boolean sign) {
		super(upper, sign);
		GundamGUITools.setTitleImage(this, "images/Icon.png");
		this.setBounds(700, 300, 510, 480);
		this.setResizable(false);
		this.setTitle("CashOut");
		this.img = new JLabel(new ImageIcon("photos/PAY2.jpg"));
		this.add(this.img);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				Close();
			}
		});
	}
	public void Close() {
		this.dispose();
	}
}

class Register extends Dialog{
	//Label, account, password, name, contact, addr
	public Label accountL;
	public Label passwordL;
	public Label nameL;
	public Label contactL;
	public Label addrL;
	public Label Title;
	//Button, enter, cancel
	public Button enterB;
	public Button cancelB;
	//TextField, account, password, name, contact, addr
	public TextField accountT;
	public TextField passwordT;
	public TextField nameT;
	public TextField contactT;
	public TextField addrT;
	//GridLayout
	public GridLayout grid;
	
	public Register(Frame frame, boolean sign){
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
		
		this.setTitle("AdminRegister");
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
					Admin ad = new Admin(Admin.Count + 1, nameT.getText(), accountT.getText(), passwordT.getText(), 
							addrT.getText(), contactT.getText(), date.toString(), 0, "");
					gundamData gd = new gundamData("admin");
					if(!gd.addData(ad)) {
						System.out.println("Error Code:2333");
					}
					Close();
				}
				else {
					GUIDialogError gde = new GUIDialogError("ErrorWarning", " Pls call @ÆìÄ¾°×ÔÕ(19979405286)!");
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

class addGood extends Dialog{
	//Label, ProductArea, Series, Gundam, Identifier, Proportion, ProductCapacity, Price, Camp
	public Label proAreaL;
	public Label seriesL;
	public Label gundamL;
	public Label ideL;
	public Label proL;
	public Label capacityL;
	public Label priceL;
	public Label campL;
	//Button, enter, cancel
	public Button enterB;
	public Button cancelB;
	//TextField, ProductArea, Series, Gundam, Identifier, Proportion, ProductCapacity, Price, Camp
	public TextField proAreaT;
	public TextField seriesT;
	public TextField gundamT;
	public TextField ideT;
	public TextField proT;
	public TextField capacityT;
	public TextField priceT;
	public TextField campT;
	//GridLayout
	public GridLayout grid;
	
	public addGood(Frame frame, boolean sign, Admin ad){
		super(frame, sign);
		this.Initialize();
		this.addComponent();
		this.addListener(ad);
	}
	public void Initialize() {
		this.proAreaL = new Label("ProductArea:");
		this.seriesL = new Label("Series:");
		this.gundamL = new Label("Gundam:");
		this.ideL = new Label("Identifier:");
		this.proL = new Label("Proportion:");
		this.capacityL = new Label("Capacity:");
		this.priceL = new Label("Price:");
		this.campL = new Label("Camp:");
		this.proAreaL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.seriesL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.gundamL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.ideL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.proL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.capacityL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.priceL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.campL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		this.enterB = new Button("Enter");
		this.cancelB = new Button("Cancel");
		this.enterB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.cancelB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		this.setTitle("AddGoods");
		this.setSize(500, 600);
		GundamGUITools.center(this);
		GundamGUITools.setTitleImage(this, "images/Icon-reg.png");
		this.setResizable(false);
	}
	public void addListener(Admin ad) {
		this.enterB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				gundamData gd = new gundamData("gundamprc");
				Shop sh = new Shop(proAreaT.getText(), ad.getAdminName(), seriesT.getText(), gundamT.getText(), ideT.getText(),
						proT.getText(), Shop.Count + 1, Integer.parseInt(capacityT.getText()), Integer.parseInt(priceT.getText())
						, Integer.parseInt(campT.getText()));
				if(!gd.addData(sh)) {
					System.out.println("Error Code:2231");
				}
				GUITips gde = new GUITips("Congratulations!", " You had been added a good!");
				Close();
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
		this.proAreaT = new TextField(30);
		this.seriesT = new TextField(30);
		this.ideT = new TextField(30);
		this.proT = new TextField(30);
		this.gundamT = new TextField(30);
		this.capacityT = new TextField(30);
		this.priceT = new TextField(30);
		this.campT = new TextField(30);
		Panel panel = new Panel();
		this.grid = new GridLayout(9,1);
		grid.setVgap(10);
		this.setLayout(this.grid);
		panel.add(this.proAreaL);
		panel.add(this.proAreaT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.seriesL);
		panel.add(this.seriesT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.gundamL);
		panel.add(this.gundamT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.ideL);
		panel.add(this.ideT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.proL);
		panel.add(this.proT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.capacityL);
		panel.add(this.capacityT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.priceL);
		panel.add(this.priceT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.campL);
		panel.add(this.campT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.enterB);
		panel.add(this.cancelB);
		this.add(panel);
	}
	public void Close() {
		this.dispose();
	}
}

class updateGood extends Dialog{
	//Label, ProductArea, Series, Gundam, Identifier, Proportion, ProductCapacity, Price, Camp
	public Label proAreaL;
	public Label seriesL;
	public Label gundamL;
	public Label ideL;
	public Label proL;
	public Label capacityL;
	public Label priceL;
	public Label campL;
	//Button, enter, cancel
	public Button enterB;
	public Button cancelB;
	//TextField, ProductArea, Series, Gundam, Identifier, Proportion, ProductCapacity, Price, Camp
	public TextField proAreaT;
	public TextField seriesT;
	public TextField gundamT;
	public TextField ideT;
	public TextField proT;
	public TextField capacityT;
	public TextField priceT;
	public TextField campT;
	//GridLayout
	public GridLayout grid;
	
	public updateGood(Frame frame, boolean sign, Admin ad){
		super(frame, sign);
		this.Initialize();
		this.addComponent();
		this.addListener(ad);
	}
	public void Initialize() {
		this.proAreaL = new Label("ProductArea:");
		this.seriesL = new Label("Series:");
		this.gundamL = new Label("Gundam:");
		this.ideL = new Label("Identifier:");
		this.proL = new Label("Proportion:");
		this.capacityL = new Label("Capacity:");
		this.priceL = new Label("Price:");
		this.campL = new Label("Camp:");
		this.proAreaL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.seriesL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.gundamL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.ideL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.proL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.capacityL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.priceL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.campL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		this.enterB = new Button("Enter");
		this.cancelB = new Button("Cancel");
		this.enterB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.cancelB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		this.setTitle("UpdateGoods");
		this.setSize(500, 600);
		GundamGUITools.center(this);
		GundamGUITools.setTitleImage(this, "images/Icon-reg.png");
		this.setResizable(false);
	}
	public void addListener(Admin ad) {
		this.enterB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				int t = check();
				if(t != -1) {
					gundamData gd = new gundamData("gundamprc");
					Shop sh = new Shop(proAreaT.getText(), ad.getAdminName(), seriesT.getText(), gundamT.getText(), ideT.getText(),
							proT.getText(), t + 1, Integer.parseInt(capacityT.getText()), Integer.parseInt(priceT.getText())
							, Integer.parseInt(campT.getText()));
					if(!gd.updateData(sh)) {
						System.out.println("Error Code:2231");
					}
					GUITips gde = new GUITips("Congratulations!", " You had been updated a good!");
					Close();
					return;
				}
				GUIDialogError dle = new GUIDialogError("UpdateError", "The good doesn't include in the Shops! Pls add it!");
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
		this.proAreaT = new TextField(30);
		this.seriesT = new TextField(30);
		this.ideT = new TextField(30);
		this.proT = new TextField(30);
		this.gundamT = new TextField(30);
		this.capacityT = new TextField(30);
		this.priceT = new TextField(30);
		this.campT = new TextField(30);
		Panel panel = new Panel();
		this.grid = new GridLayout(9,1);
		grid.setVgap(10);
		this.setLayout(this.grid);
		panel.add(this.proAreaL);
		panel.add(this.proAreaT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.seriesL);
		panel.add(this.seriesT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.gundamL);
		panel.add(this.gundamT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.ideL);
		panel.add(this.ideT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.proL);
		panel.add(this.proT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.capacityL);
		panel.add(this.capacityT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.priceL);
		panel.add(this.priceT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.campL);
		panel.add(this.campT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.enterB);
		panel.add(this.cancelB);
		this.add(panel);
	}
	public void Close() {
		this.dispose();
	}
	public int check() {
		gundamData gd = new gundamData("gundamprc");
		String t = new String(ideT.getText());
		
		for(int i = 0; i < Shop.Count; i++) {
			if(t.equals(gd.shop.get(i).getIdentifier())) {
				return i;
			}
		}
		
		return -1;
	}
}

class deGood extends Dialog{
	//Label, Identifier
	public Label ideL;
	//Button, enter, cancel
	public Button enterB;
	public Button cancelB;
	//TextField, Identifier
	public TextField ideT;
	//GridLayout
	public GridLayout grid;
	
	public deGood(Frame frame, boolean sign){
		super(frame, sign);
		this.Initialize();
		this.addComponent();
		this.addListener();
	}
	public void Initialize() {
		this.ideL = new Label("DeleteGood's Identifier:");
		this.ideL.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		this.enterB = new Button("Enter");
		this.cancelB = new Button("Cancel");
		this.enterB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.cancelB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		this.setTitle("DeleteGoods");
		this.setSize(500, 200);
		GundamGUITools.center(this);
		GundamGUITools.setTitleImage(this, "images/Icon-reg.png");
		this.setResizable(false);
	}
	public void addListener() {
		this.enterB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				Shop sh;
				String t = new String(ideT.getText());
				gundamData gd = new gundamData("gundamprc");
				
				for(int i = 0; i < Shop.Count; i++) {
					sh = gd.shop.get(i);
					if(t.equals(sh.getIdentifier())) {
						if(!gd.DeleteData(sh)) {
							System.out.println("Error Code:2221");
						}
						for(int k = i + 1; k < Shop.Count; k++) {
							sh = gd.shop.get(k);
							sh.setGNumber(sh.getGNumber() - 1);
							gd.updateData(sh, 1);
						}
						GUITips gde = new GUITips("Congratulations!", " You had been deleted a good!");
						Close();
						return;
					}
				}
				GUIDialogError gle = new GUIDialogError("DeleteError","the id doesn't include in the Goods!");
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
		this.ideT = new TextField(30);
		Panel panel = new Panel();
		this.grid = new GridLayout(0,1);
		grid.setVgap(10);
		this.setLayout(this.grid);
		
		panel.add(this.ideL);
		panel.add(this.ideT);
		this.add(panel);
		panel = new Panel();
		panel.add(this.enterB);
		panel.add(this.cancelB);
		this.add(panel);
	}
	public void Close() {
		this.dispose();
	}
}