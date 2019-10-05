package com.pashov.service;

import com.pashov.dao.Disk;
import com.pashov.dao.Network;
import com.pashov.dao.VirtualMachine;

import java.util.List;
import java.util.Set;

public interface VirtualMachineService {
    List<VirtualMachine> getAll();

    VirtualMachine get(int id);

    void create(VirtualMachine virtualMachine);

    void update(VirtualMachine updatedVirtualMachine);

    void delete(int id);

    void attachDisk(int id, Set<Disk> disk);

    void attachNetworks(int id, Set<Network> networks);
}