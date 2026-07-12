# 🚗 Завод Texla — наследование и модификаторы доступа

## 📋 Задача
В коде смешались классы из двух проектов и пропали наследственные связи.
Нужно отсеять лишние классы и восстановить цепочку наследования.

---

## 🧩 Лишние классы

Убраны три класса которые не относятся к проекту:

- `Train` - поезд, не связан с автомобилями Texla
- `TexlaTruck` - грузовик, отдельная ветка которая не используется
- `ModelP` - другая модель, не участвует в тесте

---

## 🏗 Цепочка наследования
Transport


└── Automobile extends Transport


└── TexlaCar extends Automobile


└── ModelQ extends TexlaCar

Каждый уровень добавляет свою функциональность:

- `Transport` - базовые поля (speed, maxSpeed, acceleration, brakingSpeed)
  и методы (accelerate, brake)
- `Automobile` - добавляет колёса (4), направление и поворот
- `TexlaCar` - добавляет автопилот с отдельными настройками скорости
- `ModelQ` - конкретная модель с конкретными характеристиками

---

## 🧠 Теория

### Наследование цепочкой
```java
class ModelQ extends TexlaCar { }
// ModelQ наследует:
// - от TexlaCar: accelerateByAutopilot()
// - от Automobile: turnTo(), direction, wheelsNumber
// - от Transport: speed, maxSpeed, accelerate(), brake()
```
Каждый наследник получает всё что есть у всех родителей
по цепочке вверх.

### Модификаторы доступа в иерархии
```java
public double speed;        // Transport - доступно везде
protected String direction; // Automobile - доступно в наследниках
protected double autoPilotMaxSpeed; // TexlaCar - доступно в наследниках
```
`public` - доступно всем включая Practicum.
`protected` - доступно внутри класса и всем наследникам,
но не снаружи из чужих классов.

### Конструкторы в цепочке
```java
class Automobile extends Transport {
    public Automobile() {
        wheelsNumber = 4; // устанавливаем в конструкторе
    }
}

class ModelQ extends TexlaCar {
    public ModelQ() {
        speed = 0;
        maxSpeed = 300;      // характеристики конкретной модели
        acceleration = 100;
        brakingSpeed = 120;
    }
}
```
Каждый класс в конструкторе инициализирует свои данные.
ModelQ переопределяет значения из Transport под свои нужды.

---

## 🛠 Что использовал
- Цепочка наследования из 4 уровней
- `public` и `protected` модификаторы доступа
- Инициализация полей через конструкторы на разных уровнях
- Автопилот как расширение базового функционала Transport

---

## 💡 Вывод
Наследование позволяет строить иерархии от общего к частному.
Transport - самый общий класс с базовой логикой.
ModelQ - самый конкретный, знает только свои характеристики.
Всё остальное получает по цепочке от родителей.