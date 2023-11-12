import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Empleado {
    private int numero;
    private String nombre;
    private double sueldo;

    public Empleado(int numero, String nombre, double sueldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public void guardarEmpleado() {
        try (PrintWriter writer = new PrintWriter("empleados.txt")) {
            writer.println(numero + ";" + nombre + ";" + sueldo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class GestorEmpleados {
    public static void agregarEmpleado(DefaultTableModel model) {
        try {
            int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número del empleado:"));
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
            double sueldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el sueldo del empleado:"));

            Empleado empleado = new Empleado(numero, nombre, sueldo);
            empleado.guardarEmpleado();
            reporteEmpleados(model);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese valores válidos.");
        }
    }

    public static void reporteEmpleados(DefaultTableModel model) {
        model.setRowCount(0);

        try (Scanner sc = new Scanner(new File("empleados.txt"))) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(";");
                Object[] fila = {Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2])};
                model.addRow(fila);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
        }
    }
}

public class Ejercicio01 {
    private static JTable table;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicación Empleados");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JButton btnAgregar = new JButton("Agregar empleado");
        btnAgregar.addActionListener(e -> GestorEmpleados.agregarEmpleado((DefaultTableModel) table.getModel()));

        table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Número");
        model.addColumn("Nombre");
        model.addColumn("Sueldo");
        table.setModel(model);

        JScrollPane scrollPane = new JScrollPane(table);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(btnAgregar, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
        GestorEmpleados.reporteEmpleados(model);
    }
}
