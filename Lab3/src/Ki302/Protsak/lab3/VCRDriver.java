package Ki302.Protsak.lab3;

import java.io.IOException;

/**
 * Клас VideoPlayerDriver є точкою входу в програму і демонструє роботу з відеоплеєром.
 * Викликаються різні методи для керування медіатекою та відеоплеєром.
 */
public class VCRDriver {
    /**
     * Точка входу в програму. Демонструє роботу з телевізором шляхом виклику різних методів.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        try {
            VCR vcr = new VCR();

            vcr.insertTape("Касета 1");
            vcr.play("Касета 1");
            vcr.pause();
            vcr.resume();
            vcr.rewind();
            vcr.fastForward();
            vcr.changeVolume(25);
            vcr.changeBrightness(75);
            vcr.eject();

            vcr.insertTape("Касета 2");
            vcr.play("Касета 2");
            vcr.eject();

            vcr.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}