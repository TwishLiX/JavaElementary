package homework21_l10n.dto;

public enum Move {
    ROCK,
    PAPER,
    SCISSORS;

    public String toString() {
        return name().substring(0,1).toUpperCase() + name().substring(1).toLowerCase();
    }
}