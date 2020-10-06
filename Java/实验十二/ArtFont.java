import java.awt.*;
import javax.swing.*;
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
    int boldStyle = 0, italicStyle = 0, underlineStyle;
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
        setResizable(false);
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
        boldBx.addItemListener(this);
        italicBx.addItemListener(this);
        colorBtn.addActionListener(this);

        return panel;
    }
    private JPanel getCenterPanel() {
        JPanel panel = new JPanel();
        this.txtArea = new JTextArea();

        txtArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txtArea.setBackground(Color.white);
        txtArea.setVisible(true);
        txtArea.setEditable(false);
        panel.setLayout(new BorderLayout());
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
        for(int i = 10; i <= 50;){
            fontSize.addItem(i);
            i += 4;
        }
        panel.add(fontType);
        panel.add(fontSize);
        panel.add(windowStyle);
        
        fontSize.addItemListener(this);
        windowStyle.addItemListener(this);
        fontType.addItemListener(this);

        return panel;
    }
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == windowStyle){
            String s = (String) e.getItem();
            String className = "";
            if (s.equals("WindowsDisplay"))
                className = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
            else if (s.equals("UnixDisplay"))
                className = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            else if (s.equals("DefaultDisplay"))
                className = UIManager.getCrossPlatformLookAndFeelClassName();
            try {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception de) {
                System.out.println("Exception happened!");
            }
        }
        else if(e.getSource() == boldBx && e.getStateChange() == ItemEvent.SELECTED){
            this.boldStyle = 1;
        }
        else if(e.getSource() == italicBx && e.getStateChange() == ItemEvent.SELECTED){
            this.italicStyle = 1;
        }
        else if(e.getSource() == boldBx && e.getStateChange() == ItemEvent.DESELECTED){
            this.boldStyle = 0;
        }
        else if(e.getSource() == italicBx && e.getStateChange() == ItemEvent.DESELECTED){
            this.italicStyle = 0;
        }
        else if(e.getSource() == this.fontSize){
            this.fontSizeStyle = (int)(this.fontSize.getSelectedItem());
        }
        else if(e.getSource() == this.fontType){
            this.fontNameStyle = (String)this.fontType.getSelectedItem();
        }
        this.txtArea.setFont(new Font(this.fontNameStyle, this.boldStyle + this.italicStyle, this.fontSizeStyle));
        if(this.italicStyle == 1 && this.boldStyle == 1){
            this.txtArea.setFont(new Font(this.fontNameStyle, 3, this.fontSizeStyle));
        }
    }
    public void actionPerformed(ActionEvent act){
        if(act.getSource() == inputText) {
            this.txtArea.setText(inputText.getText());
        }
        else if(act.getSource() == colorBtn) {
            JColorChooser col = new JColorChooser();

            this.colorStyle = col.showDialog(this, "ColorChooser", Color.BLACK);
            if(this.colorStyle != null){
                this.txtArea.setForeground(this.colorStyle);
                this.colorBtn.setForeground(this.colorStyle);
            }
        }
    }
    public static void main(String args[]) {
        ArtFont artFont = new ArtFont();
        artFont.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}