package testinheritance;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edima
 */
public class Guitar {
    private String name;
    private int serialNum;
    private int numStrings;
    
    //constructor
    public Guitar(){
        System.out.println("Guitar constructor");
    }
    
    
    //getters and setters
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getSerialNum(){
        return serialNum; 
    }
    
    public void setSerialNum(int serialNum){
        this.serialNum = serialNum;
    }
    
    public int getNumString(){
        return numStrings;
    }
    
    public void setNumString(int numStrings){
        this.numStrings = numStrings;
    }
}
