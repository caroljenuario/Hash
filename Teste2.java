package hash.corrigido;

import java.io.IOException;
import java.util.Scanner;

public class Teste2 {

    public static void main(String[] args) throws IOException {
        long t0 = System.currentTimeMillis();
        long t1;
        int n = 0;
        do {
            Usuario_solucao us = new Usuario_solucao();
            Scanner ler = new Scanner(System.in);

            do {

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
                        System.exit(0);
                        break;
                }
                t1 = System.currentTimeMillis();
                long tr = 50000 - (t1 - t0);

                System.out.println("Tempo restante:");
                System.out.println(tr +"ms");
            } while (t1 - t0 < 50000);

        } while (true);

    }
}

