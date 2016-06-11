
package SistemaPersistencia;

import PracticasProfesionales.DTO;
import PracticasProfesionales.DTOPostulacion;
import java.sql.SQLException;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class DecoradorExpertoAsignarPrioridad extends PracticasProfesionales.ExpertoAsignarPrioridad{
    
    @Override
    public DTO buscarPostulaciones(int legajoE){
        
        try {
            FachadaPersistenciaInterna.getInstancia().iniciarTransaccion();
        } catch (SQLException ex) {
            System.out.println("Error en la DB al iniciar la Transacción");
        }
        return super.buscarPostulaciones(legajoE);
        
    }
    
    @Override
    public DTO guardarPrioridades(Vector<DTOPostulacion> dtoPostulacion){
        
        DTO dto = super.guardarPrioridades(dtoPostulacion);
        
        if(dto.isExito()){
            try {
                FachadaPersistenciaInterna.getInstancia().confirmarTransaccion();
            } catch (SQLException ex) {
                System.out.println("Error al confirmar Transacción");
            }
        }
        else{
            try {
                FachadaPersistenciaInterna.getInstancia().deshacerTransaccion();
            } catch (SQLException ex) {
                System.out.println("Error al deshacer Transacción");
            }
        }
        
        FachadaPersistenciaInterna.getInstancia().finalizarTransaccion();
        
        return dto;
        
    }
    
}
