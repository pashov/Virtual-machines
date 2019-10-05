package com.pashov.repository;

import com.pashov.dao.VirtualMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VirtualMachineRepository extends JpaRepository<VirtualMachine, String> {
    Optional<VirtualMachine> findById(int id);

    void deleteById(int id);
}
