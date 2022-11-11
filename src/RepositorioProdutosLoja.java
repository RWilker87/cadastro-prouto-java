import basico.Interface;
import java.io.*;
import java.util.ArrayList;

//7)
//Um repositório da sua classe básica.
//8)
//O repositório é salvo em arquivo, utilizando a interface Serializable.
public class RepositorioProdutosLoja implements Serializable {
    private static final long serialVersionUID = -689221195358974120L;
    ArrayList<Interface> repositorio;
    int idCount;
    //Metodo para inicalizar o repositório no Main
    public RepositorioProdutosLoja() {
        this.repositorio = new ArrayList<>();
        this.idCount = 0;
    }
    //Metodo para inserir um produto no repositório
    public void inserir(Interface produto) {
//Verifica se o produto já existe no repositório
        boolean existe = false;
        for (int i = 0; i < repositorio.size(); i++) {
            if
            (repositorio.get(i).getNomeProduto().equals(produto.getNomeProduto()))
            {
                existe = true;
            }
        }
        if (!existe) {
//Se não existe, adiciona o produto
            repositorio.add(produto);
            produto.setID(this.idCount);
            this.idCount++;
        } else {
            System.out.println("Produto já existe no repositório");
        }
    }
    //Metodo para remover um produto do repositório
    public void removerProduto(String nome) {
//Verifica se o produto já existe no repositório
        boolean existe = false;
        for (int i = 0; i < repositorio.size(); i++) {
            if (repositorio.get(i).getNomeProduto().equals(nome)) {
//Se existe, remove o produto
                System.out.println("Removendo produto");
                repositorio.remove(i);

            } else {
//Se não existe, informa que o produto não existe
                System.out.println("Produto não existe no repositório");
            }
        }
    }
    //Metodo para calcular o freto do produto
    public void calcularFrete(String nome) {
        for (int i = 0; i < repositorio.size(); i++) {
            if (repositorio.get(i).getNomeProduto().equals(nome)) {
                System.out.println("Valor do produto com o Frete");
                System.out.println(repositorio.get(i).calcularFrete());
            }
        }
    }
    //Metodo para adiconar estoque de um produto
    public void adicionarEstoqueProduto(String nome, int quantidade) {
        for (int i = 0; i < repositorio.size(); i++) {
            if (repositorio.get(i).getNomeProduto().equals(nome)) {
                System.out.println("Adicionando estoque");
                repositorio.get(i).adicionarEstoqueProduto(quantidade);
            }
        }
    }
    //Metodo para procurar um producto no repositório
    public void procurar(String nome) {
        for (int i = 0; i < repositorio.size(); i++) {
            if (repositorio.get(i).getNomeProduto().equals(nome)) {
//Se existe, informa que o produto existe
                System.out.println(repositorio.get(i).toString());
            } else {
//Se não existe, informa que o produto não existe
                System.out.println("Produto não existe no repositório");
            }
        }
    }
    public void listar() {
        for (int i = 0; i < repositorio.size(); i++) {
            System.out.println(repositorio.get(i).toString());
        }
    }
//metodos para salvar e carregar o repositório em arquivo serializado
    public void salvarRepositorio(String caminhoArquivo) throws
            IOException {

// https://www.devmedia.com.br/use-a-serializacao-em-java-comseguranca/29012

        FileOutputStream fout = new FileOutputStream(caminhoArquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fout);

        oos.writeObject(this);
        oos.close();
    }
    //O repositório é carregado do arquivo.
    public RepositorioProdutosLoja carregarRepositorio(String
                                                               caminhoArquivo) throws IOException, ClassNotFoundException {

// https://www.devmedia.com.br/use-a-serializacao-em-java-com-seguranca/29012

        FileInputStream fin = new FileInputStream(caminhoArquivo);
        ObjectInputStream ois = new ObjectInputStream(fin);
        RepositorioProdutosLoja resp = (RepositorioProdutosLoja)
                ois.readObject();
        ois.close();
        return resp;
    }
}