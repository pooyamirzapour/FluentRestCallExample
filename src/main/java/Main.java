import service.GetEmployee;
import service.CreatePerson;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        GetEmployee.get();
        CreatePerson.create();
    }
}
