package br.com.alura.literalura.model.Response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookResponse(
        String title,
        List<AuthorResponse> authors,
        List<String> languages,
        @JsonAlias("download_count") Long downloadCount
) {
}
