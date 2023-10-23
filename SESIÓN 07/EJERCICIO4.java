package sesion7p2;
public class CatchMultipleExceptionsExample {
    public static void main(String[] args) {
        try {
            // Aquí se produce una excepción ArithmeticException
            int result = divideByZero();
            System.out.println("Resultado: " + result);
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Se ha producido una excepción: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            System.out.println("Otra excepción no manejada: " + e.getClass().getSimpleName());
        }

        try {
            // Aquí se produce una excepción NullPointerException
            String str = null;
            int length = str.length();
            System.out.println("Longitud de la cadena: " + length);
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Se ha producido una excepción: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            System.out.println("Otra excepción no manejada: " + e.getClass().getSimpleName());
        }
    }

    public static int divideByZero() {
        return 5 / 0;
    }
}
