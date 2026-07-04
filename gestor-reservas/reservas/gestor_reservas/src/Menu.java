import java.util.Scanner;

public class Menu {

    public static void mostrarMenu() {
        System.out.println("\n================================");
        System.out.println("     GESTOR DE RESERVAS");
        System.out.println("     Marta Peluquería");
        System.out.println("================================");
        System.out.println("1. Agendar reserva");
        System.out.println("2. Listar reservas");
        System.out.println("3. Cancelar reserva");
        System.out.println("4. Ver reporte del día");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
    }

    public static int leerOpcion(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Debes ingresar un número. Intenta nuevamente: ");
            scanner.nextLine();
        }

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpia el salto de línea pendiente
        return opcion;
    }
}
