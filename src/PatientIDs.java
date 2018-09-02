import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
public class PatientIDs extends Identities{
	private String[] pIArr;
	private File dir;
//	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
//---------------------------------------------
	public PatientIDs(){
		dir = new File(PATH+"\\PatientIDs");
		pIArr = dir.list();
	}
//-------------------------------------------
	public boolean contain(String paID) {
		for(String pI : pIArr){
			if((paID+".txt").equals(pI))
				return true;
		}
		return false;
	}
//-----------------------------------------
	public void addID(String id, String pd) throws Exception {		//ÃÌº”≤°»ÀidµΩ
		File file = new File(dir, id+".txt");
		PrintWriter pr = new PrintWriter(file);
		pr.write(pd);
		pr.flush();
		pr.close();
		
	}
	//-----------------------------------------------------
		public boolean isPass(String paID, String pw) throws Exception{
			File file = new File(dir+"\\"+paID+".txt");
			BufferedReader bf = new BufferedReader(new FileReader(file)); 
			String password = bf.readLine();
			if(password.equals(pw))
				return true;
			return false;
		}

}
