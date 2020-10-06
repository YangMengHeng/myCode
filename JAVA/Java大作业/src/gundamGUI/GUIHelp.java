package gundamGUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;

import gundamTools.GundamGUITools;

public class GUIHelp extends Dialog{
	private TextArea helpTA;
	private Label helpL;
	private Button closeB;
	private Button linkB;
	private BorderLayout bor;
	private FileReader is;
	private Desktop desktop;
	
	public GUIHelp(Frame upper, boolean sign){
		super(upper, sign);
		Panel panel = new Panel();
		FlowLayout fl = new FlowLayout();
		String str = null;
		this.helpTA = new TextArea(8,15);
		this.helpL = new Label("HELP");
		this.closeB = new Button("Close");
		this.linkB = new Button("Link");
		this.bor = new BorderLayout();
		this.desktop = Desktop.getDesktop();
		try {
			char[] data = new char[1024];
			this.is = new FileReader("C:\\Users\\96432\\eclipse-workspace\\GUNDAMCLUB\\src\\gundamGUI\\help.txt");
			int num = is.read(data);
			str = new String(data, 0, num);
		}catch(IOException ioe) {
			System.out.println("Error Code:2504");
		}
		
		this.helpTA.setEditable(false);
		this.helpTA.setFont(new Font("Times New Roman", Font.BOLD, 15));
		this.helpL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.helpL.setAlignment(FlowLayout.CENTER);
		this.closeB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.linkB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.bor.setVgap(5);
		this.setLayout(bor);
		fl.setAlignment(FlowLayout.CENTER);
		
		this.setTitle("GundamClubHelp");
		this.setSize(970, 430);
		GundamGUITools.center(this);
		GundamGUITools.setTitleImage(this, "images/±³¾°-help.png");
		this.add(helpL, BorderLayout.NORTH);
		this.add(helpTA, BorderLayout.CENTER);
		panel.add(this.linkB);
		panel.add(this.closeB);
		this.add(panel, BorderLayout.SOUTH);
		this.helpTA.setText(str);
		//addListener
		this.linkB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent act) {
				try {
					desktop.browse(new URI("file:///G:/GUNDAMHTML5/index/index.html"));
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				Close();
			}
		});
		this.closeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent act) {
				Close();
			}
		});
	}
	public void Close() {
		this.dispose();
	}
}
