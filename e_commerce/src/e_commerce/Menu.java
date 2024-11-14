package e_commerce;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import e_commerce.util.Cores;
import e_commerce.model.Produto;
import e_commerce.repository.ProdutoRepository;

public class Menu 
{

	public static void main(String[] args) 
	{
		Scanner leia = new Scanner(System.in);
		int opcao;
		
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
		    	keyPress();
		    	break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todos os produtos\n\n");
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + " Buscar produto por número\n\n");
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar produto\n\n");
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar produto\n\n");
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