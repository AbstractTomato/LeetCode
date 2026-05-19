package ArrayAndString;


/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class water {
    public int trap(int[] height){
        //存储的水的数量
        int water = 0;

        //左右指针
        int left = 0;
        int right = height.length - 1;

        //左右高度最大值
        int leftMax = 0;
        int rightMax = 0;

        while (left < right){
            if (height[left] < height[right]){
                if (height[left] > leftMax){
                    leftMax = height[left];
                }else {
                    water += leftMax - height[left];
                }
                left++;
            }else {
                if (height[right] > rightMax){
                    rightMax = height[right];
                }else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }
}
