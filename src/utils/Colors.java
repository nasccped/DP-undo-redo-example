package utils;

/**
 * Colors util (avoid ansi escape conding).
 */
public enum Colors {
    RED,
    GREEN,
    YELLOW,
    MAGENTA,
    WHITE,
    OTHER_CASE,
    RESET;

    @Override
    public String toString() {
        switch (this) {
            case RED:     return "\u001b[91m";
            case GREEN:   return "\u001b[92m";
            case YELLOW:  return "\u001b[93m";
            case MAGENTA: return "\u001b[95m";
            case WHITE:   return "\u001b[97m";
            case RESET:   return "\u001b[0m";
            // other case
            default:      return "\u001b[93;41m";
        }
    }
}
