package day4;

public class ArrayAndString {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        // iterating over on arrays
        System.out.println("for loop"); 
        for(int i = 0;i <= nums.length - 1; i++){
            System.out.println(nums[i]);
        }

        System.out.println("for-each loop");

        // for each in array
        for(int a: nums){
            System.out.println(a);
        }

    }
}

