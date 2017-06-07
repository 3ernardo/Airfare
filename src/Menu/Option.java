package Menu;

public class Option {

	private String optName;
	
	public Option(String name){			//este metodo atribui a variavel optName o valor informado
		optName = name;
	}
	
	public String getOption(){			//este metodo retorna optName
		return optName;
	}
}
