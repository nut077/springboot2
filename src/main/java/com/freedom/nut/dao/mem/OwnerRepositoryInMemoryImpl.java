package com.freedom.nut.dao.mem;

import com.freedom.nut.dao.OwnerRepository;
import com.freedom.nut.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OwnerRepositoryInMemoryImpl implements OwnerRepository {

    private Map<Long, Owner> ownerMap = new HashMap<>();

    public OwnerRepositoryInMemoryImpl() {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Nut");
        owner1.setLastName("Freedom");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Arashi");
        owner2.setLastName("Freedom");

        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Nut");
        owner3.setLastName("Eiei");

        Owner owner4 = new Owner();
        owner4.setId(4L);
        owner4.setFirstName("Arashi");
        owner4.setLastName("Eiei");

        ownerMap.put(owner1.getId(), owner1);
        ownerMap.put(owner2.getId(), owner2);
        ownerMap.put(owner3.getId(), owner3);
        ownerMap.put(owner4.getId(), owner4);
    }

    @Override
    public List<Owner> findAll() {
        return new ArrayList<>(ownerMap.values());
    }

    @Override
    public Owner findById(Long id) {
        return ownerMap.getOrDefault(id, null);
    }

    @Override
    public List<Owner> findByFirstName(String firstName) {
        return ownerMap.values().stream()
                .filter(owner -> owner.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Owner> findByLastName(String lastName) {
        return ownerMap.values().stream()
                .filter(owner -> owner.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    @Override
    public void create(Owner owner) {
        owner.setId(new Date().getTime());
        ownerMap.put(owner.getId(), owner);
    }

    @Override
    public Owner update(Owner owner) {
        ownerMap.replace(owner.getId(), owner);
        return owner;
    }

    @Override
    public void delete(Long id) {
        ownerMap.remove(id);
    }
}
