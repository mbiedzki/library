package pl.coderslab.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Data
/*@JsonSerialize*/
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String category;
    private String format;


    /*public Book(Long id, String title, String author, String category, String format) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.format = format;
    }

    public Book() {
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
