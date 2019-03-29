package pl.coderslab.library;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
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
