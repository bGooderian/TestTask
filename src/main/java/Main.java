import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String userRequest;

    public static void main(String[] args) throws IOException {
        while (true) {
            userRequest = new Scanner(System.in).nextLine();
            RequestRepository requestRepository = new RequestRepository();
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Suggestion suggestion = mapper.readValue(requestRepository.getResponseEntityBody(), Suggestion.class);
            System.out.println("Количество совпадений: " + suggestion.getSuggestions().size());
            for (int i = 0; i < suggestion.getSuggestions().size(); i++) {
                System.out.println(suggestion.getSuggestions().get(i));
            }
        }
    }
}
