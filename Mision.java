/*
 * Proyecto aDiary
 * Alfredo Mendez, Antonio Ayres, Maximiliano Torres, Francisco Vega
 */
package aDiary;

/**
 * Esta clase permite guardar tanto la mision(tarea) en si,
 * como el estado de esta (completa o incompleta).
 * @author AAyres04
 */

public class Mision {
    
    private String mision; //La mision(tarea).
    private boolean isCompleted; //Indica el estado de la tarea.
    
    /**
    * Constructor sin parametros, con valores por default.
    * <p>Atributo mision = ""</p>
    * <p>Atributo isCompleted = false.</p>
    */
    
    public Mision(){
        this.mision = "";
        this.isCompleted = false;
    }
    
    /**
     * Constructor con parametros para inicializarlo con valores otorgados.
     * @param mision String
     * @param isCompleted boolean.
    */
    
    public Mision(String mision, boolean isCompleted){
        this.mision = mision;
        this.isCompleted = isCompleted;
    }
    
    /**
     * Asigna una nueva mision a la insiancia de esta clase.
     * @param mision String
     */

    public void setMision(String mision) {
        this.mision = mision;
    }
    
    /**
     * Asigna un nuevo valor al booleano isCompleted a a la insiancia de esta clase.
     * "isCompleted" representa el estado de la mision.
     * @param isCompleted boolean
     */

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
    
    /**
     * Obtiene el valor de "mision" de la instancia de esta clase.
     * @return String.
     */

    public String getMision() {
        return mision;
    }
    
    /**
     * Obtiene el valor de "isCompleted" de la instancia de esta clase.
     * "isCompleted" representa el estado de la mision.
     * @return boolean
     */

    public boolean getIsCompleted() {
        return isCompleted;
    }
    
    /**
     * Traduce el valor del booleano "isCompleted" al estado que este representa.
     * @return String.
     */
    
    public String estado(){
        if(this.isCompleted) return "Achieved";
        else return "Incompleto";
    }
    
    /**
     * Override de toString(). 
     * Devuelve información sobre la mision y su estado.
     * @return String
     */
    
    @Override
    public String toString() {
        return "Mision: " + this.mision + "\t" + "Estado: " + estado();
    }
    
}
