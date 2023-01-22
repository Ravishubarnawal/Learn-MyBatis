package CRUD;

import java.io.IOException;

public class LaptopService {
    private LaptopRepo repository;
    public LaptopService() throws IOException {
        repository = new LaptopRepo();
    }
    public void addLaptop(Laptop laptop) {
        repository.add(laptop);
    }

    public Laptop read(int id) {
        return repository.read(id);
    }

    public void updateLaptop(Laptop laptop) {
        repository.update(laptop);
    }

    public void deleteLaptop(int id) {
        repository.delete(id);
    }
}

