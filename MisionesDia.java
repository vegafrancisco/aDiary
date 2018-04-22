/*
 * Proyecto aDiary
 * Alfredo Mendez, Antonio Ayres, Maximiliano Torres, Francisco Vega
 */
package aDiary;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Esta clase permite tanto agregar misiones, quitarlas y mostrarlas 
 * indicando el día en las que se agregaron.
 * @author amendezllaupe
 */

public class MisionesDia {
    /**
    * Atributos de la clase
    */
    private ArrayList<Mision> misiones;
    private Calendar fecha;
    private int dia;
    
    /**
     * Constructor sin parametros, con valores por default, donde se instancia
     * el arrayList 'misiones', el calendario 'fecha' y se asigna
     * el día con un método de la clase Calendar.
    */
    public MisionesDia(){
        misiones = new ArrayList<>();
        fecha = Calendar.getInstance();
        dia = fecha.get(Calendar.DAY_OF_MONTH);
    }
    
    public ArrayList<Mision> getMisiones(){ //Alfredo falto algo importante <3
    	return this.misiones;
    }
    /**
     * Agrega una nueva mision con los parametros:
     * @param mision String
     * @param isCompleted boolean
     */
    public void agregarMision(String mision, boolean isCompleted){
       misiones.add(new Mision(mision, isCompleted));
    }
    /**
     * Quita una misión con la posición de esta dentro del arrayList 'misiones'.
     * @param posicion int
     */
    public void quitarMision(int posicion){
        for(int i = 0; i < misiones.size(); i++){
            if(posicion == i){
                misiones.remove(posicion);
            }
        }
    }
    /**
     * Recorre el arrayList 'misiones' y va alamcenando cada posición en un 
     * string 'stringMision'
     * @return String 
     */
    private String almacenarLista(){
        String stringMision = "";
        for(int i = 0; i < misiones.size(); i++){
            stringMision += "["+(i+1)+"] "+misiones.get(i).toString() + "\n"; //agrega los datos de la misión de la posición i
        }                                                      // y  los añade a los datos de la pos anterior
        return stringMision;
    }
    /**
     * 
     * @return día y misiones del día
     */
    @Override
    public String toString(){
      return "Día: " +Integer.toString(dia) + "\n" + almacenarLista();
    }
}
