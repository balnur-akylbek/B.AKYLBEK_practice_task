package utils;

public final class ScenarioContext {
    private ScenarioContext() {}

    private static final ThreadLocal<String> ORIGINAL_WINDOW = new ThreadLocal<>();

    public static void setOriginalWindow(String handle) {
        ORIGINAL_WINDOW.set(handle);
    }

    public static String getOriginalWindow() {
        return ORIGINAL_WINDOW.get();
    }

    public static void clear() {
        ORIGINAL_WINDOW.remove();
    }
}
