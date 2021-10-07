package Lista2;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        double numero1 = scanner.nextDouble();

        while (numero1 != 0) {
        System.out.println("Tente acertar o numero: ");
        double numero2 = scanner.nextDouble();
            if (numero1 < numero2) {
                System.out.println("O número a ser encontrado é menor do que você digitou \n");
            }
            if (numero1 > numero2) {
                System.out.println("O número a ser encontrado é maior do que você digitou.\n");
            }
            if (numero1 == numero2) {
                System.out.println("Parabens voce acertou");
                break;
            }
        }
    }
}

