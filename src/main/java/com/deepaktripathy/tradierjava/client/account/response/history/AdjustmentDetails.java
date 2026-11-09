package com.deepaktripathy.tradierjava.client.account.response.history;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Deepak Tripathy
 *
 */
public class AdjustmentDetails {
    @JsonProperty("description")
    private String description;

    @JsonProperty("quantity")
    private Double quantity;

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }
}
