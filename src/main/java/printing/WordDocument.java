package printing;

import java.util.Objects;

/** Represents a Word (DOCX-like) document. */
public final class WordDocument implements Document {
    private final String name;
    private final byte[] bytes;

    public WordDocument(String name, byte[] bytes) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
        this.name = name;
        this.bytes = Objects.requireNonNull(bytes, "bytes").clone();
    }

    @Override public String name() { return name; }

    public byte[] bytes() { return bytes.clone(); }
}
