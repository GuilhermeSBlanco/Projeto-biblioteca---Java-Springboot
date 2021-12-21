package br.com.arthurschultz.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import br.com.arthurschultz.library.model.Genre;


// @Entity  - Notação que indica que uma determinada classe
// representa a estrutura de uma tabela 
// Essa notação automaticamente cria a tabela no banco caso ela n exista, usando o nome da classe
// como base, para definir outro nome para a tabela adicionar a notação @Table(name = "nomedatabela")
// @Entity, @Table, @id são notações importadas de javax.persistence

@Entity
@Table(name = "books")
public class Book {
    @Id // @id representa a pk dessa tabela
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(columnDefinition = "Varchar(50) not null")
    private String Nome;
    
    @Column(columnDefinition = "varchar(70) not null")
    private String Autor;

    @Column(nullable = false)
    private Genre Genero;

    public Book() {
    }

    public Book(int Id, String Nome, String Autor, Genre Genero) {
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
