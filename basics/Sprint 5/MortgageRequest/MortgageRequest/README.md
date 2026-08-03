# 🏠 Валидация ипотечной заявки — обобщённые абстрактные классы

## 📋 Задача
Реализовать систему валидации ипотечной заявки через
цепочку правил, каждое из которых наследует общий
абстрактный класс с обобщённым типом.

---

## ⚙️ Функциональность
Три правила валидации проверяют:
- Возраст заявителя (от 18 лет)
- Сумму ипотеки (от 1.000.000 до 10.000.000)
- Трудоустроенность заявителя

Если хотя бы одно правило не пройдено - заявка отклоняется
с выводом соответствующего сообщения об ошибке.

---

## 🧠 Теория

### Абстрактный обобщённый класс как база правил
```java
public abstract class ValidationRule<T> {
    protected final T value;
    private final String errorMessage;

    protected ValidationRule(T value, String errorMessage) {
        this.value = value;
        this.errorMessage = errorMessage;
    }

    public abstract boolean isValid();
    public String getErrorMessage() { return errorMessage; }
}
```
Обобщённый параметр `T` позволяет одному классу работать
с разными типами данных - Byte, Integer, Boolean.
Метод isValid() абстрактный - каждый наследник реализует
свою логику проверки.

### Указание конкретного типа T в наследниках
```java
public class AgeValidationRule extends ValidationRule<Byte> {
    public AgeValidationRule(Byte age) {
        super(age, "Возраст для подачи на ипотеку должен быть старше 18 лет");
    }

    @Override
    public boolean isValid() {
        return value >= 18; // value уже типа Byte благодаря extends ValidationRule<Byte>
    }
}
```
Когда наследник указывает `extends ValidationRule<Byte>` -
унаследованное поле value автоматически становится типа Byte.
Создавать своё дублирующее поле не нужно - используется
родительское поле напрямую.

### Почему нельзя было оставить value как T без конкретизации
Без указания конкретного типа компилятор не знает что такое T -
может быть числом, строкой, чем угодно. Операции вроде
`value >= 18` требуют что T это именно числовой тип.
Явное указание `ValidationRule<Byte>`, `ValidationRule<Integer>`
решает эту проблему.

### Цепочка проверок в MortgageRequest
```java
AgeValidationRule ageValidationRule = new AgeValidationRule(age);
if (!ageValidationRule.isValid()) {
    result = false;
    System.out.println(ageValidationRule.getErrorMessage());
}
```
Каждое правило