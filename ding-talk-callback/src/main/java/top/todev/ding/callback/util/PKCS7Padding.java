package top.todev.ding.callback.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * <p>PKCS7Padding工具类</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-24 11:17
 * @since 0.0.1
 */
public class PKCS7Padding {
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private static final int BLOCK_SIZE = 32;

    public static byte[] getPaddingBytes(int count) {
        int amountToPad = 32 - count % 32;
        if (amountToPad == 0) {
            amountToPad = 32;
        }

        char padChr = chr(amountToPad);
        StringBuilder tmp = new StringBuilder();

        for (int index = 0; index < amountToPad; ++index) {
            tmp.append(padChr);
        }

        return tmp.toString().getBytes(CHARSET);
    }

    public static byte[] removePaddingBytes(byte[] decrypted) {
        int pad = decrypted[decrypted.length - 1];
        if (pad < 1 || pad > 32) {
            pad = 0;
        }

        return Arrays.copyOfRange(decrypted, 0, decrypted.length - pad);
    }

    private static char chr(int a) {
        byte target = (byte) (a & 255);
        return (char) target;
    }
}
