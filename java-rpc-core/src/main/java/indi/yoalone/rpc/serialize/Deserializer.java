package indi.yoalone.rpc.serialize;

import indi.yoalone.rpc.serialize.packet.ResponseBody;

/**
 * @desc 反序列化接口
 * @author Yoalone<huyilong0516@aliyun.com>
 * @since 2018-12-11 17:21:22
 */
public interface Deserializer {

    Object deserialize(ResponseBody body);
}
