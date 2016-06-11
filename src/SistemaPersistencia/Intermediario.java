    
package SistemaPersistencia;

import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public abstract class Intermediario {
    
    /*Métodos públicos de la Clase Intermediario*/
    
    public Vector buscar(Vector<Criterio> criterios){
        
        Vector vector = materializar(criterios);
        Cache.getInstancia().depositarEnCache(vector);
        return vector;
    
    }
    
    public Object buscar(String oid){
        
        if(Cache.getInstancia().seEncuentra(oid) == true){
            return Cache.getInstancia().obtenerDeCache(oid);
        }
        else{
            Object object = materializar(oid);
            Cache.getInstancia().depositarEnCache(object);
            return object;
        }
        
    }
    
    public void guardar(Object entidad){
        
        desmaterializar(entidad);
        Cache.getInstancia().quitarDeCache(entidad);
    }
    
    public void eliminar(Object entidad){
        desmaterializarEliminar(entidad);
        Cache.getInstancia().quitarDeCache(entidad);
    }
    
    protected abstract Vector materializar(Vector<Criterio> criterios);
    protected abstract Object materializar(String oid);
    protected abstract void desmaterializar(Object entidad);
    protected abstract void desmaterializarEliminar(Object entidad);
}
