
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class FabricaIntermediarios {
    
    /* <<Singleton>> */
    
    private static FabricaIntermediarios instancia= new FabricaIntermediarios();
    
    private FabricaIntermediarios(){}
    
    public static FabricaIntermediarios getInstancia(){
        return instancia;
    }
    
    /* Métodos Públicos */
    
    public Intermediario obtenerIntermediario(String nombreEntidad){
        
        Intermediario intermediario=null;
        
        if("Cargo".equals(nombreEntidad)){
            intermediario= new IntermediarioCargo();
        }
        if("Carrera".equals(nombreEntidad)){
            intermediario= new IntermediarioCarrera();
        }
        if("Contrato".equals(nombreEntidad)){
            intermediario= new IntermediarioContrato();
        }
        if("Condicion".equals(nombreEntidad)){
            intermediario= new IntermediarioCondicion();
        }
        if("Empresa".equals(nombreEntidad)){
            intermediario= new IntermediarioEmpresa();
        }
        if("EstadoAcademicoGeneral".equals(nombreEntidad)){
            intermediario= new IntermediarioEstadoAcademicoGeneral();
        }
        if("EstadoAcademicoDetallado".equals(nombreEntidad)){
            intermediario= new IntermediarioEstadoAcademicoDetallado();
        }
        if("EstadoContrato".equals(nombreEntidad)){
            intermediario= new IntermediarioEstadoContrato();
        }
        if("EstadoMateria".equals(nombreEntidad)){
            intermediario= new IntermediarioEstadoMateria();
        }
        if("EstadoPostulacion".equals(nombreEntidad)){
            intermediario= new IntermediarioEstadoPostulacion();
        }
        if("EstadoProyecto".equals(nombreEntidad)){
            intermediario= new IntermediarioEstadoProyecto();
        }
        if("Estudiante".equals(nombreEntidad)){
            intermediario= new IntermediarioEstudiante();
        }
        if("Materia".equals(nombreEntidad)){
            intermediario= new IntermediarioMateria();
        }
        if("MetodologiaOrden".equals(nombreEntidad)){
            intermediario= new IntermediarioMetodologiaOrden();
        }
        if("PlanEstudio".equals(nombreEntidad)){
            intermediario= new IntermediarioPlanEstudio();
        }
        if("Postulacion".equals(nombreEntidad)){
            intermediario= new IntermediarioPostulacion();
        }
        if("PostulacionProyectoCargo".equals(nombreEntidad)){
            intermediario= new IntermediarioPostulacionProyectoCargo();
        }        
        if("Proyecto".equals(nombreEntidad)){
            intermediario= new IntermediarioProyecto();
        }
        if("ProyectoCargo".equals(nombreEntidad)){
            intermediario= new IntermediarioProyectoCargo();
        }
        if("ProyectoCargoCarrera".equals(nombreEntidad)){
            intermediario= new IntermediarioProyectoCargoCarrera();
        }
        if("Seleccion".equals(nombreEntidad)){
            intermediario= new IntermediarioSeleccion();
        }
        if("SeleccionPostulacionProyectoCargo".equals(nombreEntidad)){
            intermediario= new IntermediarioSeleccionPostulacionProyectoCargo();
        }
        if("SituacionFiscal".equals(nombreEntidad)){
            intermediario= new IntermediarioSituacionFiscal();
        }
        if("TipoDocumento".equals(nombreEntidad)){
            intermediario= new IntermediarioTipoDocumento();
        }
        if("TipoEstadoContrato".equals(nombreEntidad)){
            intermediario= new IntermediarioTipoEstadoContrato();
        }
        if("TipoEstadoPostulacion".equals(nombreEntidad)){
            intermediario= new IntermediarioTipoEstadoPostulacion();
        }
        if("TipoEstadoProyecto".equals(nombreEntidad)){
            intermediario= new IntermediarioTipoEstadoProyecto();
        }
        if("TipoEstadoSeleccion".equals(nombreEntidad)){
            intermediario= new IntermediarioTipoEstadoSeleccion();
        }
        if("TipoEstadoSeleccionPostulacionProyectoCargo".equals(nombreEntidad)){
            intermediario= new IntermediarioTipoEstadoSeleccionPostulacionProyectoCargo();
        }
        if("Universidad".equals(nombreEntidad)){
            intermediario= new IntermediarioUniversidad();
        }
        if("PlanEstudioMateria".equals(nombreEntidad)){
            intermediario= new IntermediarioPlanEstudioMateria();
        }
        return intermediario;
        
    }
    
}
