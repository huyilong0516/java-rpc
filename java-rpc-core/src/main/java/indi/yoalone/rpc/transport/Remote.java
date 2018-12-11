package indi.yoalone.rpc.transport;

import indi.yoalone.rpc.serialize.packet.RequestBody;
import indi.yoalone.rpc.serialize.packet.ResponseBody;

import java.io.IOException;

/**
 * Created by admin on 2018/12/10.
 */
public interface Remote {


    ResponseBody invoke(RequestBody body) throws IOException, ClassNotFoundException;
}
