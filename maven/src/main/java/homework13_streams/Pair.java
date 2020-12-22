package homework13_streams;

public class Pair {
    private final String lowerCase;
    private final String upperCase;

    public Pair(String lowerCase, String upperCase) {
        this.lowerCase = lowerCase;
        this.upperCase = upperCase;
    }

    @Override
    public String toString() {
        return "{" +
                '\"' + lowerCase + '\"' +
                ":\"" + upperCase + '\"' +
                '}';
    }
}
