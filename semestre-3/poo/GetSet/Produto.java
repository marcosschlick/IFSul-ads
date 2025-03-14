package poo.GetSet;

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public void vender(int quantidade) {
        if (this.quantidadeEstoque >= quantidade) {
            this.quantidadeEstoque -= quantidade;
            System.out.println("(" + this.nome + ") Após a venda de " + quantidade + " itens o estoque ficou com " + this.quantidadeEstoque + " itens");
        } else {
            System.out.println("(" + this.nome + ") Venda não efetuada por falta de estoque");
        }
    }

    public void repor(int quantidade) {
        this.quantidadeEstoque += quantidade;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
