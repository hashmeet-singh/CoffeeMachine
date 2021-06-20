package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Map;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("machine")
public class Machine {
    @JsonProperty("outlets")
    private Outlet outlet;

    @JsonProperty("total_items_quantity")
    private Map<String, Integer> items;

    @JsonProperty("beverages")
    private Map<String, Map<String, Integer>> beverages;

    public Machine() {

    }

    public Machine(Outlet outlet, Map<String, Integer> items, Map<String, Map<String, Integer>> beverages) {
        this.outlet = outlet;
        this.items = items;
        this.beverages = beverages;
    }

    public Outlet getOutlet() {
        return outlet;
    }

    public void setOutlet(Outlet outlet) {
        this.outlet = outlet;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    public Map<String, Map<String, Integer>> getBeverages() {
        return beverages;
    }

    public void setBeverages(Map<String, Map<String, Integer>> beverages) {
        this.beverages = beverages;
    }
}
