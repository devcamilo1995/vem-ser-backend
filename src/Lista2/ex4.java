package Lista2;
import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menor = Integer.MAX_VALUE;
        int p = 0;
        int[] vetor = new int[3];


        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite um numero: ");
            vetor[i] = scanner.nextInt();
                 if (vetor[i] < menor) {
                     menor = vetor[i];
                        p = i;
                    }
                }
                System.out.println("menor valor: " + menor);
                System.out.println("posição: " + p);
            }
        }




