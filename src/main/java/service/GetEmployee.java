package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.employee.Employee;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.io.InputStreamReader;

public class GetEmployee {

    public static void get() throws IOException {
        String url = "http://dummy.restapiexample.com/api/v1/employee/1";
        HttpResponse response = Request.Get(url).execute().returnResponse();

        int statusCode = response.getStatusLine().getStatusCode();
        String content;
        content = IOUtils.toString(new InputStreamReader(response.getEntity().getContent()));
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = objectMapper.readValue(content, Employee.class);

        System.out.println(employee);
        System.out.println("status:"+ statusCode);
    }
}
