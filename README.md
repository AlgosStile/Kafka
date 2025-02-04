## Описание приложения

Приложение представляет собой простой пример использования Apache Kafka в Spring Boot. 
Оно включает в себя конфигурацию для Kafka Producer и Consumer, а также контроллер для отправки сообщений в Kafka.

### Установка и запуск

1. Убедитесь, что у вас установлен [Apache Kafka](https://kafka.apache.org/) 
и [Spring Boot](https://spring.io/projects/spring-boot).


2. Клонируйте репозиторий:
   ```
   git clone git@github.com:AlgosStile/Kafka.git
   ```
3. Перейдите в директорию проекта:
   ```
   cd kafka-example
   ```
4. Запустите приложение:
   ```
   ./mvnw spring-boot:run
   ```

### Конфигурация

- **Kafka Producer Configuration**:
- Сервер Kafka указан в файле `application.properties`.
- Используется `JsonSerializer` для сериализации объектов `UserDto`.

- **Kafka Consumer Configuration**:
- Используется `ErrorHandlingDeserializer` с настройкой `JsonDeserializer` для десериализации сообщений.
- Группа потребителей также задана в конфигурационном файле.

### Использование

- **Отправка сообщений**:
- Используйте API для отправки сообщений. Например, через POST-запрос на `/msg` с телом запроса в формате `UserDto`.

- **Обработка сообщений**:
- Приложение автоматически подписывается на топик `msg` и выводит полученные сообщения в консоль.

### Структура проекта

- `src/main/java/org/example/kafka/config`: Конфигурационные классы для Kafka Producer и Consumer.
- `src/main/java/org/example/kafka/controller`: Контроллер для отправки сообщений в Kafka.
- `src/main/java/org/example/kafka/dto`: DTO классы для передачи данных.
- `src/main/java/org/example/kafka`: Главный класс приложения с аннотацией `@SpringBootApplication`.

### Заметки

- Убедитесь, что Kafka broker запущен и доступен по указанному в конфигурации адресу.
- Проверьте, что топик `msg` создан и доступен для публикации и подписки.

### Ссылки

- [Документация Apache Kafka](https://kafka.apache.org/documentation/)
- [Документация Spring Kafka](https://docs.spring.io/spring-kafka/reference/html/)

---


