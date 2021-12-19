package br.com.arthurschultz.library.model.dto;

import br.com.arthurschultz.library.model.Genre;

public class bookDTO {
    private int Id;
    private String Nome;
    private String Autor;
    private Genre Genero;

    public bookDTO() {}

    public bookDTO(int Id, String Nome, String Autor, Genre Genero) {
        this.Id = Id;
        this.Nome = Nome;
        this.Autor = Autor;
        this.Genero = Genero;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getAutor() {
        return this.Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public Genre getGenero() {
        return this.Genero;
    }

    public void setGenero(Genre Genero) {
        this.Genero = Genero;
    }
}
