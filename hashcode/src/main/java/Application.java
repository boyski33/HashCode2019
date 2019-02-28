import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public class Application {

    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("dummy.in");
        System.out.println(Resources.toString(url, Charsets.UTF_8));
    }
}
