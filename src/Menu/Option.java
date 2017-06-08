package Menu;

public class Option {
//	==================== Option ====================
//	Esta classe cria as opcoes do menu pelo qual o usuario navegara.

	private String optName;
	
	public Option(String name){
		this.optName = name;
	}
	
	public String getOption(){
		return this.optName;
	}
}
