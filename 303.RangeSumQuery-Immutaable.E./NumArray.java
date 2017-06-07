import java.util.Arrays;

public class NumArray {
  private int[] sum;

  public NumArray(int[] nums) {
    this.sum = new int[nums.length];

    if (nums.length > 0) {
      sum[0]=nums[0];
    }

    for (int i = 1; i < nums.length; i++) {
      sum[i] = sum[i-1] + nums[i];
    }
  }

  public int sumRange(int i, int j) {
    if (i == 0) {
      return sum[j];
    }

    return sum[j] - sum[i-1];
  }
  /*
  beats 3%, :/
  int[] arr;
  int blockSize;
  int[] blockSums;

  public NumArray(int[] nums) {
    this.arr = nums;
    this.blockSize = (int) Math.sqrt(nums.length);
    if (this.blockSize == 0) {
      this.blockSize = 1;
    }

    this.blockSums = new int[(int) (nums.length / this.blockSize) + 1];
    Arrays.fill(this.blockSums, Integer.MIN_VALUE);
  }

  public int sumRange(int i, int j) {
    int leftBlockNo = i / blockSize;
    int rightBlockNo = j / blockSize;
    int blockSum = 0;

    for (int k = leftBlockNo; k <= rightBlockNo; k += 1) {
      if (blockSums[k] == Integer.MIN_VALUE) {

        int block = 0;
        // calculating block
        for (int l = k * blockSize; l < Math.min((k + 1) * blockSize, arr.length); l += 1) {
          block += arr[l];
        }

        blockSums[k] = block;
        blockSum += block;
      } else {
        blockSum += blockSums[k];
      }
    }

    // do the left fix
    int left = 0;
    for (int k = leftBlockNo * blockSize; k < i; k += 1) {
      left += arr[k];
    }

    // do the right fix
    int right = 0;
    for (int k = Math.min((rightBlockNo + 1) * blockSize - 1, arr.length - 1); k > j; k -= 1) {
      right += arr[k];
    }

    return blockSum - left - right;
  }
  */

  /*
  public NumArray(int[] nums) {
    this.arr = nums;
  }


  beats 2%, we need to use cache
  public int sumRange(int i, int j) {
    int sum = 0;
    for (int k = i; k <= j; k += 1) {
      sum += this.arr[k];
    }

    return sum;
  }
  */

  public static void main(String[] args) {
    NumArray nn = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
    System.out.println(nn.sumRange(0, 2));
    System.out.println(nn.sumRange(2, 5));
    System.out.println(nn.sumRange(0, 5));
  }
}
