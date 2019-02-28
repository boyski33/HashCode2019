import com.github.io.InputDataSetReader;
import com.github.NaiveLovelyLandscapes;

import java.io.IOException;
import java.net.URISyntaxException;

public class Application {

    public static void main(String[] args) throws IOException, URISyntaxException {
        InputDataSetReader reader = new InputDataSetReader();

        NaiveLovelyLandscapes lovelyLandscapes = new NaiveLovelyLandscapes();

        lovelyLandscapes.run()
                .forEach(System.out::println);

    }
}
