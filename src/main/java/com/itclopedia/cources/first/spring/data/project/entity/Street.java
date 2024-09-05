package com.itclopedia.cources.first.spring.data.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "streets")
public class Street {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "streets_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Integer id;

    @JsonProperty("streetName")
    @Column(name = "name")
    public String name;

    @JsonIgnore
    @OneToMany(mappedBy = "street", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<House> houses;

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", houses=" + houses +
                '}';
    }

}
