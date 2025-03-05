package utils;
import java.util.UUID;

public class UuidFormat {
    public String formatMessage() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
