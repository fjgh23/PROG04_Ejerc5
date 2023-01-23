package fjgh.prog04_ejerc5;

import java.util.InputMismatchException;
import java.lang.ArithmeticException;
import java.util.Scanner;

/**
*
* Realiza divisiones de dos números introducidos por teclado.
<br>Finaliza introduciendo en ambos números -1.
<br>Muestra el número total de divisiones realizadas.
* @author Javier Gómez
* 
*/
public class PROG04_Ejerc5 {

    /**
    *
    * Lee un número entero por teclado.
    * @param msj Mensaje a mostrar para introducir el número.
    * @return <code><b>num</b></code> Valor a retornar.
    * @exception InputMismatchException Controla la introducción de un entero.
    *
    */
    public static int leerNumero(String msj) {
        // Declara variables del método
        boolean numErr;
        int num = 0;
        // Clase Scanner para petición de datos
        Scanner teclado = new Scanner( System.in);
        
        // Bucle hasta introducir un entero
        do {
            numErr = false;
            try {
                System.out.print(msj);
                num = teclado.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("No es un número entero.");
                teclado.nextLine();
                numErr = true;
            }
        } while (numErr);
        
        return num;
    }
    
    /**
    *
    * Método main de la aplicación.
    * @param args No utiliza parámetros.
    * @exception ArithmeticException Controla la división por 0.
    *
    */
    public static void main(String[] args) {
        // Declara las variables del método main
        int contador = 0;
        int dividendo;
        int divisor;
        
        // Bucle de divisiones
        do {
            // Muestra el encabezado
            System.out.println("\n=========================");
            System.out.println(" División de dos números");
            System.out.println("=========================");

            // Solicita el dividendo
            dividendo = leerNumero("Dame el dividendo: ");

            // Solicita el divisor
            divisor = leerNumero("Dame el divisor..: ");
            
            // Comprueba que los valores no sean ambos -1
            if (dividendo == -1 && divisor == -1)
                continue;
            
            // Realiza la división
            System.out.println("-------------------------");
            System.out.println("Dividendo: " + dividendo);
            System.out.println("Divisor..: " + divisor);
            
            // Protege de la división por 0
            try {
                System.out.println("Resultado: " + (dividendo / divisor));
            } catch (ArithmeticException ae) {
                System.out.println("Resultado: infinito");
            }
            
            // Incrementa el contador
            contador++;
            
        } while (dividendo != -1 && divisor != -1);
        
        // Muestra el contador
        System.out.println("-------------------------");
        System.out.println("Divisiones realizadas: " + contador);
        
        // Fin del programa
        System.out.println("\nFin.");
    }
}
