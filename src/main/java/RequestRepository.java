import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
public class RequestRepository {

    String query = Main.userRequest;
    RestTemplate rest = new RestTemplate();
    PropertyHolder propertyHolder = new PropertyHolder();

    public HttpHeaders setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Authorization", propertyHolder.getAuthorizationToken());
        headers.add("count", "20");
        return headers;
    }

    String json = "{\n" +
            "  \"locations\": [\n" +
            "    {\n" +
            "      \"city_fias_id\": \"7dfa745e-aa19-4688-b121-b655c11e482f\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"from_bound\": {\n" +
            "    \"value\": \"street\"\n" +
            "  },\n" +
            "  \"to_bound\": {\n" +
            "    \"value\": \"street\"\n" +
            "  },\n" +
            "  \"restrict_value\": true,\n" +
            "  \"query\": \"" + query + "\"\n" +
            "}";
    HttpEntity<String> requestEntity = new HttpEntity<String>(json, setHeaders());
    ResponseEntity<String> responseEntity = rest.exchange(propertyHolder.getApiUrl(), HttpMethod.POST, requestEntity, String.class);


    String responseEntityBody = responseEntity.getBody();

    String getResponseEntityBody() {
        return responseEntityBody;
    }
}
