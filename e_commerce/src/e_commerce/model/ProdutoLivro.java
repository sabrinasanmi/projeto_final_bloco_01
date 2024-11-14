package e_commerce.model;

public class ProdutoLivro extends Produto 
{
    private String autor;
    private String isbn;
    private String editora;
    
    public ProdutoLivro(int id, String titulo, String autor, String descricao, float preco, int quantidadeEstoque, String categoria, String isbn, String editora) 
    {
        super(id, titulo, descricao, preco, quantidadeEstoque, categoria);
        this.autor = autor;
        this.isbn = isbn;
        this.editora = editora;
    }
    @Override
    public void exibirInfoProduto() {
        super.exibirInfoProduto();
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
        System.out.println("Editora: " + editora);
    }
    public String getAutor() 
    {
        return autor;
    }
    public void setAutor(String autor) 
    {
        this.autor = autor;
    }
    public String getIsbn() 
    {
        return isbn;
    }
    public void setIsbn(String isbn) 
    {
        this.isbn = isbn;
    }
    public String getEditora() 
    {
        return editora;
    }
    public void setEditora(String editora) 
    {
        this.editora = editora;
    }
    @Override
    public String toString() 
    {
        return super.toString() + ", autor=" + autor + ", isbn=" + isbn + ", editora=" + editora + "]";
    }
}
