package org.lili.forfun.spring.traning.api;

import lombok.extern.log4j.Log4j2;
import org.lili.forfun.spring.traning.service.TranscationInspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lili
 * @date 2020/1/9 23:20
 * @description 查看事务相关属性
 */
@Component
@Log4j2
@RestController
@RequestMapping("/transcationApi")
public class TranscationInspectApi extends BaseApi {

    @Autowired
    private TranscationInspectService transcationInspectService;

    @GetMapping("/programatic")
    public RequestResult<Void> programatic() {
        try {
            transcationInspectService.programatic();
            return succ();
        } catch (Exception e) {
            log.error("programatic error:", e);
            return error(e.getMessage());
        }
    }

    @GetMapping("/template")
    public RequestResult<Void> template() {
        try {
            transcationInspectService.template();
            return succ();
        } catch (Exception e) {
            log.error("template error:", e);
            return error(e.getMessage());
        }
    }

    @GetMapping("/annotation")
    public RequestResult<Void> annotation() {
        try {
            transcationInspectService.annotation();
            return succ();
        } catch (Exception e) {
            log.error("annotation error:", e);
            return error(e.getMessage());
        }
    }
}
