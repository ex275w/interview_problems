import java.util.Arrays;
import java.util.HashMap;

public class HighestChar {
	public static void main (String [] args){
		System.out.println(getMostRepeatedCharacter("hello world")); //l
		System.out.println(getMostRepeatedCharacter("abcdef")); //a or anything
		System.out.println(getMostRepeatedCharacter("pokemon")); //o
		System.out.println(getMostRepeatedCharacter("1he1llo1")); //1
		System.out.println(getMostRepeatedCharacter("this is just some random text for testing")); //blank space
		System.out.println(getMostRepeatedCharacter("YXyXyXyXY")); //X
		System.out.println(getMostRepeatedCharacter(null)); //blank space or another suggestion
		System.out.println(getMostRepeatedCharacter("")); //blank space or another suggestion   
		System.out.println(getMostRepeatedCharacter("ivan.el.guapo.123@gmail.com"));
	}
	
	public static char getMostRepeatedCharacter(String data){
		if (data == null)
			return ' ';
		
		if (data == "")
			return ' ';
		
		char [] charArray = data.toCharArray();
		Arrays.sort(charArray);
		HashMap<Character, Integer> hash = new HashMap<>();
		int counter = 0;
		char currchar = charArray[0];
		
		for(int i = 0; i < charArray.length; i++){
			if (currchar != charArray[i]){
				hash.put(currchar, counter);
				currchar = charArray[i];
				counter = 1;
			}
			else
				counter++;
		}
		
		char returnchar = 0;
		int biggestnumber = 0;
		
		for(char key: hash.keySet()){
			if(biggestnumber < hash.get(key)){
				biggestnumber = hash.get(key);
				returnchar = key;
			}
		}
	    return returnchar;
	}
}