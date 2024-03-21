package co.cobre.lib.qa.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProcessesIntheFile {
    public static String ModifyExpirationDate(String csv, String document, String newExpirationDate) {
        try {
            // Leer el archivo CSV
            BufferedReader br = new BufferedReader(new FileReader(csv));
            StringBuilder modifiedContent = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String idDocument = datos[1].trim();
                if (idDocument.equals(document)) {
                    datos[9] = newExpirationDate;
                }
                modifiedContent.append(String.join(";", datos)).append("\n");
            }
            br.close();

            // Escribir los cambios en el mismo archivo CSV
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv));
            bw.write(modifiedContent.toString());
            bw.close();

            System.out.println("Se ha actualizado el archivo '" + csv + "' con la nueva fecha de vencimiento correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Se ha actualizado el archivo '" + csv + "' con la nueva fecha de vencimiento correctamente.";
    }

    public static String getExpirationDate(String csv, String document) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(csv));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String numeroDocumento = datos[1].trim();
                if (numeroDocumento.equals(document)) {
                    return datos[9].trim(); // Devuelve el valor de la fecha de vencimiento
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Retorna null si no se encuentra el documentoId
    }

}
