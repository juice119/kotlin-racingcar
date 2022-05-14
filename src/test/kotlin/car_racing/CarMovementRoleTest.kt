package car_racing

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarMovementRoleTest : StringSpec({
    "isForwardNumber 는 랜덤 숫자를 기준으로 전진해야하는 숫자인지 판별한다" {
        // given
        val randomNumber = 4

        // when
        val moveDistance = CarMovementRole.getMoveDistance(randomNumber)

        // then
        moveDistance shouldBe 1
    }

    "4미만의 랜덤 숫자는 전진 할수 없다" {
        // given
        val randomNumber = 1

        // when
        val moveDistance = CarMovementRole.getMoveDistance(randomNumber)

        // then
        moveDistance shouldBe 0
    }

    "0 이하의 숫자를 넣으면 IllegalArgumentException 발생" {
        // given
        val randomNumber = 0

        // when
        shouldThrowExactly<IllegalArgumentException> {
            CarMovementRole.getMoveDistance(randomNumber)
        }.message shouldBe ErrorMessage.getMinNumberError(randomNumber, 1)
    }

    "10 이상의 숫자를 넣으면 IllegalArgumentException 발생" {
        // given
        val randomNumber = 10

        // when
        shouldThrowExactly<IllegalArgumentException> {
            CarMovementRole.getMoveDistance(randomNumber)
        }.message shouldBe ErrorMessage.getMaxNumberError(randomNumber, 9)
    }
})
