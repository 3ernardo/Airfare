package Menu;

import java.util.ArrayList;

public class Menu {

	ArrayList<Option> menuOptions = new ArrayList<Option>();
	
	public void addOption(String name){			//este metodo cria opcoes do menu atraves de objetos Option
		Option o = new Option(name);
		menuOptions.add(o);
	}
	
	public void showMenu(){						//este metodo printa as opcoes do menu
		int i = 0;
		for (Option opt: menuOptions) {
			i++;
			System.out.println("["+i+"] "+opt.getOption());
		}
	}
}