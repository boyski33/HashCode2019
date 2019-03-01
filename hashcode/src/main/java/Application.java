import com.github.NaiveMemorableMoments;
import com.github.NaivePetPictures;
import com.github.algorithm.NaiveRandomAlgorithm;
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
        NaiveMemorableMoments memorableMoments = new NaiveMemorableMoments();
        NaivePetPictures petPictures = new NaivePetPictures(new NaiveRandomAlgorithm(1_000_000));
        NaiveShinySelfies selfies = new NaiveShinySelfies();

        SolutionExecutor executor = new SolutionExecutor(5, petPictures);

        executor.runAll();
    }
}
