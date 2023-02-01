package edu.neu.coe.csye6225.webapp.model;


import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
	@Column(nullable = false)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@JdbcTypeCode(SqlTypes.CHAR)
    private UUID id;

	@JsonProperty("username")
    @Email(message = "Username/Email is not in format, please check")
    private String username;
	
	@JsonProperty("first_name")
    @Column(name="first_name")
    @NotEmpty(message="First Name cannot be null/empty")
    private String firstName;

	@JsonProperty("last_name")
    @Column(name="last_name")
    @NotEmpty(message="Last Name cannot be null/empty")
    private String lastName;


    @JsonProperty("password")
    @NotEmpty(message="Password cannot be null/empty")
    private String password;

    @JsonProperty(value ="account_created",access = JsonProperty.Access.READ_ONLY)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="account_created")
    private LocalDateTime accountCreated;

    @JsonProperty(value = "account_updated",access = JsonProperty.Access.READ_ONLY)
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="account_updated")
    private LocalDateTime accountUpdated;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getAccountCreated() {
		return accountCreated;
	}

	public void setAccountCreated(LocalDateTime accountCreated) {
		this.accountCreated = accountCreated;
	}

	public LocalDateTime getAccountUpdated() {
		return accountUpdated;
	}

	public void setAccountUpdated(LocalDateTime accountUpdated) {
		this.accountUpdated = accountUpdated;
	}

    
}