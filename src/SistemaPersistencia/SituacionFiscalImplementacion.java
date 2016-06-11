
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class SituacionFiscalImplementacion implements SituacionFiscal{
    
    private int nroSituacionFiscal;
    private String nombreSituacionFiscal;

    /* Métodos de la Clase SituacionFiscalImplementacion */

    /* GET */
    
    @Override
    public int getNroSituacionFiscal() {
        return nroSituacionFiscal;
    }
    
    @Override
    public String getNombreSituacionFiscal() {
        return nombreSituacionFiscal;
    }
    
    /* SET */
    
    @Override
    public void setNroSituacionFiscal(int nroSituacionFiscal) {
        this.nroSituacionFiscal = nroSituacionFiscal;
    }
    
    @Override
    public void setNombreSituacionFiscal(String nombreSituacionFiscal) {
        this.nombreSituacionFiscal = nombreSituacionFiscal;
    }
    
}
