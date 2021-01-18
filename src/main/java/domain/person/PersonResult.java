package domain.person;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonResult {

    private String status;
    @JsonProperty("data")
    private PersonData personResult;
    private String message;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PersonData getPersonResult() {
        return personResult;
    }

    public void setPersonResult(PersonData personResult) {
        this.personResult = personResult;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PersonResult{" +
                "status='" + status + '\'' +
                ", personResult=" + personResult +
                ", message='" + message + '\'' +
                '}';
    }
}
