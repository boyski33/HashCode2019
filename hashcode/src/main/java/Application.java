import com.github.InputDataSetReader;

import java.io.IOException;
import java.net.URISyntaxException;

public class Application {

    public static void main(String[] args) throws IOException, URISyntaxException {
        InputDataSetReader reader = new InputDataSetReader();

        System.out.println(reader.read("a_example.txt"));

    }
}
