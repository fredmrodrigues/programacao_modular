/*
==================================================ENUNCIADO============================================================
11. Refaça o exercício 08, adicionando a capacidade de ler várias datas de um arquivo texto. O arquivo conterá, em sua
primeira linha, o número de datas das linhas seguintes. Por exemplo:
4
12/02/2013
14/11/2019
31/04/2020
26/01/2021
=======================================================================================================================
 */
package aplicacao11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Aplicacao11 {

    public static String[] lerDatasDoArquivo(String nomeArquivo) {
        String[] datas = null;

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            int numDatas = Integer.parseInt(br.readLine());
            datas = new String[numDatas];

            for (int i = 0; i < numDatas; i++) {
                datas[i] = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return datas;
    }

    public static String verificarData(String data) {
        if (data.matches("\\d{2}/\\d{2}/\\d{4}")) {
            int dia = Integer.parseInt(data.substring(0, 2));
            int mes = Integer.parseInt(data.substring(3, 5));
            int ano = Integer.parseInt(data.substring(6, 10));

            if (ano >= 1900 && ano <= 9999) {
                if (mes >= 1 && mes <= 12) {
                    int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

                    if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) {
                        diasPorMes[2] = 29; // Ano bissexto, fevereiro tem 29 dias
                    }

                    if (dia >= 1 && dia <= diasPorMes[mes]) {
                        return "valida";
                    } else {
                        return "dia inválido para o mês";
                    }
                } else {
                    return "mês inválido";
                }
            } else {
                return "ano inválido";
            }
        } else {
            return "formato inválido (DD/MM/AAAA)";
        }
    }

    public static void main(String[] args) {
        String nomeArquivo = "/Users/fredericorodrigues/Library/CloudStorage/OneDrive-Personal/Documentos/PUC/2023-02/Programação Modular (6650.1.00)/Canvas/Exercícios/01. Revisão/Códigos/03. Uso de Arquivos/11/Aplicacao11/src/aplicacao11/datas.txt";
        String[] datas = lerDatasDoArquivo(nomeArquivo);

        for (String data : datas) {
            String resultadoValidacao = verificarData(data);

            if (resultadoValidacao.equals("valida")) {
                System.out.println("A data " + data + " é válida.");
            } else {
                System.out.println("A data " + data + " é inválida. Motivo: " + resultadoValidacao);
            }
        }
    }
}
