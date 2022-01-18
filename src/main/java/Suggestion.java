import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Suggestion {


    @JsonProperty
    public ArrayList<Value> suggestions;

    public ArrayList<Value> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(ArrayList<Value> suggestions) {
        this.suggestions = suggestions;
    }

    @Override
    public String toString() {
        return suggestions.toString();
    }
}