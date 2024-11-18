package lab10.decorator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MockedDocument implements Document{
    public String gcsPath;

    @Override
    public String parse() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'parse'");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        return "Mocked Parse Result";

    }

}
