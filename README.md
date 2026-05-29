# fake-repository-sample

Demonstrates a fake in-memory repository for testing purposes.

## Structure

All code is in a single file for clarity: `FakeRepositorySampleApplication.java`

- `Owner` — entity
- `OwnerRepository` — repository interface
- `FakeOwnerRepository` — in-memory implementation using `LinkedHashMap`

## Run

```bash
./mvnw spring-boot:run
```
