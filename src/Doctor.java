import java.util.Scanner;

public class Doctor {
	private Scanner in = new Scanner(System.in);

//-----------------------------------------------------------
	//��¼�˺�
	public boolean load(String docID, String pw) throws Exception {
		//������ڵ�ҽ�����˺�,�ж��˺��Ƿ���� 
		if(!new DoctorIDs().contain(docID)){
			System.out.println("Wrong id! enter again:");
			return false;
		}
		//�������˺��Ƿ�ƥ��
		else if(!new DoctorIDs().isPass(docID, pw)){
				System.out.println("Wrong password! enter again:");
		}
		System.out.println("Loading successfully!");
		//��ʾҽ����ҳ
		this.menu();
		return true;
	}
//--------------------------------------------------------------------------
	private void menu() throws Exception {		//��ʾ�˵�
		System.out.println("Doctor Menu");
		System.out.print("Please enter l (look record) or w(write record):");
		char butten = in.nextLine().charAt(0);
		switch (butten) {
		/*
		 * �鿴���˲���
		 */
		case 'l':System.out.print("������Ҫ�鿴�Ĳ��˵�id:");
		 		String paID = in.nextLine();
		 		while(!new PatientIDs().contain(paID)){
		 			System.out.print("�ò����˺Ų����ڣ�����������:");
		 			paID = in.nextLine();
		 		}
		 		Patient currentP = new Patient(paID);
		 		currentP.show(paID);
			break;
		/*
		 * д�벡�˲���
		 */
		case 'w':inputRecord();
			break;
		default:System.out.println("Wrong enter!");
			break;
		}
		
	}
//-----------------------------------------------------------
	private void inputRecord() throws Exception {		//д����
		System.out.print("�����벡�˵�id:");
		String id = in.nextLine();
		System.out.print("�������˺ŵ����룺");
		String pd = in.nextLine();
		new PatientIDs().addID(id, pd);
		PatientRecord.writeRecord(id);
	}
}
