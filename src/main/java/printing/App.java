package printing;

import java.nio.charset.StandardCharsets;

public final class App {
    public static void main(String[] args) {
        // Wiring (Dependency Injection)
        LegacyWordPrinter legacy = new LegacyWordPrinter("HP-4010");
        DocumentConverter<PdfDocument, WordDocument> converter = new PdfToWordConverter();
        Printer adapter = new PdfPrinterAdapter(legacy, converter);

        // Demo PDF (fake bytes)
        byte[] pdfBytes = "%PDF-1.7 sample content".getBytes(StandardCharsets.UTF_8);
        PdfDocument pdf = new PdfDocument("report.pdf", pdfBytes);

        // Client uses only Printer interface
        PrintService service = new PrintService(adapter);
        service.print(pdf);
    }
}
