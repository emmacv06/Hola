/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package templazon;

import javax.swing.JOptionPane;

/**
 *
 * @author sanlo
 */
public class EspacioRecreativo {

    static Recreativo[] espacios = new Recreativo[7]; // 2 tenis, 1 baloncesto, 2 fútbol, 1 billar, 1 ping-pong

    
    static boolean precargado = false; //Dice si ya se precargaron los espacios o no

    
    static class Recreativo { // Representa un espacio recreativo
        
        String tipo;
        String nombre;
        int capacidadMaxima;
        int cuposDisponibles;

        public Recreativo(String tipo, String nombre, int capacidadMaxima) {
            this.tipo = tipo;
            this.nombre = nombre;
            this.capacidadMaxima = capacidadMaxima;
            this.cuposDisponibles = capacidadMaxima; // Al inicio todos los cupos están disponibles
        }

        public Recreativo() {
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getCapacidadMaxima() {
            return capacidadMaxima;
        }

        public void setCapacidadMaxima(int capacidadMaxima) {
            this.capacidadMaxima = capacidadMaxima;
        }

        public int getCuposDisponibles() {
            return cuposDisponibles;
        }

        public void setCuposDisponibles(int cuposDisponibles) {
            this.cuposDisponibles = cuposDisponibles;
        }

        
        public boolean reservar(int cantidad) { // Resta los cupos si hay suficiente espacio disponible
            if (cuposDisponibles >= cantidad) {
                cuposDisponibles -= cantidad;
                return true;
            }
            return false;
        }

        // Devuelve un resumen con el tipo, nombre y cupos disponibles
        public String resumen() {
            return tipo + " - " + nombre + " | Cupos disponibles: " + cuposDisponibles;
        }

        // Calcula cuántos espacios ya están reservados
        public int reservados() {
            return capacidadMaxima - cuposDisponibles;
        }
    }

    // Menú principal del sistema recreativo
    public static void iniciar() {
        if (!precargado) {
            precargarEspacios(); // Precarga los datos una única vez
            precargado = true;
        }

        String opcion;
        do {
            // Menú de opciones
            opcion = JOptionPane.showInputDialog(
                    "SISTEMA DE ESPACIOS RECREATIVOS\n\n"
                    + "1. Ver espacios disponibles\n"
                    + "2. Reservar espacio\n"
                    + "3. Volver al menú principal"
            );

            // Si el usuario cierra o selecciona salir
            if (opcion == null || opcion.equals("3")) {
                break;
            }

            // Lógica según la opción seleccionada
            switch (opcion) {
                case "1":
                    mostrarEspacios();
                    break;
                case "2":
                    reservarEspacio();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }

        } while (true); // Repite hasta que el usuario decida salir
    }

    // Carga inicial de los espacios recreativos
    private static void precargarEspacios() {
        espacios[0] = new Recreativo("Ping-pong", "Mesa 1", 2);
        espacios[1] = new Recreativo("Billar", "Mesa 2", 2);
        espacios[2] = new Recreativo("Fútbol", "Cancha 1", 12);
        espacios[3] = new Recreativo("Fútbol", "Cancha 2", 12);
        espacios[4] = new Recreativo("Baloncesto", "Cancha Principal", 10);
        espacios[5] = new Recreativo("Tenis", "Cancha 1", 2);
        espacios[6] = new Recreativo("Tenis", "Cancha 2", 2);
    }

    // Muestra todos los espacios y sus cupos disponibles
    public static void mostrarEspacios() {
        String mensaje = "ESPACIOS DISPONIBLES:\n\n";
        for (int i = 0; i < espacios.length; i++) {
            mensaje += i + ". " + espacios[i].resumen() + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // Permite al usuario seleccionar y reservar un espacio
    private static void reservarEspacio() {
        mostrarEspacios();
        String id = JOptionPane.showInputDialog("Ingrese su ID de socio:");
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número del espacio a reservar:"));

        if (opcion >= 0 && opcion < espacios.length) {
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas personas reservarán?"));

            if (espacios[opcion].reservar(cantidad)) {
                JOptionPane.showMessageDialog(null, "Reserva exitosa para el socio ID: " + id);
            } else {
                JOptionPane.showMessageDialog(null, "No hay suficientes cupos disponibles.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Número de espacio inválido.");
        }
    }

    // Muestra únicamente los espacios que ya tienen reservas hechas
    public static void mostrarReservas() {
        String mensaje = "ESPACIOS CON RESERVAS REALIZADAS:\n\n";
        boolean hayReservas = false;

        for (Recreativo espacio : espacios) {
            int reservados = espacio.reservados();
            if (reservados > 0) {
                hayReservas = true;
                mensaje += espacio.getTipo() + " - " + espacio.getNombre()
                        + " | Reservados: " + reservados + "\n";
            }
        }

        if (hayReservas) {
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            JOptionPane.showMessageDialog(null, "No hay reservas realizadas aún.");
        }
    }
}
