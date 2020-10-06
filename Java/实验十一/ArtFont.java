import java.awt.*;
import javax.swing.*;

import javafx.scene.input.KeyEvent;

import java.awt.event.*;

public class ArtFont extends JFrame implements ActionListener, ItemListener{
	JComboBox<String> fontType;//字体样式下拉框,
	JComboBox<Integer> fontSize;//字体大小下拉框
	JComboBox<String> windowStyle;//窗体样式下拉框

	JCheckBox boldBx;// 粗体按钮
	JCheckBox italicBx;// 斜体按钮
	JButton colorBtn;// 颜色按钮；
	String[] fontNames;// 字体名称;
	String[] fontSizes;// 字体大小；

	JLabel label;// 输入提示标签；
	JTextField inputText;// 文字输入框；
	JTextArea txtArea;// 文字显示区;
	JPanel northPanel;// 字体设置；
	JPanel centerPanel;// 显示效果区
	JPanel southPanel;//样式设置

	Font font;
	int boldStyle, italicStyle, underlineStyle;
	int fontSizeStyle;
	String fontNameStyle;
	Color colorStyle = Color.black;// 设置字体的默认颜色为黑色;
	String[] style = { "DefaultDisplay", "WindowsDisplay", "UnixDisplay" };

	public ArtFont() {
		super("FontSet");
		// 设置默认字体
		boldStyle = 0;
		italicStyle = 0;
		underlineStyle = 0;
		fontSizeStyle = 10;
		fontNameStyle = "宋体";
		font = new Font(fontNameStyle, boldStyle + italicStyle, fontSizeStyle);

		northPanel = getNorthPanel();
		centerPanel = getCenterPanel();
		southPanel = getSouthPanel();
		// 设置容器;
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add(northPanel, BorderLayout.NORTH);//将northPanel添加到窗体的北部
		container.add(centerPanel, BorderLayout.CENTER);//将centerPanel添加到窗体的北部
		container.add(southPanel, BorderLayout.SOUTH);//将southPanel添加到窗体的北部
		setSize(500, 300);
		setLocationRelativeTo(null);//将窗体位于屏幕的中央
		setVisible(true);
	}
	private JPanel getNorthPanel() {
		JPanel panel = new JPanel();
        this.label = new JLabel("Input");
        this.inputText = new JTextField(7);
        this.boldBx = new JCheckBox("Bold");
        this.italicBx = new JCheckBox("Italic");
        this.colorBtn = new JButton("Color");

        panel.add(label);
        panel.add(inputText);
        panel.add(boldBx);
        panel.add(italicBx);
        panel.add(colorBtn);

		inputText.addActionListener(this);
		boldBx.addActionListener(this);
		italicBx.addActionListener(this);
		colorBtn.addActionListener(this);

		return panel;
	}
	private JPanel getCenterPanel() {
		JPanel panel = new JPanel();
        this.txtArea = new JTextArea(10,40);

        txtArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txtArea.setBackground(Color.white);
        txtArea.setVisible(true);
        txtArea.setEditable(false);
        panel.add(txtArea);
        
		return panel;
	}
	private JPanel getSouthPanel() {
		JPanel panel = new JPanel();
		this.fontSize = new JComboBox<Integer>();
        this.windowStyle = new JComboBox<String>();

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		fontNames = ge.getAvailableFontFamilyNames();
		fontType = new JComboBox(fontNames);
        for(int i = 0; i < style.length; i++){
            windowStyle.addItem(style[i]);
        }
        for(int i = 1; i <= 50; i++){
            fontSize.addItem(i);
        }
        panel.add(fontType);
        panel.add(fontSize);
        panel.add(windowStyle);
        
		return panel;
	}
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == windowStyle){
			String s = (String) e.getItem();
			String className = "";
			if (s.equals("Windows显示效果"))
				className = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
			else if (s.equals("Unix显示效果"))
				className = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
			else if (s.equals("默认显示效果"))
				className = UIManager.getCrossPlatformLookAndFeelClassName();
			try {
				UIManager.setLookAndFeel(className);
				SwingUtilities.updateComponentTreeUI(this);
			} catch (Exception de) {
				System.out.println("Exception happened!");
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boldBx){
			this.txtArea.setFont(new Font(this.fontNameStyle, Font.BOLD, this.fontSizeStyle));
		}
		else if(e.getSource() == italicBx){
			this.txtArea.setFont(new Font(this.fontNameStyle, Font.ITALIC, this.fontSizeStyle));
		}
		else if(e.getSource() == inputText){
			this.txtArea.setText(inputText.getText());
		}
		else if(e.getSource() == colorBtn){
			
		}
	}
	public static void main(String args[]) {
		ArtFont artFont = new ArtFont();
		artFont.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}