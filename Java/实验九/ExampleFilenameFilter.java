
import java.io.*;
/**
 * ����ָ��Ŀ¼�µ�����JavaԴ�ļ�
 */
public class ExampleFilenameFilter {
	public static void main(String[] args) throws Exception {
		// ����File����
		File file = new File("D:\\files");
		// ��������������
		FilenameFilter filter = new FilenameFilter() {
			// ʵ��accept()����
			public boolean accept(File dir, String name) {
				File currFile = new File(dir, name);
				// ����ļ�����.txt��β����true�����򷵻�false
				if (currFile.isFile() && name.endsWith(".java")) {
					return true;
				} else {
					return false;
				}
			}
		};
		if (file.exists()) { // �ж�File�����Ӧ��Ŀ¼�Ƿ����
			String[] lists = file.list(filter); // ��ù��˺�������ļ�������
			for (String name : lists) {
				System.out.println(name);
			}
		}
	}
}