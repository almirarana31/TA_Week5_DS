import java.util.*;

public class smelly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input your amount of disks: ");
        int n = sc.nextInt();
        towerOfHanoi(n, 'A', 'C', 'B');

        Scanner ya = new Scanner(System.in);
        System.out.print("Input size of array: ");
        int y = ya.nextInt();
        System.out.print("Input array elements (separated by space): ");
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 0; i < y; i++) {
            nums.add(ya.nextInt());
        }

        Scanner ex = new Scanner(System.in);
        System.out.print("Input your target number: ");
        int target = ex.nextInt();

        int[] indices = countPairs(nums, target);
        if (indices.length == 2) {
            System.out.println("Indices of the two numbers (" + indices[0]+", "+ indices[1] + ")");
        }
        else {
            System.out.println("No such pair found.");
        }


    }
    static void towerOfHanoi(int n, char from_rod, char to_rod, char mid_rod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n-1, from_rod,mid_rod, to_rod);
        System.out.println("Move disk "+ n + " from rod " + from_rod + " to rod " + to_rod);
        towerOfHanoi(n-1, mid_rod,to_rod,from_rod);
    }
    static int[] countPairs(LinkedList<Integer> nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int num : nums) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), index};
            }
            map.put(num, index);
            index++;
        }
        return new int[0];
    }

}
