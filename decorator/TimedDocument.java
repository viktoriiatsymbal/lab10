package lab10.decorator;
import java.time.Duration;
import java.time.LocalTime;

import lombok.AllArgsConstructor;

// import org.w3c.dom.Document;

@AllArgsConstructor
public class TimedDocument implements Document {
    private Document document;

    @Override
    public String parse() {
        LocalTime startTime = LocalTime.now();

        String result = document.parse();
        
        LocalTime endTime = LocalTime.now();

        System.out.println("Time: " + 
            Duration.between(startTime, endTime).getSeconds());
        return result;
        // return document.parse();
    }

    public String getGcsPath() {
        return document.getGcsPath();
    }
}
