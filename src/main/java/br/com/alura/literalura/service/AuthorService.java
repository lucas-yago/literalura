package br.com.alura.literalura.service;

import br.com.alura.literalura.model.Author;
import br.com.alura.literalura.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public List<Author> getRegisteredAuthors() {
        return  repository.findAll();
    }
}
