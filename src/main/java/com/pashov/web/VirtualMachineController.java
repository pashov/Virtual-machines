package com.pashov.web;

import com.pashov.model.Disk;
import com.pashov.model.Network;
import com.pashov.model.VirtualMachine;
import com.pashov.service.VirtualMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/vm")
public class VirtualMachineController {
    @Autowired
    private VirtualMachineService virtualMachineService;

    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public List<VirtualMachine> getAll() {
        return virtualMachineService.getAll();
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public VirtualMachine get(@PathVariable String id) {
        return virtualMachineService.get(id);
    }

    @PostMapping("")
    @ResponseStatus(CREATED)
    public void create(@RequestBody VirtualMachine virtualMachine) {
        virtualMachineService.create(virtualMachine);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable String id,
                       @RequestBody VirtualMachine virtualMachine) {
        virtualMachineService.update(id, virtualMachine);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable String id) {
        virtualMachineService.delete(id);
    }

    @PutMapping("/{id}/disk")
    @ResponseStatus(NO_CONTENT)
    public void attachDisk(@PathVariable String id,
                           @RequestBody Disk disk) {
        virtualMachineService.attachDisk(id, disk);
    }

    @PutMapping("/{id}/networks")
    @ResponseStatus(NO_CONTENT)
    public void attachDisk(@PathVariable String id,
                           @RequestBody List<Network> networks) {
        virtualMachineService.attachNetworks(id, networks);
    }
}