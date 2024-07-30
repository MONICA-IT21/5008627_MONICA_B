package factorymethodpatternexample;

// Abstract product class
abstract class Document {
    abstract void open();
}

// Concrete product classes
class WordDocument extends Document {
    @Override
    void open() {
        System.out.println("Opening Word Document.");
    }
}

class PdfDocument extends Document {
    @Override
    void open() {
        System.out.println("Opening PDF Document.");
    }
}

class ExcelDocument extends Document {
    @Override
    void open() {
        System.out.println("Opening Excel Document.");
    }
}
