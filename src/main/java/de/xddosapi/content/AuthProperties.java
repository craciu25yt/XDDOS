package de.xddosapi.content;

import de.xddosapi.utils.Files;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Getter
@Setter
public class AuthProperties {

    private final Properties properties;

    public AuthProperties() throws IOException {
        this.properties = new Properties();
        final File directory = new File("./XDDOS-API/");
        if (!directory.exists()) directory.mkdirs();
        final File configFile = Files.saveResource(directory, "config.properties", "config.properties", false);
        final BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(configFile));

        this.properties.load(bufferedInputStream);
    }
}
