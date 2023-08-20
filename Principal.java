import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroSecreto = 7; // ingresar numero
        int intento;
        int vidas = 3; // vidas iniciales

        System.out.println("¡Bienvenido al juego de adivinar el número!");
        
        while (vidas > 0) {
            System.out.print("Intenta adivinar el número secreto entre 1 y 10: ");
            intento = scanner.nextInt();
            
            if (intento == numeroSecreto) {
                System.out.println("¡Felicidades! Has adivinado el número secreto.");
                mostrarPremio(vidas);
                break;
            } else {
                vidas--;
                if (vidas > 0) {
                    System.out.println("Número incorrecto. Te quedan " + vidas + " vidas.");
                } else {
                    System.out.println("Lo siento, no adivinaste el número. ¡Mejor suerte la próxima vez!");
                }
            }
        }
        
        scanner.close();
    }
    
    public static void mostrarPremio(int vidas) {
        switch (vidas) {
            case 3:
                System.out.println("¡Ganaste el premio mayor! Eres un adivinador excepcional.");
                break;
            case 2:
                System.out.println("¡Ganaste un premio mediano! ¡Sigue mejorando!");
                break;
            case 1:
                System.out.println("¡Ganaste un premio pequeño! ¡No te rindas!");
                break;
            default:
                System.out.println("¡No deberías estar viendo esto! Hubo un error.");
                break;
        }
    }
}
