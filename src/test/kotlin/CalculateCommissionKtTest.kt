import org.junit.Assert.assertEquals
import org.junit.Test
import ru.netology.calculateCommission

class CalculateCommissionTest {

    @Test
    fun testCalculateCommission() {
        val commission = calculateCommission(
            cardType = "MasterCard",
            previousTransfers = 1000_00,
            currentTransfer = 1000_00
        )
        assertEquals(620.0, commission, 0.01)
    }

    @Test
    fun testCalculateCommissionMasterCardAboveLimit() {
        val commission = calculateCommission(
            cardType = "MasterCard",
            previousTransfers = 80_000_00,
            currentTransfer = 1_000_00
        )
        val expected = 620.0
        assertEquals(expected, commission, 0.01)
    }

    @Test
    fun testCalculateCommissionVKPay() {
        val commission = calculateCommission(
            cardType = "VK Pay",
            currentTransfer = 10_000_00
        )
        val expected = 0.0
        assertEquals(expected, commission, 0.01)
    }

    @Test
    fun testCalculateCommissionMasterCardBelowLimit() {
        val commission = calculateCommission(
            cardType = "MasterCard",
            previousTransfers = 70_000_00,
            currentTransfer = 1_000_00
        )
        assertEquals(620.0, commission, 0.01)
    }


    @Test
    fun testCalculateCommissionUnknownCardType() {
        val commission = calculateCommission(
            cardType = "RandomCardType",
            currentTransfer = 1_000_00
        )
        assertEquals(0.0, commission, 0.01)
    }
    @Test
    fun testCalculateCommissionMasterCardAboveLimit1() {
        val commission = calculateCommission(
            cardType = "MasterCard",
            previousTransfers = 80_000_00,
            currentTransfer = 1_000_00
        )
        val expected = 620.0
        assertEquals(expected, commission, 0.01)
    }
    @Test
    fun testCalculateCommissionInvalidCardType() {
        val commission = calculateCommission(
            cardType = "InvalidCardType",
            currentTransfer = 1_000_00
        )
        assertEquals(0.0, commission, 0.01)
    }
    @Test
    fun testCalculateCommissionVKPayOverLimit() {
        val commission = calculateCommission(
            cardType = "VK Pay",
            previousTransfers = 40000_00,
            currentTransfer = 16000_00
        )
        assertEquals(0.0, commission, 0.01)
    }
    @Test
    fun testCalculateCommissionUnknownCardType2() {
        val commission = calculateCommission(
            cardType = "RandomCardType",
            currentTransfer = 10_000_00
        )
        assertEquals(0.0, commission, 0.01)
    }

    @Test
    fun testCalculateCommissionVisaCardType() {
        val commission = calculateCommission(
            cardType = "Visa",
            currentTransfer = 1_000_00
        )
        assertEquals(750.0, commission, 0.01)
    }
    @Test
    fun testCalculateCommissionVisaBelowMinimum() {
        val commission = calculateCommission(
            cardType = "Visa",
            currentTransfer = 500
        )
        assertEquals(35.0, commission, 0.01)
    }

    @Test
    fun testCalculateCommissionMirCardType() {
        val commission = calculateCommission(
            cardType = "Мир",
            currentTransfer = 1_000_00
        )
        assertEquals(750.0, commission, 0.01)
    }
    @Test
    fun testCalculateCommissionMasterCardAboveLimit2() {
        val commission = calculateCommission(
            cardType = "MasterCard",
            previousTransfers = 70_000_00,
            currentTransfer = 10_000_00
        )
        assertEquals(6020.0, commission, 0.01)
    }
    @Test
    fun testCalculateCommissionVisaAboveMinimum() {
        val commission = calculateCommission(
            cardType = "Visa",
            currentTransfer = 10_000_00
        )
        assertEquals(70.0, commission, 0.01)
    }

    @Test
    fun testCalculateCommissionMasterCardBelowLimit2() {
        val commission = calculateCommission(
            cardType = "MasterCard",
            previousTransfers = 70_000_00,
            currentTransfer = 1_000_00
        )
        assertEquals(620.0, commission, 0.01)
    }
}


