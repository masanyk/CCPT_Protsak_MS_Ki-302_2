package Ki302.Protsak.lab6;

/**
 * Клас-драйвер для демонстрації роботи класу Basket.
 * Цей клас містить метод main, який демонструє функціональність кошика для продуктів і книг.
 *
 * @version 1.0
 */
public class BasketDriver {

    /**
     * Головний метод програми.
     * Створює кошики для продуктів і книг,
     * додає до них елементи,
     * виконує пошук найдорожчих продуктів та найбільшої кількості сторінок у книгах,
     * а також демонструє можливості видалення елементів.
     *
     * @param args масив рядків, який може містити аргументи командного рядка (не використовується)
     */
    public static void main(String[] args) {
        // Тестування кошика з продуктами
        Basket<Product> productBasket = new Basket<>(5);
        productBasket.addItem(new Product("Яблуко", 1.99));
        productBasket.addItem(new Product("Апельсин", 2.49));
        productBasket.addItem(new Product("Банан", 0.99));

        System.out.println("Кошик з продуктами:");
        productBasket.displayItems();
        System.out.println("Найдорожчий продукт: " + productBasket.findMax());

        // Тестування кошика з книгами
        Basket<Book> bookBasket = new Basket<>(3);
        bookBasket.addItem(new Book("Програмування на Java", 500));
        bookBasket.addItem(new Book("Структури даних", 400));
        bookBasket.addItem(new Book("Алгоритми", 600));

        System.out.println("\nКошик з книгами:");
        bookBasket.displayItems();
        System.out.println("Книга з найбільшою кількістю сторінок: " + bookBasket.findMax());

        // Тестування видалення елементів
        System.out.println("\nВидалення останньої книги: " + bookBasket.removeItem());
        System.out.println("Оновлена кількість книг у кошику: " + bookBasket.getSize());
    }
}