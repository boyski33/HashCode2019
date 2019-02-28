import com.github.NaivePetPictures;
import com.github.NaiveShinySelfies;
import com.github.execute.SolutionExecutor;
import com.github.io.InputDataSetReader;
import com.github.NaiveLovelyLandscapes;

import java.io.IOException;
import java.net.URISyntaxException;

public class Application {

    public static void main(String[] args) throws IOException, URISyntaxException {
        InputDataSetReader reader = new InputDataSetReader();

        NaiveLovelyLandscapes lovelyLandscapes = new NaiveLovelyLandscapes();
        NaivePetPictures petPictures = new NaivePetPictures();
        NaiveShinySelfies selfies = new NaiveShinySelfies();

        SolutionExecutor executor = new SolutionExecutor(10, lovelyLandscapes);

        executor.runAll();
    }
}
