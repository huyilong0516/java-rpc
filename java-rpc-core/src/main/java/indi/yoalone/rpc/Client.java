package indi.yoalone.rpc;

import indi.yoalone.rpc.serialize.proxy.InvocationProxy;


/**
 * @desc 消费端
 * @author Yoalone<huyilong0516@aliyun.com>
 * @since 2018-12-11 17:21:22
 */
public class Client {

    private String host;

    private int port;

    private InvocationProxy invocationProxy;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
        this.invocationProxy = new InvocationProxy(this.host, this.port);
    }

    public <T> T getService(Class<T> clazz) {
        return invocationProxy.get(clazz);
    }
}
