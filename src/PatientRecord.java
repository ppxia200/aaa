import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//���没��
public class PatientRecord {
	private static final String PATH = "E:\\Mycode\\Myjava\\PatientRecord";
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
//-----------------------------------------------
	public static void writeRecord(String id) throws Exception {
		System.out.println("׫д����,��end����");
		/*
		 * ���ļ��з�װ�ɶ��󣬲�ȷ�������
		 */
		
		File fileDir = new File(PATH);
		if(!fileDir.exists()){
			fileDir.mkdirs();
		}
		/*
		 * Ϊ�²��˴��������ļ�����idΪ�ļ���
		 */
		File file = new File(fileDir, id+".txt");
		FileWriter fw = new FileWriter(file, true);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//����̨��ȡ��
		String str = br.readLine();
		while(!str.equals("end")){
			fw.write(str);
			fw.write(LINE_SEPARATOR);
			fw.flush();
			str = br.readLine();
		}
		fw.close();
		
	}
//--------------------------------------------------
	//��ʾָ��id�Ĳ��˵Ĳ���
	public static void showRecord(String id) throws IOException {
		FileReader fr = new FileReader(PATH+"\\"+id+".txt");//�ö�ȡ��
		/*
		 * ��ȡ����ӡ�ڿ���̨��
		 */
		char[] cha = new char[3];
		int len = 0;
		while((len = fr.read(cha)) != -1)
		{
			System.out.print(new String(cha, 0, len));
		}
	}

}
