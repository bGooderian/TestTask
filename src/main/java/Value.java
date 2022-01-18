import com.fasterxml.jackson.annotation.JsonProperty;

public class Value {
    @JsonProperty("value") public String value;
    @JsonProperty("unrestricted_value") public String unrestrictedValue;

    public Value() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
