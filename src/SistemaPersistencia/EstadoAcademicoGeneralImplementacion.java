
package SistemaPersistencia;


import java.sql.Date;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class EstadoAcademicoGeneralImplementacion implements EstadoAcademicoGeneral{
    
    private Date fechaBaja;
    private Date fechaIngreso;
    
    private Condicion condicion;
    private Vector<EstadoAcademicoDetallado> estadoAcademicoDetallado = new Vector();
    private Carrera carrera;
    private PlanEstudio planEstudio;

    
    /* Métodos de la Clase EstadoAcademicoGeneralImplementacion */
    
    /* SET */
    
    @Override
    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    @Override
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    @Override
    public void addEstadoAcademicoDetallado(EstadoAcademicoDetallado estadoAcademicoDetallado) {
        this.estadoAcademicoDetallado.add(estadoAcademicoDetallado);
    }

    @Override
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public void setPlanEstudio(PlanEstudio planEstudio) {
        this.planEstudio = planEstudio;
    }
   
    /* GET */
    
    @Override
   public Date getFechaBaja() {
        return fechaBaja;
    }

    @Override
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    @Override
    public Condicion getCondicion() {
        return condicion;
    }

    @Override
    public Vector<EstadoAcademicoDetallado> getEstadoAcademicoDetallado() {
        return this.estadoAcademicoDetallado;
    }

    @Override
    public Carrera getCarrera() {
        return carrera;
    }

    @Override
    public PlanEstudio getPlanEstudio() {
        return planEstudio;
    }
    
}
