package Ki302.Protsak.lab3;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Клас VideoPlayer представляє простий відеоплеєр, що підтримує відтворення, паузу, відновлення,
 * зміну гучності та яскравості, а також управління медіатекою відео.
 */
public abstract class VideoPlayer {
    protected Display display;
    protected AudioSystem audioSystem;
    protected MediaLibrary mediaLibrary;
    protected Logger logger;
    protected boolean isPlaying;
    protected String currentVideo;

    /**
     * Конструктор за замовчуванням створює новий відеоплеєр з новими екземплярами Display, AudioSystem
     * та MediaLibrary, а також ініціалізує логування.
     *
     * @throws IOException якщо виникає помилка під час створення логера
     */
    public VideoPlayer() throws IOException {
        this.display = new Display();
        this.audioSystem = new AudioSystem();
        this.mediaLibrary = new MediaLibrary();
        this.isPlaying = false;
        this.currentVideo = "";

        this.logger = new Logger("video_player_log.txt");
        logger.log(String.format("Відеоплеєр %s створено.", this.toString()));
    }

    /**
     * Конструктор з параметрами дозволяє створити відеоплеєр з уже існуючими компонентами.
     *
     * @param display      екземпляр класу Display
     * @param audioSystem  екземпляр класу AudioSystem
     * @param mediaLibrary екземпляр класу MediaLibrary
     * @throws IOException якщо виникає помилка під час створення логера
     */
    public VideoPlayer(Display display, AudioSystem audioSystem, MediaLibrary mediaLibrary) throws IOException {
        this.display = display;
        this.audioSystem = audioSystem;
        this.mediaLibrary = mediaLibrary;
        this.isPlaying = false;
        this.currentVideo = "";

        this.logger = new Logger("video_player_log.txt");
        logger.log(String.format("Відеоплеєр %s створено.", this.toString()));
    }


    /**
     * Абстрактний метод для початку відтворення відео.
     * @param videoName назва відео для відтворення
     * @throws IOException якщо виникає помилка при логуванні
     */
    public abstract void play(String videoName) throws IOException;

    /**
     * Абстрактний метод для паузи відтворення.
     * @throws IOException якщо виникає помилка при логуванні
     */
    public abstract void pause() throws IOException;

    /**
     * Абстрактний метод для відновлення відтворення.
     * @throws IOException якщо виникає помилка при логуванні
     */
    public abstract void resume() throws IOException;


    /**
     * Метод для зміни гучності.
     *
     * @param volume нове значення гучності (0-100)
     * @throws IOException якщо виникає помилка під час логування
     */
    public void changeVolume(int volume) throws IOException {
        if (volume < 0 || volume > 100) {
            logger.log("Не можна змінити значення гучності");
            System.out.println("Не можна змінити значення гучності");
        } else {
            audioSystem.setVolume(volume);

            logger.log(String.format("Зміна гучності на: %s", volume));
            System.out.printf("Зміна гучності на: %s\n", volume);
        }
    }

    /**
     * Метод для зміни яскравості дисплею.
     *
     * @param brightness нове значення яскравості (0-100)
     * @throws IOException якщо виникає помилка під час логування
     */
    public void changeBrightness(int brightness) throws IOException {
        if (brightness < 0 || brightness > 100) {
            logger.log("Не можна змінити значення яскравості");
            System.out.println("Не можна змінити значення яскравості");
        } else {
            display.setBrightness(brightness);

            logger.log(String.format("Зміна яскравості на: %s", brightness));
            System.out.printf("Зміна яскравості на: %s\n", brightness);
        }
    }

    /**
     * Метод для додавання відео до медіатеки.
     *
     * @param videoName назва відео
     * @throws IOException якщо виникає помилка під час логування або додавання відео
     */
    public void addVideo(String videoName) throws IOException {
        boolean exist = getVideoList().contains(videoName);

        if (exist) {
            logger.log("Відео уже додано в медіатеку");
            System.out.println("Відео уже додано в медіатеку");
        } else {
            mediaLibrary.addVideo(videoName);

            logger.log(String.format("Додано нове відео: %s", videoName));
            System.out.printf("Додано нове відео: %s\n", videoName);
        }
    }

    /**
     * Метод для видалення відео з медіатеки.
     *
     * @param videoName назва відео
     * @throws IOException якщо виникає помилка під час логування або видалення відео
     */
    public void removeVideo(String videoName) throws IOException {
        if (mediaLibrary.removeVideo(videoName)) {
            logger.log(String.format("Видалено відео: %s", videoName));
            System.out.printf("Видалено відео: %s\n", videoName);
        } else {
            logger.log(String.format("Не вдалося видалити відео: %s", videoName));
            System.out.printf("Не вдалося видалити відео: %s\n", videoName);
        }
    }

    /**
     * Метод для отримання списку всіх відео в медіатеці.
     *
     * @return список відео
     * @throws IOException якщо виникає помилка під час логування або отримання списку
     */
    public List<String> getVideoList() throws IOException {
        logger.log("Запит списку відео");
        System.out.println("Запит списку відео");

        return mediaLibrary.getVideoList();
    }

    /**
     * Метод для перевірки стану відтворення.
     *
     * @return true, якщо відео відтворюється, інакше false
     * @throws IOException якщо виникає помилка під час логування
     */
    public boolean isPlaying() throws IOException {
        logger.log(String.format("Відео відтворюється %s", isPlaying));
        System.out.printf("Відео відтворюється %s\n", isPlaying);

        return isPlaying;
    }

    /**
     * Метод для випадкового вибору та відтворення відео з медіатеки.
     *
     * @throws IOException якщо виникає помилка під час логування або відтворення відео
     */
    public void switchToRandomVideo() throws IOException {
        List<String> videos = mediaLibrary.getVideoList();
        if (videos.isEmpty()) {
            logger.log("Медіатека порожня. Неможливо вибрати випадкове відео.");
            System.out.println("Медіатека порожня. Неможливо вибрати випадкове відео.");
            return;
        }

        Random random = new Random();
        String randomVideo = videos.get(random.nextInt(videos.size()));

        play(randomVideo);
        logger.log(String.format("Випадково вибрано та відтворено відео: %s", randomVideo));
        System.out.printf("Випадково вибрано та відтворено відео: %s\n", randomVideo);
    }

    /**
     * Закриває логер для збереження даних у файл.
     * @throws IOException якщо виникає помилка під час закриття логера
     */
    public void closeLogger() throws IOException {
        logger.close();
    }
}