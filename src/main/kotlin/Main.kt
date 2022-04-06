fun main() {
    val list = mutableListOf<Int>(7, 2, 1, 8, 6, 3, 5, 4, 5, 7, 9, 6, 54, 567,5, 66, 7, 8)


    val quick = QuickSorting()
//    println(quick.partition(list, 0, list.size-1))
    println(quick.quickSort(list, 0, list.size-1))
}

class QuickSorting(){
    fun partition(list: MutableList<Int>, low: Int, high: Int): Int {
        var i = low-1
        var j = low
        var p = list[high]

        for (index in low..high) {
            if (list[j] >= p) {
                j++

                if (j >= high) {
                    list[high] = list[i+1]
                    list[i+1] = p
                    println(list)
                    return i+1
                }

            } else if (list[j] < p) {
                i++
                val temp = list[i]
                list[i] = list[j]
                list[j] = temp
                j++
            }
        }
        println(list)
        return (i+1)
    }

    fun quickSort(list: MutableList<Int>, low: Int, high: Int) {
        if(low < high) {
            val pi = partition(list, low, high)
//            println(pi)
            quickSort(list, low, pi-1)
            quickSort(list, pi+1, high)
        }
    }
}

