package indi.yoalone.rpc.serialize.support;

import indi.yoalone.rpc.serialize.Deserializer;
import indi.yoalone.rpc.serialize.packet.ResponseBody;

/**
 * @desc 反序列化简单实现
 * @author Yoalone<huyilong0516@aliyun.com>
 * @since 2018-12-11 17:21:22
 */
public class DefaultDeserializer implements Deserializer{


    public Object deserialize(ResponseBody body) {
        if (body == null){
            return null;
        }

        return body.getResponseData();
    }
}
