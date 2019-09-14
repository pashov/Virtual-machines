package com.pashov.repository;

import com.pashov.model.VirtualMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VirtualMachineRepository extends JpaRepository<VirtualMachine, String> {
}
