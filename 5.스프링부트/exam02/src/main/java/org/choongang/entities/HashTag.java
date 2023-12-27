package org.choongang.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class HashTag {
    @Id
    private String Tag;

    @ManyToMany(mappedBy = "tags")
    private List<BoardData> items = new ArrayList<>();
}
