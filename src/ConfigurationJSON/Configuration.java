package ConfigurationJSON;

import ConfigurationJSON.OperationalBuilder.OrderDTO;
import ConfigurationJSON.KnowledgeBuilder.FeatureTypeDTO;
import ConfigurationJSON.KnowledgeBuilder.ProcessTypeDTO;
import ConfigurationJSON.KnowledgeBuilder.ProductTypeDTO;
import ConfigurationJSON.KnowledgeBuilder.ResourceTypeDTO;
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

    public ResourceTypeDTO readResourceJSON(String path) throws IOException {

        InputStream is = getClass().getResourceAsStream(path);

        if (is == null) {
            throw new IllegalArgumentException("Resource not found: " + path);
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(is, ResourceTypeDTO.class);
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
