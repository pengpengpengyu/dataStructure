package com.example.datastructure;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

        list.addByOrder(heroNode1);
        list.addByOrder(heroNode2);
        list.addByOrder(heroNode3);
        //list.addByOrder(heroNode1);
        list.addByOrder(heroNode4);

        list.list();
        System.out.println("==================================================");
        /*list.delete(heroNode2);
        list.list();*/

       // System.out.println("length=" + list.getListLength(list.getHead()));

      //  System.out.println("res=" + list.getHeroNodeByLastIndex(list.getHead(), 2));

        list.reverse(list.getHead());
        list.list();
    }

    @Test
    public void test2() {

        List<String> list = new ArrayList<>();
        String str = "abc";
        list.add(str);
        list.add(str);
        list.forEach(System.out::println);
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

        public HeroNode getHead() {
            return head;
        }

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
         * 有序插入
         *
         * @param heroNode
         */
        public void addByOrder(HeroNode heroNode) {
            HeroNode temp = head;
            while (true) {
                if (null == temp.next) {
                    break;
                }

                if (temp.next.getNo() > heroNode.getNo()) {
                    heroNode.next = temp.next;
                    break;
                }
                temp = temp.next;
            }
            if (temp.getNo() == heroNode.getNo()) {
                HeroNode newNode = new HeroNode(heroNode.getNo(), heroNode.getName(), heroNode.getNickName());
                newNode.next = temp.next;
                temp.next = newNode;

            } else {
                temp.next = heroNode;
            }
        }

        /**
         * 删除节点（根据no）
         *
         * @param heroNode
         */
        public void delete(HeroNode heroNode) {
            if (null == head.next) {
                System.out.println("该链表没有数据");
            }
            HeroNode temp = head;
            while (true) {
                if (null == temp.next || temp.next.getNo() == heroNode.getNo()) {
                    temp.next = heroNode.next;
                    break;
                }
                temp = temp.next;
            }
        }

        /**
         * 获取链表有效节点的长度(不包含头)
         *
         * @param head
         * @return
         */
        public int getListLength(HeroNode head) {
            if (null == head || null == head.next) {
                return 0;
            }

            HeroNode current = head.next;
            int length = 0;
            while (null != current) {
                length++;
                current = current.next;
            }

            return length;
        }

        /**
         * 求链表倒数第n个节点
         *
         * @param head
         * @param index
         * @return
         */
        public HeroNode getHeroNodeByLastIndex(HeroNode head, int index) {

            int length = this.getListLength(head);
            if (length <= 0 || index > length) {
                return null;
            }

            HeroNode temp = head.next;
            for (int i = 0; i < length - index; i++) {
                temp = temp.next;
            }

            return temp;
        }

        /**
         * 列表反转
         * @param head
         */
        public void reverse(HeroNode head) {
            if (null == head || null == head.next || null == head.next.next) {
                return;
            }
            HeroNode rerverseNode = new HeroNode();
            HeroNode cur = head.next;
            HeroNode next = null;
            while (null != cur) {
                next = cur.next;
                cur.next = rerverseNode.next;
                rerverseNode.next = cur;
                cur = next;
            }

            head.next = rerverseNode.next;
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

        public HeroNode() {
        }

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
