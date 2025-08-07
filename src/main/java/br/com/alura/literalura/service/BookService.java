package br.com.alura.literalura.service;

import br.com.alura.literalura.model.Author;
import br.com.alura.literalura.model.Book;
import br.com.alura.literalura.repository.AuthorRepository;
import br.com.alura.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public void saveBook(Book book){
        Optional<Author> authorExist = authorRepository.findByNameContainingIgnoreCase(book.getAuthor().getName());
        if (authorExist.isPresent()) {
            book.setAuthor(authorExist.get());
        }
        repository.save(book);
    }

    public List<Book> getRegisteredBooks() {
        return repository.findAll();
    }

    public List<Book> getBooksInLanguage(String language) {
        return repository.findByLanguages(language);
    }
}
