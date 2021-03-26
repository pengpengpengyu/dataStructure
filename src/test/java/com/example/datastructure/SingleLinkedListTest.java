package com.example.datastructure;

import lombok.Data;
import org.junit.jupiter.api.Test;

/**
 * 单链表
 */
public class SingleLinkedListTest {

    @Test
    public void test() {
        SingleLinedList list = new SingleLinedList();
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(4, "林冲", "豹子头");
        HeroNode heroNode3 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode4 = new HeroNode(3, "吴用", "智多星");

        list.add(heroNode1);
        list.add(heroNode2);
        list.add(heroNode3);
        list.add(heroNode4);

        list.list();
    }

    /**
     * 单链表
     */
    @Data
    class SingleLinedList {

        /**
         * 头部节点, 该节点不存放数据, 否则将导致找不到头结点
         */
        private HeroNode head = new HeroNode(0, "", "");

        /**
         * 添加节点
         * 思路:
         * 1.找到当前列表的最后一个节点 (next为null的节点)
         * 2.将最后一个节点的netx指向要添加的节点
         *
         * @param hero
         */
        public void add(HeroNode hero) {

            HeroNode temp = head;
            while (true) {
                if (null == temp.next) {
                    break;
                }
                temp = temp.next;
            }
            temp.next = hero;
        }

        /**
         * 遍历列表
         */
        public void list() {

            HeroNode temp = head;

            while (true) {

                if (null == temp.next) {
                    break;
                }
                temp = temp.next;

                System.out.println(temp);
            }
        }
    }

    @Data
    class HeroNode {
        private int no;

        private String name;

        private String nickName;

        private HeroNode next;

        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }
}
