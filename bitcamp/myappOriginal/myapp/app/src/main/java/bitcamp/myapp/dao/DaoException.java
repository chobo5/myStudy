package bitcamp.myapp.dao;

//이 클래스의 목적은 RuntimeException의 기능을 확장하는 것이 아닌
//어떤 작업에서 예외가 발생했는지 알기 위해 Exception명을 변경하기 위한 클래스이다.
public class DaoException extends RuntimeException {
    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
