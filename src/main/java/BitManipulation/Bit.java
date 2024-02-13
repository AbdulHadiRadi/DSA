package BitManipulation;

public class Bit {
    // Printing the bit of the i'th position
    public static void getBit(int n, int i){
        int bitMask = 1<<i;
        if((n & bitMask) ==0){
            System.out.println("The "+i+"th position is 0");
        }
        else System.out.println("The "+i+"th position is 1");
    }
    // set the i'th position bit 1.
    public static void setBit (int n, int i){
        int bitMask = 1<<i;
        int bitSet = n | bitMask;
        System.out.println("Bit Set " +bitSet);
        getBit(bitSet, i);
    }
    // clear the i'th position bit and make it 0.
    public static void clearBit(int n, int i){
        int bitMask = ~(1<<i);
        int bitSet = n & bitMask;
        System.out.println("Bit Set " +bitSet);
        getBit(bitSet, i);
    }
    // Update the ith position bit.
    public static void updateBit(int n, int i){
        int bitMask = 1<<i;
        int res = n^bitMask;
        System.out.println(res);
        getBit(res, i);
        //if the bit is 0 then Set it or clear it.
//        if((bitMask & n)==0){
//           setBit(n, i);
//        }
//        else {
//            clearBit(n, i);
//        }
    }
    //checking even and odd using Bit
    public static void oddEven(int n){
        if((n & 1) == 0){
            System.out.println("EVEN");
        }
        else {
            System.out.println("ODD");
        }
    }
    //Swapping between 2 numbers without using temp Variable
    public static void swap(int a, int b){
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a +" "+ b);
    }
    public static void multiplyBy2(int a){
        System.out.println(a<<1);
    }
    public static void dividedBy2(int a){
        System.out.println(a>>1);
    }
    //2's Complement
    public static void complementOf2(int n){
        n = ~n+1;
        System.out.println(n);
    }
    // finding number of bits of a decimal
    public static void countBits(int n){
        int bits = (int) (Math.log(n)/ Math.log(2)) +1;// Log2 (n) + 1;
        System.out.println(bits);
    }
    // count number of sets
    public static void countSets(int n){
        int set = 0;
        while(n!=0){
            n = n & (n-1);// convert the last set bit to 0 (clearing last set bit).
            set++;
//            if((n & 1) !=0){
//                set++;// if last bit is set bit
//            }
//            n = n>>1;
        }
        System.out.println(set);
    }
    // number of bits to change to covert bit a to b
    public static void numberBitsConvert(int a, int b){
        int res = a^b;
        countSets(res);
    }
    //Reverse the bits of a decimal number
    public static int reverseBits(int n){
        int res = 0;
        for(int i=0; i<32; i++){
             int bit = n & 1;//get the ith last bit of n
             bit = bit<<(31-i);//send the bit into (31-i)th position
             res = res | bit; //store the bit into res
             n = n>>1;
        }
        return res;
    }
    //finding trailing zero bits of a number
    public static void tailingZeros(int n){
        int zeros = 0;
        while(n!=0){
            if((n&1)==0){
                zeros++;
                n = n>>1;
            }
            else break;
        }
        System.out.println(zeros);
    }
    //Get the single element from the array where all others elements presence twice
    public static void getDistinct(int [] nums){
        int res = 0;
        for(int i=0; i<nums.length; i++){
            res = res^nums[i];
        }
        System.out.println(res);
    }
    public static void main(String [] args){
        updateBit(5,0);
        oddEven(5);
        swap(5,9);
        complementOf2(3);
        countBits(13);
        numberBitsConvert(22, 27);
        System.out.println(reverseBits(4));
        int [] nums = {2,4,2,8,4};
        getDistinct(nums);
    }
}
