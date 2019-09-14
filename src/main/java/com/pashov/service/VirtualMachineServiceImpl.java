package com.pashov.service;

import com.pashov.model.Disk;
import com.pashov.model.Network;
import com.pashov.model.VirtualMachine;
import com.pashov.repository.DiskRepository;
import com.pashov.repository.NetworkRepository;
import com.pashov.repository.VirtualMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VirtualMachineServiceImpl implements VirtualMachineService {
    private final VirtualMachineRepository virtualMachineRepository;
    private final DiskRepository diskRepository;
    private final NetworkRepository networkRepository;

    @Autowired
    public VirtualMachineServiceImpl(VirtualMachineRepository virtualMachineRepository,
                                     DiskRepository diskRepository,
                                     NetworkRepository networkRepository) {
        this.virtualMachineRepository = virtualMachineRepository;
        this.diskRepository = diskRepository;
        this.networkRepository = networkRepository;
    }

    @Override
    public List<VirtualMachine> getAll() {
        return (List<VirtualMachine>) virtualMachineRepository.findAll();
    }

    @Override
    public VirtualMachine get(String id) {
        Optional<VirtualMachine> virtualMachine = virtualMachineRepository.findById(id);
        if(virtualMachine.isPresent()) {
            return virtualMachine.get();
        }
        throw new RuntimeException("No virtual machine with such id");
    }

    @Override
    public void create(VirtualMachine virtualMachine) {
        virtualMachineRepository.save(virtualMachine);
    }

    @Override
    public void update(String id, VirtualMachine updatedVirtualMachine) {

    }

    @Override
    public void delete(String id) {
        virtualMachineRepository.deleteById(id);
    }

    @Override
    public void attachDisk(String id, Disk disk) {
        diskRepository.save(disk);
    }

    @Override
    public void attachNetworks(String id, List<Network> networks) {
        networkRepository.saveAll(networks);
    }
}