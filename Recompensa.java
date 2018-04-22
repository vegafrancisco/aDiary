
import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Francisco
 */
public class Recompenza {

    private String nombre;
    Random random = new Random();

    private ArrayList<String> Recompenzas() {

        ArrayList<String> nombres = new ArrayList<>();
        // Estas serian como las recompenzas predeterminadas 
        nombres.add("Recompenza 1");
        nombres.add("Recompenza 2");
        nombres.add("Recompenza 4");
        nombres.add("Recompenza 4");
        nombres.add("Recompenza 5");
        nombres.add("Recompenza 6");
        nombres.add("Recompenza 7");

        return nombres;
    }

//    private String ElegirRecompeza(ArrayList<String>nombre){
//        
//        
//           String RecopenzaElegida=nombre.get((Integer.parseInt(JOptionPane.showInputDialog("Elegir Recompenza")))-1);
//        
//        
//       return RecopenzaElegida;
//    }
//    
//    public void   MostrarTodas(ArrayList<String>nombre){
//        for (int i=0; i<nombre.size();i++) {
//            System.out.println(""+nombre.get(i-1));
//        }
//      
//    }
    private String nombre(ArrayList<String> nombres) {
        String nombre = nombres.get(random.nextInt(nombres.size() - 1));
        return nombre;
    }

    public Recompenza() {
        this.nombre = nombre(Recompenzas());

    }

    public void mostrar() {
//       

        System.out.println("Tu recompenza es  " + nombre);
    }

}
