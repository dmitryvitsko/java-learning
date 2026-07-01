# 💰 Финансовое приложение v10 — траты по категориям

## 📋 Задача
Замена ArrayList на HashMap. Теперь траты хранятся по категориям.
Ключ - название категории, значение - список трат в ней.

---

## 🧠 Теория

### HashMap<String, ArrayList<Double>>
```java
HashMap<String, ArrayList<Double>> expensesByCategories = new HashMap<>();
```
Ключ - категория (String): "Еда", "Дом", "Здоровье".
Значение - список трат в этой категории (ArrayList<Double>).

### Проверка наличия ключа перед добавлением
```java
if (expensesByCategories.containsKey(category)) {
    // категория уже есть - добавляем в существующий список
    expensesByCategories.get(category).add(expense);
} else {
    // категории нет - создаём новый список и кладём в таблицу
    ArrayList<Double> expenses = new ArrayList<>();
    expenses.add(expense);
    expensesByCategories.put(category, expenses);
}
```
Это ровно та же логика что и в разменном автомате монет.
containsKey() - проверяем есть ли ключ.
get() - достаём значение по ключу.
put() - кладём новый ключ со значением.

### Два вложенных цикла для обхода HashMap
```java
for (String category : expensesByCategories.keySet()) {
    System.out.println(category);
    for (double exp : expensesByCategories.get(category)) {
        System.out.println(exp);
    }
}
```
keySet() - возвращает все ключи HashMap.
Внешний цикл идёт по категориям.
Внутренний цикл идёт по тратам внутри категории.

### Поиск максимума в конкретной категории
```java
if (expensesByCategories.containsKey(category)) {
    for (double exp : expensesByCategories.get(category)) {
        if (exp > maxExpense) maxExpense = exp;
    }
} else {
    System.out.println("Такой категории пока нет.");
}
```
Сначала проверяем что категория существует.
Потом ищем максимум только внутри неё.

---

## 🛠 Что использовал
- `HashMap<String, ArrayList<Double>>` - таблица категорий и трат
- `containsKey()` - проверка существования категории
- `get()` - получение списка по категории
- `put()` - добавление новой категории со списком
- `keySet()` - получение всех ключей для обхода
- `clear()` - очистка всей таблицы

---

## 💡 Вывод
HashMap решает задачу группировки данных по признаку.
Паттерн "проверь ключ - добавь в существующее или создай новое"
встречается в реальных проектах постоянно.
Это основа для понимания как устроены кэши, корзины,
группировки данных в Spring и базах данных.