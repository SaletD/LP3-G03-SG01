import java.util.Scanner;
import java.util.Random;
public class Main
{
	public static void main(String[] args) {
	    Scanner scanner=new Scanner(System.in);
		System.out.print("Ingrese el número de filas: ");
		int filas=scanner.nextInt();
		System.out.print("Ingrese el número de columnas: ");
		int columnas=scanner.nextInt();
		int [][] arreglo=new int[filas][columnas];
		Random random=new Random();
		for (int i=0;i<filas;i++){
		    for (int j=0;j<columnas;j++){
		        arreglo[i][j]=random.nextInt(99)+ 1;
		    }
		}
		System.out.println("----------ARREGLO BIDIMENSIONAL RANDOM----------");
		for (int i=0;i<filas;i++){
		    for (int j=0;j<columnas;j++){
		        System.out.print(arreglo[i][j]+"\t");
		    }
		    System.out.println();
		}
	}
}
