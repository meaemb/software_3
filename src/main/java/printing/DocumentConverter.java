package printing;

/** Strategy for converting between document types. */
public interface DocumentConverter<S extends Document, T extends Document> {
    T convert(S source);
}
