package e_commerce.repository;

import java.util.List;
import e_commerce.model.Produto;

public interface ProdutoRepository 
{
	void adicionarProduto(Produto produto);
	List<Produto> listarProdutos();
	Produto buscarProdutoPorId(int id);
	void atualizarProduto(Produto produto);
	boolean apagarProduto(int id);
	boolean existeProduto(int id);
}