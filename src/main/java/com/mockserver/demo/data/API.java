package com.mockserver.demo.data;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "api")
public class API {
    @Id
    public String uuid;
    private String endpointName;
    private int httpCode;
    private String responseBody;
}
