# 🎥 Калькулятор времени просмотра — интерфейсы и полиморфизм

## 📋 Задача
Посчитать сколько дней пользователь потратил на просмотр
фильмов и сериалов. Movie и Series хранятся в одном списке
через общий интерфейс MediaItem.

---

## 🧠 Теория

### Интерфейс как общий контракт
```java
public interface MediaItem {
    public int getRuntime();
    public String getTitle();
}
```
Интерфейс не говорит КАК получить runtime и title -
только что эти методы обязательно должны быть.
Movie и Series реализуют интерфейс каждый по-своему.

### List<MediaItem> хранит разные типы объектов
```java
List<MediaItem> mediaItems = new ArrayList<>();
mediaItems.add(new Movie(title, runtime));
mediaItems.add(new Series(title, runtime, seriesCount));
```
Movie и Series - разные классы, но оба implements MediaItem.
Поэтому оба помещаются в один список общего типа.
Это и есть полиморфизм на практике.

### instanceof для определения реального типа
```java
if (el instanceof Movie) {
    sumDays += (double) el.getRuntime();
} else {
    Series series = (Series) el;
    sumDays += (double) (series.getSeriesCount() * el.getRuntime());
}
```
Через MediaItem видны только getRuntime() и getTitle().
Но у Series есть свой уникальный метод getSeriesCount()
которого нет в интерфейсе. Чтобы его вызвать - нужно
проверить реальный тип через instanceof и явно привести
объект к Series.

### Приватный конструктор — класс-утилита
```java
public class Calculator {
    private Calculator() {}
    public static double calculate(List<MediaItem> mediaItems) { ... }
}
```
Приватный конструктор запрещает создание объектов Calculator.
Логично - у этого класса нет состояния, только один
статический метод-утилита. Создавать объекты незачем.

---

## 🛠 Что использовал
- `interface MediaItem` - общий контракт для Movie и Series
- `implements` - реализация интерфейса в двух разных классах
- `List<MediaItem>` - полиморфный список разнородных объектов
- `instanceof` + явное приведение типа - доступ к уникальным методам
- Приватный конструктор для класса-утилиты
- `final` поля - неизменяемые после создания объекта

---

## 💡 Вывод
Интерфейс решает задачу которая раньше казалась сложной -
как хранить в одном списке разные типы объектов и работать
с ними единообразно. instanceof + приведение типа нужны
только когда требуется что-то специфичное для конкретного класса.