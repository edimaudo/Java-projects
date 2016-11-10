package guessinggame;
import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    
    public static int number, guess, maxValue;
    public static Scanner scan;
    public static Random rand;
    
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        rand = new Random();
        System.out.print("Please enter a maximum number: ");
        maxValue = scan.nextInt();
        number = rand.nextInt(maxValue);
        System.out.println("");
        System.out.print("Please enter the number you want to guess: ");
        
        while (guess != number) {
            guess = scan.nextInt();
            if (guess > number) {
                System.out.println("The guess is to high!");
            }
            
            if (guess < number){
                System.out.println("The guess is to low!");
            }
        }
        System.out.println("Congrats! you won!");
    }
    
}
