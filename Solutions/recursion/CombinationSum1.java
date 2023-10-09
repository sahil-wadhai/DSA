import java.util.*;

class CombinationSum1 {
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        combinationSum(candidates, 0, target, ds, ans);
        return ans;
    }

    private static void combinationSum(int[] candidates, int ind, int target, List<Integer> ds,List<List<Integer>> ans) {
        if (ind >= candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if (ind < candidates.length && target - candidates[ind] >= 0) {
            ds.add(candidates[ind]);
            combinationSum(candidates, ind, target - candidates[ind], ds, ans);
            ds.remove(ds.size() - 1);
        }
        combinationSum(candidates, ind + 1, target, ds, ans);
        return;
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 5 };
        int target = 8;
        List<List<Integer>> ans = combinationSum(candidates, target);
        System.out.println(ans);
    }
}