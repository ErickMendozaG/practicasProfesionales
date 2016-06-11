
package SistemaPersistencia;

import java.util.Random;
import java.util.UUID;

/* @author GrowingIdeas:
  
   * MARINOZI, Pablo
   * MARTINEZ, Maribel
   * MORÓN, Sebastián
   * SANCHEZ, Gonzalo
   * MENDOZA, Erick
  
*/

class Agente {
    
    private String OID;
    private boolean nuevo=true;
    private boolean modificado=true;

    /* SET y GET */
    
    public String getOID() {
        return OID;
    }
    
    public void setOID(String oid) {
        this.OID = oid;
    }

    public boolean isNuevo() {
        return nuevo;
    }
    
    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public boolean isModificado() {
        return modificado;
    }
    
    public void setModificado(boolean modificado) {
        this.modificado = modificado;
    }
    
    /*Cada vez que se modifican los agentes con los SET en las interfaces, se modifican, el INtermediario específico tiene que poner modificado en false cuando los crea*/
    
    /* Método privado para generar un OID en String */
    public void generarOID(){
        
        String oid = UUID.randomUUID().toString();
        Random r;
        String replace, replaced;
        for(int i =0; i<=35; i++){
            r = new Random();
            int valorDado = r.nextInt(9)+1;
            replace = String.valueOf(valorDado);
            char esValor = oid.charAt(i);
            if(esValor == 'a'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'b'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'c'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'd'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'e'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'f'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'g'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'h'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'i'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'j'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'k'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'l'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'm'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'n'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'o'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'p'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'q'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'r'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 's'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 't'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'u'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'v'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'w'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'x'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'y'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == 'z'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            if(esValor == '-'){
                replaced = String.valueOf(esValor);
                oid = oid.replaceFirst(replaced, replace);
            }
            
        }
        this.OID = oid;
    }
    
}
