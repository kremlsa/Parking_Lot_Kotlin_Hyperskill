import java.util.*

fun parseCardNumber(cardNumber: String): Long {
    if ("\\d\\d\\d\\d\\s\\d\\d\\d\\d\\s\\d\\d\\d\\d\\s\\d\\d\\d\\d".toRegex().matches(cardNumber)) {
        return cardNumber.replace(" ", "").toLong()
    } else {
        throw Exception("Number is wrong")
    }
}
