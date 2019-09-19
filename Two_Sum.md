# 两数之和
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
```
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```
## 暴力法
```Python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        res = []
        length = len(nums)
        for i in range(length):
            for j in range(i+1, length):
                if nums[i] + nums[j] == target:
                    res.append(i)
                    res.append(j)
                    
        return res
```
时间复杂度：$ O(n^2) $
空间复杂度：$ O(n) $

## 优化：哈希表
* 通过哈希表来优化查找度时间复杂度
```Python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        res = []
        d_nums = dict()
            
        for i, v in enumerate(nums):
            if str(target - v) in d_nums:
                res.append(d_nums[str(target - v)])
                res.append(i)
            d_nums[str(v)] = i
            
        return res
```
时间复杂度：$ O(n) $
空间复杂度：$ O(n) $

如果先遍历数组将所有的数添加到哈希表中，然后再遍历一次数组查找符合条件的数会导致得到的结果有重复数，比如[0, 1, 1, 0]。实际上只需要一次遍历，即添加数到哈希表，同时查找符合条件到数，这样即没有重复结果，运行速度也更快。
