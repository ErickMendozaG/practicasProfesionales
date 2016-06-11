
package SistemaPersistencia;

import java.sql.Date;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class MateriaAgente extends Agente implements Materia{

    private MateriaImplementacion materia;
    
    /* Métodos de la Clase MateriaAgente */
    
    public void setMateria(MateriaImplementacion materia) {
        this.materia = materia;
    }

    public MateriaImplementacion getMateria() {
        return materia;
    }   
    
    /* Métodos Implementados de la Interfaz Materia */
    
    /* SET */
    
    @Override
    public void setNroMateria(int nroMateria) {
       materia.setNroMateria(nroMateria);
        super.setModificado(true);
    }

    @Override
    public void setNombreMateria(String nombreMateria) {
        materia.setNombreMateria(nombreMateria);
        super.setModificado(true);
    }

    @Override
    public void setFechaFinVigenciaMateria(Date fechaFinVigenciaMateria) {
        materia.setFechaFinVigenciaMateria(fechaFinVigenciaMateria);
        super.setModificado(true);
    }

    /* GET */
    
    @Override
    public int getNroMateria() {
        return materia.getNroMateria();
    }

    @Override
    public String getNombreMateria() {
        return materia.getNombreMateria();
    }

    @Override
    public Date getFechaFinVigenciaMateria() {
        return materia.getFechaFinVigenciaMateria();
    }
    
}
