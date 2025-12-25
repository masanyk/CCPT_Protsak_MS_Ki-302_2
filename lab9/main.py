from VideoRecorder import VideoRecorder

if __name__ == "__main__":
    # Створюємо відеомагнітофон
    recorder = VideoRecorder("Panasonic VCR", ["MP4", "AVI"], 500, 50)

    # Перевіряємо початковий статус
    print("\n1. Початковий статус:")
    print(recorder.get_status())

    # Вмикаємо відеомагнітофон
    print("\n2. Вмикаємо відеомагнітофон:")
    recorder.turn_on()

    # Відтворення відео
    print("\n3. Відтворення відео:")
    recorder.play("movie.mp4")

    # Починаємо запис
    print("\n4. Початок запису:")
    recorder.start_recording("event.avi")

    # Зупиняємо запис
    print("\n5. Зупинка запису:")
    recorder.stop_recording()

    # Переглядаємо список записаних файлів
    print("\n6. Список записів:")
    print(recorder.list_recorded_files())

    # Видаляємо запис
    print("\n7. Видалення запису:")
    recorder.delete_recording("event.avi")

    # Промотуємо відео вперед
    print("\n8. Промотування відео вперед:")
    recorder.fast_forward()

    # Зупиняємо відтворення
    print("\n9. Зупинка відтворення:")
    recorder.stop()

    # Вимикаємо відеомагнітофон
    print("\n10. Вимикаємо відеомагнітофон:")
    recorder.turn_off()
    print(recorder.get_status())