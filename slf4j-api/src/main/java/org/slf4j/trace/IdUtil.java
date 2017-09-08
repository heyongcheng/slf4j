package org.slf4j.trace;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by heyc on 2017/8/28.
 */
public class IdUtil {

    private AtomicInteger counter;

    private AtomicBoolean locker;

    private String serverIp;

    private static final int MAX_INDEX = 9999;

    private static IdUtil instance = new IdUtil();

    private IdUtil(){
        counter = new AtomicInteger(0);
        locker = new AtomicBoolean(true);
        serverIp = NetworkUtils.ip2HexString(NetworkUtils.HOST);
    }

    /**
     * 生成traceId
     * 服务器IP + 时间戳 + 序号 + 线程ID
     * @return
     */
    public static String getTraceId(){
        return instance.serverIp + System.currentTimeMillis() + String.format("%04d",instance.nextTicket()) + String.format("%04d",Thread.currentThread().getId());
    }

    /**
     * 获取计数器
     * @return
     */
    private Integer nextTicket(){
        for (;;){
            if (locker.compareAndSet(true,false)){
                if(counter.get() == MAX_INDEX){
                    counter.set(0);
                }
                int count = counter.incrementAndGet();
                locker.set(true);
                return count;
            }
        }
    }
}
