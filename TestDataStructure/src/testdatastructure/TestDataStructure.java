/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testdatastructure;

/**
 *
 * @author edima
 */
public class TestDataStructure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
     
    //using generics to create a linked list
    public class ListElement<T>{
       public ListElement( T value ) { data = value; }
        public ListElement<T> next() { return next; }
        public T value() { return data; }
        public void setNext( ListElement<T> elem ) { next = elem; } public void setValue( T value ) { data = value; }
        private ListElement<T> next;
        private T data; 
    }
    
    //keeping track of the head of the list
    public ListElement<Integer> insertInFront( ListElement<Integer> list, int data ){ ListElement<Integer> l = new ListElement<Integer>( data );
        l.setNext( list );
        return l;
    }
    
    //traversing the linked list
    public ListElement<Integer> find( ListElement<Integer> head, int data ){ ListElement<Integer> elem = head;
while( elem != null && elem.value() != data ){
elem = elem.next(); }
return elem; }
}
