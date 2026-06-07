package ConfigurationJSON;

import ConfigurationJSON.KnowledgeBuilder.*;
import ConfigurationJSON.OperationalBuilder.FeatureDTO;
import ConfigurationJSON.OperationalBuilder.ObservationDTO;
import ConfigurationJSON.OperationalBuilder.OrderDTO;
import ConfigurationJSON.OperationalBuilder.ResourceDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

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
        mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(is, new TypeReference<>() {});
    }

    public ProductTypeDTO readProductJSON(String path) throws IOException {

        InputStream is = getClass().getResourceAsStream(path);

        if (is == null) {
            throw new IllegalArgumentException("Resource not found: " + path);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(is, ProductTypeDTO.class);
    }

    public ResourceDTO readResourceJSON(String path) throws IOException{

        InputStream is = getClass().getResourceAsStream(path);

        if (is == null) {
            throw new IllegalArgumentException("Resource not found: " + path);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(is, ResourceDTO.class);
    }

    public OrderDTO readOrderJSON(String path) throws IOException {

        InputStream is = getClass().getResourceAsStream(path);

        if (is == null) {
            throw new IllegalArgumentException("Resource not found: " + path);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(is, OrderDTO.class);
    }

    public ObservationDTO readObservationJSON(String path) throws IOException {

        InputStream is = getClass().getResourceAsStream(path);

        if (is == null) {
            throw new IllegalArgumentException("Resource not found: " + path);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(is, ObservationDTO.class);
    }

    public FeatureDTO readFeatureJSON(String path) throws IOException{

        InputStream is = getClass().getResourceAsStream(path);

        if (is == null) {
            throw new IllegalArgumentException("Resource not found: " + path);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(is, FeatureDTO.class);
    }
}
