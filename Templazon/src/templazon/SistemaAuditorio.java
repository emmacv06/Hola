/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package templazon;

/**
 *
 * @author emmac
 */
public class SistemaAuditorio {

    public void iniciar() {
        GestorAuditorio gestor = new GestorAuditorio();
        gestor.mostrarMenu();
        
        
    }

    @Override
    public String toString() {
        return "Gracias por su visita!";
    }
}
