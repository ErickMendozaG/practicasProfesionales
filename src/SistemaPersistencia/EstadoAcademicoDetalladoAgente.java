
package SistemaPersistencia;


import java.sql.Date;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class EstadoAcademicoDetalladoAgente extends Agente implements EstadoAcademicoDetallado{

    private EstadoAcademicoDetalladoImplementacion estadoAcademicoDetallado;
    
    private String OIDEstadoMateria;
    private String OIDMateria;
    private boolean heBuscadoEstadoMateria;
    private boolean heBuscadoMateria;
    
    private String OIDEstadoAcademicoGeneral;/*Atributo de Relación*/
    
    /* Métodos de la Clase EstadoAcademicoDetalladoAgente */
    
    /* SET */
    
    public void setEstadoAcademicoDetallado(EstadoAcademicoDetalladoImplementacion estadoAcademicoDetallado) {
        this.estadoAcademicoDetallado = estadoAcademicoDetallado;
    }

    public void setOIDEstadoMateria(String OIDEstadoMateria) {
        this.OIDEstadoMateria = OIDEstadoMateria;
    }

    public void setOIDMateria(String OIDMateria) {
        this.OIDMateria = OIDMateria;
    }

    public void setHeBuscadoEstadoMateria(boolean heBuscadoEstadoMateria) {
        this.heBuscadoEstadoMateria = heBuscadoEstadoMateria;
    }

    public void setHeBuscadoMateria(boolean heBuscadoMateria) {
        this.heBuscadoMateria = heBuscadoMateria;
    }

    public void setOIDEstadoAcademicoGeneral(String OIDEstadoAcademicoGeneral) {
        this.OIDEstadoAcademicoGeneral = OIDEstadoAcademicoGeneral;
    }
        
    /* GET */
    public EstadoAcademicoDetalladoImplementacion getEstadoAcademicoDetallado() {
        return estadoAcademicoDetallado;
    }

    public String getOIDEstadoMateria() {
        return OIDEstadoMateria;
    }

    public String getOIDMateria() {
        return OIDMateria;
    }

    public boolean isHeBuscadoestadoMateria() {
        return heBuscadoEstadoMateria;
    }

    public boolean isHeBuscadomateria() {
        return heBuscadoMateria;
    }

    public String getOIDEstadoAcademicoGeneral() {
        return OIDEstadoAcademicoGeneral;
    }
        
    /* Métodos Implementados de la Interfaz EstadoAcademicoDetallado */
    
    /* SET */    
    
    @Override
    public void setFechaEstado(Date fechaEstado) {
        estadoAcademicoDetallado.setFechaEstado(fechaEstado);
        super.setModificado(true);
    }  
    
    @Override
    public void setNotaFinal(float notaFinal) {
        estadoAcademicoDetallado.setNotaFinal(notaFinal);
        super.setModificado(true);
    }

    @Override
    public void setEstadoMateria(EstadoMateria estadoMateria) {
        estadoAcademicoDetallado.setEstadoMateria(estadoMateria);
        Agente agente = (Agente) estadoMateria;
        this.OIDEstadoMateria = agente.getOID();
        super.setModificado(true);
    }

    @Override
    public void setMateria(Materia materia) {
        estadoAcademicoDetallado.setMateria(materia);
        Agente agente = (Agente) materia;
        this.OIDMateria = agente.getOID();
        super.setModificado(true);
    }

    /* GET */
    
    @Override
    public Date getFechaEstado() {
        return estadoAcademicoDetallado.getFechaEstado();
    }

    @Override
    public float getNotaFinal() {
        return estadoAcademicoDetallado.getNotaFinal();
    }

    @Override
    public EstadoMateria getEstadoMateria() {
        
        if (heBuscadoEstadoMateria == true){
            return estadoAcademicoDetallado.getEstadoMateria();
        }
        else{
            EstadoMateria estMat = (EstadoMateria) FachadaPersistenciaInterna.getInstancia().buscar("EstadoMateria", OIDEstadoMateria);
            estadoAcademicoDetallado.setEstadoMateria(estMat);
            this.setHeBuscadoEstadoMateria(true);
            return estMat;
        }
        
    }

    @Override
    public Materia getMateria() {
        
        if (heBuscadoMateria == true){
            return estadoAcademicoDetallado.getMateria();
        }
        else{
            Materia mat = (Materia) FachadaPersistenciaInterna.getInstancia().buscar("Materia", OIDMateria);
            estadoAcademicoDetallado.setMateria(mat);
            this.setHeBuscadoMateria(true);
            return mat;
        }
        
    }
    
}
