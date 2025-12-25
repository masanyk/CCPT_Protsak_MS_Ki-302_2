package Ki302.Protsak.lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас MediaLibrary представляє медіатеку, що зберігає список відео та дозволяє
 * додавати, видаляти та перевіряти наявність відео.
 */
public class MediaLibrary {
    private List<String> videos;

    /**
     * Конструктор за замовчуванням створює порожню медіатеку.
     */
    public MediaLibrary() {
        this.videos = new ArrayList<>();
    }

    /**
     * Конструктор, який дозволяє створити медіатеку з наявним списком відео.
     *
     * @param videos початковий список відео
     */
    public MediaLibrary(List<String> videos) {
        this.videos = videos;
    }

    /**
     * Додає відео до медіатеки.
     *
     * @param videoName назва відео, яке потрібно додати
     */
    public void addVideo(String videoName) {
        videos.add(videoName);
    }

    /**
     * Видаляє відео з медіатеки.
     *
     * @param videoName назва відео, яке потрібно видалити
     * @return true, якщо відео успішно видалено, інакше false
     */
    public boolean removeVideo(String videoName) {
        return videos.remove(videoName);
    }

    /**
     * Перевіряє, чи є відео в медіатеці.
     *
     * @param videoName назва відео для перевірки
     * @return true, якщо відео є в медіатеці, інакше false
     */
    public boolean hasVideo(String videoName) {
        return videos.contains(videoName);
    }

    /**
     * Повертає список усіх відео в медіатеці.
     *
     * @return список відео в медіатеці
     */
    public List<String> getVideoList() {
        return new ArrayList<>(videos);
    }
}