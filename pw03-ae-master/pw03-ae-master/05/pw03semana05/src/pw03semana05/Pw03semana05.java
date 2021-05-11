/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw03semana05;

/**
 *
 * @author magoc
 */
public class Pw03semana05 {

    /**
     * Tipos de dato primitivo
     * int
     * float
     * double
     * long
     */
    private Float size;
    // Control de acceso default
    int age;
    protected String bloodType;
    public String name;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pw03semana05 ejemplo = new Pw03semana05();
        ejemplo.size = 4.0f;

//        Shape shape = new Shape();
        
        System.out.println("Size: " + ejemplo.size.toString());
        
        System.out.println("Es 4 Impar? " + OddCalculator.isOdd(4));
        System.out.println("Es 3 Impar? " + OddCalculator.isOdd(3));
        System.out.println("Fibonacci " + FibonacciCalculator.calculateFibonacci(10));
    }
    
}
