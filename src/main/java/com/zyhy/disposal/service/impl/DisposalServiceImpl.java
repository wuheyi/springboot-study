package com.zyhy.disposal.service.impl;

import com.zyhy.disposal.service.DisposalService;
import org.springframework.stereotype.Service;

/**
 * Created by wuheyi on 2019/5/21.
 */

@Service
public class DisposalServiceImpl implements DisposalService {
    @Override
    public String disposal(String cmd) {
        return "ok";
    }
}
