package top.todev.ding.callback.util;

import java.util.Random;

/**
 * <p>工具类</p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-24 11:17
 * @since 0.0.1
 */
public class Utils {

    public static String getRandomStr(int count) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; ++i) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }

        return sb.toString();
    }

    public static byte[] int2Bytes(int count) {
        byte[] byteArr = new byte[]{(byte) (count >> 24 & 255), (byte) (count >> 16 & 255), (byte) (count >> 8 & 255),
                (byte) (count & 255)};
        return byteArr;
    }

    public static int bytes2int(byte[] byteArr) {
        int count = 0;

        for (int i = 0; i < 4; ++i) {
            count <<= 8;
            count |= byteArr[i] & 255;
        }

        return count;
    }
}
