package br.com.alura.literalura;

import br.com.alura.literalura.model.Author;
import br.com.alura.literalura.model.Book;
import br.com.alura.literalura.model.Response.BookResponse;
import br.com.alura.literalura.model.Response.BookSearchResponse;
import br.com.alura.literalura.service.ApiClient;
import br.com.alura.literalura.service.AuthorService;
import br.com.alura.literalura.service.BookService;
import br.com.alura.literalura.service.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Scanner;

@Component
public class Main {

    private final String url = "https://gutendex.com/books/?search=";
    private final Scanner scanner = new Scanner(System.in);
    private final ApiClient apiClient = new ApiClient();
    private final DataConverter dataConverter = new DataConverter();

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    public void  showMenu() {
        var menu = """
                
                Escolha o número de sua opção :
                
                1- Buscar livro pelo título
                2- Listar livros registrados
                3- Listar autores registrados
                4- Listar autores vivos em um determinado ano
                5- Listar livros em um determinado idioma
                
                0 - Sair
                
                """;
        var option = 1;
        while (option != 0) {
            System.out.println(menu);
            var input = scanner.nextLine();

            try{
                option = Integer.parseInt(input);
            }catch (NumberFormatException e){
                System.out.println("Entrada inválida! Digite um número.");
                continue;
            }

            switch (option) {
                case 1:
                    fetchBooks();
                    break;
                case 2:
                    showRegisteredBooks();
                    break;
                case 3:
                    showRegisteredAuthors();
                    break;
                case 4:
                    showAuthorsAliveInYear();
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void fetchBooks() {
        System.out.println("Insira o nome do livro que você deseja buscar:");
        String bookTitle = scanner.nextLine() ;
        var json = apiClient.fetchData(url+bookTitle.replace(" ", "%20"));
        BookSearchResponse bookSearchResponse =  dataConverter.fromJson(json, BookSearchResponse.class);
            if(!bookSearchResponse.results().isEmpty()){
                Book book =  new Book(bookSearchResponse.results().getFirst());
                bookService.saveBook(book);
                System.out.println(book);

            }else{
                System.out.println("Nenhum livro encontrado com esse nome!");
            }

    }

    private void showRegisteredBooks(){
        List<Book> books =  bookService.getRegisteredBooks();
        if (!books.isEmpty()){
            books.forEach(System.out::println);
        }else {
            System.out.println("Nenhum livro foi registrado ainda");
        }
    }

    private void showRegisteredAuthors(){
        List<Author> authors = authorService.getRegisteredAuthors();
        if (!authors.isEmpty()){
            authors.forEach(System.out::println);
        }else {
            System.out.println("Nenhum Autor encontrado.");
        }
    }

    private void showAuthorsAliveInYear(){
        System.out.println("Informe o ano desejado:");
        var year  = scanner.nextInt();
        scanner.nextLine();
        List<Author> authors = authorService.getAuthorsAliveInYear(year);

        if (!authors.isEmpty()){
            authors.forEach(System.out::println);
        }{
            System.out.println("Nenhum Autor encontrado nesse ano.");
        }

    }


}
