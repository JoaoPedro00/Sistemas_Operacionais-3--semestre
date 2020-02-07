package view;


import controller.RedesController;

public class Main {
	public static void main(String [] args) {
		RedesController rc = new RedesController();
		System.out.println(rc.os());
		if (rc.os().contains("Windows")){
		rc.leProcesso("ipconfig");
		}

	}
}
