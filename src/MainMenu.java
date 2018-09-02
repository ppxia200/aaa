import java.util.Scanner;

public class MainMenu {

	public void open() throws Exception {		//��������
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter d(doctor load) or p(patient load):");
		char tap = in.nextLine().charAt(0);
		loadType(in, tap);
	}
//-----------------------------------------------------------------------
	//��¼��ʽ
	public void loadType(Scanner in, char tap) throws Exception {
		switch (tap) {
		//ҽ����
		case 'd': 	Doctor doctor = new Doctor();
					System.out.print("Enter doctor's id and password:");
					String docID = in.nextLine();
					String pw = in.nextLine();
					while(!doctor.load(docID, pw)){		//ֱ��������ڵ��˺�
						 System.out.print("id��");
						 docID = in.nextLine(); 
						 System.out.print("password:");
						 pw = in.nextLine();
					}
			break;
		//���˶�
		case 'p':	Patient patient = new Patient();
					System.out.print("Enter patient's id and password:");
					String paID = in.nextLine();
					String pw1  = in.nextLine();
					while(!patient.load(paID, pw1)){
						System.out.print("id��");
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
