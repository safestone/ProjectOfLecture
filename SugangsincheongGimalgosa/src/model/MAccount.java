package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VFindId;
import valueObject.VFindPW;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class MAccount {

	public VUserInfo login(VLogin vLogin) {
		try {
			Scanner sc= new Scanner(new File("data/Account"));
			VUserInfo vUserInfo = null;
			while (sc.hasNext()) {
				String line = sc.nextLine();
				String[]  Information = line.split("[ ]");
				if(Information[0].equals(vLogin.getUserId())){
					if (Information[1].equals(vLogin.getpassword())) {
						vUserInfo = new VUserInfo();
						vUserInfo.setName(Information[2]);
						vUserInfo.setRoot(Information[4]);
						vUserInfo.setDepartment(Information[5]);
						vUserInfo.setCredit(Integer.parseInt(Information[6]));
						break;
					}
				}
			}
			sc.close();
			return vUserInfo;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public VUserInfo FindId(VFindId vFindId) {
		try {
			Scanner sc= new Scanner(new File("data/Account"));
			VUserInfo vUserInfo = null;
			while (sc.hasNext()) {
				String line = sc.nextLine();
				String[] IdInformation = line.split("[ ]");
				if(IdInformation[2].equals(vFindId.getName())) {
					if(IdInformation[3].equals(vFindId.getDate())) {
						vUserInfo = new VUserInfo();
						vUserInfo.setId(IdInformation[0]);
						break;
					}
				}
			}
			sc.close();
			return vUserInfo;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public VUserInfo FindPW(VFindPW vFindPW) {
		try {
			Scanner sc= new Scanner(new File("data/Account"));
			VUserInfo vUserInfo = null;
			while (sc.hasNext()) {
				String line = sc.nextLine();
				String[] PwInformation = line.split("[ ]");
				if(PwInformation[0].equals(vFindPW.getId())) {
					if(PwInformation[3].equals(vFindPW.getDate())) {
						vUserInfo = new VUserInfo();
						vUserInfo.setPw(PwInformation[1]);
						break;
					}
				}
			}
			sc.close();
			return vUserInfo;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
