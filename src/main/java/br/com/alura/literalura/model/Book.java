package br.com.alura.literalura.model;

import br.com.alura.literalura.model.Response.BookResponse;
import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private Author author;
    private String languages;
    private Long downloadCount;

    public Book() {
    }

    public Book(BookResponse book) {
        this.title = book.title();
        this.author = new Author(book.authors().getFirst());
        this.languages = book.languages().getFirst();
        this.downloadCount = book.downloadCount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Long downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return """
                
                ---------- LIVRO ----------
                
                Título: %s
                Autor: %s
                Idioma: %s
                Numero de downloads: %s
                
                ---------------------------
                
                """.formatted(this.title, this.author.getName(),this.languages, this.downloadCount);
    }
}
