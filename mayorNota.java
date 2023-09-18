//estudiante promedio con mayor nota
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir la cantidad de estudiantes a ingresar
        System.out.print("Ingrese la cantidad de estudiantes: ");
        int cantidadEstudiantes = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Variables para mantener el promedio general y los nombres de estudiantes con máx. y mín. promedio
        double promedioGeneral = 0.0;
        double promedioMaximo = 0.0; // Agregar esta línea
        double promedioMinimo = 0.0; // Agregar esta línea
        String estudianteMaximoPromedio = "";
        String estudianteMinimoPromedio = "";

        System.out.println("Ingrese la información de los estudiantes:");

        // Encabezado de la tabla
        System.out.println("Nombre\tMatemática\tFísica\tPromedio");

        for (int i = 0; i < cantidadEstudiantes; i++) {
            // Pedir nombre del estudiante
            System.out.print("Nombre del estudiante " + (i + 1) + ": ");
            String nombre = scanner.nextLine();

            // Pedir notas de Matemática y Física
            System.out.print("Nota de Matemática para " + nombre + ": ");
            double notaMatematica = scanner.nextDouble();
            System.out.print("Nota de Física para " + nombre + ": ");
            double notaFisica = scanner.nextDouble();

            // Calcular el promedio del estudiante
            double promedioEstudiante = (notaMatematica + notaFisica) / 2;

            // Actualizar el promedio general y los nombres de estudiante con máx. y mín. promedio
            promedioGeneral += promedioEstudiante;
            if (i == 0 || promedioEstudiante > promedioMaximo) {
                promedioMaximo = promedioEstudiante;
                estudianteMaximoPromedio = nombre;
            }
            if (i == 0 || promedioEstudiante < promedioMinimo) {
                promedioMinimo = promedioEstudiante;
                estudianteMinimoPromedio = nombre;
            }

            // Mostrar la información del estudiante en la tabla
            System.out.println(nombre + "\t" + notaMatematica + "\t" + notaFisica + "\t" + promedioEstudiante);

            // Consumir el salto de línea después de las notas
            scanner.nextLine();
        }

        // Calcular el promedio general
        promedioGeneral /= cantidadEstudiantes;

        // Mostrar los resultados
        System.out.println("Estudiante con Promedio más Alto: " + estudianteMaximoPromedio);
        System.out.println("Estudiante con Promedio más Bajo: " + estudianteMinimoPromedio);
        System.out.println("Promedio General: " + promedioGeneral);

        // Cerrar el scanner
        scanner.close();
    }
}
