package com.myd.dou.barcode;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.IntStream;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/10/29 14:29
 * @Description: TODO
 */
public class BarCodeUtils {
    private static final int[] BAR_CODE_LEN = {8, 12, 13, 14, 17, 18};

    private BarCodeUtils() {
    }

    public static boolean isBarCode(final String barCode) {
        if (!StringUtils.isNumeric(barCode) || !ArrayUtils.contains(BAR_CODE_LEN, StringUtils.length(barCode))) {
            return false;
        }
        final int len = StringUtils.length(barCode);
        // 每位的数据相加：长度为奇数位，则奇数位乘3，偶数位乘1；反之，长度为偶数位，则偶数位乘3，奇数位乘1
        int checkSum = IntStream.range(0, len - 1).map(i -> ((i & 1) == (len & 1) ? 3 : 1) * Character.getNumericValue(barCode.charAt(i))).sum();
        checkSum = (10 - checkSum % 10) % 10;
        return Character.getNumericValue(barCode.charAt(len - 1)) == checkSum;
    }
}
