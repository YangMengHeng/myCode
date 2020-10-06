import java.util.Scanner;
import javax.swing.JOptionPane;
public class test{
public static void main(String args[]){
int x, y, z;
String str = JOptionPane.showInputDialog("你猜呀~：");
do{
z = (int)(Math.random()*100 + 1);
x = Integer.parseInt(str);
if(x > z){
str = JOptionPane.showInputDialog("猜大了！再猜呀~：");
}
else if(x < z){
str = JOptionPane.showInputDialog("猜小了！再猜呀~：");
}
}while(x == z);
str = JOptionPane.showInputDialog("恭喜你！猜对了！baibai~~~");
System.exit(0);
}
}