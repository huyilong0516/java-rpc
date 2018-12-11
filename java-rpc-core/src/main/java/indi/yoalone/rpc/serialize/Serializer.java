package indi.yoalone.rpc.serialize;

import indi.yoalone.rpc.serialize.packet.RequestBody;

import java.lang.reflect.Method;

/**
 * Created by admin on 2018/12/10.
 */
public interface Serializer {

    RequestBody serialize(Method method, Object[] args) throws IllegalAccessException, InstantiationException;
}
