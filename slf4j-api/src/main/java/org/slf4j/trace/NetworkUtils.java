package org.slf4j.trace;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Created by heyc on 2017/8/28.
 */
public class NetworkUtils {

    public static final String DEFAULT_IP_HEX;

    private static final String LOCAL_HOST;

    public static final String HOST;
    static {
        DEFAULT_IP_HEX = "7f000001";
        LOCAL_HOST = "127.0.0.1";
        HOST = getSiteIp();
    }

    /**
     * 获取内网IP
     * @return 内网IP
     */
    public static String getSiteIp() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface network = interfaces.nextElement();
                Enumeration<InetAddress> addresses = network.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    if (address.isSiteLocalAddress()) {
                        return address.getHostAddress();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LOCAL_HOST;
    }

    /**
     * 转换16进制
     * @param ipStr
     * @return
     */
    public static String ip2HexString(String ipStr){
        if (ipStr == null || "".equals(ipStr)){
            return DEFAULT_IP_HEX;
        }
        if (ipStr.contains(":")) {
            return DEFAULT_IP_HEX;
        }

        String[] ips = ipStr.split("\\.");

        return String.format("%02x",Integer.valueOf(ips[0])) +
                String.format("%02x",Integer.valueOf(ips[1])) +
                String.format("%02x",Integer.valueOf(ips[2])) +
                String.format("%02x",Integer.valueOf(ips[3]));
    }
}
