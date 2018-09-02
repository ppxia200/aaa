import java.util.Scanner;

public class Patient {
	private String id;
	private String pd;
	Scanner in = new Scanner(System.in);
//-----------------------------------------
	public Patient(String patID) {
		this.id = patID;
	}
//---------------------------------------
	public Patient() {
		id = null;
	}
//------------------------------------------
	public boolean load(String paID, String pw1) throws Exception {
		//输入存在的医生的账号
		if(!new PatientIDs().contain(paID)){
			System.out.println("Wrong patient id, enter again!");
			return false;
		}
		else if(!new PatientIDs().isPass(paID, pw1)){
			System.out.println("Wrong password! enter again:");
			return false;
		}
		System.out.println("Loading successfully!");
		//显示医生主页
		this.menu(paID);
		return true;
	}
//-------------------------------------------------
	private void menu(String paID) throws Exception {
		System.out.println("enter l(look the record)");
		char ch = in.nextLine().charAt(0);
		if(ch=='l')
			show(paID);
		else
			System.out.println("Wrong enter!");
	}
//------------------------------------------------------
	public void show(String paID) throws Exception {
		PatientRecord.showRecord(paID);
	}

}
