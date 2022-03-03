package hash;

import java.io.IOException;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) throws IOException {
        Usuario us = new Usuario();
        Scanner ler = new Scanner(System.in);
        int n;
        do{

            System.out.printf("Digite a opção desejada %n");
            System.out.printf("1 - Cadastrar %n2 - Autenticar %n3 - Sair%n");
            n = ler.nextInt();

            switch (n) {
                case 1:
                    us.cadastrar();
                    break;
                case 2:
                    us.autenticar("hash.txt");
                    break;
                default:
                    System.out.println("Encerrado.");
                    break;
            }

        }while(n!=3);
    }
}

