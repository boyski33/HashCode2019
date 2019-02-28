package com.github.execute;

import com.github.DataSet;
import com.github.InterestResult;
import com.github.NaiveLovelyLandscapes;
import com.github.io.GenerateOutput;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Timestamp;

public class SolutionExecutor {
    private int runCount;
    private DataSet dataSet;
    private int maxScore = 0;
    InterestResult theResult;

    public SolutionExecutor(int runCount, DataSet dataSet) {
        this.runCount = runCount;
        this.dataSet = dataSet;
    }

    public void runAll() throws IOException, URISyntaxException {
        for (int i = 0; i < this.runCount; i++) {
            long startTime = System.nanoTime();
            InterestResult result = dataSet.run();

            if (result.score > maxScore) {
                maxScore = result.score;
                theResult = result;
            }

            long endTime = System.nanoTime();
            System.out.println((endTime - startTime) / 1_000_000_000);
        }

        new GenerateOutput().generate(dataSet.getClass().getName(), theResult.ids);
    }
}
