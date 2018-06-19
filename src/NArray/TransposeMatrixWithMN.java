package NArray;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/19 15:53
 * M行N列，矩阵转置
 */
public class TransposeMatrixWithMN {
    public void print(int [][] a){
        for (int i = 0;i <a.length;i++){
            int length =  a[i].length;
            for (int j =0; j < length; j++){
                System.out.printf(a[i][j]+"  ");
            }
            System.out.println();
        }
    }
    //行列转换 m行n列
    public int [][] transfer(int [][] a){
        //异常分析
        if (a == null || a.length < 1){
            return null;
        }
        //取出行列
        int hlen = a.length;
        int lielen = a[0].length;
        int [][] b = new int[lielen][hlen];
        // 采用赋值的方式实现矩阵转换：注意a数组的边界，a[i][j] i 一定是控制行+j一定是控制列的
        for (int i = 0;i <hlen;i++){
            for (int j =0; j < lielen; j++){
                //赋值
                b[j][i] = a[i][j];
            }
        }
        return b;
    }

    public static void main(String[] args) {
        int [][] a = {{1,3,5,8},{6,7,9,11},{32,45,67,12}};
        TransposeMatrixWithMN tmn = new TransposeMatrixWithMN();
        tmn.print(a);
        System.out.println("after transfer ");
        tmn.print(tmn.transfer(a));
    }
}
