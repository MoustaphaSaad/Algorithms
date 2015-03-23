package com.AIDSA;

/**
 * Created by Moustapha Saad on 20/12/2014.
 */
public class knapsack {
    public static double bruteForce(double[] Ow, double[] Op, int w){
        double res = 0;
        int size = Op.length;
        int[] A = new int[size];
        for(int i=0;i<size;i++)
            A[i] = 0;
        for(int i=0;;i++){
            int j = size;
            double tempW = 0;
            double tempV = 0;
            int k = 1;
            for(j=0;j<size;j++){
                A[j]+=k;
                k = A[j]/2;
                A[j] = A[j]%2;
            }
            if(k>0)
                break;
            for(k=0;k<size;k++){
                if(A[k]==1){
                    tempW += (double)Ow[k];
                    tempV += (double)Op[k];
                }
            }
            if(tempW<=w && res<=tempV)
                res = tempV;
        }
        return res;
    }
}
