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
public class SistemaCabina {

    private Cabina cabina1 = new Cabina(1);

    public void iniciar() {
        String opcion = "";

        while (!opcion.equals("3")) {
            opcion = JOptionPane.showInputDialog(
                    "SISTEMA DE RESERVAS\n\n"
                    + "1. Hacer una reserva\n"
                    + "2. Ver reservas actuales\n"
                    + "3. Salir\n\n"
                    + "Seleccione una opción:"
            );

            if (opcion == null) {
                break;
            }

            switch (opcion) {
                case "1":
                    String id = JOptionPane.showInputDialog("Ingrese el ID del socio:");
                    if (id != null && !id.isBlank()) {
                        cabina1.ingresarReserva(id.trim());
                    }
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, cabina1.obtenerResumenReservas());
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Reservas finalizadas. Gracias por usar el sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
    
    public String getResumenReservas() {
    return cabina1.obtenerResumenReservas();
}
}
