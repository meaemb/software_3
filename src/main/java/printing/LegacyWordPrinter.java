package printing;

import java.util.Objects;

/** Adaptee: legacy printer understands only WordDocument. */
public final class LegacyWordPrinter {
    private final String deviceId;

    public LegacyWordPrinter(String deviceId) {
        if (deviceId == null || deviceId.isBlank()) {
            throw new IllegalArgumentException("deviceId must not be blank");
        }
        this.deviceId = deviceId;
    }

    /** Prints Word documents only. */
    public void printWordDoc(WordDocument doc) {
        Objects.requireNonNull(doc, "doc");
        System.out.printf("[LegacyWordPrinter %s] Printing WORD: %s (%d bytes)%n",
                deviceId, doc.name(), doc.bytes().length);
        // ... real device-specific logic would be here
    }

    public String deviceId() { return deviceId; }
}
