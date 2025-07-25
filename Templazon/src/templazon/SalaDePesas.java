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
public class SalaDePesas {

    public void controlPesas() {

    }
    private int opciones;
    private int maximoRegistro = 50;
    private int contador;
    private int cantidadRegistro;
    private String ID;
    int continuar;

    //Matriz
    String Listado[] = new String[50];

    public int registro() {
        opciones = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para entrar al registro \nDigite 2 si desea ver los registros"));
        if (opciones == 1) {
            do {
                Listado[contador] = JOptionPane.showInputDialog("Registre su numero de ID");

                contador++;
                cantidadRegistro++;
                continuar = JOptionPane.showConfirmDialog(null, "Desea hacer un nuevo registro en la salas de pesas", "continuar", JOptionPane.YES_NO_OPTION);

            } while (continuar == JOptionPane.YES_OPTION && contador < maximoRegistro);
            if (continuar == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Las personas registradas son un total de " + cantidadRegistro + " \nA continuacion se le muestran las ID registradas ");
                String res = "";
                for (int i = 0; i < cantidadRegistro; i++) {
                    res += Listado[i] + ",";
                }
                JOptionPane.showMessageDialog(null, res);
            }

        } else {
            if (opciones == 2) {
                Registrados();
            }

        }
        return cantidadRegistro;

    }

    public void Registrados() {
        JOptionPane.showMessageDialog(null, "Las personas registradas son un total de " + cantidadRegistro + " A continuacion se muestran los ID  ");
        String res = "";
        for (int i = 0; i < cantidadRegistro; i++) {
            res += Listado[i] + ",";
        }
        JOptionPane.showMessageDialog(null, res);
    }
}
