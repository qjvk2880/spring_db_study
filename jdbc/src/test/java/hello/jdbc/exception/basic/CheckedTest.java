package hello.jdbc.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class CheckedTest {


    @Test
    void checked_catch() {
        Service service = new Service();
        service.callCatch();

    }

    @Test
    void checked_throw() {
        Service service = new Service();
        Assertions.assertThatThrownBy(() -> service.callThrow())
                .isInstanceOf(MyCheckedExceiption.class);
    }

    // exception은 체크예외
    static class MyCheckedExceiption extends Exception {
        public MyCheckedExceiption(String message) {
            super(message);
        }
    }


    //    체크예외는 잡아서 처리 또는 throw 해야한다
    static class Service {
        Repository repository = new Repository();

        // 예외를 잡아서 처리하는 코드
        public void callCatch() {
            try {
                repository.call();
            } catch (MyCheckedExceiption e) {
                log.info("예외 처리, message={}", e.getMessage(), e);
            }
        }

        // 예외를 받지않고 throw
        public void callThrow() throws MyCheckedExceiption {
            repository.call();
        }
    }

    static class Repository {
        public void call() throws MyCheckedExceiption {
            throw new MyCheckedExceiption("ex");
        }
    }
}
