package com.pashov.service;

import com.pashov.model.Disk;
import com.pashov.model.Network;
import com.pashov.model.VirtualMachine;
import com.pashov.repository.DiskRepository;
import com.pashov.repository.NetworkRepository;
import com.pashov.repository.VirtualMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        return virtualMachineRepository.findAll();
    }

    @Override
    public VirtualMachine get(int id) {
        Optional<VirtualMachine> virtualMachine = virtualMachineRepository.findById(id);
        if (virtualMachine.isPresent()) {
            return virtualMachine.get();
        }
        throw new RuntimeException("No virtual machine with such id");
    }

    @Override
    public void create(VirtualMachine virtualMachine) {
        virtualMachineRepository.save(virtualMachine);
    }

    @Override
    public void update(VirtualMachine updatedVirtualMachine) {
        virtualMachineRepository.save(updatedVirtualMachine);
    }

    @Transactional
    @Override
    public void delete(int id) {
        virtualMachineRepository.deleteById(id);
    }

    @Override
    public void attachDisk(int id, Disk disk) {
        diskRepository.save(disk);
        VirtualMachine virtualMachine = get(id);
        virtualMachine.setDisk(disk);
        virtualMachineRepository.save(virtualMachine);
    }

    @Override
    public void attachNetworks(int id, Set<Network> networks) {
        networkRepository.saveAll(networks);
        VirtualMachine virtualMachine = get(id);
        virtualMachine.setNetworks(networks);
        //virtualMachine.getNetworks().addAll(networks);
        virtualMachineRepository.save(virtualMachine);
    }
}