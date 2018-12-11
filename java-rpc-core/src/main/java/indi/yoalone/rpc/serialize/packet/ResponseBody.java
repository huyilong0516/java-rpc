package indi.yoalone.rpc.serialize.packet;

import java.io.Serializable;

/**
 * Created by admin on 2018/12/10.
 */
public class ResponseBody implements Serializable{

    private Object responseData;

    private Class type;

    public Object getResponseData() {
        return responseData;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }
}
