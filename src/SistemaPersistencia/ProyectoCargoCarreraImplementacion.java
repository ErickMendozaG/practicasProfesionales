
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class ProyectoCargoCarreraImplementacion implements ProyectoCargoCarrera {

    private int cantMateriasReg;
    private int cantMateriasRend;
    private Carrera carrera;

    
    @Override
    public void setCantMateriasReg(int cantMateriasReg) {
        this.cantMateriasReg=cantMateriasReg;
    }

    @Override
    public void setCantMateriasRend(int cantMateriasRend) {
        this.cantMateriasRend=cantMateriasRend;
    }

    @Override
    public void setCarrera(Carrera carrera) {
        this.carrera=carrera;
    }

        
    @Override
    public int getCantMateriasReg() {
        return cantMateriasReg;
    }

    @Override
    public int getCantMateriasRend() {
        return cantMateriasRend;
    }

    @Override
    public Carrera getCarrera() {
        return carrera;
    }
    
}
