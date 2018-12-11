package indi.yoalone.rpc.serialize;

import indi.yoalone.rpc.serialize.packet.ResponseBody;

/**
 * Created by admin on 2018/12/10.
 */
public interface Deserializer {

    Object deserialize(ResponseBody body);
}
