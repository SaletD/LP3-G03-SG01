import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sn = new Scanner(System.in);
    int matriz[][] = new int[4][4];
    boolean salir = false;
    int opcion, fila, columna;
    boolean rellenado = false;
    do {
        System.out.println("Menu");
        System.out.println("1. Rellenar Matriz");
        System.out.println("2. Sumar fila");
        System.out.println("3. Suma de una columna");
        System.out.println("4. Suma diagonal principal");
        System.out.println("5. Suma diagonal inversa");
        System.out.println("6. La media de todos los valores");
        System.out.println("7. Salir");
        System.out.println("Elije una opcion");
        opcion = sn.nextInt();
        switch (opcion) {
            case 1:
                rellenarMatriz(sn, matriz);
                rellenado = true;
                break;
            case 2:
                if (rellenado) {
                    do {
                        System.out.println("Elige una fila");
                        fila = sn.nextInt();
                    }while (!(fila >= 0 && fila < matriz.length));
                    System.out.println("La suma de los valores de la fila " + fila+ " es: " + sumaFila(matriz, fila));
                } else {
                    System.out.println("Debes rellenar la matriz primero");
                }
                break;
            case 3:
                if (rellenado){
                    do {
                        System.out.println ("Elige una columna");
                        columna= sn.nextInt();
                    }while (!(columna>=0 && columna<matriz.length));
                    System.out.println("La suma de los valores de la columna "+columna+" es: "+sumaColumna(matriz,columna));
                } else{
                    System.out.println("Debes rellenar la matriz primero");
                }
                break;
            case 4:
                if (rellenado){
                    System.out.println("La suma de la diagonal principal es " + sumaDiagonalprin(matriz));
                }else{
                   System.out.println("Debes rellenar la matriz primero"); 
                }
                break;
            case 5:
                if (rellenado){
                    System.out.println("La suma de la diagonal inversa es " + sumaDiagonalinv(matriz));
                }else{
                    System.out.println("Debes rellenar la matriz primero"); 
                }
                break;
            case 6:
                if (rellenado){
                    System.out.println("La media de todos los valores de la matriz es " + mediaTodo(matriz));
                }else{
                    System.out.println("Debes rellenar la matriz primero");
                }
                break;
            case 7:
                salir = true;
                break;
            default:
            System.out.println("Tienes que meter un valor entre 1 y 7");
        }
    } while (!salir);
    System.out.println("FIN");
 }
 public static void rellenarMatriz(Scanner sn, int[][] matriz) {
     for (int i = 0; i < matriz.length; i++) {
         for (int j = 0; j < matriz[0].length; j++) {
             System.out.println("Escribe un numero en la posicion " + i + " " + j);
             matriz[i][j] = sn.nextInt();
         }
     }
 }
 public static int sumaFila(int[][] matriz, int fila) {
     int suma = 0;
     for (int j = 0; j < matriz.length; j++) {
         suma += matriz[fila][j];
     }
     return suma;
 }
 public static int sumaColumna(int [][] matriz, int columna){
     int suma=0;
     for (int a=0; a<matriz.length;a++){
         suma+=matriz[a][columna];
     }
     return suma;
 }
 public static int sumaDiagonalprin(int [][] matriz){
     int suma=0;
     for (int b=0;b<matriz.length;b++){
         suma+=matriz[b][b];
     }
     return suma;
 }
 public static int sumaDiagonalinv(int [][] matriz){
     int suma=0;
     int fila=0;
     int columna=matriz.length-1;
     while (fila<matriz.length && columna>=0){
         suma+=matriz[fila][columna];
         fila++;
         columna--;
     }
     return suma;
 }
 public static int mediaTodo(int [][] matriz){
     int suma =0;
     for (int fila=0;fila<matriz.length;fila++){
         for (int columna=0;columna<matriz[0].length;columna++){
             suma+=matriz[fila][columna];
         }
     }
     return suma/(matriz.length*matriz[0].length);
 }
}
