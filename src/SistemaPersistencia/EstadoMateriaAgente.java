
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class EstadoMateriaAgente extends Agente implements EstadoMateria{

    private EstadoMateriaImplementacion estadoMateria;
    
    /* Métodos de la Clase EstadoMateriaAgente */
    
    public void setEstadoMateria(EstadoMateriaImplementacion estadoMateria) {
        this.estadoMateria = estadoMateria;
    }
        
    public EstadoMateria getEstadoMateria() {
        return estadoMateria;
    }
    
    /* Métodos Implementados de la Interfaz EstadoMateria */
    
    /* SET */
    
    @Override
    public void setNroEstadoMateria(int nroEstadoMateria) {
        estadoMateria.setNroEstadoMateria(nroEstadoMateria);
        super.setModificado(true);
    }

    @Override
    public void setNombreEstadoMateria(String nombreEstadoMateria) {
        estadoMateria.setNombreEstadoMateria(nombreEstadoMateria);
        super.setModificado(true);
    }

    /* GET */
    
    @Override
    public int getNroEstadoMateria() {
        return estadoMateria.getNroEstadoMateria();
    }

    @Override
    public String getNombreEstadoMateria() {
        return estadoMateria.getNombreEstadoMateria();
    }
    
}
