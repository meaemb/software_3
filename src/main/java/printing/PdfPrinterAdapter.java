package printing;

import java.util.Objects;

/**
 * Adapter: makes a LegacyWordPrinter look like a generic Printer for PDFs.
 * - Client calls print(PdfDocument)
 * - Adapter converts PDF -> Word and delegates to LegacyWordPrinter
 */
public final class PdfPrinterAdapter implements Printer {
    private final LegacyWordPrinter legacy;
    private final DocumentConverter<PdfDocument, WordDocument> converter;

    public PdfPrinterAdapter(LegacyWordPrinter legacy,
                             DocumentConverter<PdfDocument, WordDocument> converter) {
        this.legacy = Objects.requireNonNull(legacy, "legacy");
        this.converter = Objects.requireNonNull(converter, "converter");
    }

    @Override
    public void print(Document document) {
        if (!(document instanceof PdfDocument pdf)) {
            throw new IllegalArgumentException("Adapter supports only PdfDocument");
        }
        System.out.println("[Adapter] Received PDF: " + pdf.name());
        WordDocument word = converter.convert(pdf);
        System.out.println("[Adapter] Converted to WORD: " + word.name() + " (" + word.bytes().length + " bytes)");
        legacy.printWordDoc(word);
    }

}
