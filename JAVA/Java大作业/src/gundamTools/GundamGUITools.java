package gundamTools;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Toolkit;

public class GundamGUITools {
		static Toolkit kit = Toolkit.getDefaultToolkit();
		//Set the Component Center
		public static void center(Component c) {
			int x = (kit.getScreenSize().width - c.getWidth()) / 2;
			int y = (kit.getScreenSize().height - c.getHeight()) / 2;
			c.setLocation(x, y);
		}
		//Set the window for TitleImage
		public static void setTitleImage(Frame frame,String titleIconPath) {
			frame.setIconImage(kit.createImage(titleIconPath));
		} 
		public static void setTitleImage(Dialog dig,String titleIconPath) {
			dig.setIconImage(kit.createImage(titleIconPath));
		} 
		public static int getScreenWidth() {
			return kit.getScreenSize().width;
		}
		public static int getScreenHeight() {
			return kit.getScreenSize().height;
		}
}
