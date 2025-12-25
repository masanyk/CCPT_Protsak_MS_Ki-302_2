package Ki302.Protsak.lab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Узагальнений клас кошика, який може зберігати різні типи елементів
 * @param <T> тип елементів, що зберігаються в кошику
 */
public class Basket<T extends Comparable<T>> {
    private List<T> items;
    private int capacity;

    /**
     * Конструктор створює новий кошик із вказаною місткістю
     * @param capacity максимальна кількість елементів, яку може вмістити кошик
     */
    public Basket(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    /**
     * Додає елемент до кошика, якщо є вільне місце
     * @param item елемент для додавання в кошик
     * @return true якщо елемент успішно додано, false якщо кошик повний
     */
    public boolean addItem(T item) {
        if (items.size() < capacity) {
            items.add(item);
            return true;
        }
        return false;
    }

    /**
     * Видаляє та повертає останній елемент з кошика
     * @return видалений елемент або null, якщо кошик порожній
     */
    public T removeItem() {
        if (!items.isEmpty()) {
            return items.remove(items.size() - 1);
        }
        return null;
    }

    /**
     * Знаходить максимальний елемент у кошику
     * @return максимальний елемент або null, якщо кошик порожній
     */
    public T findMax() {
        if (items.isEmpty()) {
            return null;
        }
        return Collections.max(items);
    }

    /**
     * Отримує поточну кількість елементів у кошику
     * @return кількість елементів у кошику
     */
    public int getSize() {
        return items.size();
    }

    /**
     * Відображає всі елементи в кошику
     */
    public void displayItems() {
        System.out.println("Вміст кошика:");
        for (T item : items) {
            System.out.println(item.toString());
        }
    }
}
