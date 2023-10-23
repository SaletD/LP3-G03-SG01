package sesion7p1;

import java.io.IOException;

public class ProcesarEntrada{
    public static void main(String[] args) {
        LeerEntrada lector = new LeerEntrada(System.in);
        boolean salir = false;

        while (!salir) {
            try {
                char caracter = lector.getChar();
                salir = procesarCaracter(caracter);
            } catch (IOException e) {
                System.out.println("Error de entrada: " + e.getMessage());
            } catch (ExcepcionDeVocal e) {
                System.out.println("Excepción de vocal: " + e.getMessage());
            } catch (ExcepcionDeNumero e) {
                System.out.println("Excepción de número: " + e.getMessage());
            } catch (ExcepcionDeBlanco e) {
                System.out.println("Excepción de blanco: " + e.getMessage());
            } catch (ExcepcionDeSalida e) {
                System.out.println("Excepción de salida: " + e.getMessage());
                salir = true;
            }
        }
    }

    private static boolean procesarCaracter(char caracter)
            throws ExcepcionDeVocal, ExcepcionDeNumero, ExcepcionDeBlanco, ExcepcionDeSalida {
        if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
            throw new ExcepcionDeVocal("Vocal encontrada: " + caracter);
        } else if (Character.isDigit(caracter)) {
            throw new ExcepcionDeNumero("Número encontrado: " + caracter);
        } else if (Character.isWhitespace(caracter)) {
            throw new ExcepcionDeBlanco("Espacio en blanco encontrado: " + caracter);
        } else if (caracter == 'q') {
            throw new ExcepcionDeSalida("Caracter de salida 'q' encontrado");
        }
        return false;
    }
}
