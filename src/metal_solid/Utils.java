package metal_solid;

/**
 * Clase que nos ayudara en la futura inicializacion de nuestro mundo
 * convirtiendo nuestros strings en number
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Utils {

	public String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(path)));
			String line;
			while((line =  br.readLine()) != null)
				builder.append(line + "\n");
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	/**
	 * Funcion parseInt, que utilizaremos para convertir los numeros en formato string a numeros integer
	 * @param number Numero como string
	 * @return
	 */
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
