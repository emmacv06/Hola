/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package templazon;

import javax.swing.JOptionPane;

/**
 *
 * @author Santi
 */
public class Parqueo {

    int plantas;
    int IngresoPlanta;
    int[][] parqueo1 = new int[5][5]; // 0 = libre, 1 = ocupado
    int[][] parqueo2 = new int[5][5];
    int[][] parqueo3 = new int[5][5];

    public void verParqueo() {
        int plantas = Integer.parseInt(JOptionPane.showInputDialog("Que planta desea visualizar? \n"+
                "Para la primera planta seleccione el 1 \n"+
                "Para la segunda el 2 \n"+
                "Para la tercera el 3"));
        switch (plantas) {
            case 1:
                String estado = "Parqueo:\n";
                for (int i = 0; i < parqueo1.length; i++) {
                    for (int j = 0; j < parqueo1[0].length; j++) {
                        estado += parqueo1[i][j] == 0 ? "[ L ]" : "[ O ]";
                    }
                    estado += "\n";
                }
                JOptionPane.showMessageDialog(null, estado);
                break;
            case 2:
                String estado2 = "Parqueo:\n";
                for (int i = 0; i < parqueo2.length; i++) {
                    for (int j = 0; j < parqueo2[0].length; j++) {
                        estado2 += parqueo2[i][j] == 0 ? "[ L ]" : "[ O ]";
                    }
                    estado2 += "\n";
                }
                JOptionPane.showMessageDialog(null, estado2);
                break;
            case 3:
                String estado3 = "Parqueo:\n";
                for (int i = 0; i < parqueo3.length; i++) {
                    for (int j = 0; j < parqueo3[0].length; j++) {
                        estado3 += parqueo3[i][j] == 0 ? "[ L ]" : "[ O ]";
                    }
                    estado3 += "\n";
                }
                JOptionPane.showMessageDialog(null, estado3);
                break;
            default:
                throw new AssertionError();
        }

    }

    public void reservarEspacio(int idSocio, String nombre) {
        IngresoPlanta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese en que planta desea registrar su espacio: \n" +
                "Para la primera ingrese 1 \n "+
                "Para la segunda ingrese 2 \n"+
                "Para la tercera ingrese 3"));
        switch (IngresoPlanta) {
            case 1:
                for (int i = 0; i < parqueo1.length; i++) {
                    for (int j = 0; j < parqueo1[0].length; j++) {
                        if (parqueo1[i][j] == 0) {
                            parqueo1[i][j] = 1;
                            JOptionPane.showMessageDialog(null, "Espacio reservado para " + nombre + " en [" + i + "," + j + "]");
                            return;
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < parqueo2.length; i++) {
                    for (int j = 0; j < parqueo2[0].length; j++) {
                        if (parqueo2[i][j] == 0) {
                            parqueo2[i][j] = 1;
                            JOptionPane.showMessageDialog(null, "Espacio reservado para " + nombre + " en [" + i + "," + j + "]");
                            return;
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < parqueo3.length; i++) {
                    for (int j = 0; j < parqueo3[0].length; j++) {
                        if (parqueo3[i][j] == 0) {
                            parqueo3[i][j] = 1;
                            JOptionPane.showMessageDialog(null, "Espacio reservado para " + nombre + " en [" + i + "," + j + "]");
                            return;
                        }
                    }
                }
                break;
            default:
                throw new AssertionError();
        }

        JOptionPane.showMessageDialog(null, "No hay espacios disponibles en el parque.");
    }
}
