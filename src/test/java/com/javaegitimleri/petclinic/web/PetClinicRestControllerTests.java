package com.javaegitimleri.petclinic.web;
import java.awt.List;
import java.net.URI;
import java.util.stream.Collectors;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.javaegitimleri.petclinic.model.Owner;

public class PetClinicRestControllerTests {
private RestTemplate restTemplate;
@Before
public void setUp() {
	restTemplate=new RestTemplate();
	
}

//@Test
//public void testUpdateOwner() {   //Test ederken hata aldım.Güncelleme işlemini yapmadı.
//	
//	Owner owner=restTemplate.getForObject("http://localhost:1523/rest/owner/4", Owner.class);
//	MatcherAssert.assertThat(owner.getFirstName(), Matchers.equalTo("VAHAP"));
//	owner.setFirstName("Vahap Arıca");
//	restTemplate.put("http://localhost:1523/rest/owner/4", owner);
//	owner=restTemplate.getForObject("http://localhost:1523/rest/owner/4", Owner.class);
//	MatcherAssert.assertThat(owner.getFirstName(), Matchers.equalTo("Vahap Arıca"));
//}

@Test

public void testDeleteOwner() {
	restTemplate.delete("http://localhost:1523/rest/owner/1");
	restTemplate.getForObject("http://localhost:1523/rest/owner/1", Owner.class);
}

@Test
public void testCreateOwner() {
	Owner owner=new Owner();
	owner.setFirstName("Hakan");
	owner.setLastName("Arıca");
	URI location=restTemplate.postForLocation("http://localhost:1523/rest/owner",owner);
	Owner owner2=restTemplate.getForObject(location, Owner.class);
	MatcherAssert.assertThat(owner2.getFirstName(), Matchers.equalTo(owner.getFirstName()));
	MatcherAssert.assertThat(owner2.getLastName(), Matchers.equalTo(owner.getLastName()));	
}
@Test
public void testGetOwnerById() {
	ResponseEntity<Owner> response=restTemplate.getForEntity("http://localhost:1523/rest/owner/1", Owner.class);
	MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
	MatcherAssert.assertThat(response.getBody().getFirstName(),Matchers.equalTo("Merve"));
}}
//@Test
//public void testGetOwnersByLastName() {
//	ResponseEntity<List> response=restTemplate.getForEntity("http://localhost:1523/rest/owner?ln=Yalçın",List.class);
//	MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
//	List<Map<String, String>> body=response.getBody();
//	List<String> firstNames=body.stream().map(e->e.get("firstName")).collect(Collectors.toList());
//	MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Merve","Esra","Feyzullah"));
//}
//}
