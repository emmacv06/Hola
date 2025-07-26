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
public class AuditorioFit {

    private String[] participantes10am = new String[30];
    private String[] participantes3pm = new String[30];
    private int contador10am = 0;
    private int contador3pm = 0;

    public boolean inscribir(String idSocio, String horario) {
        if (horario.equals("10am") && contador10am < 30) {
            participantes10am[contador10am++] = idSocio;
            return true;
        } else if (horario.equals("3pm") && contador3pm < 30) {
            participantes3pm[contador3pm++] = idSocio;
            return true;
        }
        return false;
    }

    public String obtenerParticipantes() {
        StringBuilder sb = new StringBuilder();

        sb.append("Participantes 10 a.m.:\n");
        for (int i = 0; i < contador10am; i++) {
            sb.append("- ").append(participantes10am[i]).append("\n");
        }

        sb.append("\nParticipantes 3 p.m.:\n");
        for (int i = 0; i < contador3pm; i++) {
            sb.append("- ").append(participantes3pm[i]).append("\n");
        }

        return sb.toString();
    }
}
