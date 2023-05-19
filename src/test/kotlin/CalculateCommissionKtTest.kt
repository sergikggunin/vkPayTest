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
}
