import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class DoctorIDs extends Identities{
	private File dir;
	private String[] doArr;
//----------------------------------------------
	public DoctorIDs(){
		dir = new File(PATH+"\\DoctorIDs");
		doArr = dir.list();	
	}
//----------------------------------------------	
	public boolean contain(String docID) throws Exception {
		for(String dI : doArr){
			if((docID+".txt").equals(dI))
				return true;
		}
		return false;
	}
//-----------------------------------------------------
	public boolean isPass(String docID, String pw) throws Exception{
		File file = new File(dir+"\\"+docID+".txt");
		BufferedReader bf = new BufferedReader(new FileReader(file)); 
		String password = bf.readLine();
		if(password.equals(pw))
			return true;
		return false;
	}
}
