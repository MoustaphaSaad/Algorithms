
/**
 * Created by Hesham on 21/09/2014.
 */
public class PercolationStats {
    private double[] th;
    public PercolationStats(int N,int T){
        if(T<=0 || N<=0)
            throw new IllegalArgumentException("N and T should be positive!");
        th = new double[T];
        for(int i=0;i<T;i++){
            Percolation p = new Percolation(N);
            double openCount = 0d;
            while(!p.percolates()){
                int x = StdRandom.uniform(1,N+1);
                int y = StdRandom.uniform(1,N+1);
                if(!p.isOpen(x,y)){
                    p.open(x,y);
                    openCount++;
                }
            }
            th[i] = openCount/(N*N);
        }
    }

    public double mean(){
        return StdStats.mean(th);
    }
    public double stddev(){
        if(th.length > 1){
            return StdStats.stddev(th);
        }else
            return Double.NaN;
    }
    public double confidenceLo(){
        return mean()-stddev();
    }
    public double confidenceHi(){
        return mean()+stddev();
    }
    public static void main(String[] args) {
        int T = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(
                Integer.parseInt(args[0]), T);
        double mean = stats.mean();
        StdOut.println("mean = " + mean);
        double stddev = stats.stddev();
        StdOut.println("stddev = " + stddev);
        double d = (1.96 * stddev) / Math.sqrt(T);
        StdOut.println("95% confidence interval = " + (mean - d) + ", "
                + (mean + d));
    }

}
