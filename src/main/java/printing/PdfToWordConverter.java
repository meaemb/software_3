package printing;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/** Fake converter for demo purposes. Replace with a real library if needed. */
public final class PdfToWordConverter implements DocumentConverter<PdfDocument, WordDocument> {

    @Override
    public WordDocument convert(PdfDocument source) {
        Objects.requireNonNull(source, "source");
        byte[] pdfBytes = source.bytes();
        byte[] header = ("DOCX-from-PDF:" + source.name() + ":").getBytes(StandardCharsets.UTF_8);
        byte[] merged = new byte[header.length + pdfBytes.length];
        System.arraycopy(header, 0, merged, 0, header.length);
        System.arraycopy(pdfBytes, 0, merged, header.length, pdfBytes.length);

        String docxName = source.name().replaceAll("\\.pdf$", ".docx");
        return new WordDocument(docxName, merged);
    }
}
