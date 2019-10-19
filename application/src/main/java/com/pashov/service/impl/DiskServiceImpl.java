package com.pashov.service.impl;

import com.pashov.dao.Disk;
import com.pashov.dao.VirtualMachine;
import com.pashov.exception.BusinessRuleException;
import com.pashov.repository.DiskRepository;
import com.pashov.service.DiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DiskServiceImpl implements DiskService {
    private final DiskRepository diskRepository;

    @Autowired
    public DiskServiceImpl(DiskRepository diskRepository) {
        this.diskRepository = diskRepository;
    }

    @Override
    public List<Disk> getAll() {
        return diskRepository.findAll();
    }

    @Override
    public Disk get(int id) {
        return diskRepository.findById(id)
                .orElseThrow(() -> new BusinessRuleException(String.format("No disk with id: %d exists", id)));
    }

    @Override
    public void create(Disk disk) {
        Optional<Disk> diskById = diskRepository.findById(disk.getId());
        if (diskById.isPresent()) {
            throw new BusinessRuleException(String.format("Disk with id: %d already exists", disk.getId()));
        }
        diskRepository.save(disk);
    }

    @Override
    public void update(Disk disk) {
        diskRepository.save(disk);

    }

    @Transactional
    @Override
    public void delete(int id) {
        diskRepository.deleteById(id);
    }
}