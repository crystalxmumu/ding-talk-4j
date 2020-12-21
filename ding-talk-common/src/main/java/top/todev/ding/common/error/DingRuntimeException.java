package top.todev.ding.common.error;

/**
 * WxJava专用的runtime exception.
 * @author 小飞猪
 * @date 2020-12-14
 */
public class DingRuntimeException extends RuntimeException {
  private static final long serialVersionUID = 4881698471192264412L;

  public DingRuntimeException(Throwable e) {
    super(e);
  }

  public DingRuntimeException(String msg) {
    super(msg);
  }

  public DingRuntimeException(String msg, Throwable e) {
    super(msg, e);
  }
}
