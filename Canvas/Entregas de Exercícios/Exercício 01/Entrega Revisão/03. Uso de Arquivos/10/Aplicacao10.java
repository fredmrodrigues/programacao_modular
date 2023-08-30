/*
==================================================ENUNCIADO============================================================
110. Refaça o exercício 02, sendo que os dados serão lidos de um arquivo texto. O arquivo texto pode ter várias linhas e
cada linha representa um vetor a ser utilizado pelo método. O separador usado é ponto e vírgula. Por exemplo:
4;8;15;4;15;16;23;42
7;11;13;17;29;23;29;31
6;5;4;3;2;1
=======================================================================================================================
 */
package aplicacao10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao10 {

    public static List<int[]> lerVetoresDoArquivo(String nomeArquivo) {
        List<int[]> vetores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] numeros = linha.split(";");
                int[] vetor = new int[numeros.length];
                for (int i = 0; i < numeros.length; i++) {
                    vetor[i] = Integer.parseInt(numeros[i]);
                }
                vetores.add(vetor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vetores;
    }

    public static int[] somarParesVetor(int[] vetor) {
        int tamanhoVetorSoma = vetor.length / 2 + vetor.length % 2;
        int[] vetorSoma = new int[tamanhoVetorSoma];

        for (int i = 0; i < vetor.length; i += 2) {
            int indiceVetorSoma = i / 2;
            if (i == vetor.length - 1) {
                vetorSoma[indiceVetorSoma] = vetor[i];
            } else {
                vetorSoma[indiceVetorSoma] = vetor[i] + vetor[i + 1];
            }
        }

        return vetorSoma;
    }

    public static void imprimirVetor(int[] vetor) {
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        String nomeArquivo = "/Users/fredericorodrigues/Library/CloudStorage/OneDrive-Personal/Documentos/PUC/2023-02/Programação Modular (6650.1.00)/Canvas/Exercícios/01. Revisão/Códigos/03. Uso de Arquivos/10/Aplicacao10/src/aplicacao10/vetores.txt";
        List<int[]> vetores = lerVetoresDoArquivo(nomeArquivo);

        for (int[] vetor : vetores) {
            int[] vetorSoma = somarParesVetor(vetor);
            System.out.print("Vetor original: ");
            imprimirVetor(vetor);
            System.out.print("Vetor soma: ");
            imprimirVetor(vetorSoma);
            System.out.println();
        }
    }
}

