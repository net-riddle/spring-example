package com.netriddle.spring_example.model.response;

import com.netriddle.spring_example.model.po.RequestData;

import java.util.List;

public class GetRequestDataResponse extends RestResponse{
    private List<RequestData> requestDataList;

    public GetRequestDataResponse() {
    }

    public List<RequestData> getRequestDataList() {
        return requestDataList;
    }

    public void setRequestDataList(List<RequestData> requestDataList) {
        this.requestDataList = requestDataList;
    }
}
