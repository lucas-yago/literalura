package br.com.alura.literalura.model.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookSearchResponse(
        List<BookResponse> results
) {}
