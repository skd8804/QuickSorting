fun main() {
    val list = mutableListOf<Int>(1,2,3)


    val quick = QuickSorting()

    println(quick.quickSort(list, 0, list.size-1))
}

class QuickSorting(){

//    Partitioning method is used from this: https://www.youtube.com/watch?v=MZaf_9IZCrc
    fun partition(list: MutableList<Int>, low: Int, high: Int): Int { //low - initial value of first i in list, high - initial value of highest i in list
        var i = low-1  // select index which is 1 lower than lowest in the list eg. -1
        var j = low // 1
        val p = list[high] // select pivot

        for (index in low..high) { // iterate list from low to high index
            if (list[j] >= p) { // check if j value is higher or equal to pivot
                j++ // if it is increase j index by 1

                if (j >= high) { // if j index is at same position as p, at the end of list
                    list[high] = list[i+1] // if it is swap p index with list[i+10]
                    list[i+1] = p // list[i+1] becomes pivot
                    return (i+1) // sublist is finished partitioning, returning pivot_index position pi = i+1
                 }

            } else if (list[j] < p) { // check if j value is less than p
                i++ // increase i++ index by 1
                val temp = list[i] // swap initiation
                list[i] = list[j] // swap i element with, with j
                list[j] = temp // swap j element with i
                j++ // increase j
            }
        }
        println("something when wrong returning -1")
        return  -1
    }

    fun quickSort(list: MutableList<Int>, low: Int, high: Int): MutableList<Int> {
        if(low < high) {
            val pi = partition(list, low, high)
//            println(pi)
            quickSort(list, low, pi-1)
            quickSort(list, pi+1, high)
        }
        return list
    }
}

