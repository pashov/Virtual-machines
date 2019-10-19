package com.pashov.repository;

import com.pashov.dao.Disk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiskRepository extends JpaRepository<Disk, String> {
    Optional<Disk> findById(int id);

    void deleteById(int id);
}
