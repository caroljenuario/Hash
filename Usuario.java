package hash;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private final List<String> nomes = new ArrayList<String>();
    private final List<String>  senhas = new ArrayList<String>();
    private String nome;
    private String senha;


    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void autenticar(String caminho) {

        StringBuilder conteudo = new StringBuilder();
        try {
            FileReader arq = new FileReader("hash.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    conteudo.append(linha).append("\n");
                    linha = lerArq.readLine();

                    Hash hash = Hash.getInstance();
                    Scanner ler = new Scanner(System.in);
                    System.out.printf("Informe um nome: %n");
                    this.nome = ler.nextLine();
                    System.out.printf("Digite a senha: %n");
                    this.senha = ler.nextLine();
                    String saida = hash.toString(this.senha);


                    for (var us : nomes) {
                        for (var user : senhas) {
                            if (us.contains(this.nome) && user.contains(saida)) {
                                if (us.indexOf(this.nome) == user.indexOf(saida)) {
                                    System.out.printf("Autenticado com sucesso. %n");
                                    return;
                                } else {
                                    System.out.printf("Nome ou Senha incorretos. %n");
                                    return;
                                }

                            }
                        }
                    }
                }
                arq.close();
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
        }

    }



    public void cadastrar() throws IOException {
            Hash hash = Hash.getInstance();
            Scanner ler = new Scanner(System.in);
            System.out.printf("Digite o nome: %n");
            this.nome = ler.nextLine();
            nomes.add(this.nome);
            System.out.printf("Digite a senha: %n");
            this.senha = ler.nextLine();
            String saida = hash.toString(this.senha);
            senhas.add(saida);
            if (this.nome.length() <= 4 && (this.senha.length() <= 4)) {
                System.out.println("Cadastrado com sucesso!");
                FileWriter arq;
                arq = new FileWriter("hash.txt");
                PrintWriter gravarArq = new PrintWriter(arq);
                gravarArq.println(nomes);
                gravarArq.println(senhas);
                arq.close();

            } else {
                System.out.printf("Tamanho invalido. Digite no maximo 4 caracteres no nome e senha. %n");
            }

        }
    }












