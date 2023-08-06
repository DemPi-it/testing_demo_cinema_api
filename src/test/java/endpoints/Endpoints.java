package endpoints;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Endpoints {
    add("/add"),
    getById("/id/"),
    all("/all"),
    email("/email/"),
    phoneNumber("/phone/"),
    update("/update/"),
    deleteById("/delete/");
    private final String endpoint;

    public String getEndpoint(int id) {
        return endpoint + id;
    }
    public String getEndpoint(String parameter) {
        return endpoint + parameter;
    }
    public String getEndpoint() {
        return endpoint;
    }
}
