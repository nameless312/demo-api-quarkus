package com.nameless.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PublisherDTO {
    private UUID publisherId;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String website;
    private String description;
}
