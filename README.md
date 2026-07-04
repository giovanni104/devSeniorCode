Se desarrolló una aplicación de consola en Java para gestionar las reservas de una peluquería. El sistema permite agendar, listar, cancelar reservas y generar un reporte diario con el total de citas y la facturación.

La solución fue organizada en las clases App, Menu, Validador y Operaciones, separando las responsabilidades del programa. Para almacenar la información se utilizaron arreglos paralelos, relacionando el nombre del cliente, la hora y el servicio por medio del mismo índice.

El programa incluye validaciones para evitar nombres vacíos, horas inválidas, servicios no permitidos, reservas duplicadas en una misma hora y exceso del cupo máximo. Además, al cancelar una reserva, los datos se reorganizan para no dejar espacios vacíos en los arreglos.

Con esta solución se aplican fundamentos de Java como ciclos, condicionales, métodos, arreglos, Scanner, constantes y validación de entradas.
