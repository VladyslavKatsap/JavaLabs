package lab2;

import java.io.File;

public interface Serializer<T> {

    String serialize(T entity);

    T deserialize(String data, Class<T> valueType);

    void writeToFile(T entity, File file);

    T readFromFile(File file, Class<T> valueType);
}