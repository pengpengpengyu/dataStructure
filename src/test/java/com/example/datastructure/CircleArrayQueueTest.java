package com.example.datastructure;

import org.junit.jupiter.api.Test;

/**
 * 循环队列
 */
public class CircleArrayQueueTest {

    @Test
    public void test() {
        System.out.println(3 % 4);
    }
}

/**
 * 这是一个重复可用的环形链表 但是 数字下标为maxSize的位置没有使用
 */
class CircleArrayQueue {
    /**
     * 最大总量
     */
    private int maxSize;
    /**
     * 队列头 指向队列的第一个元素 例如队列里已有五个元素 下表分别为0,1,2,3,4 那么 front = 4
     */
    private int front;
    /**
     * 队列尾 指向队列的最后一个元素的下一个位置 例如队列里已有5个元素, 下下标分别为0,1,2,3,4 那么rear = 5
     */
    private int rear;
    /**
     * 存放数据用的数组队列
     */
    private int[] queueArray;

    /**
     * 初始化一个maxSize长度的数组队列。
     *
     * @param maxSize
     */
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new int[maxSize];
    }

    /**
     * 判断队列是否满
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 往队列中添加一个元素
     *
     * @param element
     * @return
     */
    public boolean addQueue(int element) {

        boolean flag = false;
        if (isFull()) {
            return flag;
        }
        //队尾后移一位
        queueArray[rear] = element;
        rear = (rear + 1) % maxSize;
        flag = true;
        return flag;
    }

    /**
     * @return 弹出&获取当前队首任务
     */
    public int takeQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        //队首后移一位
        int value = queueArray[front];
        queueArray[front] = 0;
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 显示队列里的数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列里没有数据");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.println("当前数据顺序位数 = " + queueArray[i]);
        }
    }

    /**
     * @return 队列中有效数据个数
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}