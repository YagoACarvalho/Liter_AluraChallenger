package br.com.LiterAluraChallhenge.LiterAlura.controller;


import br.com.LiterAluraChallhenge.LiterAlura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuController {

    @Autowired
   public LivroService livroService;

    private Scanner leitura = new Scanner(System.in);

    public void exibirMenu() {
        var opcao = -1;
        while (opcao!= 0) {
            var menu = """
                    1 - Buscar Livro por título
                    2 - Listar livros cadastrados
                    3 - Listar autores cadastrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idioma
                    0 - sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    livroService.buscarLivrosPorNome();
                    break;
                case 2:
                    livroService.listarLivrosCadastrados();
                    break;
                case 3:
                    livroService.listarAutoresCadastrados();
                    break;
                case 4:
                    livroService.listarAtoresVivosNoAno();
                    break;
                case 5:
                    livroService.listarLivrosDeUmIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

}
