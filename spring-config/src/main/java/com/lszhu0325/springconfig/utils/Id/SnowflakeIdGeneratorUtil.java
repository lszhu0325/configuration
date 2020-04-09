package com.lszhu0325.springconfig.utils.Id;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Create by lenovo on 2020/4/9
 */
public class SnowflakeIdGeneratorUtil implements IdGeneratorUtil {

    // 开始时间戳
    private final long startMillis = 1586431848116L;

    // 机器所占位数
    private final long workerIdBits = 5L;

    // 数据中心所占的位数
    private final long dataCenterIdBits = 5L;

    // 支持的最大机器id, 计算结果是31
    private final long maxWorkId = -1L ^ (-1L << workerIdBits);

    // 支持的最大数据标识id, 结果是31
    private final long maxDataCenterId = -1L ^ (-1L << dataCenterIdBits);

    // 序列在id中所占的位数
    private final long sequenceBits = 12L;

    // 机器id向左移12位
    private final long workerIdShift = sequenceBits;

    // 数据中心id向左移17位
    private final long dataCenterIdShift = sequenceBits + workerIdBits;

    private final long timestampShift = sequenceBits + workerIdBits + dataCenterIdBits;

    // 生成序列的掩码, 这里为4095
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    // 工作机器id
    private long workerId;

    // 数据中心id
    private long dataCenterId;

    //毫秒内序列
    private long sequence = 0L;

    // 上次生成的时间戳
    private long lastTimestamp;

    /**
     * 构造函数
     * @param workerId
     * @param dataCenterId
     */
    public SnowflakeIdGeneratorUtil(long workerId, long dataCenterId) {
        if (workerId > maxWorkId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater and %d or less than 0", workerId));
        }
        if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
            throw new IllegalArgumentException(String.format("dataCenter Id can't be greater and %d or less than 0", dataCenterId));
        }
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    /**
     * 获取下一个id
     * @return
     */
    @Override
    public synchronized long nextId() {
        long timestamp = System.currentTimeMillis();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards, Refusing to generate id for $d milliseconds", lastTimestamp - timestamp));
        }
        if (timestamp == lastTimestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tillNextMillis();
            }

        } else {
            sequence = 0L;
        }
        lastTimestamp = timestamp;
        return ((lastTimestamp - startMillis) << timestampShift)
                | (dataCenterId << dataCenterIdShift)
                | (workerId << workerIdShift)
                | sequence;
    }

    private long tillNextMillis() {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }
}
