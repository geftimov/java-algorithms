WeightedQuickUnionUF
============

Used for:

1. [Percolation.](https://github.com/geftimov/Algorithms/tree/master/readme/Percolation.md) DONE.
2. Games(Go,Hex).
3. Dynamic connectivity.
4. Least common ancestor.
5. Equivalence of finite state automata.
6. Hoshen-Kopelman algorithm in physics.
7. Hinley-Milner polymorphic type inference.
8. Kruskal`s minimum spanning tree algorithm.
9. Compiling equivalence statements in Fortran.
10. Morphological attribute opening and closings.
11. Matlab`s bwlabel() function in image processing.

![ScreenShot](http://tjure.sfs.uni-tuebingen.de/files/Kursmaterialien/Gerdemann/fig1.7.png)

How it is done:
------------------
>WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);
>
>uf.union(4,3);
>uf.union(9,3);
>uf.union(0,8);
>uf.union(2,3);
>uf.union(6,5);
>uf.union(6,3);
>uf.union(7,9);
>uf.union(0,6);
>uf.union(1,3);
>
>//When 0 union with 6 (```uf.union(0,6);```) the root of 0(8) is connected to the root of 6 (3)
>//The test is :
>uf.connected(8,6);
>//this returns true


