package indi.yoalone.rpc.api.demo;

import java.util.List;

/**
 * Created by admin on 2018/12/11.
 */
public interface IHelloService {

    String sayHello(String msg);


    List<String> array2List(String[] strings);
}
