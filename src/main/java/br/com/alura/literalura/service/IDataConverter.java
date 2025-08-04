package br.com.alura.literalura.service;

public interface IDataConverter {

    <T> T fromJson(String json, Class<T> tClass);
}
