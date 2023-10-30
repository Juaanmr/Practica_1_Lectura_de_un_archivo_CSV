
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
        
        try {
            entrada = new FileInputStream("archivos/alumnosNotas.txt");
            
            BufferedReader buffer = new BufferedReader(new FileReader("archivos/alumnosNotas.txt"));
            String linea;
                
            while ((linea = buffer.readLine()) != null) {
                String[] partes = linea.split(":");
                
                if(partes.length == 4){
                    Double media = (Double.parseDouble(partes[1]) + Double.parseDouble(partes[2]) + Double.parseDouble(partes[3])) /3;
                    System.out.println("La media de " + partes[0] + " es: " + media);
                }
            }
        }
        catch (Exception e) 
        {
            if(entrada != null){
                entrada.close();
            }
        }
    }
}