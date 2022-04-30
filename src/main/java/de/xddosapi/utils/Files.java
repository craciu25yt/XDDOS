package de.xddosapi.utils;

import java.io.*;

public class Files {

    public static File saveResource(final File outputDirectory, final String name, final String resource, final boolean replace)
            throws IOException {
        final File out = new File(outputDirectory, name);
        if (!replace && out.exists())
            return out;
        final InputStream resourceStream = Files.class.getClassLoader().getResourceAsStream(resource);
        if (resourceStream == null)
            throw new FileNotFoundException(resource + " (resource not found)");
        try (final OutputStream writer = new FileOutputStream(out)) {
            copyStream(resourceStream, writer);
            writer.close();
        }
        return out;
    }

    private static void copyStream(final InputStream inputStream, final OutputStream outputStream) throws IOException {
        final byte[] buffer = new byte[4096];
        int length;
        while ((length = inputStream.read(buffer)) > 0)
            outputStream.write(buffer, 0, length);
    }
}
