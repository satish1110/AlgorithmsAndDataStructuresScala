package PermutationsCombinations

import scala.collection.mutable.ArrayBuffer

// program to generate the power-set of a given set of numbers
// Time complexity: O(n * (2^n))
object PowerSet{

  /*
   recursive function to generate power-set (pow(2,n) sets) from a set of n numbers
   params -> ipSet: i/p array of numbers ; currIndex: the current index of i/p array which we are processing ;
             opSet: o/p arrayBuffer of numbers, i.e. one of the sets of the power-set;
  eg: (i/p) -> ipSet: [1, 2] ; currIndex: 0 ;
      (o/p) -> opSet: [], [1], [2], [1, 2]
   */
  def generatePowerSet(ipSet: Array[Int], currIndex: Int = 0, opSet: ArrayBuffer[Int]): Unit ={

    // base case: we've processed all the numbers in the ipSet
    if(currIndex == ipSet.length){
      println(opSet)
      return
    }

    // from here we can make two decisions and proceed
    // 1. do not include the current number to the opSet
    generatePowerSet(ipSet, currIndex + 1, opSet)
    // 2. include the current number to the opSet
    generatePowerSet(ipSet, currIndex + 1, opSet ++ ArrayBuffer(ipSet(currIndex)))

  }

  // driver function
  def main(args: Array[String]): Unit = {

    val ipSet = Array(1,2,3)
    val opSet = new ArrayBuffer[Int]()

    println("The "+ scala.math.pow(2,ipSet.length).toInt+" power sets are: ")
    generatePowerSet(ipSet, 0, opSet)

  }
}
