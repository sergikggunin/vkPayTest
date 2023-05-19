package ru.netology

import ru.netology.calculateCommission

fun main() {
    val type = "Visa"
    val totalPreviousTransfers = 70_000_00
    val transferAmount = 1_000_00

    val commission = calculateCommission(
        cardType = type,
        previousTransfers = totalPreviousTransfers,
        currentTransfer = transferAmount
    )

    println("Комиссия составит: $commission руб.")
}
