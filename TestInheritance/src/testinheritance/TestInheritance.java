/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testinheritance;

/**
 *
 * @author edima
 */
public class TestInheritance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Bass bass = new Bass();
        
        bass.setName("New Gibson");
        
        Guitar myGuitar = new Guitar();
        myGuitar.setName("Gibson");
        System.out.println(myGuitar.getName());
        
    }
    
}
