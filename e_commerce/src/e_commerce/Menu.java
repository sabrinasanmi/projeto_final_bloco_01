package e_commerce;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import e_commerce.util.Cores;
import e_commerce.controller.ProdutoController;
import e_commerce.model.Produto;
import e_commerce.model.ProdutoLivro;
import e_commerce.repository.ProdutoRepository;

public class Menu 
{

	public static void main(String[] args) 
	{
		Scanner leia = new Scanner(System.in);
		ProdutoController controller = new ProdutoController();
		
		int opcao, id;
		String titulo, autor, descricao, categoria, isbn, editora;
		float preco;
		int quantidadeEstoque;
		
		while (true) 
		{
			System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND
					+ "****************************************************");
			System.out.println("                                                    ");
			System.out.println("                   SANMI STORE                      ");
			System.out.println("                                                    ");
			System.out.println("****************************************************");
			System.out.println("                                                    ");
			System.out.println("            1 - Cadastrar produto                   ");
			System.out.println("            2 - Listar todos os produtos            ");
			System.out.println("            3 - Buscar produto por número           ");
			System.out.println("            4 - Atualizar produto                   ");
			System.out.println("            5 - Apagar produto                      ");
			System.out.println("            6 - Sair                                ");
			System.out.println("                                                    ");
			System.out.println("****************************************************");
			System.out.println("Entre com a opção desejada:                         ");
			System.out.println("                                                    " + Cores.TEXT_RESET);

			try 
			{
				opcao = leia.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao=0;
			}
			if (opcao == 6) 
			{
				System.out.println(Cores.TEXT_CYAN_BOLD + "\n SANMI STORE, O que você precisa está aqui.");
				sobre();
				leia.close();
				System.exit(0);
			}
			switch (opcao) 
			{
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Cadastrar produto\n\n");
				System.out.println("Digite o ID do produto: ");
				id = leia.nextInt();
				leia.nextLine(); // Consume newline
				System.out.println("Digite o título do livro: ");
				titulo = leia.nextLine();
				System.out.println("Digite o autor do livro: ");
				autor = leia.nextLine();
				System.out.println("Digite a descrição do livro: ");
				descricao = leia.nextLine();
				System.out.println("Digite o preço do livro: ");
				preco = leia.nextFloat();
				System.out.println("Digite a quantidade em estoque: ");
				quantidadeEstoque = leia.nextInt();
				leia.nextLine(); // Consume newline
				System.out.println("Digite a categoria do livro: ");
				categoria = leia.nextLine();
				System.out.println("Digite o ISBN do livro: ");
				isbn = leia.nextLine();
				System.out.println("Digite a editora do livro: ");
				editora = leia.nextLine();

				ProdutoLivro novoLivro = new ProdutoLivro(id, titulo, autor, descricao, preco, quantidadeEstoque, categoria, isbn, editora);
				controller.adicionarProduto(novoLivro);
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todos os produtos\n\n");
				for (Produto produto : controller.listarProdutos()) 
				{
					produto.exibirInfoProduto();
					System.out.println("-----------------------------");
				}
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + " Buscar produto por número\n\n");
				System.out.println("Digite o ID do produto: ");
				id = leia.nextInt();
				try 
				{
					Produto produtoEncontrado = controller.buscarProdutoPorId(id);
					produtoEncontrado.exibirInfoProduto();
				}
				catch (RuntimeException e) 
				{
					System.out.println(e.getMessage());
				}
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar produto\n\n");
				System.out.println("Digite o ID do produto a ser atualizado: ");
				id = leia.nextInt();
				leia.nextLine(); // Consume newline
				if (controller.existeProduto(id)) 
				{
					System.out.println("Digite o novo título do livro: ");
					titulo = leia.nextLine();
					System.out.println("Digite o novo autor do livro: ");
					autor = leia.nextLine();
					System.out.println("Digite a nova descrição do livro: ");
					descricao = leia.nextLine();
					System.out.println("Digite o novo preço do livro: ");
					preco = leia.nextFloat();
					System.out.println("Digite a nova quantidade em estoque: ");
					quantidadeEstoque = leia.nextInt();
					leia.nextLine(); // Consume newline
					System.out.println("Digite a nova categoria do livro: ");
					categoria = leia.nextLine();
					System.out.println("Digite o novo ISBN do livro: ");
					isbn = leia.nextLine();
					System.out.println("Digite a nova editora do livro: ");
					editora = leia.nextLine();

					ProdutoLivro livroAtualizado = new ProdutoLivro(id, titulo, autor, descricao, preco,
							quantidadeEstoque, categoria, isbn, editora);
					controller.atualizarProduto(livroAtualizado);
				} 
				else 
				{
					System.out.println("Produto não encontrado!");
				}
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar produto\n\n");
				System.out.println("Digite o ID do produto a ser apagado: ");
				id = leia.nextInt();
				controller.apagarProduto(id);
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}
	public static void sobre() 
	{
			System.out.println("\n*****************************************************");
			System.out.println("Projeto Desenvolvido por: Sabrina S. Lima			   ");
			System.out.println("Generation Brasil - sabrinal@genstudents.org		   ");
			System.out.println("https://github.com/sabrinasanmi/projeto_final_bloco_01 ");
			System.out.println("\n*****************************************************");
	}
	public static void keyPress()
	{
		try
		{
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
		}
		catch (IOException e)
		{
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}