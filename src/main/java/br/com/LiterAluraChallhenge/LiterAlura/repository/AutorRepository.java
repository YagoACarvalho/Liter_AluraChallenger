package br.com.LiterAluraChallhenge.LiterAlura.repository;

import br.com.LiterAluraChallhenge.LiterAlura.Entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a LEFT JOIN FETCH a.livros ORDER BY a.nome")
    List<Autor> findAllWithLivros();


    @Query("SELECT a FROM Autor a WHERE a.nascimento <= :anoEscolhido AND (a.falecimento IS NULL OR a.falecimento >= :anoEscolhido)")
    List<Autor> findAutoresVivosNoAno(@Param("anoEscolhido") Integer ano);
}
