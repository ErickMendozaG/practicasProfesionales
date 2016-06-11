
package SistemaPersistencia;


import java.sql.Date;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class EstadoAcademicoDetalladoImplementacion implements EstadoAcademicoDetallado{
   
    private Date fechaEstado;
    private float notaFinal;
    
    private EstadoMateria estadoMateria;
    private Materia materia;

    

    /* Métodos de la Clase EstadoAcademicoDetalladoImplementacion */
    
    /*SET*/
    
    @Override
    public void setFechaEstado(Date fechaEstado) {
        this.fechaEstado = fechaEstado;
    }
    
    @Override
    public void setNotaFinal(float notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public void setEstadoMateria(EstadoMateria estadoMateria) {
        this.estadoMateria = estadoMateria;
    }

    @Override
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    /* GET */
    
    @Override
    public Date getFechaEstado() {
        return fechaEstado;
    }

    @Override
    public float getNotaFinal() {
        return notaFinal;
    }

    @Override
    public EstadoMateria getEstadoMateria() {
        return estadoMateria;
    }

    @Override
    public Materia getMateria() {
        return materia;
    }
    
}
