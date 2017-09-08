package org.slf4j.trace;

import org.slf4j.Logger;
import org.slf4j.MDC;
import org.slf4j.Marker;

/**
 * Created by heyc on 2017/8/31.
 */
public class TraceLogger implements Logger {

  private final Logger logger;

  public TraceLogger(Logger logger){
    this.logger = logger;
  }

  private void mdcInject(){
    try{
      if (TraceContext.getTraceId() == null){
        TraceContext.setTraceId(IdUtil.getTraceId());
        TraceContext.setSpanId(TraceContext.nextSpan());
      }
      MDC.put(TraceContext.TRACE_ID_KEY, TraceContext.getTraceId());
      MDC.put(TraceContext.SPAN_ID_KEY, TraceContext.getSpanId());
    }catch (Exception e){
      logger.error("mdcInject error: {}",e.getMessage());
    }
  }

  @Override
  public String getName() {
    return logger.getName();
  }

  @Override
  public boolean isTraceEnabled() {
    return logger.isTraceEnabled();
  }

  @Override
  public void trace(String s) {
    mdcInject();
    logger.trace(s);
  }

  @Override
  public void trace(String s, Object o) {
    mdcInject();
    logger.trace(s,o);
  }

  @Override
  public void trace(String s, Object o, Object o1) {
    mdcInject();
    logger.trace(s,o,o1);
  }

  @Override
  public void trace(String s, Object... objects) {
    mdcInject();
    logger.trace(s,objects);
  }

  @Override
  public void trace(String s, Throwable throwable) {
    mdcInject();
    logger.trace(s,throwable);
  }

  @Override
  public boolean isTraceEnabled(Marker marker) {
    return logger.isTraceEnabled();
  }

  @Override
  public void trace(Marker marker, String s) {
    mdcInject();
    logger.trace(marker,s);
  }

  @Override
  public void trace(Marker marker, String s, Object o) {
    mdcInject();
    logger.trace(marker,s,o);
  }

  @Override
  public void trace(Marker marker, String s, Object o, Object o1) {
    mdcInject();
    logger.trace(marker,s,o,o1);
  }

  @Override
  public void trace(Marker marker, String s, Object... objects) {
    mdcInject();
    logger.trace(marker,s,objects);
  }

  @Override
  public void trace(Marker marker, String s, Throwable throwable) {
    mdcInject();
    logger.trace(marker,s,throwable);
  }

  @Override
  public boolean isDebugEnabled() {
    return logger.isDebugEnabled();
  }

  @Override
  public void debug(String s) {
    mdcInject();
    logger.debug(s);
  }

  @Override
  public void debug(String s, Object o) {
    mdcInject();
    logger.debug(s,o);
  }

  @Override
  public void debug(String s, Object o, Object o1) {
    mdcInject();
    logger.debug(s,o,o1);
  }

  @Override
  public void debug(String s, Object... objects) {
    mdcInject();
    logger.debug(s,objects);
  }

  @Override
  public void debug(String s, Throwable throwable) {
    mdcInject();
    logger.debug(s,throwable);
  }

  @Override
  public boolean isDebugEnabled(Marker marker) {
    return logger.isDebugEnabled(marker);
  }

  @Override
  public void debug(Marker marker, String s) {
    mdcInject();
    logger.debug(marker,s);
  }

  @Override
  public void debug(Marker marker, String s, Object o) {
    mdcInject();
    logger.debug(marker,s,o);
  }

  @Override
  public void debug(Marker marker, String s, Object o, Object o1) {
    mdcInject();
    logger.debug(marker,s,o,o1);
  }

  @Override
  public void debug(Marker marker, String s, Object... objects) {
    mdcInject();
    logger.debug(marker,s,objects);
  }

  @Override
  public void debug(Marker marker, String s, Throwable throwable) {
    mdcInject();
    logger.debug(marker,s,throwable);
  }

  @Override
  public boolean isInfoEnabled() {
    return logger.isInfoEnabled();
  }

  @Override
  public void info(String s) {
    mdcInject();
    logger.info(s);
  }

  @Override
  public void info(String s, Object o) {
    mdcInject();
    logger.info(s,o);
  }

  @Override
  public void info(String s, Object o, Object o1) {
    mdcInject();
    logger.info(s,o,o1);
  }

  @Override
  public void info(String s, Object... objects) {
    mdcInject();
    logger.info(s,objects);
  }

  @Override
  public void info(String s, Throwable throwable) {
    mdcInject();
    logger.info(s,throwable);
  }

  @Override
  public boolean isInfoEnabled(Marker marker) {
    return logger.isInfoEnabled(marker);
  }

  @Override
  public void info(Marker marker, String s) {
    mdcInject();
    logger.info(marker,s);
  }

  @Override
  public void info(Marker marker, String s, Object o) {
    mdcInject();
    logger.info(marker,s,o);
  }

  @Override
  public void info(Marker marker, String s, Object o, Object o1) {
    mdcInject();
    logger.info(marker,s,o,o1);
  }

  @Override
  public void info(Marker marker, String s, Object... objects) {
    mdcInject();
    logger.info(marker,s,objects);
  }

  @Override
  public void info(Marker marker, String s, Throwable throwable) {
    mdcInject();
    logger.info(marker,s,throwable);
  }

  @Override
  public boolean isWarnEnabled() {
    return logger.isWarnEnabled();
  }

  @Override
  public void warn(String s) {
    mdcInject();
    logger.warn(s);
  }

  @Override
  public void warn(String s, Object o) {
    mdcInject();
    logger.warn(s,o);
  }

  @Override
  public void warn(String s, Object... objects) {
    mdcInject();
    logger.warn(s,objects);
  }

  @Override
  public void warn(String s, Object o, Object o1) {
    mdcInject();
    logger.warn(s,o,o1);
  }

  @Override
  public void warn(String s, Throwable throwable) {
    mdcInject();
    logger.warn(s,throwable);
  }

  @Override
  public boolean isWarnEnabled(Marker marker) {
    return logger.isWarnEnabled(marker);
  }

  @Override
  public void warn(Marker marker, String s) {
    mdcInject();
    logger.warn(marker,s);
  }

  @Override
  public void warn(Marker marker, String s, Object o) {
    mdcInject();
    logger.warn(marker,s,o);
  }

  @Override
  public void warn(Marker marker, String s, Object o, Object o1) {
    mdcInject();
    logger.warn(marker,s,o,o1);
  }

  @Override
  public void warn(Marker marker, String s, Object... objects) {
    mdcInject();
    logger.warn(marker,s,objects);
  }

  @Override
  public void warn(Marker marker, String s, Throwable throwable) {
    mdcInject();
    logger.warn(marker,s,throwable);
  }

  @Override
  public boolean isErrorEnabled() {
    return logger.isErrorEnabled();
  }

  @Override
  public void error(String s) {
    mdcInject();
    logger.error(s);
  }

  @Override
  public void error(String s, Object o) {
    mdcInject();
    logger.error(s,o);
  }

  @Override
  public void error(String s, Object o, Object o1) {
    mdcInject();
    logger.error(s,o,o1);
  }

  @Override
  public void error(String s, Object... objects) {
    mdcInject();
    logger.error(s,objects);
  }

  @Override
  public void error(String s, Throwable throwable) {
    mdcInject();
    logger.error(s,throwable);
  }

  @Override
  public boolean isErrorEnabled(Marker marker) {
    return logger.isErrorEnabled(marker);
  }

  @Override
  public void error(Marker marker, String s) {
    mdcInject();
    logger.error(marker,s);
  }

  @Override
  public void error(Marker marker, String s, Object o) {
    mdcInject();
    logger.error(marker,s,o);
  }

  @Override
  public void error(Marker marker, String s, Object o, Object o1) {
    mdcInject();
    logger.error(marker,s,o,o1);
  }

  @Override
  public void error(Marker marker, String s, Object... objects) {
    mdcInject();
    logger.error(marker,s,objects);
  }

  @Override
  public void error(Marker marker, String s, Throwable throwable) {
    mdcInject();
    logger.error(marker,s,throwable);
  }
}