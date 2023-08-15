/*
==================================================ENUNCIADO============================================================
05. Um estudante muito organizado está matriculado em N disciplinas, e dispõe de um total semanal de H horas e M
minutos para estudar. Sua intenção é dividir o tempo disponível igualmente para as N disciplinas, e distribuir o tempo
de descanso que sobrar nas pausas entre as disciplinas. Crie um ou mais métodos para informar ao estudante como ele
deve organizar seu plano de estudos.
=======================================================================================================================
*/
package aplicacao05;

import java.util.Scanner;

public class Aplicacao05 {

    //método para organizar o plano de estudos
    public static int[][] organizarPlanoDeEstudos(int numDisciplinas, int totalHoras, int totalMinutos) {
        int totalMinutosDisponiveis = (totalHoras * 60) + totalMinutos;

        // Calcula o tempo de descanso (10% do tempo total)
        int tempoDeDescansoTotal = (int) (totalMinutosDisponiveis * 0.2);
        int tempoDeDescansoPorDisciplina = tempoDeDescansoTotal / numDisciplinas;

        // Calcula o tempo disponível para as disciplinas (descontando o tempo de descanso)
        int tempoDisponivelDisciplinas = totalMinutosDisponiveis - tempoDeDescansoTotal;

        int tempoPorDisciplina = tempoDisponivelDisciplinas / numDisciplinas;
        int tempoMaximoPorDisciplina = 59; // 59 minutos

        int[][] planoDeEstudos = new int[numDisciplinas][4]; // [horasEstudo, minutosEstudo, horasDescanso, minutosDescanso] para cada disciplina

        for (int i = 0; i < numDisciplinas; i++) {
            planoDeEstudos[i][0] = tempoPorDisciplina / 60; // Horas de estudo
            planoDeEstudos[i][1] = tempoPorDisciplina % 60; // Minutos de estudo

            // Se o tempo de minutos for maior que o tempo máximo permitido (59 minutos)
            // então acrescente 1 hora de estudo e ajuste os minutos
            if (planoDeEstudos[i][1] > tempoMaximoPorDisciplina) {
                planoDeEstudos[i][0]++;
                planoDeEstudos[i][1] -= tempoMaximoPorDisciplina + 1;
            }

            planoDeEstudos[i][2] = tempoDeDescansoPorDisciplina / 60; // Horas de descanso
            planoDeEstudos[i][3] = tempoDeDescansoPorDisciplina % 60; // Minutos de descanso
        }

        return planoDeEstudos;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //define quantas disciplinas serão estudadas
        System.out.print("Digite o número de disciplinas: ");
        int numDisciplinas = input.nextInt();

        //define o total de horas disponíveis
        System.out.print("Digite o total semanal de horas disponíveis: ");
        int totalHoras = input.nextInt();

        //define o total de minutos disponíveis
        System.out.print("Digite o total semanal de minutos disponíveis: ");
        int totalMinutos = input.nextInt();

        //montagem da matriz com o plano de estudos chamando o método de organizar o plano de estudos
        int[][] planoDeEstudos = organizarPlanoDeEstudos(numDisciplinas, totalHoras, totalMinutos);

        //imprime o plano de estudos organizado
        System.out.println("\nPlano de estudos:");
        for (int i = 0; i < numDisciplinas; i++) {
            System.out.println("Disciplina " + (i + 1) + ": " + planoDeEstudos[i][0] + " horas e " + planoDeEstudos[i][1] + " minutos de estudo, " +
                               "com " + planoDeEstudos[i][2] + " horas e " + planoDeEstudos[i][3] + " minutos de descanso.");
        }

        input.close();
    }
}