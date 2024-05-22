package com.example.springopenapidemo.entity;

import java.io.Serializable;

/**
 * DTO for {@link Customer}
 */
public record CustomerSaveDto(String firstName, String lastName) implements Serializable {

}
