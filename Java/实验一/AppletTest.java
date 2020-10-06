import java.awt.*;
import java.applet.Applet;
public class AppletTest extends Applet
{
	public void init()
	{		
		setBackground(Color.cyan);
	}
public void paint(Graphics g)
{
    g.setColor(Color.blue); 
    g.drawString("This is a JAVA program!",10,30); 
    g.setColor(Color.red);
    g.setFont(new Font("宋体",Font.BOLD,36));
    g.drawString("I have changed the Font!",10,100);
    }
}
