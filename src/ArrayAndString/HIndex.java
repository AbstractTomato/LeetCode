package ArrayAndString;


import java.util.Arrays;


public class HIndex {

    /**
     * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
     *
     * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，
     * 一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
     * 并且 至少 有 h 篇论文被引用次数大于等于 h 。
     * 如果 h 有多种可能的值，h 指数 是其中最大的那个。
     */
    public static int hIndex(int[] citations){
        if (citations == null || citations.length == 0){
            return 0;
        }

        int len = citations.length;
        /*
        表示论文引用的篇数
        count[0] 表示论文被引用0次的篇数
        count[1] 表示论文被引用1次的篇数
         */
        int[] count = new int[len + 1];
        for (int citation : citations) {
            count[Math.min(citation, len)]++;
        }

        int total = 0;
        for (int i = count.length - 1; i >=0; i--){
            total += count[i];
            if (total >= i){
                return i;
            }
        }
        return 0;
    }


    /**
     * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 非降序排列 。
     * 计算并返回该研究者的 h 指数。
     * h 指数的定义：h 代表“高引用次数”（high citations），
     * 一名科研人员的 h 指数是指他（她）的 （n 篇论文中）至少 有 h 篇论文分别被引用了至少 h 次。
     * 请你设计并实现对数时间复杂度的算法解决此问题。
     */
    public int hIndex2(int[] citations){
        /*
        此时已经排好序了,只需要满足citations[n - h] >= h 即可
        此时用二分查找
         */

        int n = citations.length;
        int left = 0;
        int right = n;
        while (left < right){
            int mid = (left + right + 1) / 2;

            if (citations[n - mid] >= mid){
                left = mid;
            }else {
                right--;
            }
        }

        return left;
    }
}
