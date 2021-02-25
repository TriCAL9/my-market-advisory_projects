package api.my_market_advisor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor(staticName = "valueOf")
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Logo {
    private String url;
}
