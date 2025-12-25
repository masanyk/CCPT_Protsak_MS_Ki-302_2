package Ki302.Protsak.lab6;

/**
 * Клас продукту, що представляє товари, які можна зберігати в кошику
 */
public class Product implements Comparable<Product> {
    private String name;
    private double price;

    /**
     * Конструктор створює новий продукт з назвою та ціною
     * @param name назва продукту
     * @param price ціна продукту
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return "Продукт{назва='" + name + "', ціна=" + price + "}";
    }
}