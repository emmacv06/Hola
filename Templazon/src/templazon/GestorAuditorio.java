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
public class GestorAuditorio {

    AuditorioFit auditorio = new AuditorioFit();

    public void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            String opcionTexto = JOptionPane.showInputDialog(
                    "Menú de opciones:\n"
                    + "1 - Inscribir participante\n"
                    + "2 - Mostrar lista de inscritos\n"
                    + "3 - Salir\n\n"
                    + "Digite una opción:"
            );

            if (opcionTexto == null) {
                break;
            }

            int opcion = Integer.parseInt(opcionTexto);

            switch (opcion) {
                case 1:
                    inscribirParticipante();
                    break;
                case 2:
                    mostrarLista();
                    break;
                case 3:
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Hasta la proxima");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
            }
        }
    }

    public void inscribirParticipante() {
        String continuar = "si";

        while (continuar.toLowerCase().equals("si")) {
            String id = JOptionPane.showInputDialog("Ingrese el ID del socio:");
            String horario = JOptionPane.showInputDialog("¿Qué horario desea? (10am o 3pm)");

            boolean exito = auditorio.inscribir(id, horario);
            if (exito) {
                JOptionPane.showMessageDialog(null, "Inscripción exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Aforo lleno o horario inválido");
            }

            continuar = JOptionPane.showInputDialog("¿Desea inscribir otro socio? (escriba 'si' para continuar)");
        }
    }

    public void mostrarLista() {
        String lista = auditorio.obtenerParticipantes();
        JOptionPane.showMessageDialog(null, lista);
        
        
    }

    @Override
    public String toString() {
        return "GestorAuditorio{" + "auditorio=" + auditorio + '}';
    }
}
