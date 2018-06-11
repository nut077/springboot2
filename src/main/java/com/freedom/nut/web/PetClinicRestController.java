package com.freedom.nut.web;

import com.freedom.nut.exception.InternalServerException;
import com.freedom.nut.exception.OwnerNotFoundException;
import com.freedom.nut.model.Owner;
import com.freedom.nut.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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

    @PutMapping("/owner/{id}")
    public ResponseEntity<?> updateOwner(@PathVariable Long id, @RequestBody Owner ownerRequest) {
        try {
            Owner owner = petClinicService.findOwner(id);
            owner.setFirstName(ownerRequest.getFirstName());
            owner.setLastName(ownerRequest.getLastName());
            petClinicService.updateOwner(owner);
            return ResponseEntity.ok().build();
        } catch (OwnerNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/owner/{id}")
    public ResponseEntity<?> deleteOwner(@PathVariable Long id) {
        try {
            petClinicService.deleteOwner(id);
            return ResponseEntity.ok().build();
        } catch (OwnerNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalServerException(e);
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

    @GetMapping(value = "/owner/{id}", produces = "application/json")
    public ResponseEntity<?> getOwnerAsHateoasResource(@PathVariable Long id) {
        try {
            Owner owner = petClinicService.findOwner(id);
            Link self = ControllerLinkBuilder.linkTo(PetClinicRestController.class).slash("/owner/" + id).withSelfRel();
            Link create = ControllerLinkBuilder.linkTo(PetClinicRestController.class).slash("/owner").withRel("create");
            Link update = ControllerLinkBuilder.linkTo(PetClinicRestController.class).slash("/owner/" + id).withRel("update");
            Link delete = ControllerLinkBuilder.linkTo(PetClinicRestController.class).slash("/owner/" + id).withRel("delete");
            Resource<Owner> resource = new Resource<>(owner, self, create, update, delete);
            return ResponseEntity.ok(resource);
        } catch (OwnerNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/owner/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable Long id) {
        try {
            Owner owner = petClinicService.findOwner(id);
            return ResponseEntity.ok(owner);
        } catch (OwnerNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

}
