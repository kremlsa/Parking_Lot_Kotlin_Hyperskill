package parking

import java.util.*
var parking = Parking(0)
var isCreate = false
val ncmess = "Sorry, a parking lot has not been created."

fun main() {
    var isRun = true
    val scanner = Scanner(System.`in`)
    while (isRun) {
        val action = scanner.next()
        when (action) {
            "create" -> create(scanner.nextInt())
            "park" -> if (isCreate) parking.park(scanner.next(), scanner.next()) else println(ncmess)
            "leave" -> if (isCreate) parking.leave(scanner.nextInt()) else println(ncmess)
            "status" -> if (isCreate) parking.status() else println(ncmess)
            "reg_by_color" -> if (isCreate) parking.find(scanner.next()) else println(ncmess)
            "spot_by_color" -> if (isCreate) parking.spot(scanner.next(), "color") else println(ncmess)
            "spot_by_reg" -> if (isCreate) parking.spot(scanner.next(), "registration number") else println(ncmess)
            "exit" -> isRun = false
        }
    }
}

fun create(size: Int) {
    parking = Parking(size)
    println("Created a parking lot with $size spots.")
    isCreate = true
}


class Parking(size: Int) {
    var parking: Array<Spot> = Array(size) {Spot()}

    fun find (color: String) {
        var isFind = false
        var output = ""
        for(i in parking.indices) {
            if (parking[i].color.toLowerCase() == color.toLowerCase()) {
                isFind = true
                output += "${parking[i].plate}, "
            }
        }
        if(isFind) {
            output = output.substring(0, output.length - 2)
            println(output)
        }
            else println("No cars with color $color were found.")
    }

    fun spot (value: String, type: String) {
        var isFind = false
        var output = ""
        for(i in parking.indices) {
            when (type) {
                "color" -> {
                    if (parking[i].color.toLowerCase() == value.toLowerCase()) {
                        output += "${i + 1}, "
                        isFind = true
                    }
                }
                "registration number" -> {
                    if (parking[i].plate.toLowerCase() == value.toLowerCase()) {
                        output += "${i + 1}, "
                        isFind = true
                    }
                }
            }
        }
        if(isFind) {
            output = output.substring(0, output.length - 2)
            println(output)
        }
        else println("No cars with $type $value were found.")
    }

    fun park (plate: String, color: String) {
        for(i in parking.indices) {
            if (parking[i].status == "free") {
                parking[i].plate = plate
                parking[i].color = color
                parking[i].status = "notfree"
                println("$color car parked in spot ${i + 1}.")
                return
            }
        }
        println("Sorry, the parking lot is full.")
    }

    fun leave (spot: Int) {
        if (parking[spot - 1].status != "free") {
            println("Spot $spot is free.")
            parking[spot - 1].status = "free"
            parking[spot - 1].plate = "none"
            parking[spot - 1].color = "none"
        }
        else println("There is no car in spot $spot.")
    }

    fun status () {
        var isFree = true
        for(i in parking.indices) {
            if (parking[i].status != "free") {
                isFree = false
                println("${i + 1} ${parking[i].plate} ${parking[i].color}")
            }
        }
        if (isFree) println("Parking lot is empty.")
    }
}

class Spot {
    var status: String = "free"
    var plate: String = "none"
    var color: String = "none"
}
