package com.freedom.nut.web;

import com.freedom.nut.exception.OwnerNotFoundException;
import com.freedom.nut.model.Owner;
import com.freedom.nut.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class PetClinicRestController {
    private PetClinicService petClinicService;

    @Autowired
    public PetClinicRestController(PetClinicService petClinicService) {
        this.petClinicService = petClinicService;
    }

    @PostMapping("/owner")
    public ResponseEntity<URI> createOwner(@RequestBody Owner owner) {
        try {
            petClinicService.createOwner(owner);
            Long id = owner.getId();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/owners")
    public ResponseEntity<List<Owner>> getOwners() {
        List<Owner> owners = petClinicService.findOwners();
        return ResponseEntity.ok(owners);
    }

    @GetMapping("/owners/firstname")
    public ResponseEntity<List<Owner>> getOwnersByFirstName(@RequestParam("firstname") String firstName) {
        List<Owner> owners = petClinicService.findByFirstName(firstName);
        return ResponseEntity.ok(owners);
    }

    @GetMapping("/owners/lastname")
    public ResponseEntity<List<Owner>> getOwnersByLastName(@RequestParam("lastname") String lastName) {
        List<Owner> owners = petClinicService.findByLastName(lastName);
        return ResponseEntity.ok(owners);
    }

    @GetMapping("/owner/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable("id") Long id) {
        try {
            Owner owner = petClinicService.findOwner(id);
            return ResponseEntity.ok(owner);
        } catch (OwnerNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

}
