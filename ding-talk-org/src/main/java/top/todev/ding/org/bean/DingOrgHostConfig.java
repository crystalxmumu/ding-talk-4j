package top.todev.ding.org.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 钉钉接口地址域名部分的自定义设置信息.
 *
 * @author 小飞猪
 * @date 2020-12-14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DingOrgHostConfig {
  public static final String API_DEFAULT_HOST_URL = "https://oapi.dingtalk.com";
  /**
   * 对应于：https://oapi.dingtalk.com
   */
  private String apiHost;


  public static String buildUrl(DingOrgHostConfig hostConfig, String prefix, String path) {
    if (hostConfig == null) {
      return prefix + path;
    }

    if (hostConfig.getApiHost() != null && prefix.equals(API_DEFAULT_HOST_URL)) {
      return hostConfig.getApiHost() + path;
    }

    return prefix + path;
  }
}
