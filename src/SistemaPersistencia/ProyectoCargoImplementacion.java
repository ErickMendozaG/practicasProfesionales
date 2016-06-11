package SistemaPersistencia;

import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class ProyectoCargoImplementacion implements ProyectoCargo {
    private Cargo cargo;
    private Vector<ProyectoCargoCarrera> proyectoCargoCarrera = new Vector();
    private int cantPuestos;
    private int cdadLimPost;
    private int horasEstimadas;
   @Override
    public Cargo getCargo() {
        return cargo;
    }
    @Override
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    @Override
    public Vector<ProyectoCargoCarrera> getProyectoCargoCarrera() {
        return proyectoCargoCarrera;
    }
    @Override
    public void addProyectoCargoCarrera(ProyectoCargoCarrera proyectoCargoCarrera) {
        this.proyectoCargoCarrera.add(proyectoCargoCarrera);
    }
    @Override
    public int getCantPuestos() {
        return cantPuestos;
    }
    @Override
    public void setCantPuestos(int cantPuestos) {
        this.cantPuestos = cantPuestos;
    }
    @Override
    public int getCdadLimPost() {
        return cdadLimPost;
    }
    @Override
    public void setCdadLimPost(int cdadLimPost) {
        this.cdadLimPost = cdadLimPost;
    }
    @Override
    public int getHorasEstimadas() {
        return horasEstimadas;
    }
    @Override
    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }
    
}
