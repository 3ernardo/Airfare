package Menu;

import java.util.ArrayList;

public class Menu {
//	==================== Menu ====================
//	Esta classe cria o menu atraves do qual o usuario navegara.

	ArrayList<Option> menuOptions = new ArrayList<Option>();
	
	public void addOption(String name){
	//	Este metodo cria opcoes do menu atraves de objetos Option.
		Option o = new Option(name);
		menuOptions.add(o);
	}
	
	public void showMenu(){
	//	Este metodo exibe as opcoes do menu.
		int i = 0;
		for (Option opt: menuOptions) {
			i++;
			System.out.println("["+i+"] "+opt.getOption());
		}
	}
}