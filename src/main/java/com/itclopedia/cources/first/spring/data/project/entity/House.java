package com.itclopedia.cources.first.spring.data.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "houses")
public class House {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "houses_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Integer id;

    @Column(name = "number")
    private Integer number;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "street_id")
    private Street street;

    @Column(name = "area")
    private String area;

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", number=" + number +
                ", area='" + area + '\'' +
                '}';
    }
}
