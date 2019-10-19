package com.pashov.web;

import com.pashov.dao.Disk;
import com.pashov.service.DiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/disk")
public class DiskController {
    @Autowired
    private DiskService diskService;

    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public List<Disk> getAll() {
        return diskService.getAll();
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public Disk get(@PathVariable int id) {
        return diskService.get(id);
    }

    @PostMapping("")
    @ResponseStatus(CREATED)
    public void create(@RequestBody Disk disk) {
        diskService.create(disk);
    }

    @PutMapping("")
    @ResponseStatus(NO_CONTENT)
    public void update(@RequestBody Disk disk) {
        diskService.update(disk);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable int id) {
        diskService.delete(id);
    }
}