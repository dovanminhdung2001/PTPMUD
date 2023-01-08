package org.example.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FilterCheckinReq {
    private String from;
    private String to;
    private String id;
}
