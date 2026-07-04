# Gestor de Reservas - Marta Peluquería

Aplicación de consola desarrollada en Java para gestionar las reservas diarias de una peluquería.

## Funcionalidades

- Agendar una reserva.
- Listar todas las reservas del día.
- Cancelar una reserva por número.
- Ver reporte del día con total de citas y total facturado.
- Salir del programa de forma ordenada.

## Reglas de negocio

- El horario válido es de 8:00 a 17:00.
- No se permite agendar dos reservas en la misma hora.
- El nombre del cliente no puede estar vacío.
- Solo se aceptan los servicios 1, 2 o 3.
- La agenda permite máximo 10 reservas.

## Servicios disponibles

| Código | Servicio | Precio |
|---|---|---:|
| 1 | Corte de cabello | $25.000 |
| 2 | Tinte | $60.000 |
| 3 | Manicure | $30.000 |

## Estructura del proyecto

```txt
.
├── App.java
├── Menu.java
├── Validador.java
└── Operaciones.java
```

## Cómo compilar

```bash
javac *.java
```

## Cómo ejecutar

```bash
java App
```

## Clases principales

### App.java
Contiene el método `main`, el ciclo principal del programa y el `switch` que ejecuta las opciones del menú.

### Menu.java
Se encarga de mostrar el menú y leer la opción elegida por el usuario.

### Validador.java
Contiene métodos para validar hora, nombre, servicio y número de reserva.

### Operaciones.java
Contiene los arreglos paralelos y las operaciones principales: agendar, listar, cancelar y generar reporte.
