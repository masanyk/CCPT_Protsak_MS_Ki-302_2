package Ki302.Protsak.lab3;

import java.io.IOException;

/**
 * Інтерфейс TapeOperations визначає набір операцій, що можуть виконуватись з касетами у відеомагнітофоні.
 *
 * <p>До основних операцій відносяться перемотування назад, швидке перемотування вперед та виймання касети.
 * Всі методи можуть генерувати виключення {@link IOException} у разі помилок під час виконання операцій.
 */
public interface TapeOperations {

    /**
     * Перемотує касету назад.
     *
     * @throws IOException якщо виникає помилка при виконанні операції
     */
    void rewind() throws IOException;

    /**
     * Швидко перемотує касету вперед.
     *
     * @throws IOException якщо виникає помилка при виконанні операції
     */
    void fastForward() throws IOException;

    /**
     * Виймає касету з відеомагнітофона.
     *
     * @throws IOException якщо виникає помилка при виконанні операції
     */
    void eject() throws IOException;
}