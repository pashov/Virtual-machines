package com.pashov.service;

import com.pashov.dao.Disk;
import com.pashov.dao.VirtualMachine;

import java.util.List;

public interface DiskService {
    List<Disk> getAll();

    Disk get(int id);

    void create(Disk disk);

    void update(Disk disk);

    void delete(int id);
}
