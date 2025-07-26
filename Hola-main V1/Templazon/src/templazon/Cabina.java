/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package templazon;

import javax.swing.JOptionPane;

/**
 *
 * @author emmac
 */
public class Cabina {

    private int numero;
    private String[] horas = {
        "9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm"
    };
    private String[] reservas = new String[10];

    public Cabina(int numero) {
        this.numero = numero;
        for (int i = 0; i < reservas.length; i++) {
            reservas[i] = ""; // sin reservas
        }
    }

    public void ingresarReserva(String idSocio) {
        String hora = JOptionPane.showInputDialog("Ingrese la hora a reservar (ej: 9am, 2pm, 6pm):");
        if (hora == null) {
            return; // Cancelado
        }
        int posicion = obtenerPosicionHora(hora.trim().toLowerCase());

        if (posicion == -1) {
            JOptionPane.showMessageDialog(null, "Hora inválida.");
            return;
        }

        if (reservas[posicion].isEmpty()) {
            reservas[posicion] = idSocio;
            JOptionPane.showMessageDialog(null, "Reserva exitosa a las " + horas[posicion]);
        } else {
            JOptionPane.showMessageDialog(null, "Esa hora ya está reservada.");
        }
    }

    public void mostrarHorarios() {
        StringBuilder mensaje = new StringBuilder("Horarios de Cabina " + numero + ":\n");
        int disponibles = 0;

        for (int i = 0; i < horas.length; i++) {
            String estado = reservas[i].isEmpty() ? "LIBRE" : "RESERVADO por " + reservas[i];
            mensaje.append(horas[i]).append(" - ").append(estado).append("\n");
            if (reservas[i].isEmpty()) {
                disponibles++;
            }
        }

        mensaje.append("\nHoras disponibles: ").append(disponibles).append(" de 10");
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    public String obtenerResumenReservas() {
        StringBuilder resumen = new StringBuilder("RESERVAS CABINA " + numero + ":\n");
        for (int i = 0; i < horas.length; i++) {
            if (!reservas[i].isEmpty()) {
                resumen.append(horas[i]).append("Socio: ").append(reservas[i]).append("\n");
            }
        }
        return resumen.toString();
    }

    private int obtenerPosicionHora(String horaTexto) {
        for (int i = 0; i < horas.length; i++) {
            if (horas[i].equalsIgnoreCase(horaTexto)) {
                return i;
            }
        }
        return -1;
    }
}
