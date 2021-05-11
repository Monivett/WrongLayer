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
public class FibonacciCalculator {

    public static String calculateFibonacci(int value) {
        String fibonacci = "1,";
        
        int a = 0;
        int b = 1;
        int sum = 0;
        
        for (int i = 2; i <= value; i++) {
            sum = a + b;
            fibonacci += sum + ",";
            a = b;
            b = sum;
        }

        return fibonacci;
    }

}
