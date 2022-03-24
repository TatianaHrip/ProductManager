package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;


import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager(new ProductRepository());

    private Book book = new Book(1, "Утро", 255, "Иванова");
    private Book booking = new Book(3, "fit", 195, "Семенов");
    private Book bookin = new Book(4, "fit", 255, "Лира");
    private Smartphone smart = new Smartphone(89, "notes", 25698, "samsung");
    private Smartphone smartphone = new Smartphone(99, "xfit", 99845, "apple");


    @Test
    public void shouldAdd() {
        manager.add(book);
        manager.add(booking);

        Product[] expected = new Product[]{book, booking};
        Product[] actual = manager.findAllProduct();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBy() {
        manager.add(book);
        manager.add(booking);
        manager.add(smart);
        manager.add(smartphone);

        Product[] expected = new Product[]{smart};
        Product[] actual = manager.searchBy("notes");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBook() {
        manager.add(book);
        manager.add(booking);
        manager.add(smart);
        manager.add(smartphone);

        Product[] expected = new Product[]{book};
        Product[] actual = manager.searchBy("Утро");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookDual() {
        manager.add(book);
        manager.add(booking);
        manager.add(bookin);
        manager.add(smart);
        manager.add(smartphone);

        Product[] expected = new Product[]{booking, bookin, smartphone};
        Product[] actual = manager.searchBy("fit");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookNull() {
        manager.add(book);
        manager.add(booking);
        manager.add(bookin);
        manager.add(smart);
        manager.add(smartphone);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("привет");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdProduct() {
        manager.add(book);
        manager.add(booking);

        manager.removeByIdProduct(3);

        Product[] expected = new Product[]{book};
        Product[] actual = manager.findAllProduct();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdThrow() {
        manager.add(book);
        manager.add(booking);

        Assertions.assertThrows(NotFoundException.class, () -> manager.removeByIdProduct(5));
    }

}
