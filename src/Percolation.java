/**
 * Created by Hesham on 21/09/2014.
 */
public class Percolation {
    private boolean[][] _grid;
    private int _nSize;
    private WeightedQuickUnionUF _gridUF;
    private WeightedQuickUnionUF _gridUFFill;
    public Percolation(int N){
        _nSize = N;
        _grid = new boolean[_nSize][_nSize];
        _gridUF = new WeightedQuickUnionUF(_nSize*_nSize+2);
        _gridUFFill = new WeightedQuickUnionUF(_nSize*_nSize+2);
        for(int i=0;i<_nSize;i++)
            for(int j=0;j<_nSize;j++)
                _grid[i][j] = false;

    }
    public void open(int i,int j){
        checkIX(i,j);
        if(!isOpen(i,j)){
            _grid[i-1][j-1] = true;
            union(i,j,i-1,j);
            union(i,j,i+1,j);
            union(i,j,i,j-1);
            union(i,j,i-1,j+1);

            if(i==1) {
                _gridUF.union(0, map2D1D(i, j));
                _gridUFFill.union(0,map2D1D(i,j));
            }
            if(i==_nSize)
                _gridUF.union(1,map2D1D(i,j));

        }
    }
    public boolean isOpen(int i,int j){
        checkIX(i,j);
        return _grid[i-1][j-1];
    }
    public boolean isFull(int i,int j){
        checkIX(i,j);
        return _gridUFFill.connected(0,map2D1D(i,j));
    }
    public boolean percolates(){
        return _gridUF.connected(0,1);
    }
    private void union(int i,int j,int i2,int j2){
        if(i2>0 && j2>0 && i2<=_nSize && j2<=_nSize && isOpen(i2,j2)){
            _gridUF.union(map2D1D(i,j),map2D1D(i2,j2));
        }
    }
    private int map2D1D(int i,int j){
        checkIX(i,j);
        return (i-1)*_nSize+j+1;
    }
    private void checkIX(int i,int j){
        i--;
        j--;
        if(i<0       ||
           j<0       ||
           i>=_nSize ||
           j>=_nSize  ){
            throw new IndexOutOfBoundsException(String.format("Index is out of Range, i=%s, j=%s",i+1,j+1));
        }
    }
}
