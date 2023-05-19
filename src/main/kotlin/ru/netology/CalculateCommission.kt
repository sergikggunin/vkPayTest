package ru.netology

fun calculateCommission(
    cardType: String = "VK Pay",
    previousTransfers: Int = 0,
    currentTransfer: Int
): Double {
    return when (cardType) {
        "MasterCard", "Maestro" -> {
            if (previousTransfers + currentTransfer <= 75000) {
                0.0
            } else {
                0.006 * currentTransfer + 20
            }
        }
        "Visa", "Мир" -> {
            val commission = 0.0075 * currentTransfer
            if (commission < 35) 35.0 else commission
        }
        "VK Pay" -> 0.0
        else -> 0.0
    }
}