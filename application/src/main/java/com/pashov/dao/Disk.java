package com.pashov.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "disks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Disk {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private int size; // in GB
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "virtual_machine_id", insertable = false, updatable = false)
    private VirtualMachine virtualMachine;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disk disk = (Disk) o;
        return id == disk.id &&
                size == disk.size &&
                Objects.equals(name, disk.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, size);
    }
}