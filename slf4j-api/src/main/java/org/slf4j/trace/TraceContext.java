package org.slf4j.trace;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by heyc on 2017/8/29.
 */
public class TraceContext {
    /**  trace_id   **/
    private static ThreadLocal<String> TRACE_ID = new InheritableThreadLocal<String>();
    /**  span_id  **/
    private static ThreadLocal<String> SPAN_ID = new InheritableThreadLocal<String>();
    /** NEXT_LEVEL_SPAN_INDEX **/
    private static ThreadLocal<Map<String,AtomicInteger>> NEXT_LEVEL_SPAN_INDEX = new InheritableThreadLocal<Map<String,AtomicInteger>>();
    /** trace_id_key **/
    public static final String TRACE_ID_KEY = "traceId";
    /** span_id_key **/
    public static final String SPAN_ID_KEY = "spanId";
    /** 客户端/消费者发起请求 **/
    public static final String CLIENT_SEND = "cs";
    /** 客户端/消费者接收到应答 **/
    public static final String CLIENT_RECV = "cr";
    /** 服务端/生产者接收到请求 **/
    public static final String SERVER_RECV = "sr";
    /** 服务端/生产者发送应答 **/
    public static final String SERVER_SEND = "ss";
    /** 是否开启记录跟踪 **/
    private static volatile boolean traceEnable = true;

    /**
     * 获取traceId
     * @return
     */
    public static String getTraceId(){
        return TRACE_ID.get();
    }

    /**
     * createTraceId
     * @return
     */
    public static String createTraceId(){
        return IdUtil.getTraceId();
    }

    /**
     * setTraceId
     * @param traceId
     * @return
     */
    public static String setTraceId(String traceId){
        if (traceId != null){
            TRACE_ID.set(traceId);
        }else {
            TRACE_ID.remove();
        }
        return traceId;
    }

    public static boolean isTraceEnable(){
        return traceEnable;
    }

    public static void setTraceEnable(boolean traceEnable) {
        TraceContext.traceEnable = traceEnable;
    }

    /**
     * getSpanId
     * @return
     */
    public static String getSpanId(){
        return SPAN_ID.get();
    }

    /**
     * setSpanId
     * @param spanId
     * @return
     */
    public static String setSpanId(String spanId){
        if (spanId != null){
            SPAN_ID.set(spanId);
        }else {
            SPAN_ID.remove();
        }
        return spanId;
    }

    /**
     * nextSpan
     * @return
     */
    public static String nextSpan(){
        String spanId = getSpanId();
        return nextSpan(spanId == null ? "0.0" : spanId);
    }

    /**
     * nextSpan
     * @return
     */
    public static String nextSpan(String currentSpan){
        try {
            int index = currentSpan.lastIndexOf(".");
            if (index != -1){
                return nextLevelSpan(currentSpan.substring(0,index));
            }
            return currentSpan;
        }catch (Exception e){
            return "0";
        }
    }

    /**
     * nextLevelSpan
     * @return
     */
    public static String nextLevelSpan(){
        String spanId = getSpanId();
        return nextLevelSpan(spanId == null ? "0" : spanId);
    }

    /**
     * 下一级span
     * @param currentSpan
     * @return
     */
    public static String nextLevelSpan(String currentSpan){
        try {
            if (currentSpan == null){
                return "0.1";
            }
            Map<String, AtomicInteger> map = NEXT_LEVEL_SPAN_INDEX.get();
            AtomicInteger atomic;
            if (map == null){
                map = new ConcurrentHashMap<String, AtomicInteger>();
                atomic = new AtomicInteger(0);
                map.put(currentSpan,atomic);
                NEXT_LEVEL_SPAN_INDEX.set(map);
            }else {
                atomic = map.get(currentSpan);
            }
            if (atomic == null){
                atomic = new AtomicInteger(0);
                map.put(currentSpan,atomic);
            }
            return setSpanId(currentSpan + "." + atomic.incrementAndGet());
        }catch (Exception e){
            return "0";
        }
    }

    /**
     * clear
     */
    public static void clear(){
        TRACE_ID.remove();
        SPAN_ID.remove();
        NEXT_LEVEL_SPAN_INDEX.remove();
    }

    public static void main(String[] args) {
        System.out.println(nextLevelSpan());
        System.out.println(nextLevelSpan());
        System.out.println(nextSpan());
        System.out.println(nextLevelSpan());
    }

}
