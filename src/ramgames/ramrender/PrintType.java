package ramgames.ramrender;

public enum PrintType {
    INFO("Info", ""),
    ERROR("Error", "\u001B[31m");
    private final String name;
    private final String code;

    PrintType(String name, String colorCode) {
        this.name = name;
        this.code = colorCode;
    }

    String getName() {
        return this.name;
    }

    String getCode() {
        return this.code;
    }
}
