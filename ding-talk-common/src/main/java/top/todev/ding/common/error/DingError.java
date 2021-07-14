package top.todev.ding.common.error;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 钉钉开放平台接口错误码.
 * @author Daniel Qian Binary Wang
 */
@Data
@Builder
public class DingError implements Serializable {
  private static final long serialVersionUID = 7869786563361406291L;

  /**
   * 微信错误代码.
   */
  private int errorCode;

  /**
   * 微信错误信息.
   * （如果可以翻译为中文，就为中文）
   */
  private String errorMsg;

  /**
   * 微信接口返回的错误原始信息（英文）.
   */
  private String errorMsgEn;

  private String json;

  @Override
  public String toString() {
    if (this.json == null) {
      return "错误代码：" + this.errorCode + ", 错误信息：" + this.errorMsg;
    }

    return "错误代码：" + this.errorCode + ", 错误信息：" + this.errorMsg + "，微信原始报文：" + this.json;
  }

}
