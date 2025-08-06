package br.com.alura.literalura.repository;

import br.com.alura.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByNameContainingIgnoreCase(String name);

    @Query("SELECT a FROM Author a WHERE :ano BETWEEN a.birthYear AND a.deathYear")
    List<Author> getAuthorsAliveInYear(Integer ano);
}
