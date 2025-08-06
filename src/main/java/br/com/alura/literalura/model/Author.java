package br.com.alura.literalura.model;

import br.com.alura.literalura.model.Response.AuthorResponse;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private Integer birthYear;
    private Integer deathYear;

    @OneToMany(mappedBy = "author")
    private List<Book> books;


    public Author() {
    }

    public Author(AuthorResponse author) {
        this.name = author.name();
        this.birthYear = author.birthYear();
        this.deathYear = author.deathYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    private List<String> titleBooksList(){
        return this.books.stream()
                .map(Book::getTitle)
                .toList();
    }

    @Override
    public String toString() {
        return """
                
                Autor: %s
                Ano de nascimento: %s
                Ano de falecimento: %s
                Livros: %s
                
                """.formatted(this.name, this.birthYear, this.deathYear, titleBooksList().toString());
    }
}
