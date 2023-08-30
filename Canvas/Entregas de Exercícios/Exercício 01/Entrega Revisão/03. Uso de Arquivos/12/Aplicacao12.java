/*
==================================================ENUNCIADO============================================================
12. Refaça o exercício 04, fazendo com que o programa leia de um arquivo todas as frases a serem impressas de forma
invertida. A última linha deste arquivo terá a palavra “fim”.
=======================================================================================================================
 */
package aplicacao12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Aplicacao12 {

    public static void lerFrasesDoArquivo(String nomeArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null && !linha.equalsIgnoreCase("fim")) {
                String fraseInvertida = inverterFrase(linha);
                System.out.println(fraseInvertida);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String inverterFrase(String frase) {
        StringBuilder sb = new StringBuilder(frase);
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        String nomeArquivo = "/Users/fredericorodrigues/Library/CloudStorage/OneDrive-Personal/Documentos/PUC/2023-02/Programação Modular (6650.1.00)/Canvas/Exercícios/01. Revisão/Códigos/03. Uso de Arquivos/12/Aplicacao12/src/aplicacao12/frases.txt";
        lerFrasesDoArquivo(nomeArquivo);
    }
}
