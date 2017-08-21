import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Ya revise el codigo. La solucion esta bien, es la correcta y la optima. Los comentarios que te voy hacer nomas son para mejorar la sintaxis del codigo.

No es necesaria la variable "student", puedes hacer un if donde checas si el mapa contiene la key con el metodo map.containsKey(key).
Si te devuelve false entonces dentro del if haces el map.put y le pasas una lista nueva. Despues del if agregas el firstname (entre o no entre al if).

Para lo de las comas en lugar de usar String firstnames, usa un StringBuilder firstnames y el metodo append, para ir concatenando el String.
Usar un StringBuilder es mejor porque va haciendo un buffer de los caracteres en lugar de estar creando muchos Strings nuevos, lo cual es malo para la memoria
del programa. (Si quieres saber mas lee acerca de la pool de Strings en Java y acerca de como los Strings son inmutables).

Updeatea tu codigo con los cambios que te di y listo.

Pro tip (no es necesario que hagas esto): En Java 8 hay un metodo de la clase String que se llama join en el cual le puedes pasar un CharSequence y una lista y te junta los elementos de la lista con el (los) caracter(es) especificados.
String.join(",", map.get(key));
 * */

public class TeacherLastNames {

	public static void main(String [] args){
		List<String> students = new ArrayList<String>();
		students.add("Smith, John");
		students.add("Ortiz, Juan");
		students.add("Sanchez, Diego");
		students.add("Sanchez, Ivan");
		students.add("Ortiz, John");
		students.add("Oda, Eiichiro");
		LastName(students);
	}

	public static void LastName(List<String> data){
		//Se crea un mapa con 
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		
		for(String i : data){
			String [] name = i.split(", ");
			String LastName = name[0];
			String FirstName = name[1];

			if (!map.containsKey(LastName)) {
				map.put(LastName, new ArrayList<String>());
			}
			map.get(LastName).add(FirstName);
		}

		for (String key : map.keySet() ) {
			StringBuilder firstnames = new StringBuilder();
			firstnames.append(map.get(key).get(0));
			for(int i = 1; i < map.get(key).size(); i++){
				firstnames.append(", "+map.get(key).get(i));
			}
			System.out.println(key +": "+firstnames);
		}
	}
}