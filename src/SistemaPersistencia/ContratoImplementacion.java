
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

public class ContratoImplementacion implements Contrato{
    
    private int nroContrato;
    private Date fechaCreacionContrato;
    private Time horaCreacionContrato;
    private Date fechaVigenciaDeContrato;
    
    private Proyecto proyectoDeContrato;
    private PostulacionProyectoCargo postulacionProyectoCargoDeContrato;
    private Postulacion postulacionDeContrato;
    private Vector<EstadoContrato> estadosDeContrato = new Vector();
    
    /* Métodos Implementados de la Interfaz Contrato */
    
    /* SET */
    
    @Override
    public void setNroContrato(int nroContrato) {
        this.nroContrato = nroContrato;
    }
    
    @Override
    public void setFechaCreacionContrato(Date fechaCreacionContrato) {
        this.fechaCreacionContrato = fechaCreacionContrato;
    }
    
    @Override
    public void setHoraCreacionContrato(Time horaCreacionContrato) {
        this.horaCreacionContrato = horaCreacionContrato;
    }
    
    @Override
    public void setFechaVigenciaDeContrato(Date fechaVigenciaDeContrato) {
        this.fechaVigenciaDeContrato = fechaVigenciaDeContrato;
    }
    
    @Override
    public void setProyectoDeContrato(Proyecto proyectoDeContrato) {
        this.proyectoDeContrato = proyectoDeContrato;
    }
    
    @Override
    public void setPostulacionProyectoCargoDeContrato(PostulacionProyectoCargo postulacionProyectoCargoDeContrato) {
        this.postulacionProyectoCargoDeContrato = postulacionProyectoCargoDeContrato;
    }
    
    @Override
    public void setPostulacionDeContrato(Postulacion postulacionDeContrato) {
        this.postulacionDeContrato = postulacionDeContrato;
    }
    
    @Override
    public void addEstadosDeContrato(EstadoContrato estadosDeContrato) {
        this.estadosDeContrato.add(estadosDeContrato);
    }
    
    /* GET */
    
    @Override
    public int getNroContrato() {
        return nroContrato;
    }
    
    @Override
    public Date getFechaCreacionContrato() {
        return fechaCreacionContrato;
    }
    
    @Override
    public Time getHoraCreacionContrato() {
        return horaCreacionContrato;
    }
    
    @Override
    public Date getFechaVigenciaDeContrato() {
        return fechaVigenciaDeContrato;
    }
    
    @Override
    public Proyecto getProyectoDeContrato() {
        return proyectoDeContrato;
    }
    
    @Override
    public PostulacionProyectoCargo getPostulacionProyectoCargoDeContrato() {
        return postulacionProyectoCargoDeContrato;
    }
    
    @Override
    public Postulacion getPostulacionDeContrato() {
        return postulacionDeContrato;
    }
    
    @Override
        public Vector<EstadoContrato> getEstadosDeContrato() {
        return this.estadosDeContrato;
    }
    
}
