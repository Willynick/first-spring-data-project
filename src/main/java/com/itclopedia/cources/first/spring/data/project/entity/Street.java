package com.itclopedia.cources.first.spring.data.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "name")
    public String name;

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
