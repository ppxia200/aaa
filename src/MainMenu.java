import java.util.Scanner;

public class MainMenu {

	public void open() throws Exception {		//打开主界面
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter d(doctor load) or p(patient load):");
		char tap = in.nextLine().charAt(0);
		loadType(in, tap);
	}
//-----------------------------------------------------------------------
	//登录方式
	public void loadType(Scanner in, char tap) throws Exception {
		switch (tap) {
		//医生端
		case 'd': 	Doctor doctor = new Doctor();
					System.out.print("Enter doctor's id and password:");
					String docID = in.nextLine();
					String pw = in.nextLine();
					while(!doctor.load(docID, pw)){		//直至输入存在的账号
						 System.out.print("id：");
						 docID = in.nextLine(); 
						 System.out.print("password:");
						 pw = in.nextLine();
					}
			break;
		//病人端
		case 'p':	Patient patient = new Patient();
					System.out.print("Enter patient's id and password:");
					String paID = in.nextLine();
					String pw1  = in.nextLine();
					while(!patient.load(paID, pw1)){
						System.out.print("id：");
						paID = in.nextLine(); 
						 System.out.print("password:");
						 pw1 = in.nextLine();
					}
			break;
		default:	System.out.println("Wrong enter!");
			break;
		}
	}
}
