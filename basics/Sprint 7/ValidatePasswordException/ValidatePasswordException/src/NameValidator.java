public class NameValidator implements Validator {
    @Override
    public void validate(final String value) throws ValidateException {
        if (value == null || value.isEmpty()) {
            throw new ValidateNameException("Имя не должно быть пустым");
        }
    }
}