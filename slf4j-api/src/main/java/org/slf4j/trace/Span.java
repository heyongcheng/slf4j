package org.slf4j.trace;

import java.util.Map;

/**
 * Created by heyc on 2017/8/31.
 */
public class Span {
    /** 开始时间 **/
    private long begin;
    /** 结束时间 **/
    private long end;
    /** 接口/方法 名称 **/
    private String name;
    /** trace id **/
    private String traceId;
    /** span id **/
    private String spanId;
    /** parent span id **/
    private String parent;
    /** remote **/
    private boolean remote;
    /** 接口名 **/
    private String interfaces;
    /** 方法名 **/
    private String method;
    /** 接口版本 **/
    private String version;
    /** 远程接口地址 **/
    private String host;
    /** 属性 **/
    private Map<String, String> tags;

    public long getBegin() {
        return begin;
    }

    public void setBegin(long begin) {
        this.begin = begin;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getSpanId() {
        return spanId;
    }

    public void setSpanId(String spanId) {
        this.spanId = spanId;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    public String getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(String interfaces) {
        this.interfaces = interfaces;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Span{" +
                "begin=" + begin +
                ", end=" + end +
                ", name='" + name + '\'' +
                ", traceId='" + traceId + '\'' +
                ", spanId='" + spanId + '\'' +
                ", parent='" + parent + '\'' +
                ", remote=" + remote +
                ", interfaces='" + interfaces + '\'' +
                ", method='" + method + '\'' +
                ", version='" + version + '\'' +
                ", host='" + host + '\'' +
                ", tags=" + tags +
                '}';
    }
}
