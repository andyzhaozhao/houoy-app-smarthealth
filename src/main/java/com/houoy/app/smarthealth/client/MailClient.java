package com.houoy.app.smarthealth.client;

import com.houoy.common.mail.MailVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author andyzhao
 * @create 2017-04-13 15:10
 **/
@FeignClient(name = "notificationapi", url = "${url.notificationapi}")
@RequestMapping(value = "/notification", produces = {"application/json;charset=UTF-8"})
@Component
public interface MailClient {
    @RequestMapping(value = "/sendSimpleMail", method = RequestMethod.POST)
    Boolean sendSimpleMail(@RequestBody MailVO mail);


    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    Boolean sendMail(@RequestBody MailVO mail);

}
