package com.github.execute;

import com.github.DataSet;
import com.github.NaiveLovelyLandscapes;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Timestamp;

public class SolutionExecutor {
    private int runCount;
    private DataSet dataSet;

    public SolutionExecutor(int runCount, DataSet dataSet) {
        this.runCount = runCount;
        this.dataSet = dataSet;
    }

    public void runAll() throws IOException, URISyntaxException {
        for (int i = 0; i < this.runCount; i++) {
            long startTime = System.nanoTime();
            dataSet.run();
            long endTime = System.nanoTime();
            System.out.println((endTime - startTime) / 1_000_000_000);
        }

    }
}
