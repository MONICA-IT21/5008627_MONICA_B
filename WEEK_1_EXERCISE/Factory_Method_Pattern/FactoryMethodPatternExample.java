package Factory_Method_Pattern;

abstract class Document {
    abstract void open();
}

class WordDocument extends Document {
    @Override
    void open() {
        System.out.println("Opening Word Document for you.");
    }
}

class PdfDocument extends Document {
    @Override
    void open() {
        System.out.println("Opening PDF Document for you.");
    }
}

class ExcelDocument extends Document {
    @Override
    void open() {
        System.out.println("Opening Excel Document for you.");
    }
}
