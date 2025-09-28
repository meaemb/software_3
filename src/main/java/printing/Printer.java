package printing;

import java.util.Objects;

/** Target interface expected by the client. */
public interface Printer {
    /** Print a document using the printer's native capabilities. */
    void print(Document document);

    /** Optional: null-safe wrapper. */
    default void safePrint(Document document) {
        print(Objects.requireNonNull(document, "document"));
    }
}
