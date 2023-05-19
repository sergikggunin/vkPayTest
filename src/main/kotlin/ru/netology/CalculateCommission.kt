package ru.netology

fun calculateCommission(
    cardType: String = "VK Pay",
    previousTransfers: Int = 0,
    currentTransfer: Int
): Double {
    // Проверка лимитов
    when (cardType) {
        "MasterCard", "Maestro" -> {
            if (previousTransfers + currentTransfer > 150_000_00 || previousTransfers + currentTransfer > 600_000_00) {
                return -1.0
            }
        }
        "VK Pay" -> {
            // Проверка ежемесячного и единоразового лимитов
            if (currentTransfer > 15_000_00 || previousTransfers + currentTransfer > 40_000_00) {

                return -1.0
            }
        }
    }
    return when (cardType) {
        "MasterCard", "Maestro" -> {
            if (previousTransfers + currentTransfer <= 75_000_00) {
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
