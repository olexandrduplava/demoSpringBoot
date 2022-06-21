package com.demoSrping.demoSpring.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "user_entity")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;

    @OneToMany
    @ToString.Exclude
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private List<Article> articles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && Objects.equals(name, user.name) && Objects.equals(age, user.age) && Objects.equals(articles, user.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, articles);
    }
}
