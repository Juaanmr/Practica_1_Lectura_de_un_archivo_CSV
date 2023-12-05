
package generararchivonotasmedias;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Juan
 */
public class GenerarArchivoNotasMedias {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException {
        FileInputStream entrada = null;
        
        //selecciono el archivo alumnosNotas.txt donde estan las notas de los alumnos
        try {
            entrada = new FileInputStream("archivos/alumnosNotas.txt");
            
            //decimos el archivo donde estan las notas de los alumnos
            BufferedReader buffer = new BufferedReader(new FileReader("archivos/alumnosNotas.txt"));
            String linea;
                
            //lee el archivo linea por linea y le digo al codigo que cada palabra o cada numero esta separado por :
            while ((linea = buffer.readLine()) != null) {
                String[] partes = linea.split(":");
                
                //parseo la nota del fichero a double por si la nota fuese un double y le digo las partes que quiero que parsee 
                //creo la variable media para que la nota se guarde ahi
                if(partes.length == 4){
                    Double media = (Double.parseDouble(partes[1]) + Double.parseDouble(partes[2]) + Double.parseDouble(partes[3])) /3;
                    System.out.println("La media de " + partes[0] + " es: " + media);
                }
            }
        }
        catch (Exception e) 
        {
            if(entrada != null){
                //cierra el fihero
                entrada.close();
            }
        }
    }
}