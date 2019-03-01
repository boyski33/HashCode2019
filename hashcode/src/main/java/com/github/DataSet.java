package com.github;

import java.io.IOException;
import java.net.URISyntaxException;

public interface DataSet {
    InterestResult run() throws IOException, URISyntaxException;
}
