
public class ParenthesisCheck {
	public static void main(String args[]){
		System.out.println(isValidParenthesis("(abc)")); //true
		System.out.println(isValidParenthesis("(ab(c))")); //true
		System.out.println(isValidParenthesis("(())")); //true
		System.out.println(isValidParenthesis("((a)")); //false
		System.out.println(isValidParenthesis(")(")); //false
		System.out.println(isValidParenthesis("a")); //true
		System.out.println(isValidParenthesis("(he(ll)o)(w)((or(ld)))")); //true
		System.out.println(isValidParenthesis("(he(ll)o)(w)(or(ld)))")); //false
		System.out.println(isValidParenthesis(null)); //false
		System.out.println(isValidParenthesis("")); //true
		System.out.println(isValidParenthesis("())(")); //false
	}
	
	public static boolean isValidParenthesis(String data){
		int leftPar = 0; //Contador de caracter (
		int rightPar = 0; //Contador de caracter )
		
		if(data == null) //En caso de que se envie un caso nulo
			return false;
		
		//Se lee todo el String y se va sumando a los contadores o en caso de que se ponga un ) invalido retorna falso 
		for(int i = 0; i < data.length(); i++){  
			//Si se encuentra un ) antes de un ( o hay mas ) en un momento se regresa falso inmediatamente
			if(data.charAt(i) == ')' && rightPar >= leftPar){
				return false;
			}
			else if(data.charAt(i) == '('){
				leftPar++;
			}
			else if(data.charAt(i) == ')')
				rightPar++;
		}
		//Si se tiene un mismo numero de ( y ) y los ) no estan mal posicionados se regresa un )
		if(leftPar == rightPar)
			return true;
		else
			return false;
	}
}
