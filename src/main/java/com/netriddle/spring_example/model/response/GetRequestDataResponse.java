package com.netriddle.spring_example.model.response;

import com.netriddle.spring_example.model.po.RequestData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GetRequestDataResponse extends RestResponse{
    private List<RequestData> requestDataList;
}
