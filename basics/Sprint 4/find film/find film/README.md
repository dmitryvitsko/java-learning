# 🎬 Фильмография актёров — equals, hashCode и HashMap

## 📋 Задача
Доработать классы Movie и Actor чтобы они корректно работали
как ключи в HashMap. Переопределить equals() и hashCode().

---

## 🧠 Теория

### Почему HashMap требует equals() и hashCode()
```java
HashMap<Actor, ArrayList<Movie>> filmography = new HashMap<>();
filmography.put(aDemyanenko, actorMovies);

// Ищем по НОВОМУ объекту с теми же данными
filmography.containsKey(new Actor("Александр", "Демьяненко"));
```
Это два разных объекта в памяти. Без переопределения
equals() и hashCode() HashMap не найдёт ключ - вернёт false.

### Как работает поиск в HashMap
1. Java считает hashCode() для ключа
2. Находит нужную корзину (bucket) в таблице
3. Сравнивает через equals() с объектами в этой корзине
4. Возвращает результат

Если hashCode() разный - объекты попадут в разные корзины
и equals() даже не вызовется. Поэтому оба метода важны.

### Правило: equals() и hashCode() всегда вместе
Если два объекта равны по equals() - у них ОБЯЗАТЕЛЬНО
должен быть одинаковый hashCode(). Иначе HashMap сломается.

### Реализация через Objects.hash() и Objects.equals()
```java
@Override
public int hashCode() {
    return Objects.hash(firstName, lastName);
}

@Override
public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Actor actor = (Actor) obj;
    return Objects.equals(firstName, actor.firstName)
        && Objects.equals(lastName, actor.lastName);
}
```
Objects.hash() и Objects.equals() - стандартный безопасный
способ реализации. Обрабатывают null автоматически.

### Порядок проверок в equals()
```java
if (obj == this) return true;   // 1. та же ссылка - точно равны
if (obj == null) return false;  // 2. null - не равны
if (getClass() != obj.getClass()) return false; // 3. разные классы
```
Порядок важен - проверка на null должна быть ДО getClass(),
иначе NullPointerException при вызове obj.getClass().

---

## 🛠 Что использовал
- `equals()` и `hashCode()` - переопределение для корректной
  работы объектов как ключей в HashMap
- `Objects.hash()` - генерация hashCode по нескольким полям
- `Objects.equals()` - null-безопасное сравнение строк
- `HashMap<Actor, ArrayList<Movie>>` - таблица фильмографии
- `HashMap<Movie, Double>` - таблица рейтингов

---

## 💡 Вывод
Любой класс который используется как ключ в HashMap
или хранится в HashSet - должен переопределять equals()
и hashCode(). Это фундаментальное правило Java.
В реальных проектах IDE генерирует эти методы автоматически,
но понимать как они работают - обязательно.
