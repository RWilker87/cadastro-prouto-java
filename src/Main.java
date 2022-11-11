import basico.Interface;
import basico.ProdutosLoja;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
public class Main implements Serializable {
    public static void main(String[] args) {
        RepositorioProdutosLoja repositorio = new
                RepositorioProdutosLoja();
//Carrega os produtos do arquivo
        try {
            repositorio =
                    repositorio.carregarRepositorio("./repositorio.dat");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Scanner comando = new Scanner(System.in);
        int opcao = 1;
        boolean verificador = true;
//10)
//O repositório é carregado do arquivo.
        while (opcao != 0) {
            System.out.println("1) Cadastro de produtos");
            System.out.println("2) Procurar produto");
            System.out.println("3) Listar produtos");
            System.out.println("4) Calcular valor com o frete ");
            System.out.println("5) Adicionar produto ao estoque");
            System.out.println("6) Remover produto");
            opcao = comando.nextInt();

            switch (opcao) {
//Operação para inserir produtos
                case 1:
                    System.out.println("Digite o nome do produto: ");
                    String nome = comando.next();

                    System.out.println("Digite o preço do produto: ");

                    double preco = comando.nextDouble();
                    System.out.println("Digite a quantidade do produto: ");
                    int quantidade = comando.nextInt();
                    if (preco < 0 || quantidade < 0) {
                        System.out.println("Valor inválido");
                        verificador = false;
                    }
                    if (verificador) {
                        ProdutosLoja produto = new ProdutosLoja(nome,
                                quantidade, preco);
                        repositorio.inserir((Interface) produto);
                    }
                    break;
//Operação para procurar produto
                case 2:
                    System.out.println("Digite o nome do produto: ");
                    String nome2 = comando.next();
                    repositorio.procurar(nome2);
                    break;

//Operação para listar produtos
                case 3:
                    repositorio.listar();
                    break;
//Operação para calcular o valor com o frete
                case 4:
                    System.out.println("Digite o nome do produto:");
                    String nome4 = comando.next();
                    repositorio.calcularFrete(nome4);
                    break;

//Operação para adicionar produto ao estoque
                case 5:
                    System.out.println("Digite o nome do produto:");
                    String nome5 = comando.next();

                    System.out.println("Digite o quantidade que ira ser adicionada:");
                    int quantidade5 = comando.nextInt();
                    repositorio.adicionarEstoqueProduto(nome5,

                            quantidade5);
                    break;
//Operação para remover produto
                case 6:
                    System.out.println("Digite o nome do produto:");
                    String nome6 = comando.next();
                    repositorio.removerProduto(nome6);

            }
        }
//Salvar o repositório no arquivo
        try {
            repositorio.salvarRepositorio("./repositorio.dat");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}