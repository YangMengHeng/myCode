
import java.io.*;
/**
 * list()�������÷�
 */
public class ExampleList{
	public static void main(String[] args) throws Exception {
		File file = new File("D:\\files"); // ����File����
		if (file.isDirectory()) { // �ж�File�����Ӧ��Ŀ¼�Ƿ����
			String[] names = file.list(); // ���Ŀ¼�µ������ļ����ļ���
			for (String name : names) {
				System.out.println(name); // ����ļ���
			}
		}
	}
}