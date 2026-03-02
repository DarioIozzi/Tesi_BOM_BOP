package ConfigurationJSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Configuration {

    public void readProductJSON(){

        ObjectMapper mapper = new ObjectMapper();

        try{
            ProductTypeDTO ptd = mapper.readValue(new File("Product.json"), ProductTypeDTO.class);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readProcessJSON(){
        ObjectMapper mapper = new ObjectMapper();

        try{
            ProcessTypeDTO ptd = mapper.readValue(new File("Process.json"), ProcessTypeDTO.class);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
