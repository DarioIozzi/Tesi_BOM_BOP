package ConfigurationJSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class Configuration {

    public ProductTypeDTO readProductJSON(String path) throws IOException {

        InputStream is = getClass().getResourceAsStream(path);

        if (is == null) {
            throw new IllegalArgumentException("Resource not found: " + path);
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(is, ProductTypeDTO.class);
    }

    public ProcessTypeDTO readProcessJSON(String path) throws IOException {

        InputStream is = getClass().getResourceAsStream(path);

        if (is == null) {
            throw new IllegalArgumentException("Resource not found: " + path);
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(getClass().getResourceAsStream(path), ProcessTypeDTO.class);
    }
}
