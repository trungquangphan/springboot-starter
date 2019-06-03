package vn.codegym.springbootdatajpa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Product {

    @NotBlank String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @NotBlank long price;

    @ManyToOne
    @JoinColumn
    User user;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
