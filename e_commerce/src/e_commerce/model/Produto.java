package e_commerce.model;

public class Produto
{

	private int id;
	private String nome;
	private String descricao;
	private float preco;
	private int quantidadeEstoque;
	private String categoria;

	public Produto(int id, String nome, String descricao, float preco, int quantidadeEstoque, String categoria) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
		this.categoria = categoria;
}

	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public String getDescricao() 
	{
		return descricao;
	}
	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
	}
	public float getPreco() 
	{
		return preco;
	}
	public void setPreco(float preco) 
	{
		this.preco = preco;
	}
	public int getQuantidadeEstoque() 
	{
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) 
	{
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public String getCategoria() 
	{
		return categoria;
	}
	public void setCategoria(String categoria) 
	{
		this.categoria = categoria;
	}
	public void adicionarEstoque(int quantidade) 
	{
		this.quantidadeEstoque += quantidade;
	}
	public boolean reduzirEstoque(int quantidade) 
	{
		if (this.quantidadeEstoque >= quantidade) 
		{
			this.quantidadeEstoque -= quantidade;
			return true;
		}
		else 
		{
			System.out.println("Estoque insuficiente!");
			return false;
		}
	}
	public void exibirInfoProduto() 
	{
		System.out.println("ID: " + id);
		System.out.println("Nome: " + nome);
		System.out.println("Descrição: " + descricao);
		System.out.println("Preço: " + preco);
		System.out.println("Quantidade em Estoque: " + quantidadeEstoque);
		System.out.println("Categoria: " + categoria);
	}
    @Override
    public String toString() 
    {
        return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + 
               ", quantidadeEstoque=" + quantidadeEstoque + ", categoria=" + categoria + "]";
    }
	public void atualizar(Produto novoProduto) 
	{
		this.nome = novoProduto.getNome();
		this.descricao = novoProduto.getDescricao();
		this.preco = novoProduto.getPreco();
		this.quantidadeEstoque = novoProduto.getQuantidadeEstoque();
		this.categoria = novoProduto.getCategoria();
	}
}
