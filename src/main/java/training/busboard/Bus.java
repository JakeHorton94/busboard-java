package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bus {
    public String lineName;
    public String destinationName;
    public int timeToStation;
}
