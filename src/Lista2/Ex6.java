package Lista2;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] vetor = new int[10];
        vetor[0] = 9;
        vetor[1] = 8;
        vetor[2] = 7;
        vetor[3] = 6;
        vetor[4] = 5;
        vetor[5] = 4;
        vetor[6] = 3;
        vetor[7] = 2;
        vetor[8] = 1;
        vetor[9] = 9;

        System.out.println("Digite um valor para procurar no vetor");
        int num = scanner.nextInt();





        for(int i = 0; i < vetor.length; i++){
           if(vetor[i] == num){
                System.out.println("O índice do número digitado é " + i);
                break;
           } else if (i == vetor.length-1){
                System.out.println("Número não encontrado no vetor");
            }
        }
    }
}