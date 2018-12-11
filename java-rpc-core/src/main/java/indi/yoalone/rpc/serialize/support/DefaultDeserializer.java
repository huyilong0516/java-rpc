package indi.yoalone.rpc.serialize.support;

import indi.yoalone.rpc.serialize.Deserializer;
import indi.yoalone.rpc.serialize.packet.ResponseBody;

/**
 * Created by admin on 2018/12/10.
 */
public class DefaultDeserializer implements Deserializer{


    public Object deserialize(ResponseBody body) {
        if (body == null){
            return null;
        }

        return body.getResponseData();
    }
}
