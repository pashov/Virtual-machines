package com.pashov.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "networks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Network {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "data")
    private String data;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "virtual_machine_id", insertable = false, updatable = false)
    private VirtualMachine virtualMachine;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Network network = (Network) o;
        return id == network.id &&
                Objects.equals(name, network.name) &&
                Objects.equals(data, network.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, data);
    }
}