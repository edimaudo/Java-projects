/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practiceintroch1;

/**
 *
 * @author edima
 */
public class TenHelloWorld {

    public static void main(String[] args) {        
        
        /*
        If public/static is missing from the public static void main
        an error occurs saying no main class can be found
        
        if args/void is missing the application runs but it is a warning
        */
        
        //Playing with char
        /*
        System.out.println("b");//output is b
        System.out.println("b" + "c");//output is bc
        System.out.println((char) ('a' + 4));// The output is e
        */
        
        /*
        int a = 2147483647;
        System.out.println(a);//will output a
        System.out.println(a + 1); //overflow/give -2147483648
        System.out.println(2 * a);//-2
        System.out.println(4 * a);
        */
        
        /*
        double a = 3.14159;
        System.out.println(a);// output will be a
        System.out.println(a + 1);// 4.14159
        System.out.println(8 / (int) a); //2
        System.out.println(8 / a); //2.
        System.out.println((int) (8 / a)); //2 
        */
        
        /*
        System.out.println(Math.sqrt(2) * Math.sqrt(2) == 2);//answer if false
        //false because Math.sqrt(2) ^2 is 2.0000000004
        */
        float a = (Float.valueOf(args[0])); 
        float b = (Float.valueOf(args[1]));

    }
    
}
