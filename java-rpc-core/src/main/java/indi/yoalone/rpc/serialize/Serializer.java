package indi.yoalone.rpc.serialize;

import indi.yoalone.rpc.serialize.packet.RequestBody;

import java.lang.reflect.Method;

/**
 * @desc 序列化接口
 * @author Yoalone<huyilong0516@aliyun.com>
 * @since 2018-12-11 17:21:22
 */
public interface Serializer {

    RequestBody serialize(Method method, Object[] args) throws IllegalAccessException, InstantiationException;
}
