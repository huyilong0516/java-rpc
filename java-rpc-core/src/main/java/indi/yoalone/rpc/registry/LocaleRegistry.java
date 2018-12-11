package indi.yoalone.rpc.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @desc 本地缓存容器
 * @author Yoalone<huyilong0516@aliyun.com>
 * @since 2018-12-11 17:21:22
 */
public class LocaleRegistry {

    private final static Map<String, Object> objectsMap = new ConcurrentHashMap<String, Object>();

    public static Object register(String className, Object object){
        return objectsMap.put(className, object);
    }

    public static boolean containsKey(String className) {
        return objectsMap.containsKey(className);
    }

    public static Object get(String className){
        return objectsMap.get(className);
    }
}
