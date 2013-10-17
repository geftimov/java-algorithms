[![Build Status](https://travis-ci.org/geftimov/Algorithms.png?branch=master)](https://travis-ci.org/geftimov/Algorithms)

Algorithms
==========

Welcome to Algorithms

How to use the algorithms:
--------------------------

Clone the repository:
```
git clone git@github.com:geftimov/Algorithms.git
```
Go in to the folder:
```
cd Algorithms
```
Build it with Maven:
```
mvn clean install
```

All algorithms and their meaning
================================

1. [WeightedQuickUnionUF](https://github.com/geftimov/Algorithms/tree/master/readme/QuickUnion.md)
--------------------------------------------------------------------------
```
WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);

uf.union(4,3);
uf.union(9,3);
uf.union(0,8);
uf.union(2,3);
uf.union(6,5);
uf.union(6,3);
uf.union(7,9);
uf.union(0,6);
uf.union(1,3);

//The test is :
uf.connected(8,6);
//this returns true
```
2. [Percolation](https://github.com/geftimov/Algorithms/tree/master/readme/Percolation.md)
--------------------------------------------------------------------------
```
Percolation per = new Percolation(10);
per.open(10,2);
per.open(2,10);
per.open(6,8);
per.open(2,6);
per.open(1,4);
per.open(8,4);
...
per.open(9,10);

per.percolates();
//this returns false

per.open(10,10);

per.percolates();
//this returns true
```
