package br.com.alura.literalura.repository;

import br.com.alura.literalura.model.Author;
import br.com.alura.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {

//    @Query("SELECT b.author FROM Book b")
//    List<Author> getAllRegisteredAuthors();
//    List<Author> findByAuthor();

//    @Query("SELECT b.author FROM Book b JOIN b.author")
//    List<Author> findRegisteredAuthors();
}
