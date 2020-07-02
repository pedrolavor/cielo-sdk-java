package cielo.sdk.superlink.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductFilter {

    @JsonProperty("pageSize")
    @SerializedName("pageSize")
    private Integer size;
    
    private Integer page;

    private String name;
    
}