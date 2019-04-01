package pl.coderslab.library;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import javax.persistence.*;



@Entity
@Data
@JsonSerialize
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private String category;
    private String format;

}
