package printing;

import java.util.Objects;

/** Represents a PDF document in memory. */
public final class PdfDocument implements Document {
    private final String name;
    private final byte[] bytes;

    public PdfDocument(String name, byte[] bytes) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
        this.name = name;
        this.bytes = Objects.requireNonNull(bytes, "bytes").clone();
    }

    @Override public String name() { return name; }

    public byte[] bytes() { return bytes.clone(); }
}
