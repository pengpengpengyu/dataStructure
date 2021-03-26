package com.example.datastructure;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * 队列
 * 1.有序列表可以由数组或者链表实现
 * 2.遵循先入先出原则
 * 3.
 */
public class QueueTest {

    @Test
    public void ArrayQueueTest() {

    }

}


class ArrayQueue {

    // 头指针
    private int front;

    // 尾指针
    private int rear;

    // 队列(数组)最大数
    private int maxSize;

    // 用于存放数据
    private int[] arr;

    // 初始化队列
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1;  // 指向队列头部,即队列第一个数据前一个位置
        rear = -1;  // 指向队列尾部,指向队列最后一个数据
        arr = new int[maxSize];
    }


    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空不能遍历");
            return;
        }
        for (int i = 0; i < maxSize; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public void add(int v) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = v;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无法取数");
        }
        front++;
        return arr[front];
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        return arr[front + 1];
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("请输入选项:");
            System.out.println("s(show())显示队列");
            System.out.println("a(add())插入数据到队列");
            System.out.println("g(get())取出数据");
            System.out.println("h(headQueue())显示队列头部数据");
            System.out.println("e(exit())退出");
            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("请输入一个数字:");
                    queue.add(scanner.nextInt());
                    break;
                case 'g':
                    try {
                        int v = queue.get();
                        System.out.println(v);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int h = queue.headQueue();
                        System.out.println(h);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("退出成功 !!!");

    }

}

