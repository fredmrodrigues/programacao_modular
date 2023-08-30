/*
==================================================ENUNCIADO============================================================
04. Elabore um programa que leia uma frase e mostre-a invertida na tela. Após mostrar a primeira frase, o programa deve
ler e imprimir outra, assim fazendo até que o usuário digite a palavra "fim".
=======================================================================================================================
*/
package aplicacao04;

import java.util.Scanner;

public class Aplicacao04 {

    //método para inverter a frase
    public static String inverterFrase(String frase) {
        StringBuilder sb = new StringBuilder(frase);
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Digite uma frase (ou 'fim' para sair): ");
            String frase = input.nextLine();

            if (frase.equalsIgnoreCase("fim")) {
                System.out.println("Encerrando o programa.");
                break;
            }

            String fraseInvertida = inverterFrase(frase);
            System.out.println("Frase invertida: " + fraseInvertida);
        }

        input.close();
    }
}
