package br.com.LiterAluraChallhenge.LiterAlura.repository;


import br.com.LiterAluraChallhenge.LiterAlura.Entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT l FROM Livro l JOIN FETCH l.autor")
    List<Livro> findAllWithAutor();

    List<Livro> findByIdioma(String idioma);
}
