package br.com.alura.literalura.service;

import br.com.alura.literalura.model.Book;
import br.com.alura.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public void saveBook(Book book){
        repository.save(book);
    }

}
