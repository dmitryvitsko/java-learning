# 🎒 Бюро находок — универсальные методы и Object

## 📋 Задача
Написать класс LostAndFoundOffice с универсальными методами
которые принимают объекты любых классов через тип Object.

---

## 🧠 Теория

### Object — родитель всех классов в Java
```java
ArrayList<Object> things = new ArrayList<>();
```
Object это корневой класс в Java - от него наследуются
абсолютно все классы. Ball, Accordion, Hat - все они Object.
Поэтому список ArrayList<Object> может хранить что угодно.

### Универсальный параметр через Object
```java
public void put(Object object) {
    things.add(object);
}

public boolean check(Object object) {
    return things.contains(object);
}
```
Методы принимают Object - значит им можно передать
экземпляр любого класса. Ball, Umbrella, Hat - всё подойдёт.

### contains() и null
```java
things.contains(object); // если object == null - вернёт false
```
ArrayList.contains() корректно обрабатывает null -
не выбросит NullPointerException, просто вернёт false.
Именно поэтому отдельная проверка на null не нужна.

### Сравнение объектов в contains()
```java
checkObject(hat, "Шляпа"); // hat не добавляли - вернёт false
checkObject(ball, "Мяч");  // ball добавляли - вернёт true
```
contains() сравнивает по ссылке на объект.
Две разные переменные с одинаковым классом - разные объекты.

---

## 🛠 Что использовал
- `ArrayList<Object>` - список который хранит любые объекты
- `Object` как универсальный тип параметра метода
- `contains()` для проверки наличия объекта в списке
- Обработка null без дополнительных проверок

---

## 💡 Вывод
Object как тип параметра - это способ сделать метод универсальным.
Но в современной Java для этого чаще используют дженерики (generics) -
они делают то же самое но с проверкой типов на этапе компиляции.