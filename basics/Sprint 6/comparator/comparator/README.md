# 🎬 DateTime Comparator

## 📋 Описание

В приложении по прокату фильмов необходимо корректно сравнивать даты и время.

Для решения задачи реализован класс `DateTimeComparator`, который имплементирует интерфейс `Comparator<DateTime>`.

Компаратор последовательно сравнивает два объекта `DateTime` по всем полям:

- Год
- Месяц
- День
- Часы
- Минуты
- Секунды

---

## 🛠 Используемые технологии

- Java
- ООП
- Generics
- `Comparator<T>`
- `Integer.compare()`

---

## 📁 Структура проекта

├── Main.java

├── DateTime.java

├── DateTimeComparator.java

└── RentedFilm.java


---

## 🔍 Логика сравнения

Метод `compare()` возвращает:

| Результат              | Значение                                      |
|------------------------|-----------------------------------------------|
| **отрицательное число** | первая дата **раньше** второй                 |
| **0**                  | даты **полностью совпадают**                  |
| **положительное число** | первая дата **позже** второй                  |

Сравнение происходит последовательно:


---

## 💻 Пример использования

```java
DateTime today = new DateTime(26, 11, 2021, 23, 58, 58);

DateTimeComparator comparator = new DateTimeComparator();

boolean shouldAlreadyBeReturned =
    comparator.compare(today, film1.getTimeOfReturn()) > 0;