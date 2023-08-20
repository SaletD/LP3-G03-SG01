import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroSecreto = 7; // Número que el usuario debe adivinar
        int intento;

        System.out.println("¡Bienvenido al juego de adivinar el número!");
        System.out.print("Intenta adivinar el número secreto entre 1 y 10: ");
        intento = scanner.nextInt();

        if (intento == numeroSecreto) {
            System.out.println("¡Felicidades! Has adivinado el número secreto.");
            System.out.println("¡Ganaste un premio! ¡Eres increíble!");
        } else {
            System.out.println("Lo siento, no adivinaste el número. ¡Inténtalo de nuevo!");
        }

        scanner.close();
    }
}
