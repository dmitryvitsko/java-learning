# 🔐 PasswordStorageValidation — хранилище паролей с валидацией и обработкой ошибок

## 📋 Задача
Доработать приложение для хранения паролей пользователей: добавить собственное исключение для ошибок валидации имени, объявить проверяемые `IOException` в интерфейсе хранилища, реализовать валидатор имени, подключить его в общий список проверок и организовать корректную обработку ошибок и закрытие хранилища при любом сценарии выполнения.

---

## ⚙️ Функциональность
- `addUser()` — запрашивает имя и пароль, валидирует их и сохраняет в хранилище
- `showUserPassword()` — запрашивает имя, валидирует его и показывает сохранённый пароль
- `NameValidator` / `PasswordLengthValidator` / `PasswordStrengthValidator` — правила проверки введённых данных
- `ValidateNameException` / `ValidatePasswordException` — доменные исключения для конкретных ошибок валидации
- `PasswordMemoryStorage` — хранилище паролей в памяти с эмуляцией случайных ошибок ввода-вывода

---

## 🧠 Теория

### Иерархия исключений валидации
```java
public class ValidateException extends Exception { ... }
public class ValidateNameException extends ValidateException { ... }
public class ValidatePasswordException extends ValidateException { ... }
```
`ValidateNameException` и `ValidatePasswordException` — это два "листа" одного дерева исключений с общим предком `ValidateException`. Такая иерархия позволяет ловить либо конкретную ошибку (`catch (ValidateNameException e)`), либо любую ошибку валидации сразу (`catch (ValidateException e)`) — в зависимости от того, насколько детальной должна быть реакция.

### Интерфейс объявляет, что может пойти не так
```java
public interface PasswordStorage {
    void open() throws IOException;
    void store(String user, String password) throws IOException;
    String get(String user) throws IOException;
    void close();
}
```
`throws IOException` в сигнатуре интерфейса — это контракт: любая реализация хранилища обязана либо обработать ошибку ввода-вывода сама, либо явно передать её вызывающему коду. `close()` не объявляет исключений специально — закрытие ресурса не должно "падать" и мешать освобождению памяти.

### Валидатор имени по аналогии с валидатором пароля
```java
public class NameValidator implements Validator {
    @Override
    public void validate(final String value) throws ValidateException {
        if (value == null || value.isEmpty()) {
            throw new ValidateNameException("Имя не должно быть пустым");
        }
    }
}
```
`NameValidator` реализует общий интерфейс `Validator`, что позволяет добавлять его в список проверок наравне с валидаторами пароля и вызывать единообразно через `checkValidatorRules`, не заботясь о том, что именно проверяется внутри.

### Список валидаторов как настраиваемый набор правил
```java
private static final List<Validator> nameValidators = List.of(new NameValidator());
```
Список, а не одиночный объект — потому что правил проверки может быть несколько (как для пароля: длина + сложность). Добавление нового правила не требует изменения кода, который эти правила применяет.

### try-catch-finally: сначала конкретное, потом общее, потом гарантированное закрытие
```java
try {
    storage.open();
    ...
} catch (ValidateNameException e) {
    System.out.println("Ошибка валидации имени: " + e.getMessage());
} catch (ValidatePasswordException e) {
    System.out.println("Ошибка валидации пароля: " + e.getMessage());
} catch (ValidateException e) {
    System.out.println("Ошибка валидации: " + e.getMessage());
} catch (IOException e) {
    System.out.println("Ошибка работы с хранилищем: " + e.getMessage());
} finally {
    storage.close();
}
```
Порядок веток `catch` важен: более специфичные исключения (`ValidateNameException`, `ValidatePasswordException`) должны идти раньше своего общего родителя (`ValidateException`) — иначе до них просто не дойдёт очередь. Блок `finally` гарантирует, что `storage.close()` вызовется в любом случае — успешно ли прошла операция, произошла ли ошибка валидации или сбой ввода-вывода.

---

## 🛠 Что использовал
- Иерархию собственных проверяемых исключений (`ValidateException` → `ValidateNameException`, `ValidatePasswordException`)
- Интерфейсы `Validator` и `PasswordStorage` для единообразной работы с разными реализациями
- Явное объявление `throws IOException` в контракте хранилища
- Список валидаторов (`List<Validator>`) как расширяемый набор правил проверки
- Множественные блоки `catch` с порядком от частного к общему
- Блок `finally` для гарантированного освобождения ресурса

---

## 💡 Вывод
Задача демонстрирует связку из трёх практик обработки ошибок в Java: собственная иерархия исключений даёт точный контроль над тем, что именно пошло не так; интерфейсы с `throws` в сигнатуре делают контракт явным ещё на этапе компиляции; а `try-catch-finally` с закрытием ресурса в `finally` защищает от утечек даже при аварийном завершении метода.

---

## 🚀 Запуск

```bash
javac ValidateException.java ValidateNameException.java ValidatePasswordException.java PasswordStorage.java PasswordMemoryStorage.java Validator.java NameValidator.java PasswordLengthValidator.java PasswordStrengthValidator.java Practicum.java
java Practicum
```