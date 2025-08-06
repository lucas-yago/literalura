package br.com.alura.literalura;

import br.com.alura.literalura.model.Book;
import br.com.alura.literalura.model.Response.BookResponse;
import br.com.alura.literalura.model.Response.BookSearchResponse;
import br.com.alura.literalura.service.ApiClient;
import br.com.alura.literalura.service.BookService;
import br.com.alura.literalura.service.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main {

    private final String url = "https://gutendex.com/books/?search=";
    private final Scanner scanner = new Scanner(System.in);
    private final ApiClient apiClient = new ApiClient();
    private final DataConverter dataConverter = new DataConverter();

    @Autowired
    private BookService service;

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
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    fetchBooks();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
                service.saveBook(book);
                System.out.println(book);

            }else{
                System.out.println("Nenhum livro encontrado com esse nome!");
            }

    }

}
