package com.zyhy.disposal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuheyi on 2019/5/21.
 */

@RestController
public class DisposalController {

    // 服务可用的探针
    @RequestMapping(value = "/api/health/check")
    public String check_api_health() throws Exception {
        return "200";
    }


}
