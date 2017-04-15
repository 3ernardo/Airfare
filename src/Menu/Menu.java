package Menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	List<Option> menuOptions = new ArrayList<Option>();
	
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
