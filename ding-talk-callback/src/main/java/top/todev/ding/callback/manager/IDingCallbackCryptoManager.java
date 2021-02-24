package top.todev.ding.callback.manager;

import top.todev.ding.callback.bean.response.CallbackResponseBodyVO;
import top.todev.ding.callback.exception.DingTalkEncryptException;

import java.util.Map;

/**
 * <p>钉钉回调加解密工具接口</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-24 11:14
 * @since 0.0.1
 */
public interface IDingCallbackCryptoManager {

    /**
     * <p>将和钉钉开放平台同步的消息体加密,返回加密实体</p>
     * @param data 消息体
     * @return 加密后的对象
     * @throws DingTalkEncryptException 加密异常
     * @author 小飞猪
     * @date 2021/2/24 11:26
     * @since 0.0.1
     */
    CallbackResponseBodyVO getEncryptedResponse(Object data) throws DingTalkEncryptException;

    /**
     * <p>将和钉钉开放平台同步的消息体加密,返回加密Map</p>
     * @param plaintext 传递的消息体明文
     * @return 加密Map
     * @throws DingTalkEncryptException 加密异常
     * @author 小飞猪
     * @date 2021/2/24 11:23
     * @since 0.0.1
     */
    Map<String, String> getEncryptedMap(String plaintext) throws DingTalkEncryptException;

    /**
     * 将和钉钉开放平台同步的消息体加密,返回加密Map
     * @param plaintext 传递的消息体明文
     * @param timeStamp 时间戳
     * @param nonce     随机字符串
     * @return 加密Map
     * @throws DingTalkEncryptException 加密异常
     */
    Map<String, String> getEncryptedMap(String plaintext, Long timeStamp, String nonce) throws DingTalkEncryptException;

    /**
     * 密文解密
     * @param msgSignature 签名串
     * @param timeStamp    时间戳
     * @param nonce        随机串
     * @param encryptMsg   密文
     * @return 解密后的原文
     * @throws DingTalkEncryptException 加解密异常
     */
    String getDecryptMsg(String msgSignature, String timeStamp, String nonce, String encryptMsg) throws DingTalkEncryptException;

    /**
     * 数字签名
     * @param token     isv token
     * @param timestamp 时间戳
     * @param nonce     随机串
     * @param encrypt   加密文本
     * @return 签名
     * @throws DingTalkEncryptException 加密异常
     */
    String getSignature(String token, String timestamp, String nonce, String encrypt) throws DingTalkEncryptException;
}
