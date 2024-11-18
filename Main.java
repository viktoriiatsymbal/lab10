package lab10;

import lab10.decorator.MockedDocument;
// import lab10.decorator.SmartDocument;
import lab10.decorator.TimedDocument;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // SmartDocument smartDocument = new SmartDocument("https://upload.wikimedia.org/wiktionary/uk/b/bc/Wiki.png");
        // smartDocument.parse();
        MockedDocument mockedDocument = new MockedDocument("gs://cv-examples/wiki.png");
        System.out.println(mockedDocument.parse());

        TimedDocument timedDocument = new TimedDocument(mockedDocument);
        System.out.println(timedDocument.parse());
    }
}