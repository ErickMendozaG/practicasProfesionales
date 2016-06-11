
package SistemaPersistencia;

import java.sql.Date;
import java.sql.Time;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface Contrato {
    
    /* SET */
    
    abstract public void setNroContrato(int nroContrato);
    abstract public void setFechaCreacionContrato(Date fechaCreacionContrato);
    abstract public void setHoraCreacionContrato(Time horaCreacionContrato);
    abstract public void setFechaVigenciaDeContrato(Date fechaVigenciaDeContrato);
    abstract public void setProyectoDeContrato(Proyecto proyectoDeContrato);
    abstract public void setPostulacionProyectoCargoDeContrato(PostulacionProyectoCargo postulacionProyectoCargoDeContrato);
    abstract public void setPostulacionDeContrato(Postulacion postulacionDeContrato);
    abstract public void addEstadosDeContrato(EstadoContrato estadosDeContrato);
    
    /* GET */
    
    abstract public int getNroContrato();  
    abstract public Date getFechaCreacionContrato();    
    abstract public Time getHoraCreacionContrato();    
    abstract public Date getFechaVigenciaDeContrato();    
    abstract public Proyecto getProyectoDeContrato();    
    abstract public PostulacionProyectoCargo getPostulacionProyectoCargoDeContrato();    
    abstract public Postulacion getPostulacionDeContrato();    
    abstract public Vector<EstadoContrato> getEstadosDeContrato();
    
}
