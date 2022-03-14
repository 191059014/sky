package com.hb.sky.admin.config;

import com.hb.sky.common.container.DropdownRegister;
import com.hb.sky.common.enums.IsValidEnum;
import com.hb.sky.config.enums.ConfigStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 启动即执行
 *
 * @author Mr.huang
 * @date 2022/3/13
 */
@Slf4j
@Component
public class SkyAdminRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        registerDropdowns();
    }

    private void registerDropdowns() {
        Arrays.stream(IsValidEnum.values()).forEach(e -> DropdownRegister.register("isValid", e.getDesc(), e.getValue()));
        Arrays.stream(ConfigStatusEnum.values()).forEach(e -> DropdownRegister.register("configStatus", e.getDesc(), e.getValue()));
        log.info("Dropdown register complete");
    }

}
