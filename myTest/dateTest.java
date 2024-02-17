package myTest;

public class dateTest {
    public static void main(String[] args) {
        /*
        如果想要到达20级台阶，可能是从18级台阶上来，也可能是从19级台阶上来
        所以我们计算20级台阶的爬法 = 19级台阶的爬法 + 18级台阶的爬法
        为了不重复计算，如果小明在第18级台阶的时候，再爬一层，这种走法已经包括在Fn(19)中了
        所以18到20只有一种爬法
         */

        System.out.println(getCount(20));
    }

    private static int getCount(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return getCount(n - 1) + getCount(n - 2);
    }
}
