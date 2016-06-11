
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class SituacionFiscalAgente extends Agente implements SituacionFiscal{
    
    private SituacionFiscalImplementacion situacionFiscal;

    /* Métodos de la Clase SituacionFiscalAgente */
    
    public void setSituacionFiscal(SituacionFiscalImplementacion situacionFiscal) {
        this.situacionFiscal = situacionFiscal;
    }
    public SituacionFiscalImplementacion getSituacionFiscal() {
        return situacionFiscal;
    }
    
    /* Métodos Implementados de la Interfaz SituacionFiscal */

    /* GET */
    
    @Override
    public int getNroSituacionFiscal(){
        return situacionFiscal.getNroSituacionFiscal();
    }
    
    @Override
    public String getNombreSituacionFiscal(){
        return situacionFiscal.getNombreSituacionFiscal();
    }
    
    /* SET */
    
    @Override
    public void setNroSituacionFiscal(int nroSituacionFiscal){
        situacionFiscal.setNroSituacionFiscal(nroSituacionFiscal);
        super.setModificado(true);
    }
    
    @Override
    public void setNombreSituacionFiscal(String nombreSituacionFiscal){
        situacionFiscal.setNombreSituacionFiscal(nombreSituacionFiscal);
        super.setModificado(true);
    }
    
}
