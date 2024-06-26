package generator;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import common.CommonFunctions;
import model.ContactDate;
import model.GroupDate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Generator {
    @Parameter(names={"--type", "-t"})
     String type;

    @Parameter (names={"--output", "-o"})
    String output;

    @Parameter (names={"--format", "-f"})
    String format;

    @Parameter (names={"--count", "-c"})
    int count;

    public static void main (String[] args) throws IOException {
      var generator =  new Generator();
        JCommander.newBuilder()
                   .addObject(generator)
                   .build()
                   .parse(args);
      generator.run();
    }

    private void run() throws IOException {
        var data = generate();
        save(data);
    }

    private void save(Object data) throws IOException {
        if ("json".equals(format)){
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
            var json =  mapper.writeValueAsString(data);
           try ( var writer = new FileWriter(output)){
               writer.write(json);

              // writer.close();
           }


    } else {
            throw  new IllegalArgumentException("неизвестный формат"+format);
        }
    }

    private Object generate() {
        if ("groups".equals(type)){
            return  generateGroups();

        } else if ("contacts".equals(type)){
            return generateContacts();
        }  else{
            throw new IllegalArgumentException("неизвестный тип данных" + type);
        }

    }

    private Object generateGroups() {
        var result = new ArrayList<GroupDate>();
        for (int i=0; i < count; i++) {
            result.add(new GroupDate()
                    .withName(CommonFunctions.randomString(i*10))
                    .withHeader(CommonFunctions.randomString(i*10))
                    .withFooter(CommonFunctions.randomString(i*10)));
        }
        return result;
    }

    private Object generateContacts() {
        var result = new ArrayList<ContactDate>();
        for (int i=0; i < count; i++) {
            result.add(new ContactDate()
                    .withlastname(CommonFunctions.randomString(i*10))
                    .withMiddlename(CommonFunctions.randomString(i*10))
                    .withFirstname(CommonFunctions.randomString(i*10)));
        }
        return result;
    }

}
