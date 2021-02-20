package Clases;

import static Clases.Datos.DatosPath;
import java.io.*;

/**
 *
 * @author giovannyb
 */
public class Datos {

    public static String path = System.getProperty("user.dir");
    public static String DatosPath = path + "/Datos/";
    public static String archivo = "Eventos.tsk";

    public static void main(String[] args) {

    }

    public static void Escribir(String dato) {

        File file = new File(DatosPath);
        try {

            FileWriter fw = null;

            if (file.exists()) {
                fw = new FileWriter(DatosPath + archivo, true);
            } else {
                if (file.mkdirs()) {
                    fw = new FileWriter(DatosPath + archivo);
                }
            }

            for (int i = 0; i < dato.length(); i++) {
                fw.write(dato.charAt(i));
            }

            fw.write("\n");

            fw.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void Eliminar(String linea) {
        try {
            File file = new File(DatosPath + archivo);
            File tempFile = new File(file.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            while ((line = br.readLine()) != null) {
                if (!line.trim().equals(linea)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
