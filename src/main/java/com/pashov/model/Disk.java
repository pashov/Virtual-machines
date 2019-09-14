package com.pashov.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Disk {
    private String id;
    private String name;
    private int size; // in GB
}