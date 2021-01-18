package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.person.Person;
import domain.person.PersonResult;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.io.InputStreamReader;

public class CreatePerson {

    public static PersonResult create() throws IOException {
        Person person = new Person();
        person.setAge("23");
        person.setName("test");
        person.setSalary("123");

        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writeValueAsString(person);


        HttpResponse response = Request.Post("http://dummy.restapiexample.com/api/v1/create")
                .bodyString(value, ContentType.APPLICATION_JSON)
                .execute().returnResponse();
        int statusCode = response.getStatusLine().getStatusCode();
        String content = IOUtils.toString(new InputStreamReader(response.getEntity().getContent()));
        PersonResult personResult = objectMapper.readValue(content, PersonResult.class);
        System.out.println(personResult);
        System.out.println("status:" + statusCode);
        return personResult;
    }
}
