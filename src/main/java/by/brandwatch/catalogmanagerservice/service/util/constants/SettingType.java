package by.brandwatch.catalogmanagerservice.service.util.constants;

public enum SettingType {

    BODY_TYPE("Тип корпуса"),
    BRAND("Бренд"),
    CATEGORY("Категория"),
    COLOR("Цвет"),
    MECHANISM("Механизм");

    private final String stringValue;

    SettingType(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
