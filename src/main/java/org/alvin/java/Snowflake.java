package org.alvin.java;

public class Snowflake {

    private final long SEQUENCE_BITS = 12L;
    private final long WORK_ID_BITS = 5L;
    private final long DATACENTER_ID_BITS = 5L;

    private final long MAX_WORK_ID = (1L << WORK_ID_BITS) - 1;
    private final long MAX_DATACENTER_ID = (1L << DATACENTER_ID_BITS) - 1;
    private final long SEQUENCE_MASK = (1L << SEQUENCE_BITS) - 1;

    private final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORK_ID_BITS + DATACENTER_ID_BITS;
    private final long DATACENTER_LEFT_SHIFT = SEQUENCE_BITS + WORK_ID_BITS;
    private final long WORK_LEFT_SHIFT = SEQUENCE_BITS;

    private long workId;
    private long datacenterId;
    private long sequence = 0L;
    private long lastTimestamp = -1;


    public Snowflake(long workId, long datacenterId) {
        if (workId > MAX_WORK_ID || workId < 0) {
            throw new IllegalArgumentException();
        }

        if (datacenterId > MAX_DATACENTER_ID || datacenterId < 0) {
            throw new IllegalArgumentException();
        }

        this.workId = workId;
        this.datacenterId = datacenterId;
    }


    private synchronized long nextId() {
        long timestamp = System.currentTimeMillis();
        // 时钟回拨
        if (timestamp < lastTimestamp) {
            throw new RuntimeException();
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & SEQUENCE_MASK;
            if (sequence == 0) {
                timestamp = tilNextMillis(timestamp);
            }
        } else {
            sequence = 0l;
        }
        lastTimestamp = timestamp;

        return timestamp << TIMESTAMP_LEFT_SHIFT
                | (datacenterId << DATACENTER_LEFT_SHIFT)
                | (workId << WORK_LEFT_SHIFT)
                | sequence;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        // 一直阻塞
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    public static void main(String[] args) {
        Snowflake snowflake = new Snowflake(1, 1);
        for (int i = 0; i < 10; i++) {
            long id = snowflake.nextId();
            System.out.println(id + " -> " + Long.toBinaryString(id));
        }
    }
}
