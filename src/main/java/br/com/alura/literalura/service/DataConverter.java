package br.com.alura.literalura.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements IDataConverter{

   private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> tClass) {
        try{
            return mapper.readValue(json, tClass);
        }catch(JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
