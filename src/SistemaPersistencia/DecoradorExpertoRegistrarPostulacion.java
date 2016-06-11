
package SistemaPersistencia;

import PracticasProfesionales.DTO;
import PracticasProfesionales.DTOTipoDocumento;
import PracticasProfesionales.ExpertoRegistrarPostulacion;
import java.sql.SQLException;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class DecoradorExpertoRegistrarPostulacion extends ExpertoRegistrarPostulacion{
    
    @Override
    public DTO buscarTiposDeDocumentos(String universidadInstanciada){
        try {
            FachadaPersistenciaInterna.getInstancia().iniciarTransaccion();
        } catch (SQLException ex) {
            System.out.println("Error en la DB al iniciar la Transacción");
        }
        return super.buscarTiposDeDocumentos(universidadInstanciada);
        
    }
    
    @Override
    public DTO registrarPostulacion(){
        
        DTO dto = super.registrarPostulacion();
        
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
    
    @Override
    public DTO cancelarPostulacion(){
        
        DTO dto = super.cancelarPostulacion();
        
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
