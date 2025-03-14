package poo.GetSet;

public class ProdutoTeste {
    public static void main(String[] args) {
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();

        produto1.setNome("Notebook");
        produto1.setPreco(2999.99);
        produto1.setQuantidadeEstoque(2);

        produto2.setNome("Caneta");
        produto2.setPreco(1.99);
        produto2.setQuantidadeEstoque(5);

        produto1.vender(2);
        produto1.vender(1);
        produto1.repor(5);
        produto1.vender(2);

        produto2.vender(6);
        produto2.repor(5);
        produto2.vender(6);
    }
}
