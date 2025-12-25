package Ki302.Protsak.lab3;

/**
 * Клас AudioSystem представляє аудіосистему з регулюванням гучності.
 */
public class AudioSystem {
    private int volume;

    /**
     * Конструктор за замовчуванням створює аудіосистему з гучністю 50%.
     */
    public AudioSystem() {
        this.volume = 50;
    }

    /**
     * Конструктор, що дозволяє створити аудіосистему з вказаним рівнем гучності.
     *
     * @param volume початкове значення гучності (0-100%)
     */
    public AudioSystem(int volume) {
        this.volume = volume;
    }

    /**
     * Повертає поточний рівень гучності.
     *
     * @return рівень гучності (0-100%)
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Встановлює новий рівень гучності.
     *
     * @param volume новий рівень гучності (0-100%)
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }
}