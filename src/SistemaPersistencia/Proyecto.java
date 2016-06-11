
package SistemaPersistencia;

import java.sql.Date;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface Proyecto {
    
    /*SET*/
    public void setEmpresa(Empresa empresa);
    public void addEstadoProyecto(EstadoProyecto estadoProyecto);
    public void setFechaInicioInscripcion(Date fechaInicioInscr);
    public void setFechaInicioProyecto(Date fechaInicioProy);
    public void setFechaLimiteDePostulacion(Date fechaLimPost);
    public void setMetodologiaOrden(MetodologiaOrden metodologia);
    public void setNombreProyecto(String nombreProyecto);
    public void setNroProyecto(int nroProyecto);
    public void addProyectoCargo(ProyectoCargo proyectoCargo);
    public void setTiempoDuracionProyecto(int tiempo);
    public void setUniversidad(Universidad universidad);
   
    /*GET*/
    public Empresa getEmpresa();
    public Vector<EstadoProyecto> getEstadoproyecto();
    public Date getFechaInicioInscripcion();
    public Date getFechaInicioProyecto();
    public Date getFechaLimiteDePostulacion();
    public MetodologiaOrden getMetodologiaOrden();
    public String getNombreProyecto();
    public int getNroProyecto();
    public Vector<ProyectoCargo> getProyectoCargo();
    public int getTiempoDuracionProyecto();
    public Universidad getUniversidad();
   
}
