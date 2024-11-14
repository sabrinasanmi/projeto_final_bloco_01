package e_commerce.controller;

import e_commerce.model.Produto;
import e_commerce.repository.ProdutoRepository;
import e_commerce.util.Cores;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController implements ProdutoRepository {

    private List<Produto> produtos;

    public ProdutoController() {
        this.produtos = new ArrayList<>();
    }

    @Override
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println(Cores.TEXT_GREEN + "Produto adicionado com sucesso!" + Cores.TEXT_RESET);
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtos;
    }

    @Override
    public Produto buscarProdutoPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        throw new RuntimeException("Produto não encontrado!");
    }

    @Override
    public void atualizarProduto(Produto produto) {
        int index = -1;
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == produto.getId()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            produtos.set(index, produto);
            System.out.println(Cores.TEXT_GREEN + "Produto atualizado com sucesso!" + Cores.TEXT_RESET);
        } else {
            throw new RuntimeException("Produto não encontrado para atualização!");
        }
    }

    @Override
    public boolean apagarProduto(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produtos.remove(produto);
                System.out.println(Cores.TEXT_GREEN + "Produto removido com sucesso!" + Cores.TEXT_RESET);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existeProduto(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return true;
            }
        }
        return false;
    }
}