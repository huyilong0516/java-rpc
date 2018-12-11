package indi.yoalone.rpc.serialize.packet;

import java.io.Serializable;

/**
 * @desc 返回实体
 * @author Yoalone<huyilong0516@aliyun.com>
 * @since 2018-12-11 17:21:22
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
