/*
==================================================ENUNCIADO============================================================
07. Um algoritmo para multiplicação rápida por 11 de números de 2 dígitos funciona assim: para multiplicar 81 x 11,
some os dígitos do número (8 + 1 = 9) e insira o resultado entre os dígitos (891). Se a soma der maior que 9,
incremente o dígito da esquerda (vai-um): 56 X 11 = 616. Escreva um programa que efetue multiplicações por 11 usando
este algoritmo.
=======================================================================================================================
*/
package aplicacao07;

import java.util.Scanner;

public class Aplicacao07 {

    //método para fazer a multiplicação por 11 através do algoritmo dado
    public static int multiplicarPor11(int numero) {
        int digito1 = numero / 10; // Primeiro dígito
        int digito2 = numero % 10; // Segundo dígito

        int resultado = (digito1 * 100) + (digito1 + digito2) * 10 + digito2;

        return resultado;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numero;
        boolean numeroValido = false;

        while (!numeroValido) {
            System.out.print("Digite um número de 2 dígitos: ");
            numero = input.nextInt();

            if (numero >= 10 && numero <= 99) {
                int resultado = multiplicarPor11(numero);
                System.out.println("Resultado: " + resultado);
                numeroValido = true;
            } else {
                System.out.println("Número inválido. Digite um número de 2 dígitos.");
            }
        }

        input.close();
    }
}