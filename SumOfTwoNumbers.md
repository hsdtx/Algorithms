# 两数之和
给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

## 初始想法：转换成数字相加，再转换成链表，时间复杂度太高
```Python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        num_1, num_2 = 0, 0
        s = []
        while l1.next != None:
            s.append(l1.val)
        while s:
            num_1 = 10 * num_1 + s.pop()
        
        while l2.next != None:
            s.append(l2.val)
        while s:
            num_2 = 10 * num_2 + s.pop()
            
        num = num_1 + num_2
        
        first = None
        temp = None
        index = 1
        while num / 10 != 0:
            if index == 1:
                first = ListNode(num % 10)
                temp = first
                index += 1
            else:
                temp.next = ListNode(num % 10)
                temp = temp.next
        
        return first
```

## 初等数学
实际上，从链表的第一位往后遍历，然后把各位相加正好符合数学中加法的操作，因此无需转换数字。其中需要注意进位的情情况。
```Python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        res = index = ListNode(None)
        flag = 0
        while l1 != None or l2 != None:
            if l1 != None and l2 != None:
                index.next = ListNode((l1.val + l2.val + flag) % 10)
                flag = int((l1.val + l2.val + flag) / 10)
                l1, l2 = l1.next, l2.next
                index = index.next
            if l1 != None and l2 == None:
                index.next = ListNode((l1.val + flag) % 10)
                flag = int((l1.val + flag)/10)
                l1 = l1.next
                index = index.next
            if l2 != None and l1 == None:
                index.next = ListNode((l2.val + flag) % 10)
                flag = int((l2.val + flag)/10)
                l2 = l2.next
                index = index.next
            
        if flag != 0:
            index.next = ListNode(flag)
        
        res = res.next
        return res
```
