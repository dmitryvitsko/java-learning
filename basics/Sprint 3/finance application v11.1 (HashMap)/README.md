# 💰 Финансовое приложение v11 — расширенный HashMap

## 📋 Задача
Расширение функциональности HashMap-приложения.
Новые методы: сумма всех трат, удаление категории,
поиск самой дорогой категории.

---

## 🧠 Теория

### values() - обход только значений без ключей
```java
for (ArrayList<Double> expList : expensesByCategories.values()) {
    for (double exp : expList) {
        totalSum += exp;
    }
}
```
keySet() возвращает ключи, values() возвращает значения.
Когда ключи не нужны - используй values(), это чище.

### Удаление категории по ключу
```java
if (expensesByCategories.containsKey(category)) {
    expensesByCategories.remove(category);
} else {
    System.out.println("Такой категории нет!");
}
```
Всегда проверяй наличие ключа перед удалением -
иначе remove() просто ничего не сделает без ошибки,
и пользователь не поймёт что пошло не так.

### Поиск максимума среди категорий
```java
double maxCategorySum = 0;
String maxCategoryName = "";

for (String category : expensesByCategories.keySet()) {
    double sumExpensesCategory = 0;
    for (Double expense : expensesByCategories.get(category)) {
        sumExpensesCategory += expense;
        if (sumExpensesCategory > maxCategorySum) {
            maxCategorySum = sumExpensesCategory;
            maxCategoryName = category;
        }
    }
}
```
Два накопителя: один для суммы (double), другой для названия (String).
Внешний цикл по категориям, внутренний считает сумму в категории.
Если сумма больше максимума - обновляем оба накопителя сразу.

---

## 🛠 Что использовал
- `values()` - обход значений HashMap без ключей
- `remove(key)` - удаление категории по ключу
- Два накопителя для поиска максимальной категории
- Вложенные циклы для агрегации данных по всей таблице

---

## 💡 Вывод
Три паттерна которые встречаются в реальных проектах постоянно:
агрегация данных по всей таблице (сумма, среднее, максимум),
удаление по ключу с проверкой, поиск лучшей категории.
В базах данных это делается через SQL GROUP BY и SUM -
но логика та же самая.