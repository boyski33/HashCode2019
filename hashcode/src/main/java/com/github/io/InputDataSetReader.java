package com.github.io;

import com.github.Picture;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class InputDataSetReader {

    public List<Picture> read(String filename) throws IOException, URISyntaxException {

        URL resource = this.getClass().getResource("/" + filename);
        URI uri = resource.toURI();
        final Path path = Paths.get(uri);

        return Files.lines(path)
                .skip(1)
                .map(Picture::fromInputLine)
                .collect(Collectors.toList());
    }

}
