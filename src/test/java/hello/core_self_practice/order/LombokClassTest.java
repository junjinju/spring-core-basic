package hello.core_self_practice.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

@Getter
@Setter
@ToString
public class LombokClassTest {

    private Long id;
    private String name;

    @Test
    void lombokTest() {
        LombokClassTest lombokClassTest = new LombokClassTest();
        lombokClassTest.setId(1L);
        lombokClassTest.setName("test");
        System.out.println(lombokClassTest);
    }
}
