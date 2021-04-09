package cn.iocoder.springboot.lab54.eventdemo.controller;

import cn.iocoder.springboot.lab54.eventdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(String username) {
        userService.register(username);
        return "success";
    }
//    @Scheduled(cron = "*/1 * * * * ?")
//    public void registerTask( ) {
//        String username="testName";
//        userService.register(username);
//    }

    /*@Scheduled(fixedDelay = 50L)
    public void registerTask2( ) {
        String username="testName2:"+System.nanoTime();
        userService.register(username);
    }*/

}
