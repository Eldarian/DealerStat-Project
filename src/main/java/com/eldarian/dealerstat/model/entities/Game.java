package com.eldarian.dealerstat.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Game extends AbstractEntity{

    @Column(unique = true)
    private String name;

    @OneToMany (mappedBy = "game")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonManagedReference
    private List<GameObject> gameObjects;
}
