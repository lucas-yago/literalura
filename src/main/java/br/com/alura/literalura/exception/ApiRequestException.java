package br.com.alura.literalura.exception;

public class ApiRequestException extends  RuntimeException{

    public  ApiRequestException(String messsage){
        super(messsage);
    }

    public  ApiRequestException(String messsage, Throwable cause){
        super(messsage, cause);
    }
}
