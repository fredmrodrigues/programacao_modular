/*
==================================================ENUNCIADO============================================================
01. Escreva códigos Java para preencher um vetor de 6 números inteiros a partir da entrada do usuário e, depois, inver-
-ter as posições dos números do vetor. Por exemplo, se o vetor original era 4-8-15-16-23-42, deve ficar 42-23-16-15-8-4
após a execução. Escreva um programa que verifique a correção do seu código.
=======================================================================================================================
*/
package aplicacao01;
/**
 * @author fredericorodrigues
 */
import java.util.Scanner;
public class Aplicacao01 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] vetor = new int[6];
        
        //preenchendo o vetor a partir da entrada do usuário
        for(int i = 0; i < vetor.length; i++) {
            boolean inputValido = false;
            while(!inputValido) {
                System.out.print("Digite o " + (i + 1) + "º número: ");
                if(input.hasNextInt()) {
                    vetor[i] = input.nextInt();
                    inputValido = true;
                } else {
                    System.out.println("Entrada inválida. Digite um número inteiro.");
                    input.next();
                }
            }
        }
        //verificando o vetor original
        System.out.println("Vetor antes da inversão:");
        for(int num : vetor) {
            System.out.print("[" + num + "] ");
        }
        System.out.println();
        
        //invertendo as posições dos números do vetor
        for(int i = 0; i < vetor.length / 2; i++) {
            int temp = vetor[i];
            vetor[i] = vetor[vetor.length - 1 - i];
            vetor[vetor.length - 1 - i] = temp;
        }
        
        //verificando o vetor invertido
        System.out.println("Vetor invertido:");
        for (int num : vetor) {
            System.out.print("[" + num + "] ");
        }
        input.close();
    }
    
}
