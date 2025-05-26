package com.netriddle.spring_example.model.exception;

import com.netriddle.spring_example.model.response.RestResponse;
import lombok.*;
import com.netriddle.spring_example.model.response.Error;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CommonErrorResponse extends RestResponse {
    private Error error;
}
