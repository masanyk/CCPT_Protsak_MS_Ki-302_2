package Ki302.Protsak.lab6;

/**
 * Клас книги, що представляє книги, які можна зберігати в кошику
 */
public class Book implements Comparable<Book> {
    private String title;
    private int pageCount;

    /**
     * Конструктор створює нову книгу з назвою та кількістю сторінок
     * @param title назва книги
     * @param pageCount кількість сторінок
     */
    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.pageCount, other.pageCount);
    }

    @Override
    public String toString() {
        return "Книга{назва='" + title + "', сторінок=" + pageCount + "}";
    }
}