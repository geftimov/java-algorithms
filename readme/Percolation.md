Percolation
============

Uses [WeightedQuickUnionUF](https://github.com/geftimov/Algorithms/tree/master/readme/QuickUnion.md)
---------------

Nor percolating
---------------
![ScreenShot](http://coursera.cs.princeton.edu/algs4/testing/percolation/input10-no.png)

Percolating
---------------
![ScreenShot](http://coursera.cs.princeton.edu/algs4/testing/percolation/input10.png)


How it is done:
------------------
>Percolation per = new Percolation(10);
>
>per.open(10,2);
>per.open(2,10);
>per.open(6,8);
>per.open(2,6);
>per.open(1,4);
>per.open(8,4);
>
> ...
>
>per.open(9,10);
>
>per.percolates();
>//this returns false
>
>per.open(10,10);
>
>per.percolates();
>//this returns true
>
