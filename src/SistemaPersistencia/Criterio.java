
package SistemaPersistencia;

import java.text.MessageFormat;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class Criterio {
    
    private String atributo;
    private String operador;
    private Object valor;
    
    /*Set y Get*/
    public String getAtributo() {
        return atributo;
    }
    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getOperador() {
        return operador;
    }
    public void setOperador(String operador) {
        this.operador = operador;
    }

    public Object getValor() {
        return valor;
    }
    public void setValor(Object valor) {
        this.valor = valor;
    }
    
    /* Verificar si funciona, a los String en las consultas se les agrega '' */
    public void setValor2(Object valor) {
        Class a =valor.getClass();
        a.getName();
        if("java.lang.String".equals(a.getName())){
            valor =MessageFormat.format("'{0}'", (String) valor);
        }
        this.valor = valor;
    }
}
