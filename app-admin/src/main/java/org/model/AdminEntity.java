package org.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminEntity {
    private String username;
    private String password;
}
