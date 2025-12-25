class VideoPlayer:
    """
    Базовий клас VideoPlayer представляє функціональність відеоплеєра.
    """

    def __init__(self, name, supported_formats, storage_capacity):
        """
        Ініціалізує відеоплеєр.

        :param name: Назва відеоплеєра.
        :param supported_formats: Список підтримуваних форматів файлів.
        :param storage_capacity: Ємність пам'яті у мегабайтах.
        """
        self.name = name
        self.supported_formats = supported_formats
        self.storage_capacity = storage_capacity
        self.is_on = False
        self.is_playing = False
        self.current_video = None

    def turn_on(self):
        """
        Увімкнення відеоплеєра.
        """
        self.is_on = True
        print(f"Відеоплеєр {self.name} увімкнено.")

    def turn_off(self):
        """
        Вимкнення відеоплеєра.
        """
        self.is_on = False
        self.is_playing = False
        self.current_video = None
        print(f"Відеоплеєр {self.name} вимкнено.")

    def play(self, video_name):
        """
        Відтворює відео.

        :param video_name: Назва відеофайлу.
        """
        if not self.is_on:
            print("Відеоплеєр вимкнений!")
            return

        if self.is_playing:
            print("Уже виконується відтворення.")
            return

        self.current_video = video_name
        self.is_playing = True
        print(f"Відтворення відео: {video_name}")

    def stop(self):
        """
        Зупиняє відтворення.
        """
        if self.is_playing:
            print(f"Відтворення відео {self.current_video} зупинено.")
            self.is_playing = False
            self.current_video = None
        else:
            print("Відтворення не виконується.")

    def fast_forward(self):
        """
        Промотування відео вперед.
        """
        if self.is_playing:
            print(f"Відео {self.current_video} промотано вперед.")
        else:
            print("Немає відео для промотування.")

    def rewind(self):
        """
        Промотування відео назад.
        """
        if self.is_playing:
            print(f"Відео {self.current_video} промотано назад.")
        else:
            print("Немає відео для промотування.")

    def get_status(self):
        """
        Повертає статус відеоплеєра.
        """
        power_status = "увімкнений" if self.is_on else "вимкнений"
        playback_status = f"відтворює {self.current_video}" if self.is_playing else "не відтворює"
        return f"Плеєр {self.name}: {power_status}, {playback_status}"