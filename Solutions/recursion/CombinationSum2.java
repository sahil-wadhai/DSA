import java.util.*;

class CombinationSum2 
{
  static List<List<Integer>> combinationSum2(int[] candidates, int target) 
  {
      Arrays.sort(candidates);
      List<List<Integer>> ans = new ArrayList<>();
      List<Integer> ds = new ArrayList<>();
      combinationSum(candidates, 0, target, ds, ans);
      return ans;
  }

  private static void combinationSum(int[] candidates, int ind, int target, List<Integer> ds, List<List<Integer>> ans) 
  {
    if (target == 0) 
    {
        ans.add(new ArrayList<>(ds));
        return;
    }

    for (int i = ind; i < candidates.length; i++) 
    {
        if (i > ind && candidates[i] == candidates[i - 1]) 
        {
          continue;
        }
        if (candidates[i] > target) break;

        ds.add(candidates[i]);
        combinationSum(candidates, i + 1, target - candidates[i], ds, ans);
        ds.remove(ds.size() - 1);
    }
    return;
  }
  public static void main(String[] args) {
    int[] candidates = { 1,1,1,2,2};
    int target = 4;
    List<List<Integer>> ans = combinationSum2(candidates, target);
    System.out.println(ans);
}
}
