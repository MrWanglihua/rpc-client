package com.gupaoedu.rpc;

import java.lang.reflect.Proxy;

public class RpcProxyClient {

    public <T>T clientProxy(final Class<T> interfaceCla,final String host,final int port){

        return (T)Proxy.newProxyInstance(interfaceCla.getClassLoader(),
                new Class<?>[]{interfaceCla},new RemoteInvocationHandler(host,port));
    }
}
