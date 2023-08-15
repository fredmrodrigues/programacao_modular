/*
==================================================ENUNCIADO============================================================
02. Escreva códigos Java que leiam um vetor de inteiros e criem outro vetor, contendo a soma de cada par de vizinhos do
vetor original. Por exemplo, se o vetor original era 4-8-15-16-23-42, o retorno deve ser um vetor 12-31-65 (ou seja,
4+8, 15+16 e 23+42). Caso o vetor tenha tamanho ímpar, o último número deve ser somado consigo mesmo. Para ler o vetor,
pode aproveitar o método do exercício 02(?). Escreva um programa que execute e teste seu código.
=======================================================================================================================
*/
package aplicacao02;

import java.util.Scanner;

public class Aplicacao02 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tamanhoVetor;

        // Solicita ao usuário o tamanho do vetor
        System.out.print("Digite o tamanho do vetor (um número inteiro positivo maior que zero): ");
        while (!input.hasNextInt() || (tamanhoVetor = input.nextInt()) <= 0) {
            System.out.println("Entrada inválida. Digite um número inteiro positivo maior que zero.");
            input.nextLine();
        }

        int[] vetorOriginal = new int[tamanhoVetor];
        int tamanhoVetorSoma = (tamanhoVetor % 2 == 0) ? tamanhoVetor / 2 : (tamanhoVetor / 2) + 1;
        int[] vetorSoma = new int[tamanhoVetorSoma];

        // Preenche o vetor original a partir da entrada do usuário
        for (int i = 0; i < tamanhoVetor; i++) {
            boolean inputValido = false;
            while (!inputValido) {
                System.out.print("Digite o " + (i + 1) + "º número: ");
                if (input.hasNextInt()) {
                    vetorOriginal[i] = input.nextInt();
                    inputValido = true;
                } else {
                    System.out.println("Entrada inválida. Digite um número inteiro.");
                    input.next();
                }
            }
        }

        // Calcula o vetor de soma dos vizinhos
        int j = 0;
        for (int i = 0; i < tamanhoVetor; i += 2) {
            if (i == tamanhoVetor - 1) {
                vetorSoma[j] = vetorOriginal[i] + vetorOriginal[i];
            } else {
                vetorSoma[j] = vetorOriginal[i] + vetorOriginal[i + 1];
            }
            j++;
        }

        // Exibe o vetor de soma
        System.out.println("Vetor de soma dos vizinhos:");
        for (int num : vetorSoma) {
            System.out.print("[" + num + "] ");
        }

        input.close();
    }
}
