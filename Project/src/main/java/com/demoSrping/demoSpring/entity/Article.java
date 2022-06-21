package com.demoSrping.demoSpring.entity;

import com.demoSrping.demoSpring.entity.enums.Color;
import com.demoSrping.demoSpring.utils.MyEnumConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "article_entity")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @Convert(converter = MyEnumConverter.class)
    private Color color;

    @JsonIgnore
    @ManyToOne
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id.equals(article.id) && Objects.equals(text, article.text) && color == article.color && Objects.equals(user, article.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, color, user);
    }
}
