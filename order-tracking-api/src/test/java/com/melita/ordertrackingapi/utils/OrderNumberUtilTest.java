package com.melita.ordertrackingapi.utils;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class OrderNumberUtilTest {

    @Test
    void testBuildingOrderNumber_checkIfFormatIsCorrect() {
        OrderNumberUtil util = new OrderNumberUtil();
        String orderNumber = util.get();
        assertNotNull(orderNumber);

        String prefix = "ORD-";
        assertTrue(orderNumber.startsWith(prefix));



//     Assert order number contains the current year, month, and day

        Calendar cal = Calendar.getInstance();
        String year = Integer.toString(cal.get(Calendar.YEAR));
        assertTrue(orderNumber.contains(year));

        String month = Integer.toString(cal.get(Calendar.MONTH));
        assertTrue(orderNumber.contains(month));

        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        assertTrue(orderNumber.contains(day));


//     Assert last $ digits of the order number is an integer between 1000 and 9999, inclusive.

        String dash = "-";
        String randomPart = orderNumber.substring(prefix.length() + year.length()
                + month.length() + day.length() + (3 * dash.length()));
        int randomValue = Integer.parseInt(randomPart);
        assertTrue(randomValue >= 1000 && randomValue <= 9999);
    }
}