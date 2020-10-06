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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gundamTools.GundamGUITools;
import gundamdata.User;
import gundamdata.gundamData;

public class GUIUser extends JFrame{
	//Label, UserAcc,UserName,UserContact,UserAddr,OpenTime,UserMoney,Goods
	private Label userAcc;
	private Label userN;
	private Label userC;
	private Label userAddr;
	private Label money;
	private Label openT;
	private Label goods;
	//Button, Charge, Close, Exit, Editor_link, RectifyPassword
	private Button Charge;
	private Button Close;
	private Button Exit;
	private Button Editor;
	private Button Rectify;
	//TextArea, Show purchased goods
	private TextArea goodsTA;
	//Title
	private Label title;
	//Current User
	private User us;
	//BorderLayout
	private BorderLayout br;
	
	public GUIUser(int num) {
		this.Initialize(num);
		this.addComponent();
		this.addListener();
	}
	public void Initialize(int num) {
		this.setBounds(375, 150, 1122, 750);
		gundamData gd = new gundamData("user");
		us = gd.user.get(num);
		GundamGUITools.setTitleImage(this, "images/Icon.png");
		this.setTitle(us.getUserName() + "'s SweetHome");
		this.userAcc = new Label("UserAccount:" + us.getUserA());
		this.userN = new Label("UserName:" + us.getUserName());
		this.userC = new Label("UserContact:" + us.getUserC());
		this.userAddr = new Label("UserAddress:" + us.getUserAddr());
		this.money = new Label("AccountMoney:" + us.getUserMoney());
		this.openT = new Label("AccountOpenTime:" + us.getOpenTime());
		this.goods = new Label("PurchasedGoods:");
		this.Charge = new Button("Charge");
		this.Close = new Button("Close");
		this.Exit = new Button("EXIT");
		this.Editor = new Button("Editor");
		this.Rectify = new Button("Rectify");
		this.title = new Label(us.getUserName() + "'s SweetHome");
		this.br = new BorderLayout();
		this.br.setVgap(30);
		
		this.userAddr.setFont(new Font("楷体", Font.BOLD, 30));
		this.userAddr.setAlignment(FlowLayout.CENTER);
		this.title.setFont(new Font("楷体", Font.BOLD + Font.ITALIC, 40));
		this.title.setAlignment(FlowLayout.CENTER);
		this.Rectify.setFont(new Font("楷体", Font.BOLD, 30));
		this.userAcc.setFont(new Font("楷体", Font.BOLD, 30));
		this.userAcc.setAlignment(FlowLayout.CENTER);
		this.userN.setFont(new Font("楷体", Font.BOLD, 30));
		this.userN.setAlignment(FlowLayout.CENTER);
		this.userC.setFont(new Font("楷体", Font.BOLD, 30));
		this.userC.setAlignment(FlowLayout.CENTER);
		this.money.setFont(new Font("楷体", Font.BOLD, 30));
		this.money.setAlignment(FlowLayout.CENTER);
		this.openT.setFont(new Font("楷体", Font.BOLD, 30));
		this.openT.setAlignment(FlowLayout.CENTER);
		this.goods.setFont(new Font("楷体", Font.BOLD, 30));
		this.goods.setAlignment(FlowLayout.CENTER);
		this.Charge.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.Close.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.Exit.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.Editor.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.setResizable(false);
		
		JLabel img = new JLabel(new ImageIcon("photos/freedom.png"));
		img.setSize(this.getWidth(), this.getHeight());
		this.getLayeredPane().add(img, new Integer(Integer.MIN_VALUE));
		JPanel jp = (JPanel)this.getContentPane();
		jp.setOpaque(false);
	}
	public void addComponent() {
		JPanel p = new JPanel();
		JPanel pCenter = this.getCenterP();
		FlowLayout t = new FlowLayout();
		t.setHgap(60);
		t.setVgap(30);
		t.setAlignment(FlowLayout.CENTER);
		this.br.setVgap(20);
		this.setLayout(br);
		this.add(this.title, BorderLayout.NORTH);
		p.setLayout(t);
		p.add(this.Charge);
		p.add(this.Rectify);
		p.add(this.Close);
		p.add(this.Editor);
		p.add(this.Exit);
		p.setOpaque(false);
		pCenter.setOpaque(false);
		this.add(p, BorderLayout.SOUTH);
		this.add(pCenter, BorderLayout.CENTER);
	}
	public void addListener() {
		this.Rectify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				RectifyPassword temp = new RectifyPassword(null, true);
				temp.setVisible(true);
			}
		});
		this.Editor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				LINK(); 
			}
		});
		this.Charge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				CHARGE();
			}
		});
		this.Close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent act) {
				LOGIN();
			}
		});
		this.Exit.addActionListener(new ActionListener() {
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
	}
	public JPanel getCenterP() {
		JPanel p = new JPanel();
		JPanel panel = new JPanel();
		GridLayout gr = new GridLayout(3, 2);
		BorderLayout gr1 = new BorderLayout();
		this.goodsTA = new TextArea(30, 30);
		this.goodsTA.setText(us.getGoods());
		this.goodsTA.setEditable(false);
		this.goodsTA.setSize(800, 300);
		
		gr.setVgap(40);
		gr.setHgap(30);
		p.setSize(1200, 200);
		p.setLayout(gr);
		p.add(this.userAcc);
		p.add(this.userN);
		p.add(this.userC);
		p.add(this.userAddr);
		p.add(this.money);
		p.add(this.openT);
		p.setOpaque(false);
		panel.setSize(1200, 600);
		panel.add(p);
		
		p = new JPanel();
		gr1.setVgap(10);
		p.setSize(1200, 400);
		p.setLayout(gr1);
		p.add(this.goods, BorderLayout.CENTER);
		p.add(this.goodsTA, BorderLayout.SOUTH);
		p.setOpaque(false);
		panel.add(p);
		
		return panel;
	}
	public void LOGIN() {
		int num = us.getNum() - 1;
		GUILogin t = new GUILogin(null, true, false, num);
		this.setVisible(false);
		t.setVisible(true);
		Close();
	}
	public void CHARGE() {
		OnlineCharge olc = new OnlineCharge(null, true);
		olc.setVisible(true);
	}
	public void LINK() {
		Desktop dst = Desktop.getDesktop();
		try {
			dst.browse(new URI("file:///G:/GUNDAMHTML5/index/Personal.html"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void Close() {
		this.dispose();
	}
	
	//RectifyPassword index Class
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
			if(!this.oldp.getText().equals(us.getUserP())) {
				GUIDialogError gde = new GUIDialogError("PasswordError", "Input the old right Password! Pls input again!");
				this.newp.setText("");
				this.oldp.setText("");
				return;
			}
			us.setUserP(this.newp.getText());
			gundamData gd = new gundamData("user");
			gd.updateData(us);
			GUITips gt = new GUITips("Success", "The password had been rectified!");
			CLOSE();
		}
		public void CLOSE() {
			this.dispose();
		}
	}
}

class OnlineCharge extends Dialog{
	//Pay Image
	private JLabel img;
	
	public OnlineCharge(Frame upper, boolean sign) {
		super(upper, sign);
		GundamGUITools.setTitleImage(this, "images/Icon.png");
		this.setBounds(700, 300, 510, 480);
		this.setResizable(false);
		this.setTitle("Pay");
		this.img = new JLabel(new ImageIcon("photos/PAY1.jpg"));
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