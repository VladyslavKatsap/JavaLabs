package lab2;

import java.io.*;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtSerializer<T> implements Serializer<T> {

    private final DateTimeFormatter dateFormatter;

    public TxtSerializer() {
        dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    @Override
    public String serialize(T entity) {
        return entity.toString();
    }

    @Override
    public T deserialize(String data, Class<T> valueType) {
        String[] groups = data.substring(data.indexOf("'") + 1, data.lastIndexOf("'")).split(",");
        String name = groups[0].substring(0, groups[0].length() - 1);
        String date = groups[1].substring(groups[1].indexOf("'") + 1);
        try {
            Constructor<T> constructor = null;
            constructor = valueType.getDeclaredConstructor(String.class, LocalDate.class);
            return constructor.newInstance(name, LocalDate.parse(date));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void writeToFile(T entity, File file) {
        String txt = serialize(entity);

        try {
            Files.write(file.toPath(), txt.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T readFromFile(File file, Class<T> valueType) {
        String txt = null;
        try {
            txt = new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return deserialize(txt, valueType);
    }
}