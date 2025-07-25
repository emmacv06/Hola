/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package templazon;

/**
 *
 * @author Santi
 */
public class Reserva {

    int idSocio;
    String actividad;
    String nombreSocio;

    public Reserva(int idSocio, String actividad, String nombreSocio) {
        this.idSocio = idSocio;
        this.actividad = actividad;
        this.nombreSocio = nombreSocio;
    }

    @Override
    public String toString() {
        return " Reserva{ " + " idSocio " + idSocio + " , actividad " + actividad + ", nombre del Socio " + nombreSocio + '}'+ "";
    }

}
