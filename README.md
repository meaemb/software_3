# Printer Adapter (Java)

## Problem
The client prints PDF documents via the `Printer` interface, but the available device only accepts Word documents.  
We need an Adapter that converts PDF → Word and delegates the printing.

## Roles
- **Target:** `Printer`
- **Adaptee:** `LegacyWordPrinter` (prints Word only)
- **Adapter:** `PdfPrinterAdapter` (accepts PDF, converts, delegates)
- **Converter:** `PdfToWordConverter` (Single Responsibility Principle)

## How to Run
- Requires **Java 17+**
- Run `printing.App` (the `main` method)
- Expected output:
