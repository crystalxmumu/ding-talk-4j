package top.todev.ding.common.error;

/**
 * @author Daniel Qian
 */
public class DingErrorException extends Exception {
  private static final long serialVersionUID = -6357149550353160810L;

  private final DingError error;

  public DingErrorException(String message) {
    this(DingError.builder().errorCode(-1).errorMsg(message).build());
  }

  public DingErrorException(DingError error) {
    super(error.toString());
    this.error = error;
  }

  public DingErrorException(DingError error, Throwable cause) {
    super(error.toString(), cause);
    this.error = error;
  }

  public DingErrorException(Throwable cause) {
    super(cause.getMessage(), cause);
    this.error = DingError.builder().errorCode(-1).errorMsg(cause.getMessage()).build();
  }

  public DingError getError() {
    return this.error;
  }


}
