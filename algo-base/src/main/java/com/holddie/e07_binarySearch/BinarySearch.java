package com.holddie.e07_binarySearch;

public class BinarySearch {
    /**
     * 循环实现二分查找
     *
     * @author HoldDie
     */
    public static int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归实现二分查找
     *
     * @author HoldDie
     */
    public static int binarySearchByRecursion(int[] nums, int target, int left, int right) {
        if (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return binarySearchByRecursion(nums, target, left, mid - 1);
            } else if (nums[mid] < target) {
                return binarySearchByRecursion(nums, target, mid + 1, right);
            }
        }
        return -1;
    }

    /**
     * 二分法查找定位插入位置
     *
     * @author HoldDie
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 查找边界
     *
     * @author HoldDie
     */
    public int[] searchRange(int[] nums, int target) {
        int upper = upperBound(nums, target);
        int low = lowerBound(nums, target);
        // 不存在情况
        if (upper < low) {
            return new int[] {-1, -1};
        }
        return new int[] {low, upper};
    }

    // 计算下边界
    int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 这里需要注意，计算mid
            int mid = left + ((right - left) >> 1);
            if (target <= nums[mid]) {
                // 当目标值小于等于nums[mid]时，继续在左区间检索，找到第一个数
                right = mid - 1;
            } else if (target > nums[mid]) {
                // 目标值大于nums[mid]时，则在右区间继续检索，找到第一个等于目标值的数
                left = mid + 1;
            }
        }
        return left;
    }

    // 计算上边界
    int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target >= nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return right;
    }

    /**
     * 小于给定值的第一个值
     *
     * @author HoldDie
     */
    public static int lowBoundFirstNum(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            // 大于目标值的情况
            if (nums[mid] > target) {
                // 返回 mid
                if (mid == 0 || nums[mid - 1] <= target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] <= target) {
                left = mid + 1;
            }
        }
        // 所有元素都小于目标元素
        return -1;
    }

    /**
     * 大于给定值的第一个值
     *
     * @author HoldDie
     */
    public static int upperBoundFirstNum(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            // 小于目标值
            if (nums[mid] < target) {
                // 看看是不是当前区间的最后一位，如果当前小于，后面一位大于，返回当前值即可
                if (mid == right || nums[mid + 1] >= target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] >= target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
