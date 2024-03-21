package co.cobre.lib.qa.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommonFuntion {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java CSVModifier <path_del_archivo_csv> <numero_documento>");
            return;
        }
        String filePath = args[0];
        String documento = args[1];

        modifyCSVFile(filePath, documento);
    }

    public static void modifyCSVFile(String filePath, String documento) {
        try {
            List<String[]> rows = readCSV(filePath);

            for (String[] row : rows) {
                // Suponiendo que el número de documento está en la columna 2 (indice 1)
                if (row.length >= 2 && row[1].equals(documento)) {
                    // La columna 'Fecha de Vencimiento' está en la posición 10 (indice 9)
                    if (row.length >= 10) {
                        row[9] = ""; // Modifica la fecha de vencimiento
                    }
                }
            }

            writeCSV(filePath, rows);
            System.out.println("Se ha modificado el archivo: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al modificar el archivo: " + filePath);
        }
    }

    private static List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                rows.add(data);
            }
        }
        return rows;
    }

    private static void writeCSV(String filePath, List<String[]> rows) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String[] row : rows) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < row.length; i++) {
                    sb.append(row[i]);
                    if (i < row.length - 1) {
                        sb.append(",");
                    }
                }
                sb.append("\n");
                writer.write(sb.toString());
            }
        }
    }
}
