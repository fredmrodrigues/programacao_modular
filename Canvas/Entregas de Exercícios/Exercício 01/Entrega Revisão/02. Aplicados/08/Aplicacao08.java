/*
==================================================ENUNCIADO============================================================
08. Escreva um método que verifique se uma data é válida, a partir de um dado recebido do usuário no formato DD/MM/AAAA.
Se a data for inválida, informe ao usuário onde está o erro.
=======================================================================================================================
*/
package aplicacao08;

import java.util.Scanner;

public class Aplicacao08 {

    //método para verificar data
    public static String verificarData(String data) {
        if (data.matches("\\d{2}/\\d{2}/\\d{4}")) {
            int dia = Integer.parseInt(data.substring(0, 2));
            int mes = Integer.parseInt(data.substring(3, 5));
            int ano = Integer.parseInt(data.substring(6, 10));

            if (ano >= 1900 && ano <= 9999) {
                if (mes >= 1 && mes <= 12) {
                    int[] diasPorMes = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

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
        Scanner input = new Scanner(System.in);

        System.out.print("Digite uma data no formato DD/MM/AAAA: ");
        String data = input.nextLine();

        String resultadoValidacao = verificarData(data);

        if (resultadoValidacao.equals("valida")) {
            System.out.println("A data é válida.");
        } else {
            System.out.println("A data é inválida. Motivo: " + resultadoValidacao);
        }

        input.close();
    }
}
