public class Main {
    public static void main(String[] args) {
        int filasColumnas = 3;
        
        // Matriz triangular inferior
        int[][] matrizTriangularInferior = new int[filasColumnas][filasColumnas];
        for (int i = 0; i < filasColumnas; i++) {
            for (int j = 0; j <= i; j++) {
                matrizTriangularInferior[i][j] = i * filasColumnas + j + 1;
            }
        }
        
        System.out.println("Matriz triangular inferior:");
        imprimirMatriz(matrizTriangularInferior);
        
        // Matriz triangular superior
        int[][] matrizTriangularSuperior = new int[filasColumnas][filasColumnas];
        for (int i = 0; i < filasColumnas; i++) {
            for (int j = i; j < filasColumnas; j++) {
                matrizTriangularSuperior[i][j] = i * filasColumnas + j + 1;
            }
        }
        
        System.out.println("\nMatriz triangular superior:");
        imprimirMatriz(matrizTriangularSuperior);
    }
    
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
