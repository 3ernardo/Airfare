package Menu;

import java.util.ArrayList;

public class Menu {

	ArrayList<Option> menuOptions = new ArrayList<Option>();
	
	public void addOption(String name){
		Option o = new Option(name);
		menuOptions.add(o);
	}
	
	public void showMenu(){
		int i = 0;
		for (Option opt: menuOptions) {
			i++;
			System.out.println("["+i+"] "+opt.getOption());
		}
	}
}