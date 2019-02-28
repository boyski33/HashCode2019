package com.github.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class GenerateOutput {

    public void generate(String name, List<String> slides) throws IOException {
        File file = new File(name + ".out");
        file.createNewFile();
        Files.write(file.toPath(), List.of(String.valueOf(slides.size())));
        Files.write(file.toPath(), slides, StandardOpenOption.APPEND);
    }
}
