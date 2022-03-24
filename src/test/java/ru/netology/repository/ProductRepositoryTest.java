package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Book book = new Book(1, "Утро", 255, "Иванова");
    private Book booking = new Book(3, "Океан", 195, "Иванов");
    private Smartphone smart = new Smartphone(89, "notes", 25698, "samsung");
    private Smartphone smartphone = new Smartphone(99, "xfit", 99845, "apple");

    @Test
    void shouldSave() {
        repository.save(book);
//        repository.save(smart);

        Product[] expected = new Product[]{book};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        repository.save(book);
//        repository.save(smart);

        Product[] expected = new Product[]{book};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        repository.save(smartphone);

        repository.findById(99);

        Product[] expected = new Product[]{smartphone};
        Product actual = repository.findById(99);
        assertArrayEquals(expected, new Product[]{actual});
    }

    @Test
    void shouldFindByIdNull() {
        repository.save(smartphone);

        Product expected = null;
        Product actual = repository.findById(100);
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveByID() {
        repository.save(booking);
        repository.save(smartphone);

        repository.removeByID(99);

        Product[] expected = new Product[]{booking};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdThrow() {
        repository.save(book);
        repository.save(booking);

        Assertions.assertThrows(NotFoundException.class, () -> repository.removeByID(5));
    }
}