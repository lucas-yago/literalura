package br.com.alura.literalura;

import java.util.Scanner;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

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


}
