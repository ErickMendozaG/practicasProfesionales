package SistemaPersistencia;

import java.sql.Date;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class ProyectoImplementacion implements Proyecto{
   
    private MetodologiaOrden metodologiaOrden;
    private Universidad universidad;
    private Vector<EstadoProyecto> estadoProyecto = new Vector();
    private Empresa empresa;
    private Vector<ProyectoCargo> proyCargo = new Vector();
    private Date fechaInicioInscr;
    private Date fechaInicioProy;
    private Date fechaLimPost;
    private String nombreProyecto;
    private int nroProyecto;
    private int tiempoDuracion;
    
    @Override
    public void setEmpresa(Empresa empresa) {
        this.empresa=empresa;
    }

    @Override
    public void addEstadoProyecto(EstadoProyecto estadoProyecto) {
        this.estadoProyecto.add(estadoProyecto);
    }

    @Override
    public void setFechaInicioInscripcion(Date fechaInicioInscr) {
        this.fechaInicioInscr=fechaInicioInscr;
    }

    @Override
    public void setFechaInicioProyecto(Date fechaInicioProy) {
        this.fechaInicioProy=fechaInicioProy;
    }

    @Override
    public void setFechaLimiteDePostulacion(Date fechaLimPost) {
       this.fechaLimPost=fechaLimPost;
    }

    @Override
    public void setMetodologiaOrden(MetodologiaOrden metodologia) {
        this.metodologiaOrden=metodologia;
    }

    @Override
    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto=nombreProyecto;
    }

    @Override
    public void setNroProyecto(int nroProyecto) {
       this.nroProyecto=nroProyecto;
    }

    @Override
    public void addProyectoCargo(ProyectoCargo proyectoCargo) {
        this.proyCargo.add(proyectoCargo);
    }

    @Override
    public void setTiempoDuracionProyecto(int tiempo) {
        this.tiempoDuracion=tiempo;
    }

    @Override
    public void setUniversidad(Universidad universidad) {
        this.universidad=universidad;
    }

    @Override
    public Empresa getEmpresa() {
        return empresa;
    }

    @Override
    public Vector<EstadoProyecto> getEstadoproyecto() {
        return this.estadoProyecto;
    }

    @Override
    public Date getFechaInicioInscripcion() {
       return fechaInicioInscr ;
    }

    @Override
    public Date getFechaInicioProyecto() {
       return fechaInicioProy ;
    }

    @Override
    public Date getFechaLimiteDePostulacion() {
       return fechaLimPost;
    }

    @Override
    public MetodologiaOrden getMetodologiaOrden() {
       return metodologiaOrden;
    }

    @Override
    public String getNombreProyecto() {
        return nombreProyecto;
    }

    @Override
    public int getNroProyecto() {
       return nroProyecto;
    }

    @Override
    public Vector<ProyectoCargo> getProyectoCargo() {
        return this.proyCargo;
    }

    @Override
    public int getTiempoDuracionProyecto() {
        return tiempoDuracion;
    }

    @Override
    public Universidad getUniversidad() {
        return universidad;
    }
    
}
