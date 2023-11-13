import javax.swing.*;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
//import java.nio.file.Paths;

public class TestFile {
    public static void main(String[] args) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar Archivo o Directorio");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int seleccion = fileChooser.showOpenDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            Path ruta = fileChooser.getSelectedFile().toPath();

            if (Files.exists(ruta)) {
                System.out.printf("%n%s existe%n", ruta.getFileName());
                System.out.printf("%s un directorio%n", Files.isDirectory(ruta) ? "Es" : "No es");
                System.out.printf("%s una ruta absoluta%n", ruta.isAbsolute() ? "Es" : "No es");
                System.out.printf("Fecha de ultima modificacion: %s%n", Files.getLastModifiedTime(ruta));
                System.out.printf("Tamaño: %s bytes%n", Files.size(ruta));
                System.out.printf("Ruta: %s%n", ruta);
                System.out.printf("Ruta absoluta: %s%n", ruta.toAbsolutePath());

                if (Files.isDirectory(ruta)) {
                    System.out.printf("%nContenido del directorio:%n");
                    try (DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta)) {
                        for (Path p : flujoDirectorio) {
                            System.out.println(p);
                        }
                    }
                }
            } else {
                System.out.printf("%s no existe%n", ruta);
            }
        } else {
            System.out.println("Operación cancelada por el usuario");
        }
    }
}
