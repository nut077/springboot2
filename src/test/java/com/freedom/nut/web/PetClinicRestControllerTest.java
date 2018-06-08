package com.freedom.nut.web;

import com.freedom.nut.model.Owner;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PetClinicRestControllerTest {
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void testCreateOwner() {
        Owner owner = new Owner();
        owner.setFirstName("Eiei");
        owner.setLastName("Freedom");
        URI location = restTemplate.postForLocation("http://localhost:8080/rest/owner", owner);
        Owner owner1 = restTemplate.getForObject(location, Owner.class);

        MatcherAssert.assertThat(owner1.getFirstName(), Matchers.equalTo(owner.getFirstName()));
        MatcherAssert.assertThat(owner1.getLastName(), Matchers.equalTo(owner.getLastName()));
    }

    @Test
    public void testGetOwner() {
        ResponseEntity<Owner> response = restTemplate.getForEntity("http://localhost:8080/rest/owner/1", Owner.class);
        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
        MatcherAssert.assertThat(response.getBody().getFirstName(), Matchers.equalTo("Nut"));
        MatcherAssert.assertThat(response.getBody().getLastName(), Matchers.equalTo("Freedom"));
    }

    @Test
    public void testGetOwnersByFiratName() {
        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/rest/owners/firstname?firstname=Nut", List.class);
        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
        List<Map<String, String>> body = response.getBody();
        List<String> firstName = body.stream().map(fn -> fn.get("firstName")).collect(Collectors.toList());
        MatcherAssert.assertThat(firstName, Matchers.containsInAnyOrder("Nut", "Nut"));
    }

    @Test
    public void testGetOwners() {
        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/rest/owners", List.class);
        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
        List<Map<String, String>> body = response.getBody();
        List<String> firstName = body.stream().map(val -> val.get("firstName")).collect(Collectors.toList());
        MatcherAssert.assertThat(firstName, Matchers.containsInAnyOrder("Nut", "Arashi", "Nut", "Arashi"));
    }
}
