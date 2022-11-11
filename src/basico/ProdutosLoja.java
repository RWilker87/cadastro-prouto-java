package basico;
import java.io.Serializable;
public class ProdutosLoja implements Serializable, basico.Interface {
    private static final long serialVersionUID = -
            1831499947378485496L;
    //Atributos da classe
    private String nomeProduto;
    private int quantidade;
    private double preco;
    private int id;
    //Construtor da classe
    public ProdutosLoja(String nomeProduto, int quantidade, double
            preco) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    //5)
//Crie um método que realiza operações úteis para o usuário
    public double calcularFrete() {
        return this.preco = this.preco + (this.preco * 0.1);
    }
    //6)
//Crie um método que realiza operações úteis para o usuário
    public void adicionarEstoqueProduto(int quantidade) {
        this.quantidade += quantidade;
    }

    @Override
    public String toString() {
        return
                "Nome do produto = " + nomeProduto + "\n" +
                        "Quantidade do estoque desse produto = " +
                        quantidade + "\n" +
                        "Preço do produto = " + preco + "\n";
    }
    @Override
    public int getID() {
        return this.id;
    }
    @Override
    public void setID(int id) {
        this.id = id;
    }
}