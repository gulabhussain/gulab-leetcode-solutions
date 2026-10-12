import java.util.*;

class Solution {


public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
    return result;
}

public void backtrack(int[] nums, List<Integer> perm,
                      boolean[] used, List<List<Integer>> result) {

    // Base case
    if (perm.size() == nums.length) {
        result.add(new ArrayList<>(perm));
        return;
    }

    // Loop
    for (int i = 0; i < nums.length; i++) {

        if (used[i]) {
            continue;
        }

        // Choose
        perm.add(nums[i]);
        used[i] = true;

        // Recursion
        backtrack(nums, perm, used, result);

        // Backtracking
        perm.remove(perm.size() - 1);
        used[i] = false;
    }
}


}
