package NArray;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/19 14:48
 * 二维矩阵转置
 */
public class TransposeMatrix {
    //数组行列转换
    public int [][] transfer(int [][] a){
        for (int i = 0;i <a.length;i++){
            int length =  a[i].length;
            for (int j =i; j < length; j++){
                //交换a[i][j] 与a[j][i]
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        return a;
    }
    public void print(int [][] a){
        for (int i = 0;i <a.length;i++){
            int length =  a[i].length;
            for (int j =0; j < length; j++){
                System.out.printf(a[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int [][] a = {{1,3,5,8},{6,7,9,11},{32,45,67,12},{34,12,15,18}};
        TransposeMatrix tm = new TransposeMatrix();
        tm.print(a);
        System.out.println("after transfer ");
        tm.print(tm.transfer(a));
    }
}
