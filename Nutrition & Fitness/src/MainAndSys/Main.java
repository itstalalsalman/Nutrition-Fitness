package MainAndSys;

import GUI.LoginFrame;

public class Main {

	public static void main(String[] args) {
		TrainingSys.readToSet();
		TrainingSys.readFromBinary();
		LoginFrame login = new LoginFrame();
		login.setTitle("Login");
		login.setVisible(true);
	}

}
