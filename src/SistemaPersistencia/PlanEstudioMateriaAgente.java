/* Clase para hacer la materialización perezosa para una relación de N-N */
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class PlanEstudioMateriaAgente extends Agente{
    
    private String OIDPlanEstudio;
    private String OIDMateria;
    
    /* SET */
    
    public void setOIDMateria(String OIDMateria) {
        this.OIDMateria = OIDMateria;
    }

    public void setOIDPlanEstudio(String OIDPlanEstudio) {
        this.OIDPlanEstudio = OIDPlanEstudio;
    }
    
    /* GET */
    
    public String getOIDPlanEstudio() {
        return OIDPlanEstudio;
    }

    public String getOIDMateria() {
        return OIDMateria;
    }
    
}
