package shopping;

public class StartSMS {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data data=new Data();
		data.initial();
		Menu menu=new Menu();
		menu.menu(data);
		menu.showLoginMenu();
		}
}
