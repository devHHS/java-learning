public class LogLevel {

    static int getLogLevelSeverity(String level) {
        // TODO: switch expression으로 작성
        // "DEBUG" -> 0, "INFO" -> 1, "WARN" -> 2, "ERROR" -> 3, 그 외 -> -1
        return switch (level) {
            case "DEBUG" -> 0;
            case "INFO" -> 1;
            case "WARN" -> 2;
            case "ERROR" -> 3;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        System.out.println(getLogLevelSeverity("DEBUG"));
        System.out.println(getLogLevelSeverity("WARN"));
        System.out.println(getLogLevelSeverity("UNKNOWN"));
    }
}
