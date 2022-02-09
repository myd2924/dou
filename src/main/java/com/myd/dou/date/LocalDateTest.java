package com.myd.dou.date;

import com.myd.dou.dto.DataDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/25 15:07
 * @Description: TODO
 */
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.atTime(0, 0, 0));
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.toLocalDate());

        System.out.println(LocalDateTime.now().plusDays(-1).withHour(0).withMinute(0).withSecond(0));

        DataDTO dataDTO = new DataDTO();
        dataDTO.setDateTime(LocalDateTime.now().plusDays(-1).withHour(0).withMinute(0).withSecond(0));
        System.out.println(dataDTO.getDateTime());

    }
}
