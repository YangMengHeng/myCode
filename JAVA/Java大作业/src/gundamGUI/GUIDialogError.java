package gundamGUI;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gundamTools.GundamGUITools;

public class GUIDialogError {
	public Dialog dig = new Dialog(null, true);
	public Button yes = new Button("Yes");
	public GridLayout g = new GridLayout(2, 1);
	public Label l;
	
	public GUIDialogError(String title, String index){
		dig = new Dialog(null, true);
		yes = new Button("Yes");
		g = new GridLayout(2, 1);
		l = new Label("Error!" + index);
		
		dig.setTitle(title);
		l.setFont(new Font("Times New Roman", Font.BOLD, 20));
		yes.setFont(new Font("Times New Roman", Font.BOLD, 20));
		dig.setLayout(g);
		dig.add(l);
		dig.add(yes);
		dig.setResizable(false);
		dig.setSize(800, 200);
		GundamGUITools.center(dig);
		GundamGUITools.setTitleImage(dig, "images/Icon-age.png");
		dig.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dig.dispose();
			}
		});
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent act) {
				dig.dispose();
			}
		});
		dig.setVisible(true);
	}
}
