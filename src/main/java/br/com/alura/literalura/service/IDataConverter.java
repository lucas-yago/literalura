package br.com.alura.literalura.service;

public interface IDataConverter {

    <T> T obterDados(String json, Class<T> tClass);
}
