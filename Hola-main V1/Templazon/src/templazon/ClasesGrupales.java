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
public class ClasesGrupales {

    static ClaseGrupal[] clases = new ClaseGrupal[6]; // 3 mañana, 3 noche
    static boolean precargado = false;

    static class ClaseGrupal {

        String nombre;
        String horario;
        int capacidadMaxima;
        int cuposDisponibles;

        public ClaseGrupal(String nombre, String horario, int capacidadMaxima) {
            this.nombre = nombre;
            this.horario = horario;
            this.capacidadMaxima = capacidadMaxima;
            this.cuposDisponibles = capacidadMaxima;
        }

        public boolean reservar() {
            if (cuposDisponibles > 0) {
                cuposDisponibles--;
                return true;
            } else {
                return false;
            }
        }

        public void modificar(String nuevoNombre, String nuevoHorario, int nuevaCapacidad) {
            int diferencia = nuevaCapacidad - this.capacidadMaxima;
            this.nombre = nuevoNombre;
            this.horario = nuevoHorario;
            this.capacidadMaxima = nuevaCapacidad;
            this.cuposDisponibles += diferencia;
        }

        public String resumen() {
            return nombre + " (" + horario + ") - Cupos disponibles: " + cuposDisponibles;
        }
    }

    public static void iniciar() {
        if (!precargado) {
            precargarClases();
            precargado = true;
        }

        String opcion;
        do {
            opcion = JOptionPane.showInputDialog(
                    "SISTEMA DE CLASES GRUPALES\n\n"
                    + "1. Ver clases disponibles\n"
                    + "2. Reservar clase\n"
                    + "3. Agregar/Modificar clase\n"
                    + "4. Volver al menú principal"
            );

            if (opcion == null || opcion.equals("4")) {
                break;
            }

            switch (opcion) {
                case "1":
                    mostrarClases();
                    break;
                case "2":
                    reservarClase();
                    break;
                case "3":
                    modificarClase();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (true);
    }

    private static void precargarClases() {
        clases[0] = new ClaseGrupal("Yoga", "mañana", 10);
        clases[1] = new ClaseGrupal("Crossfit", "mañana", 10);
        clases[2] = new ClaseGrupal("Funcional", "mañana", 10);
        clases[3] = new ClaseGrupal("Pilates", "noche", 10);
        clases[4] = new ClaseGrupal("Zumba", "noche", 10);
        clases[5] = new ClaseGrupal("Cardio Dance", "noche", 10);
    }

    public static void mostrarClases() {
        String mensaje = "CLASES DISPONIBLES:\n\n";
        for (int i = 0; i < clases.length; i++) {
            mensaje += i + ". " + clases[i].resumen() + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void reservarClase() {
        mostrarClases();
        String id = JOptionPane.showInputDialog("Ingrese su ID de socio:");
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la clase a reservar:"));

        if (opcion >= 0 && opcion < clases.length) {
            if (clases[opcion].reservar()) {
                JOptionPane.showMessageDialog(null, "Reserva exitosa para el socio ID: " + id);
            } else {
                JOptionPane.showMessageDialog(null, "Lo sentimos, no hay cupos disponibles.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Número de clase inválido.");
        }
    }

    private static void modificarClase() {
        mostrarClases();
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("¿Cuál clase desea modificar? (ingrese número):"));

        if (opcion >= 0 && opcion < clases.length) {
            String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:");
            String nuevoHorario = JOptionPane.showInputDialog("Nuevo horario (mañana/noche):");
            int nuevaCapacidad = Integer.parseInt(JOptionPane.showInputDialog("Nueva capacidad máxima:"));

            clases[opcion].modificar(nuevoNombre, nuevoHorario, nuevaCapacidad);
            JOptionPane.showMessageDialog(null, "Clase modificada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Número de clase inválido.");
        }
    }
}
