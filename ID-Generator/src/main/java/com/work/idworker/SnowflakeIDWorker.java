package com.work.idworker;

/**
 * Program Name: Ground
 * <p>
 * Description: ID 生成器
 * 基于 Twitter_Snowflake，整体有序，适用于分布式服务
 *
 * java中long型为64位 最大9223372036854775807，10进制共19位。
 * 所以ID转为字符串的话，位数<=19位
 *
 *
 * 如何使用：通过new 构造SnowflakeIDWorker 实例，nexId方法获取id即可，正式使用最好使用单例模式
 * <p>
 *
 * @author zhangjianwei
 * @version 1.0
 * @date 2019/8/1 12:22 PM
 */

public class SnowflakeIDWorker {

    /**
     * 开始时间 2019年08月01日14:09:48
     */
    private final long twepoch = 1564639754372L;

    private final long workerIdBits = 5L;

    private final long datacenterIdBits = 5L;

    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    private final long sequenceBits = 12L;

    private final long workerIdShift = sequenceBits;

    private final long datacenterIdShift = sequenceBits + workerIdBits;

    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long workerId;

    private long datacenterId;

    private long sequence = 0L;

    private long lastTimestamp = -1L;


    public SnowflakeIDWorker(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IDWorkerException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IDWorkerException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public synchronized long nextId() {
        long currentTimestamp = timeGen();
        if (currentTimestamp < lastTimestamp) {
            throw new IDWorkerException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - currentTimestamp));
        }

        if (lastTimestamp == currentTimestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                currentTimestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = currentTimestamp;
        return ((currentTimestamp - twepoch) << timestampLeftShift)
                | (datacenterId << datacenterIdShift)
                | (workerId << workerIdShift)
                | sequence;

        // return ((timestamp - twepoch) << (int) timestampLeftShift)
        //         | (idcId << (int) datacenterIdShift)
        //         | (workerId << (int) workerIdShift)
        //         | sequence;
    }


    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        // 1 80040 73072 55808
        SnowflakeIDWorker snowflakeIDWorker = new SnowflakeIDWorker(0, 0);
        System.out.println(snowflakeIDWorker.nextId());
        System.out.println(String.valueOf(System.currentTimeMillis()));
    }
}
