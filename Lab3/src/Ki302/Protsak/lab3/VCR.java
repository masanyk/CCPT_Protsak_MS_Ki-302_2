package Ki302.Protsak.lab3;

import java.io.IOException;

/**
 * Клас VCR (Video Cassette Recorder) представляє відеомагнітофон, що розширює функціонал класу VideoPlayer
 * та реалізує операції з касетами через інтерфейс TapeOperations.
 *
 * <p>Основні функції включають відтворення, паузу, перемотування вперед і назад,
 * а також вставлення та виймання касет. При виконанні будь-якої операції відбувається логування.
 */
public class VCR extends VideoPlayer implements TapeOperations {
    private boolean tapeInserted;

    /**
     * Конструктор класу VCR. Ініціалізує базовий клас VideoPlayer і встановлює початкові налаштування.
     *
     * @throws IOException якщо виникає помилка при ініціалізації логера
     */
    public VCR() throws IOException {
        super();
        this.tapeInserted = false;
    }

    /**
     * Відтворює відео з касети, якщо вона вставлена.
     *
     * @param videoName назва відео для відтворення
     * @throws IOException якщо виникає помилка при логуванні
     */
    @Override
    public void play(String videoName) throws IOException {
        if (tapeInserted) {
            isPlaying = true;
            currentVideo = videoName;
            logger.log("Початок відтворення касети: " + videoName);
            System.out.println("Відтворення касети: " + videoName);
        } else {
            logger.log("Неможливо відтворити. Касета не вставлена.");
            System.out.println("Помилка: Касета не вставлена");
        }
    }

    /**
     * Ставитиме відтворення на паузу.
     *
     * @throws IOException якщо виникає помилка при логуванні
     */
    @Override
    public void pause() throws IOException {
        if (isPlaying) {
            isPlaying = false;
            logger.log("Пауза відтворення касети: " + currentVideo);
            System.out.println("Пауза відтворення касети: " + currentVideo);
        }
    }

    /**
     * Відновлює відтворення відео з касети після паузи.
     *
     * @throws IOException якщо виникає помилка при логуванні
     */
    @Override
    public void resume() throws IOException {
        if (!isPlaying && tapeInserted) {
            isPlaying = true;
            logger.log("Відновлення відтворення касети: " + currentVideo);
            System.out.println("Відновлення відтворення касети: " + currentVideo);
        }
    }

    /**
     * Перемотує касету назад.
     *
     * @throws IOException якщо виникає помилка при логуванні
     */
    @Override
    public void rewind() throws IOException {
        if (tapeInserted) {
            logger.log("Перемотування касети назад");
            System.out.println("Перемотування касети назад");
        } else {
            logger.log("Неможливо перемотати. Касета не вставлена.");
            System.out.println("Помилка: Касета не вставлена");
        }
    }

    /**
     * Швидко перемотує касету вперед.
     *
     * @throws IOException якщо виникає помилка при логуванні
     */
    @Override
    public void fastForward() throws IOException {
        if (tapeInserted) {
            logger.log("Швидке перемотування касети вперед");
            System.out.println("Швидке перемотування касети вперед");
        } else {
            logger.log("Неможливо перемотати вперед. Касета не вставлена.");
            System.out.println("Помилка: Касета не вставлена");
        }
    }

    /**
     * Виймає касету з пристрою.
     *
     * @throws IOException якщо виникає помилка при логуванні
     */
    @Override
    public void eject() throws IOException {
        if (tapeInserted) {
            tapeInserted = false;
            isPlaying = false;
            currentVideo = "";
            logger.log("Касета вийнята");
            System.out.println("Касета вийнята");
        } else {
            logger.log("Неможливо вийняти. Касета не вставлена.");
            System.out.println("Помилка: Касета не вставлена");
        }
    }

    /**
     * Метод для вставлення касети.
     * @param tapeName назва касети
     * @throws IOException якщо виникає помилка при логуванні
     */
    public void insertTape(String tapeName) throws IOException {
        if (!tapeInserted) {
            tapeInserted = true;
            currentVideo = tapeName;
            logger.log("Вставлено касету: " + tapeName);
            System.out.println("Вставлено касету: " + tapeName);
        } else {
            logger.log("Неможливо вставити касету. Інша касета вже вставлена.");
            System.out.println("Помилка: Інша касета вже вставлена");
        }
    }
}