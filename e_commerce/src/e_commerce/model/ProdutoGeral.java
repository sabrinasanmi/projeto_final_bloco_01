package e_commerce.model;

public class ProdutoGeral extends Produto 
{
    public ProdutoGeral(int id, String nome, String descricao, float preco, int quantidadeEstoque, String categoria) 
    {
        super(id, nome, descricao, preco, quantidadeEstoque, categoria);
    }
    @Override
    public void exibirInfoProduto() 
    {
        System.out.println("Produto Geral:");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Preço: R$" + getPreco());
        System.out.println("Quantidade em Estoque: " + getQuantidadeEstoque());
        System.out.println("Categoria: " + getCategoria());
    }
}