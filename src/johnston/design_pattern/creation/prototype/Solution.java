package johnston.design_pattern.creation.prototype;

import java.util.Arrays;

public class Solution {
  public static int[] twoSum(int[] nums, int target) {
    // Suppose it's sorted
    Arrays.sort(nums);

    // Greedy algo.
    // Use two pointers ptrA = 0; ptrB = nums.length - 1
    // while (ptrA < ptrB)
    // if (nums[ptrA] + nums[ptrB] == target) done!
    // else if (nums[ptrA] + nums[ptrB] > target) ptrB--
    // else (nums[ptrA] + nums[ptrB] < target) ptrA++
    // Cannot parallel, because it's consistent and stateful
    // hashmap need value of prev idx
    int idxA = 0;
    int idxB = nums.length - 1;

    while (idxA < idxB) { // no equals or return [i, i] if (nums[i] * 2 == target)
      int sum = nums[idxA] + nums[idxB];

      if (sum == target) {
        return new int[]{idxA, idxB};
      } else if (sum < target) {
        idxA++;
      } else {
        idxB--;
      }
    }
    // no such solution
    return null;
    // TC: O(n), each element visited at most once.
    // SC: O(1), no reucrsion or other data stru. used.

    // Follow-ups A: how if array is very long and cannot fit into the memory
    // Input: 10GB, RAM = 1GB, unsorted
    // cannot use hashmap, because hashmap is stateful(consitent)
    // New algorithm

    // 1. First step: shard (partition) the input into 500MB blocks
    // 10GB -> array with length == 20
    // original array: ****|****|****|****|*******************|****************
    // result:                    X                    X
    // check each pair [array[i], array[j]], and each one block array[i]
    // step one: check unique block array[i] : O(20) -> O(n)
    // step two: check each pair [array[i], array[j]] subtask
    // combination problem: total pairs = 20,O(n) * 19,O(n) / 2 = 190, O(n^2)
    // each pairs: O(n / 20) -> O(n)
    // Work this algorithm in parallel.
    // Eash subtask is <b>independent</b>. Possible to  parallel

    // Follows-ups B: how to solve two sum in a distributed system (multiple servers)
    // Solution is similar to parallel. How to break the algorithm into independent subtasks.
    // Assume: the array(data) is stored in the leading server
    // Each task leading server needs to make a copy of the blocks
    // Make sure each pair of servers won't depends on each other's result
    // Similar to prev one, replace "thread" to "server"
    // In general: distributed system ==  one leading server + n working servers
    // leading server job: assign subtask to working servers, and maintain a taskQueue.
    // If one working server finshed the job, then get another job from the taskQueue.
    // space locality (CSE141): working server check 0-1, 0-2, 0-3, 0-4.... // avoid duplicated block0 data transfer

    // Leading server keep track of what blocks that working server i owned
    // Problem: how if the working server has 100MB memory, so it cannot store all data
    // Working server keep track what input data has: blockList[0, 1, 10]
    // If the leading server assign subtask[1,10], working server return: ok I got this data, no transfer
    // If the leading server assign subtask[9,10], working server return: I need block 9
    // Working server memory management algorithm: LRU: least Recently used

    // Working server can store at most 4 blocks of data
    // substask: 0, 1, needs 0, 1   cache: 0, 1
    // substask: 0, 2  needs _, 2   cache: 0, 1, 2
    // substask: 0, 3  needs _, 3   cache: 0, 1, 2, 3
    // substask: 0, 4  needs _, 4   cache: 0，2, 3, 4
    // substask: 5, 6  needs 5, 6   cache: 0, 4, 5, 6

    // Need design algorithm to minimize data transfer, proper subtasks assigned + proper cache kickout policy
    // subtasks assigned: locality oriented
    // cache kickout policy: LRU

    // microphone: not fluent, ...///..././../....
  }

  public static void main(String[] args) {
    int[] input = new int[]{0, 1, 2, 3, 4, 5, 6, 15};
    int[] result = twoSum(input, 16); // [5, 6]
    System.out.println(result[0] + "," + result[1]);
  }
}
