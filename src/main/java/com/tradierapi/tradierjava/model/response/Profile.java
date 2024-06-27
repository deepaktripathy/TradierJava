package com.tradierapi.tradierjava.model.response;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tradierapi.tradierjava.model.Account;

/**
 * 
 * @author deepak tripathy created on 05/24/2024
 *
 */
public class Profile {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("account")
    private List<Account> accounts;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accounts, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return Objects.equals(accounts, other.accounts) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", accounts=" + accounts + "]";
	}
}