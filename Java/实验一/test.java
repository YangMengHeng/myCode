import java.util.Scanner;
import javax.swing.JOptionPane;
public class test{
public static void main(String args[]){
int x, y, z;
String str = JOptionPane.showInputDialog("���ѽ~��");
do{
z = (int)(Math.random()*100 + 1);
x = Integer.parseInt(str);
if(x > z){
str = JOptionPane.showInputDialog("�´��ˣ��ٲ�ѽ~��");
}
else if(x < z){
str = JOptionPane.showInputDialog("��С�ˣ��ٲ�ѽ~��");
}
}while(x == z);
str = JOptionPane.showInputDialog("��ϲ�㣡�¶��ˣ�baibai~~~");
System.exit(0);
}
}