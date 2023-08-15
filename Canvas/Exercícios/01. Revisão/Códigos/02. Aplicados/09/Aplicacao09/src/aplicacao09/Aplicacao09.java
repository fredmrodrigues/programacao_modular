/*
==================================================ENUNCIADO============================================================
09. Sabendo que 1º de janeiro de 2024 será uma segunda-feira, escreva um método que receba uma data e diga em qual dia
da semana esta data acontecerá em 2024. Escreva um programa principal para testar seu método.
=======================================================================================================================
 */
package aplicacao09;

import java.util.Scanner;

public class Aplicacao09 {

    public static boolean verificarData(String data) {
        if (data.matches("\\d{2}/\\d{2}")) {
            int dia = Integer.parseInt(data.substring(0, 2));
            int mes = Integer.parseInt(data.substring(3, 5));

            if (mes >= 1 && mes <= 12) {
                int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

                if (anoBissexto(2024) && mes == 2) {
                    diasPorMes[2] = 29; // Ano bissexto, fevereiro tem 29 dias
                }

                return dia >= 1 && dia <= diasPorMes[mes];
            }
        }
        return false;
    }

    public static boolean anoBissexto(int ano) {
        return (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0));
    }

    public static int calcularDiaDaSemana(int dia, int mes) {
        int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int diaDoAno = dia;
        for (int i = 1; i < mes; i++) {
            diaDoAno += diasPorMes[i];
        }

        // Dia da semana para 01 de janeiro
        int diaPrimeiroDeJaneiro = 1; // Segunda-feira

        // Calcula o dia da semana para a data
        int diaDaSemana;
        if (mes > 2) {
            diaDaSemana = (diaDoAno + diaPrimeiroDeJaneiro - 1) % 7;
        } else {
            diaDaSemana = (diaDoAno + diaPrimeiroDeJaneiro - 2) % 7;
        }

        return diaDaSemana;
    }

    public static String obterNomeDiaDaSemana(int diaDaSemana) {
        String[] diasDaSemana = {"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado", "Domingo"};
        return diasDaSemana[diaDaSemana];
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite uma data no formato DD/MM: ");
        String data = input.nextLine();

        boolean dataValida = verificarData(data);

        if (dataValida) {
            //convertendo a subString em inteiros
            int dia = Integer.parseInt(data.substring(0, 2)); // Pega os dois primeiros dígitos da data e converte para inteiro (dia)
            int mes = Integer.parseInt(data.substring(3, 5)); // Pega os dois últimos dígitos da data e converte para inteiro (mês)

            int diaDaSemana = calcularDiaDaSemana(dia, mes);

            String nomeDiaDaSemana = obterNomeDiaDaSemana(diaDaSemana);

            System.out.println("Em 2024, a data " + data + " cairá em um(a) " + nomeDiaDaSemana + ".");
        } else {
            System.out.println("Data inválida.");
        }

        input.close();
    }
}
