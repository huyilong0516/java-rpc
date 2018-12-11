package indi.yoalone.rpc.transport;

import indi.yoalone.rpc.serialize.packet.RequestBody;
import indi.yoalone.rpc.serialize.packet.ResponseBody;

import java.io.IOException;

/**
 * @desc 远程调用
 * @author Yoalone<huyilong0516@aliyun.com>
 * @since 2018-12-11 17:21:22
 */
public interface Remote {


    ResponseBody invoke(RequestBody body) throws IOException, ClassNotFoundException;
}
