
package SistemaPersistencia;

import java.sql.Date;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class MateriaImplementacion implements Materia{
  
    private int nroMateria;
    private String nombreMateria;
    private Date fechaFinVigenciaMateria;
    
    /* Métodos de la Clase MateriaImplementacion */
    
    /* SET */
    
    @Override
    public void setNroMateria(int nroMateria) {
        this.nroMateria = nroMateria;
    }
    
    @Override
    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }
    
    @Override
    public void setFechaFinVigenciaMateria(Date fechaFinVigenciaMateria) {
        this.fechaFinVigenciaMateria = fechaFinVigenciaMateria;
    }
    
    /* GET */
    
    @Override
    public int getNroMateria() {
        return nroMateria;
    }
    
    @Override
    public String getNombreMateria() {
        return nombreMateria;
    }
    
    @Override
    public Date getFechaFinVigenciaMateria() {
        return fechaFinVigenciaMateria;
    }
    
}
