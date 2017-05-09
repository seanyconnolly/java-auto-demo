package io.shaneconnolly.java.auto.demo.framework.customassertions;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by ubuntu on 09/05/17.
 */
public class CustomerAssertions {

    public static void assertClick(Boolean actual){
        assertThat(actual).isTrue();
    }

}
