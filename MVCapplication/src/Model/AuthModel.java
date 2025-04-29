package Model;

import java.io.*;

public class AuthModel {

    public boolean login(String email, String password) {
        BufferedReader lector = null;
        try {
            FileReader archivo = new FileReader("src/Files/users.txt");
            lector = new BufferedReader(archivo);
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 2) {
                    String correoArchivo = datos[0].trim();
                    String passArchivo = datos[1].trim();

                    if (correoArchivo.equals(email) && passArchivo.equals(password)) {
                        lector.close();
                        return true;
                    }
                }
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
    }
}
