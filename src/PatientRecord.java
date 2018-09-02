import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//储存病历
public class PatientRecord {
	private static final String PATH = "E:\\Mycode\\Myjava\\PatientRecord";
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
//-----------------------------------------------
	public static void writeRecord(String id) throws Exception {
		System.out.println("撰写病历,以end结束");
		/*
		 * 将文件夹封装成对象，并确保其存在
		 */
		
		File fileDir = new File(PATH);
		if(!fileDir.exists()){
			fileDir.mkdirs();
		}
		/*
		 * 为新病人创建病历文件，其id为文件名
		 */
		File file = new File(fileDir, id+".txt");
		FileWriter fw = new FileWriter(file, true);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//控制台读取流
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
	//显示指定id的病人的病历
	public static void showRecord(String id) throws IOException {
		FileReader fr = new FileReader(PATH+"\\"+id+".txt");//用读取流
		/*
		 * 读取并打印在控制台上
		 */
		char[] cha = new char[3];
		int len = 0;
		while((len = fr.read(cha)) != -1)
		{
			System.out.print(new String(cha, 0, len));
		}
	}

}
