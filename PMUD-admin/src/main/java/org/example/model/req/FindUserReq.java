package org.example.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindUserReq {
    private String id;
    private String name;
    private String phone;
}
