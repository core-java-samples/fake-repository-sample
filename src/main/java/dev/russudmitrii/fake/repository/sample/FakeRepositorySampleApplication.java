package dev.russudmitrii.fake.repository.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

record Owner(Long id, String name) {}

interface OwnerRepository {
	List<Owner> findAll();
}

class FakeOwnerRepository implements OwnerRepository {

	private final Map<Long, Owner> owners = new LinkedHashMap<>();

	public FakeOwnerRepository() {
		owners.put(1L, new Owner(1L, "jack1"));
		owners.put(2L, new Owner(2L, "jack2"));
		owners.put(3L, new Owner(3L, "jack3"));
		owners.put(4L, new Owner(4L, "jack4"));
		owners.put(5L, new Owner(5L, "jack5"));
	}

	@Override
	public List<Owner> findAll() {
		return List.copyOf(owners.values());
	}
}

@SpringBootApplication
public class FakeRepositorySampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(FakeRepositorySampleApplication.class, args);
		new FakeRepositorySampleApplication().demo();
	}
	void demo() {
		OwnerRepository repository = new FakeOwnerRepository();
		repository.findAll().forEach(System.out::println);
	}
}
