package cn.iocoder.springboot.lab54.eventdemo.service;

import cn.iocoder.springboot.lab54.eventdemo.event.UserRegisterEvent;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class CouponService {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @EventListener
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Order(20)
    @Async
    public void addCoupon(UserRegisterEvent event) throws Exception {
        if(System.nanoTime()/Integer.valueOf(event.getUsername())==0){
            throw new Exception("test");
        }
        logger.info("[addCoupon][给用户({}) 发放优惠劵]", event.getUsername());
    }

}
