package lab2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TxtS implements Serializer{

    @Override
    public <T> void serialize(T entity, String filename) throws IOException {
        String data = entity.toString();
        Files.write(Paths.get(filename),data.getBytes());
    }

    @Override
    public <T> T deserialize( String filename, Class<T> entityType) throws IOException {
        byte[] data = Files.readAllBytes(Paths.get(filename));
        String dataString = new String(data);

        try {
            T entity = entityType.getConstructor(String.class).newInstance(dataString);
            return entity;
        } catch (Exception e) {
            throw new IOException("Error deserializing object", e);
        }
    }
    }
