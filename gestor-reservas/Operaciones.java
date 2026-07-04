import java.util.Scanner;

public class Operaciones {

    private static final int CUPO_MAXIMO = 10;

    private static final int SERVICIO_CORTE = 1;
    private static final int SERVICIO_TINTE = 2;
    private static final int SERVICIO_MANICURE = 3;

    private static final int PRECIO_CORTE = 25000;
    private static final int PRECIO_TINTE = 60000;
    private static final int PRECIO_MANICURE = 30000;

    private static String[] clientes = new String[CUPO_MAXIMO];
    private static int[] horas = new int[CUPO_MAXIMO];
    private static int[] servicios = new int[CUPO_MAXIMO];

    private static int contador = 0;

    public static void agendar(Scanner scanner) {
        System.out.println("\n--- Agendar reserva ---");

        if (contador == CUPO_MAXIMO) {
            System.out.println("No hay cupos disponibles para hoy.");
            return;
        }

        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();

        if (!Validador.nombreValido(nombre)) {
            System.out.println("El nombre del cliente no puede estar vacío.");
            return;
        }

        System.out.print("Hora de la reserva (8 a 17): ");
        int hora = leerEntero(scanner);

        if (!Validador.horaValida(hora)) {
            System.out.println("Hora inválida. Solo puedes agendar entre las 8:00 y las 17:00.");
            return;
        }

        if (horaOcupada(hora)) {
            System.out.println("La hora " + hora + ":00 ya está ocupada.");
            return;
        }

        mostrarServicios();
        System.out.print("Elige el servicio: ");
        int servicio = leerEntero(scanner);

        if (!Validador.servicioValido(servicio)) {
            System.out.println("Servicio inválido. Debes elegir 1, 2 o 3.");
            return;
        }

        clientes[contador] = nombre.trim();
        horas[contador] = hora;
        servicios[contador] = servicio;
        contador++;

        System.out.println("Reserva agendada correctamente.");
    }

    public static void listar() {
        System.out.println("\n--- Reservas del día ---");

        if (contador == 0) {
            System.out.println("Aún no hay reservas registradas.");
            return;
        }

        for (int i = 0; i < contador; i++) {
            System.out.println((i + 1) + ". Cliente: " + clientes[i]
                    + " | Hora: " + horas[i] + ":00"
                    + " | Servicio: " + obtenerNombreServicio(servicios[i]));
        }
    }

    public static void cancelar(Scanner scanner) {
        System.out.println("\n--- Cancelar reserva ---");

        if (contador == 0) {
            System.out.println("No hay reservas para cancelar.");
            return;
        }

        listar();

        System.out.print("Ingresa el número de la reserva a cancelar: ");
        int numeroReserva = leerEntero(scanner);

        if (!Validador.numeroReservaValido(numeroReserva, contador)) {
            System.out.println("Número de reserva inválido.");
            return;
        }

        int indice = numeroReserva - 1;

        for (int i = indice; i < contador - 1; i++) {
            clientes[i] = clientes[i + 1];
            horas[i] = horas[i + 1];
            servicios[i] = servicios[i + 1];
        }

        clientes[contador - 1] = null;
        horas[contador - 1] = 0;
        servicios[contador - 1] = 0;
        contador--;

        System.out.println("Reserva cancelada correctamente.");
    }

    public static void reporte() {
        System.out.println("\n--- Reporte del día ---");

        int totalFacturado = 0;

        for (int i = 0; i < contador; i++) {
            totalFacturado += obtenerPrecioServicio(servicios[i]);
        }

        System.out.println("Total de citas agendadas: " + contador);
        System.out.println("Total facturado: $" + totalFacturado);
    }

    private static boolean horaOcupada(int hora) {
        for (int i = 0; i < contador; i++) {
            if (horas[i] == hora) {
                return true;
            }
        }
        return false;
    }

    private static void mostrarServicios() {
        System.out.println("\nServicios disponibles:");
        System.out.println("1. Corte de cabello - $25.000");
        System.out.println("2. Tinte - $60.000");
        System.out.println("3. Manicure - $30.000");
    }

    private static String obtenerNombreServicio(int servicio) {
        switch (servicio) {
            case SERVICIO_CORTE:
                return "Corte de cabello";
            case SERVICIO_TINTE:
                return "Tinte";
            case SERVICIO_MANICURE:
                return "Manicure";
            default:
                return "Servicio desconocido";
        }
    }

    private static int obtenerPrecioServicio(int servicio) {
        switch (servicio) {
            case SERVICIO_CORTE:
                return PRECIO_CORTE;
            case SERVICIO_TINTE:
                return PRECIO_TINTE;
            case SERVICIO_MANICURE:
                return PRECIO_MANICURE;
            default:
                return 0;
        }
    }

    private static int leerEntero(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Debes ingresar un número válido. Intenta nuevamente: ");
            scanner.nextLine();
        }

        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpia el salto de línea pendiente
        return numero;
    }
}
