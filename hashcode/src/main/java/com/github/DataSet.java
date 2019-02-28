package com.github;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface DataSet {
    List<String> run() throws IOException, URISyntaxException;
}
