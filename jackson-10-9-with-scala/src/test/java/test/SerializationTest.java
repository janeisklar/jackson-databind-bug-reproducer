package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.scala.DefaultScalaModule;
import org.junit.jupiter.api.Test;
import test.model.GetInGetter;
import test.model.IsInGetter;
import test.model.SetInSetter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerializationTest {

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.registerModule(new DefaultScalaModule());
    }

    @Test
    void setInSetterTest() throws Exception {
        // Given
        final SetInSetter dto = new SetInSetter();
        dto.settlementDate("foo");

        // When
        final String json = mapper.writeValueAsString(dto);

        // Then
        assertEquals("{\"settlementDate\":\"foo\"}", json);

        // When
        final SetInSetter dto2 = mapper.readValue(json, SetInSetter.class);

        // Then
        assertEquals(dto, dto2);
    }

    @Test
    void getInGetterTest() throws Exception {
        // Given
        final GetInGetter dto = new GetInGetter();
        dto.getaways("foo");

        // When
        final String json = mapper.writeValueAsString(dto);

        // Then
        assertEquals("{\"getaways\":\"foo\"}", json);

        // When
        final GetInGetter dto2 = mapper.readValue(json, GetInGetter.class);

        // Then
        assertEquals(dto, dto2);
    }

    @Test
    void isInGetterTest() throws Exception {
        // Given
        final IsInGetter dto = new IsInGetter();
        dto.island(true);

        // When
        final String json = mapper.writeValueAsString(dto);

        // Then
        assertEquals("{\"island\":true}", json);

        // When
        final IsInGetter dto2 = mapper.readValue(json, IsInGetter.class);

        // Then
        assertEquals(dto, dto2);
    }
}
