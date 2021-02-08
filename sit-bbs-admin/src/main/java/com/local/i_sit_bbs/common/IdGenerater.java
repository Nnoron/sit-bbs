/**
 * Copyright © 贵阳市委政法委 2019 Info. Tech Ltd. All rights reserved
 */
package com.local.i_sit_bbs.common;

import java.util.UUID;

/**
 * @ClassName:  IdGenerater
 * @Description: TODO
 * @Author: chen.dedao
 * @Date: 2019/8/27 13:24
 * @Version: 1.0.0
 */
public class IdGenerater {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
