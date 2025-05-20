package com.netriddle.spring_example.model.po;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestData {
    private String ip;
    private String timestamp;
}
