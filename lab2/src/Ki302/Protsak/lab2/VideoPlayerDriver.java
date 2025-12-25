package Ki302.Protsak.lab2;

import java.io.IOException;

/**
 * Клас VideoPlayerDriver є точкою входу в програму і демонструє роботу з відеоплеєром.
 * Викликаються різні методи для керування медіатекою та відеоплеєром.
 */
public class VideoPlayerDriver {
    /**
     * Точка входу в програму. Демонструє роботу з телевізором шляхом виклику різних методів.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        try {
            VideoPlayer videoPlayer = new VideoPlayer();

            videoPlayer.addVideo("Відео 1");
            videoPlayer.addVideo("Відео 2");
            videoPlayer.addVideo("Відео 3");
            videoPlayer.play("Відео 1");
            videoPlayer.pause();
            videoPlayer.resume();
            videoPlayer.changeVolume(20);
            videoPlayer.changeBrightness(80);
            videoPlayer.getVideoList();
            videoPlayer.isPlaying();
            videoPlayer.switchToRandomVideo();
            videoPlayer.removeVideo("Відео 3");

            videoPlayer.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}