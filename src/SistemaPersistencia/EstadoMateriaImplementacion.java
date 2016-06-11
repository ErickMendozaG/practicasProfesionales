
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class EstadoMateriaImplementacion implements EstadoMateria{
   
    private int nroEstadoMateria;
    private String nombreEstadoMateria;
    
    /* Métodos de la Clase EstadoMateriaImplementacion */
    
    /* SET */
    
    @Override
    public void setNroEstadoMateria(int nroEstadoMateria) {
        this.nroEstadoMateria = nroEstadoMateria;
    }

    @Override
    public void setNombreEstadoMateria(String nombreEstadoMateria) {
        this.nombreEstadoMateria = nombreEstadoMateria;
    }
        
    /* GET */
    
    @Override
    public int getNroEstadoMateria() {
        return nroEstadoMateria;
    }

    @Override
    public String getNombreEstadoMateria() {
        return nombreEstadoMateria;
    }
    
}
