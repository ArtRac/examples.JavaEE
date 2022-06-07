package ejb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InfoTest
{
    @Test
    void itsTestExample()
    {
        assertEquals( "InfoBean.printInfo()", new Info().printInfo() );
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1", "test2"})
    void itsParameterizedTestExample(String input) {
        assertEquals( "InfoBean.printInfo()", new Info().printInfo() );
    }
}