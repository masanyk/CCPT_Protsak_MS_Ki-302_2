package Ki302.Protsak.lab3;

/**
 * Клас Display представляє дисплей із певним розміром та яскравістю.
 */
public class Display {
    private int size;
    private int brightness;

    /**
     * Конструктор за замовчуванням створює дисплей з розміром 32 дюйми та
     * яскравістю 50%.
     */
    public Display() {
        this.size = 32;
        this.brightness = 50;
    }

    /**
     * Конструктор, що дозволяє створити дисплей з вказаними параметрами розміру та яскравості.
     *
     * @param size       розмір дисплею в дюймах
     * @param brightness яскравість дисплею (0-100%)
     */
    public Display(int size, int brightness) {
        this.size = size;
        this.brightness = brightness;
    }

    /**
     * Повертає розмір дисплею.
     *
     * @return розмір дисплею в дюймах
     */
    public int getSize() {
        return size;
    }

    /**
     * Встановлює новий розмір дисплею.
     *
     * @param size новий розмір дисплею в дюймах
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Повертає поточне значення яскравості дисплею.
     *
     * @return яскравість дисплею (0-100%)
     */
    public int getBrightness() {
        return brightness;
    }

    /**
     * Встановлює нове значення яскравості дисплею.
     *
     * @param brightness нова яскравість дисплею (0-100%)
     */
    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
}