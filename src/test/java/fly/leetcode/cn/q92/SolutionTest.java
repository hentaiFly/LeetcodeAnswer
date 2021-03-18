package fly.leetcode.cn.q92;

import fly.test.converter.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution s = new Solution();

    @CsvSource(value = {"" +
            "[1,2,3,4,5]`2`4`[1,4,3,2,5]",
            "[1,2,3,4,5]`1`5`[5,4,3,2,1]",
    },delimiter = '`')
    @ParameterizedTest
    void reverseBetween(@ConvertWith(IntArrayConverter.class) int[] list, int left, int right, @ConvertWith(IntArrayConverter.class) int[] result) {
        ListNode listNode = null;
        for (int i = list.length - 1; i >= 0; i--) {
            listNode = new ListNode(list[i],listNode);
        }
        listNode = s.reverseBetween(listNode,left,right);
        for (int i = 0; i < list.length; i++) {
            list[i] = listNode.val;
            listNode = listNode.next;
        }
        assertArrayEquals(list,result);
    }
}