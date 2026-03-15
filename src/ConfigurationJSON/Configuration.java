package ConfigurationJSON;

import ConfigurationJSON.KnowledgeBuilder.*;
import ConfigurationJSON.OperationalBuilder.OrderDTO;
import ConfigurationJSON.OperationalBuilder.ResourceDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Configuration {

    public List<ProductTypeDTO> readProductListJSON(String path) throws IOException {

        InputStream is = getClass().getResourceAsStream(path);

        if (is == null) {
            throw new IllegalArgumentException("Resource not found: " + path);
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(is, new TypeReference<>() {});
    }

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
        return mapper.readValue(is, ProcessTypeDTO.class);
    }

    public FeatureTypeDTO readFeatureJSON(String path) throws IOException {

        InputStream is = getClass().getResourceAsStream(path);

        if (is == null) {
            throw new IllegalArgumentException("Resource not found: " + path);
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(is, FeatureTypeDTO.class);
    }

    public ResourceTypeDTO readResourceTypeJSON(String path) throws IOException {

        InputStream is = getClass().getResourceAsStream(path);

        if (is == null) {
            throw new IllegalArgumentException("Resource not found: " + path);
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(is, ResourceTypeDTO.class);
    }

    public ResourceDTO readResourceJSON(String path) throws IOException{

        InputStream is = getClass().getResourceAsStream(path);

        if (is == null) {
            throw new IllegalArgumentException("Resource not found: " + path);
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(is, ResourceDTO.class);
    }

    public OrderDTO readOrderJSON(String path) throws IOException {

        InputStream is = getClass().getResourceAsStream(path);

        if (is == null) {
            throw new IllegalArgumentException("Resource not found: " + path);
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(is, OrderDTO.class);
    }
}
