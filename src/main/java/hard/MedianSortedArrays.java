package hard;

public class MedianSortedArrays {

    /*
    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
    Explanation: merged array = [1,2,3] and median is 2.

    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
     */
    public static void main(String[] args) {
        MedianSortedArrays median = new MedianSortedArrays();
        int[] nums1 = {1, 3};
//        int[] nums1 = {1, 3};
        int[] nums2 = {2};
//        int[] nums2 = {2, 4};

        System.out.println(" Median of mergedArrays = " + median.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] merged = new double[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length + nums2.length) {
            if (j == nums1.length) {
                merged[i] = nums2[k];
                i++;
                k++;
            } else if (k == nums2.length) {
                merged[i] = nums1[j];
                i++;
                j++;
            } else {
                if (nums1[j] < nums2[k]) {
                    merged[i] = nums1[j];
                    i++;
                    j++;
                } else {
                    merged[i] = nums2[k];
                    i++;
                    k++;
                }
            }
        }

        if (merged.length % 2 != 0) {
            return merged[merged.length / 2];
        } else {
            return (merged[merged.length / 2 - 1] + merged[merged.length / 2]) / 2;
        }
    }
}
