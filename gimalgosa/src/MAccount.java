import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

}
