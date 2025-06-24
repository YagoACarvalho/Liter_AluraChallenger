package br.com.LiterAluraChallhenge.LiterAlura.service;

import br.com.LiterAluraChallhenge.LiterAlura.Entity.Autor;
import br.com.LiterAluraChallhenge.LiterAlura.dto.DadosLivro;
import br.com.LiterAluraChallhenge.LiterAlura.Entity.Livro;
import br.com.LiterAluraChallhenge.LiterAlura.client.ApiResponse;
import br.com.LiterAluraChallhenge.LiterAlura.client.ConsumoApi;
import br.com.LiterAluraChallhenge.LiterAlura.client.ConverteDados;
import br.com.LiterAluraChallhenge.LiterAlura.repository.AutorRepository;
import br.com.LiterAluraChallhenge.LiterAlura.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class LivroService {

    private Scanner leitura =  new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private LivroRepository livroRepository;
    private AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }



    private List<DadosLivro> getDadosLivro(String nomeLivro) {
        var json = consumoApi.obterDados(URL_BASE + nomeLivro.replace(" ", "%20"));
        ApiResponse apiResponse = converteDados.obterDados(json, ApiResponse.class);

        List<DadosLivro> livros = apiResponse.getResults();
        return livros;
    }

    public void buscarLivrosPorNome() {
        System.out.println("Qual livro deseja buscar ? ");
        String nome = leitura.nextLine();

        List<DadosLivro> livrosEncontrados = getDadosLivro(nome);


        if (livrosEncontrados.isEmpty()) {
            System.out.println("Nenhum livro encontrado!");
            return;
        }
        System.out.println("\n*** LIVROS ENCONTRADOS ***");
        for (int i = 0; i < livrosEncontrados.size(); i++) {
            DadosLivro livro = livrosEncontrados.get(i);
            System.out.println((i + 1) + ". Título: " + livro.titulo());
            System.out.println("   Autor: " + livro.autor().get(0));
            System.out.println("   Idioma: " + livro.idioma());
            System.out.println("   Downloads: " + livro.downloads());
            System.out.println("---");
        }

        System.out.println("\nQual Livro deseja salvar? (digite o número)");
        int escolha = leitura.nextInt();
        leitura.nextLine();

        DadosLivro livroEscolhido = livrosEncontrados.get(escolha - 1);

        var dadosAutor = livroEscolhido.autor().get(0);

        var autor = new Autor(dadosAutor);
        Livro livro = new Livro(livroEscolhido, autor);
        System.out.println("Autor: " + autor.getNome());
        livroRepository.save(livro);

        System.out.println("Livro salvo com sucesso!");
    }

    public void listarLivrosCadastrados(){
        List<Livro> livros = livroRepository.findAllWithAutor();

        System.out.println("\n*** LIVROS CADASTRADOS ***");
        livros.forEach(l -> {
            System.out.println("Título : " + l.getTitulo() +
                    "\nAutor: " + l.getAutor().getNome() +
                    "\nIdioma: " + l.getIdioma() +
                    "\n Downloads: " + l.getDownloads() +
                    "\n---------------------------");
        });
    }

    public void listarAutoresCadastrados() {
        List<Autor> autores = autorRepository.findAllWithLivros();

        System.out.println("\n*** AUTORES CADASTRADOS ***");
        autores.forEach(a -> System.out.println("Nome: " + a.getNome() +
                "\nNascimento: " + a.getNascimento() +
                "\nFalecimento: " + a.getFalecimento() +
                "\nLivros: " + a.getLivros().toString() +
                "\n---------------------------"));
    }

    public void listarAtoresVivosNoAno() {
        System.out.println("Qual ano deseja pesquisar?");
        var anoEscolhido = leitura.nextInt();
        leitura.nextLine();
        List<Autor> autoresVivos = autorRepository.findAutoresVivosNoAno(anoEscolhido);

        if(autoresVivos.isEmpty()) {
            System.out.println("Nenhum autor encontrado  vivo no ano " + anoEscolhido);
            return;
        }

        System.out.println("\n*** AUTORES VIVOS EM " + anoEscolhido + ": ***");
        autoresVivos.forEach(a -> System.out.println("Nome: " + a.getNome() +
                "\nNascimento: " + a.getNascimento() +
                "\nFalecimento: " + a.getFalecimento() +
                "\n---------------------------"));


    }

    public void listarLivrosDeUmIdioma() {
        System.out.println("""
                *** Insira o Idioma para realizar busca: *** 
                es - espanhol
                en - inglês
                fr - francês
                pt - português
                """);
        var idiomaEscolhido = leitura.nextLine();
        List<Livro> livrosEncontrados = livroRepository.findByIdioma(idiomaEscolhido);

        System.out.println("\n*** LIVROS ENCONTRADOS NO IDIOMA " + idiomaEscolhido + ": ***");
        livrosEncontrados.forEach(l ->
            System.out.println("Título : " + l.getTitulo() +
                    "\nAutor: " + l.getAutor().getNome() +
                    "\nIdioma: " + l.getIdioma() +
                    "\n Downloads: " + l.getDownloads() +
                    "\n---------------------------"));
    }
}

