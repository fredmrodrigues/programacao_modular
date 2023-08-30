/*
==================================================ENUNCIADO============================================================
06. Mensalmente, a organização de moradores do bairro faz um sorteio cujos bilhetes contém números de 6 dígitos. O sor-
-teio é baseado nos dois primeiros números da loteria federal, sendo que o número vencedor no sorteio da organização é
formado pelos três primeiros dígitos do segundo prêmio e os três últimos dígitos do primeiro prêmio da loteria federal.
Por exemplo, se o primeiro prêmio fosse 34.582 e o segundo 54.098, o número vencedor seria 540.582.
Escreva um programa que leia os prêmios da loteria federal e retorna o número vencedor da organização.
=======================================================================================================================
*/
package aplicacao06;

import java.util.Random;

public class Aplicacao06 {

    //método para gerar prêmio da loteria aleatoriamente
    public static int gerarPremioLoteria(Random random) {
        int premio = random.nextInt(90000) + 10000; // Gera um número aleatório entre 10000 e 99999
        return premio;
    }

    //método para calcular o número vencedor com base nos dígitos dos prêmios da loteria
    public static int[] calcularNumeroVencedor(int primeiroPremio, int segundoPremio) {
        int tresPrimeirosDigitosSegundoPremio = segundoPremio / 100; //obtém os três primeiros dígitos do segundo prêmio
        int tresUltimosDigitosPrimeiroPremio = primeiroPremio % 1000;   //obtém os três últimos dígitos do primeiro prêmio

        int[] numeroVencedor = { tresPrimeirosDigitosSegundoPremio, tresUltimosDigitosPrimeiroPremio };

        return numeroVencedor;
    }
    
    public static void main(String[] args) {
        Random random = new Random();

        //chamada do método para gerar os prêmios da loteria
        int primeiroPremio = gerarPremioLoteria(random);
        int segundoPremio = gerarPremioLoteria(random);

        //chamada do método para calcular o número vencedor
        int[] numeroVencedor = calcularNumeroVencedor(primeiroPremio, segundoPremio);

        //impressão dos dois prêmios da loteria e o número vencedor
        System.out.println("Primeiro prêmio da loteria federal: " + primeiroPremio);
        System.out.println("Segundo prêmio da loteria federal: " + segundoPremio);
        System.out.println("O número vencedor da organização é: " + numeroVencedor[0] +  numeroVencedor[1]);
    }
}