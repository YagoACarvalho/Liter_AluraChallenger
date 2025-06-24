package br.com.LiterAluraChallhenge.LiterAlura.Entity;

import br.com.LiterAluraChallhenge.LiterAlura.dto.DadosAutor;
import br.com.LiterAluraChallhenge.LiterAlura.dto.DadosLivro;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Autor autor;
    private String idioma;
    private double downloads;

    public Livro() {
    }

    public Livro(String titulo, String idioma, double downloads, Autor autor) {
        this.titulo = titulo;
        this.idioma = idioma;
        this.downloads = downloads;
        this.autor = autor;
    }

    public Livro(DadosLivro dadosLivro, Autor autor) {
        this.titulo = dadosLivro.titulo();
        this.downloads = dadosLivro.downloads();
        this.idioma = dadosLivro.idioma().isEmpty() ? "desconhecido" : dadosLivro.idioma().get(0);
        this.autor = autor;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public double getDownloads() {
        return downloads;
    }

    public void setDownloads(double downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
