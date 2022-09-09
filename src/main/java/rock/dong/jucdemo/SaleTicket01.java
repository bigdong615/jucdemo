package rock.dong.jucdemo;


public class SaleTicket01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        //并发多线程操作同一资源类，把类丢入线程

        //FunctionalInterface 函数式接口 lambda 表达式 (参数)->{代码}
        new Thread(() -> {
            for (int i = 1; i < 60; i++) {
                ticket.sale();
            }

        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i < 60; i++) {
                ticket.sale();
            }

        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i < 60; i++) {
                ticket.sale();
            }

        }, "C").start();

    }


    //资源
    static class Ticket {
        private int number = 50;

        public synchronized void sale() {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票，剩余" + number);
            }
        }
    }
}
