package com.melita.ordertrackingapi.utils;

import com.melita.ordertrackingapi.dto.CustomerDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class JsonUtilTest {

    @Test
    void testStringify_validInput() {
        CustomerDto customer = CustomerDto
                .builder()
                .address("Dressrosa")
                .email("doflamingo@gmail.com")
                .firstname("Doflamingo")
                .lastname("Donquixote")
                .telephone("2335479852")
                .build();
        String expected = "{\"id\":0" +
               ",\"firstname\":\"Doflamingo\",\"lastname\":\"Donquixote\",\"telephone\":\"2335479852\"," +
                "\"email\":\"doflamingo@gmail.com\",\"address\":\"Dressrosa\"}";
        String result = JsonUtil.stringify(customer);
        assertEquals( result,expected);
    }
}