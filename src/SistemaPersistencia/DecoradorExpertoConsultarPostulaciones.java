
package SistemaPersistencia;

import PracticasProfesionales.DTO;
import PracticasProfesionales.ExpertoConsultarPostulaciones;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/
public class DecoradorExpertoConsultarPostulaciones extends ExpertoConsultarPostulaciones{
    
    @Override
    public DTO buscarPostulaciones(int legajoE){
        
        try {
            FachadaPersistenciaInterna.getInstancia().iniciarTransaccion();
        } catch (SQLException ex) {
            Logger.getLogger(DecoradorExpertoConsultarPostulaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DTO dto= super.buscarPostulaciones(legajoE);
        
        if(dto.isExito()==true){
            try {
                FachadaPersistenciaInterna.getInstancia().confirmarTransaccion();
            } catch (SQLException ex) {
                Logger.getLogger(DecoradorExpertoConsultarPostulaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        else {
            try {
                FachadaPersistenciaInterna.getInstancia().deshacerTransaccion();
            } catch (SQLException ex) {
                Logger.getLogger(DecoradorExpertoConsultarPostulaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return dto;
        
    }
    
    
}
