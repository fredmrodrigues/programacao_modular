/*
==================================================ENUNCIADO============================================================
03. Escreva um ou mais métodos para imprimir no console retângulos usando caracteres, como, por exemplo:
XXXXX
X   X
X   X
X   X
XXXXX
=======================================================================================================================
*/
package aplicacao03;

import java.util.Scanner;

public class Aplicacao03 {
    
    //método para imprimir o retângulo
    public static void imprimirRetangulo(int largura, int altura) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if (i == 0 || i == altura - 1 || j == 0 || j == largura - 1) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(); //move para a próxima linha após imprimir uma linha
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int largura, altura;
        
        //definir largura do retângulo
        System.out.print("Digite a largura do retangulo: ");
        while(!input.hasNextInt() || (largura = input.nextInt()) <= 1) {
            System.out.println("Entrada inválida. Digite um número inteiro maior que 1.");
            input.nextLine();
        }
        
        //definir altura do retângulo
        System.out.print("Digite a altura do retangulo: ");
        while(!input.hasNextInt() || (altura = input.nextInt()) <= 1) {
            System.out.println("Entrada inválida. Digite um número inteiro maior que 1.");
            input.nextLine();
        }
        
        //chamada do metodo para imprimir o retângulo
        imprimirRetangulo(largura, altura);
    }
}
