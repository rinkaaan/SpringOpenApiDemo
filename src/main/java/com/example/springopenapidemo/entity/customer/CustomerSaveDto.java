package com.example.springopenapidemo.entity.customer;

import java.io.Serializable;

/**
 * DTO for {@link Customer}
 */
public record CustomerSaveDto(String firstName, String lastName) implements Serializable {

}
