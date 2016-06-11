
package SistemaPersistencia;

import java.util.Vector;

/* @author MACROSOFT:
  
   * 
   * MENDOZA, Erick
   * 
  
*/

public class Cache {
    
    /* <<Singleton>> */
    
    private static Cache instancia=null;
    
    private Cache(){}
    
    public static Cache getInstancia(){
        if(instancia == null){
            instancia = new Cache();
        }
        return instancia;
    }
    
    /* Atributos de la Clase Cache */
    
    private Vector<Agente> agentes = new Vector(30); 
    private Vector<Integer> cantidadBuscadas = new Vector(30);
    private int maximoCache = 30;
    
    /* Métodos de la Clase Cache */
    
    /* Busca en la Caché si se encuentra el valor con el oid pasado como parámetro */
    public boolean seEncuentra(String oidEntidad){
        
        int i = this.agentes.size() - 1;
        while (i>=0){
            if(agentes.get(i).getOID().equals(oidEntidad)){
                return true;
            }
            i = i-1;
        }
        return false;
    }
    
    /* Busca en Caché si se encuentra pasandole como parámetro un Agente */
    public boolean seEncuentra(Agente entidad){
        
        String oidEntidad = entidad.getOID();
        int i = this.agentes.size() - 1;
        while (i>=0){
            if(agentes.get(i).getOID().equals(oidEntidad)){
                return true;
            }
            i = i-1;
        }
        return false;
    }
    
    /* Devuelve el objecto que se encuentra en Caché con el oid pasado como parámetro */
    public Object obtenerDeCache (String oidEntidad){
        
        int i = this.agentes.size() - 1;
        while (i >= 0){
            if(agentes.get(i).getOID().equals(oidEntidad)){
                Integer valor = this.cantidadBuscadas.get(i);
                valor = valor +1;
                this.cantidadBuscadas.add(i, valor);
                return this.agentes.get(i);
            }
            i = i-1;
        }
        return null;
        
    }
    
    /* Guarda en la Caché un objeto pasado como parámetro */
    public void depositarEnCache (Object agente){
        
        this.mantenerLimiteCache();
        this.agentes.addElement((Agente)agente);
        this.cantidadBuscadas.add(new Integer(1));
        
    }
    
    /* Guarda en la Caché un vector de objetos pasado como parámetro */
    public void depositarEnCache (Vector agentesADepositar){
        
        int i = agentesADepositar.size() - 1;
        while (i>=0){
            this.depositarEnCache((Agente)agentesADepositar.get(i));
            i= i-1;
        }
        
    }
    
    /* Actualiza la información de un objecto que se encuentra en la Caché */
    public void actualizarEnCache (Object agente){
        
        Agente agent = (Agente) agente;
        int i = this.agentes.size() - 1;
        while(i>=0){
            /*Si el OID del Agente pasado como parámetro es igual al OID buscado en algún agente de la Cahé */
            if(this.agentes.get(i).getOID().equals(agent.getOID())){
                /*Quita el agente antiguo y deposita uno nuevo inicializando su cantidadBuscadas en 1 */
                this.quitarDeCache(agentes.get(i));
                this.depositarEnCache(agente);
                break;
            }
            i=i-1;
        }
        
    }
    
    /* Elimina un registro de la Caché */
    public void quitarDeCache(Object agente){
        
        Agente agent = (Agente) agente;
        int i = this.agentes.size() - 1;
        while(i>=0){
            /*Si el OID del Agente pasado como parámetro es igual al OID buscado en algún agente de la Cahé */
            if(this.agentes.get(i).getOID().equals(agent.getOID())){
                /*Deposita el nuevo agente en el mismo lugar del agente e inicializa su cantidadBuscadas en 1 */
                this.agentes.remove(i);
                this.cantidadBuscadas.remove(i);
                break;
            }
            i= i-1;
        }
        
    }
    
    /* Método privado que da soporte a mantener un límite de la capacidad de la caché */
    private void mantenerLimiteCache(){
        
        if( this.agentes.size() >= maximoCache){
            int tamanioCache = this.agentes.size() - 1;
            int quitar = this.cantidadBuscadas.firstElement(), indexAQuitar = 0;
            while(tamanioCache >= 0){
                if(quitar > this.cantidadBuscadas.get(tamanioCache)){
                    quitar = this.cantidadBuscadas.get(tamanioCache);
                    indexAQuitar = tamanioCache;
                }
                tamanioCache = tamanioCache - 1;
            }
            /*Para remover por objeto tiene que pasar como parámetro un Integer, como indexAQuitar es un int, remueve por posición*/
            this.cantidadBuscadas.remove(indexAQuitar);
            this.agentes.remove(indexAQuitar);
        }
        
    }
    
    /* Método para ver el contenido de la Caché para verificar su correcto funcionamiento */
    
    public void verContenidoCache(){
        
        int i = this.agentes.size() - 1;
        while (i>=0){
            Agente a = this.agentes.get(i);
            System.out.println(i+".- OID: "+a.getOID());
            System.out.println("    Cantidad de veces buscada: "+this.cantidadBuscadas.get(i));
            i=i-1;
        }
        
    }
    
}
