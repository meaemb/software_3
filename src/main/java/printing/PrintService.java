package printing;

import java.util.Objects;

public final class PrintService {
    private final Printer printer;

    public PrintService(Printer printer) {
        this.printer = Objects.requireNonNull(printer, "printer");
    }

    public void print(Document document) {
        System.out.println("[Service] Submitting job...");
        printer.safePrint(document);
        System.out.println("[Service] Job finished\n");
    }

}
