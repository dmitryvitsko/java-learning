# 💰 FinancialCalculatorException — калькулятор сложных процентов с обработкой ошибок

## 📋 Задача
Доработать калькулятор сложных процентов: написать собственные классы-исключения для двух разных ситуаций — некорректный ввод данных и превышение лимита попыток — и подключить их обработку к существующей логике программы.

---

## ⚙️ Функциональность
- `getDoubleLimited(String greeting, int attempts)` — запрашивает у пользователя дробное число с ограничением попыток
- `getIntLimited(String greeting, int attempts)` — запрашивает у пользователя целое число с ограничением попыток
- `getInterest(rate, time, principal)` — считает итоговую выгоду по формуле сложного процента
- `InputException` — исключение для некорректно введённых данных
- `LimitException` — исключение для превышения лимита попыток ввода

---

## 🧠 Теория

### Два разных типа ошибок — два разных родителя
```java
public class InputException extends Exception { ... }
public class LimitException extends RuntimeException { ... }
```
`InputException` — проверяемое (checked) исключение: ошибка одной конкретной попытки ввода, которую вызывающий код обязан обработать сразу же, рядом с местом её возникновения. `LimitException` — непроверяемое (unchecked) исключение: критическая ситуация "пользователь исчерпал все попытки", которая всплывает наверх по стеку вызовов до самого `main()`, где её и стоит ловить.

### LimitException хранит дополнительные данные
```java
public class LimitException extends RuntimeException {
    private final int attempts;

    public LimitException(String message, int attempts) {
        super(message);
        this.attempts = attempts;
    }

    public int getAttempts() {
        return attempts;
    }
}
```
Помимо текста сообщения, исключению нужно передать количество попыток — для этого в конструкторе появляется дополнительный параметр `attempts` и приватное поле с геттером. Текст ошибки уходит в `super(message)` — так работает стандартный механизм `Exception`/`RuntimeException`.

### Вложенный try-catch: сначала ловим конкретное, потом бросаем общее
```java
for (int counter = 0; counter < attempts; counter++) {
    try {
        try {
            final int value = Integer.parseInt(scanner.nextLine());
            if (value < 0) {
                throw new InputException("Введено отрицательное значение");
            }
            return value;
        } catch (NumberFormatException exception) {
            throw new InputException("Введено не число");
        }
    } catch (InputException exception) {
        System.out.println("Ошибка ввода: " + exception.getMessage());
    }
}
throw new LimitException("Превышен лимит ошибок ввода", attempts);
```
Внутренний `try-catch` ловит "техническую" `NumberFormatException` от `Integer.parseInt` и превращает её в "доменную" `InputException` — так весь код выше работает с одним понятным типом ошибки, а не с набором разных стандартных исключений. Внешний `catch` перехватывает `InputException`, печатает сообщение и позволяет циклу дать ещё одну попытку. Если попытки закончились, а `return` внутри цикла так и не сработал — после цикла бросается `LimitException`.

### Обработка в main() — там, где решение принимается окончательно
```java
public static void main(String[] args) {
    try {
        calculate();
    } catch (LimitException exception) {
        System.out.println(exception.getMessage() + ": " + exception.getAttempts());
    }
}
```
`LimitException` не ловится внутри `getIntLimited`/`getDoubleLimited` — она осознанно "пробрасывается" наверх, потому что решение "что делать, если лимит превышен" относится к точке входа в программу, а не к конкретному методу запроса числа.

---

## 🛠 Что использовал
- Собственные классы-исключения: `InputException extends Exception` и `LimitException extends RuntimeException`
- Передачу дополнительных данных через конструктор исключения (`attempts`)
- Вложенные `try-catch` для преобразования стандартных исключений в доменные
- Цикл `for` как счётчик оставшихся попыток
- Централизованную обработку критической ошибки в `main()`

---

## 💡 Вывод
Разделение исключений на checked (`InputException`) и unchecked (`RuntimeException`-наследник `LimitException`) — это способ явно показать в коде разницу между "ожидаемой, локально исправимой ошибкой" и "критической ситуацией, которую нужно решать выше по цепочке вызовов". Собственные классы исключений вместо стандартных делают код понятнее: `catch (LimitException e)` говорит само за себя, в отличие от generic `catch (RuntimeException e)`.

---

## 🚀 Запуск

```bash
javac FinancialCalculatorException.java InputException.java LimitException.java
java FinancialCalculatorException
```