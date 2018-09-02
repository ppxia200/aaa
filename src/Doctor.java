import java.util.Scanner;

public class Doctor {
	private Scanner in = new Scanner(System.in);

//-----------------------------------------------------------
	//登录账号
	public boolean load(String docID, String pw) throws Exception {
		//输入存在的医生的账号,判断账号是否存在 
		if(!new DoctorIDs().contain(docID)){
			System.out.println("Wrong id! enter again:");
			return false;
		}
		//密码与账号是否匹配
		else if(!new DoctorIDs().isPass(docID, pw)){
				System.out.println("Wrong password! enter again:");
		}
		System.out.println("Loading successfully!");
		//显示医生主页
		this.menu();
		return true;
	}
//--------------------------------------------------------------------------
	private void menu() throws Exception {		//显示菜单
		System.out.println("Doctor Menu");
		System.out.print("Please enter l (look record) or w(write record):");
		char butten = in.nextLine().charAt(0);
		switch (butten) {
		/*
		 * 查看病人病历
		 */
		case 'l':System.out.print("请输入要查看的病人的id:");
		 		String paID = in.nextLine();
		 		while(!new PatientIDs().contain(paID)){
		 			System.out.print("该病人账号不存在，请重新输入:");
		 			paID = in.nextLine();
		 		}
		 		Patient currentP = new Patient(paID);
		 		currentP.show(paID);
			break;
		/*
		 * 写入病人病历
		 */
		case 'w':inputRecord();
			break;
		default:System.out.println("Wrong enter!");
			break;
		}
		
	}
//-----------------------------------------------------------
	private void inputRecord() throws Exception {		//写病历
		System.out.print("请输入病人的id:");
		String id = in.nextLine();
		System.out.print("请输入账号的密码：");
		String pd = in.nextLine();
		new PatientIDs().addID(id, pd);
		PatientRecord.writeRecord(id);
	}
}
