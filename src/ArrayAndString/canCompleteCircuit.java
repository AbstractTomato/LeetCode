package ArrayAndString;


/**
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。
 * 如果存在解，则 保证 它是 唯一 的。
 */
public class canCompleteCircuit {

    //暴力解法
    public int canCompleteCircuit1(int[] gas, int[] cost){
        if (gas == null || gas.length == 0){
            return -1;
        }

        int oil;
        for (int i = 0; i < gas.length; i++){
            //此时的汽油总量
            oil = gas[i];
            int index = i;
            while (oil >= cost[index]){
                oil -= cost[index];
                if (index == gas.length - 1){
                    index = 0;
                }else {
                    index++;
                }


                if (index == i){
                    return index;
                }
                oil += gas[index];
            }
        }

        return -1;
    }

    //贪心
    public int canCompleteCircuit2(int[] gas, int[] cost){
        //总油量
        int totalOil = 0;
        //当前油量
        int currentOil = 0;
        //起始点
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalOil += gas[i] - cost[i];
            currentOil += gas[i] - cost[i];

            if (currentOil < 0){
                //此时证明从start出发,到i点,剩余油量为负数,即不可能到达i点
                start = i + 1;
                currentOil = 0;
            }
        }

        return totalOil >= 0 ? start : -1;
    }
}
