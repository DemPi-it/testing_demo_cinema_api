package endpoints;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Endpoints {
    add("/add"),
    getById("/id/"),
    all("/all"),
    deleteById("/delete/%d");
    private final String endpoint;

    public String getEndpoint(int id) {
        return endpoint + id;
    }
    public String getEndpoint() {
        return endpoint;
    }
}
