import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


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
		HashMap<String, List<String>> map = new HashMap<String, List<String>>(); //Creamos un mapa, el string va a contener los apellidos y la list de String es donde se van a colocar todos los primeros nombres.
		for(String i : data){
			//Cortamos la string para separar el apellido y el primer nombre
			String [] name = i.split(", ");
			String LastName = name[0];
			String FirstName = name[1];

			//Se crea una nueva lista en base al apellido
			List<String> student = map.get(LastName);

			//Cuando captura un que la llave no tiene ningun valor se agrega esa lista personalizada al mapa y se llena con el nombre, cuando esa lista ya esta en ese key, simplemente se llena para no sobreescribir la lista
			//Esto se hace para que cada Key tenga su lista personal de students y que no se copie entre ciclos el valor de students y ya que cuando se agrega un valor va a saber que lista tiene, no hay dificultades para anidar nuevos valores
			if (student == null) {
				student = new ArrayList<>();
				map.put(LastName, student);
			}
			student.add(FirstName);
		}
		
		//Se crea un string para manejar los primeros nombres y las commas
		String firstnames = new String();
		
		//Se crea un for para cada apellido
		for (String key : map.keySet() ) {
			for(int i = 0; i < map.get(key).size(); i++){
				if(i == 0){
					firstnames = map.get(key).get(i); //Se llena el primer valor sin comma
				}
				else{
					firstnames =firstnames + ", "+ map.get(key).get(i); //Para cuando hay mas de un valor se agrega una comma entre nombres
				}
			}
			System.out.println(key +": "+firstnames); //Se imprime la lista ya que esta el formato de primeros nombres correctos y se pasa al siguiente apellido
		}
	}
}

