package carracing

import carracing.util.CarRacingManagerForTest
import carracing.util.RacingMovementRoleForTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class CarRacingViewTest : StringSpec({

    "getWinnerViewString 은 우승자 디스플레이 용 데이터를 넘져준다" {
        // given
        val racingCars = RacingCars(
            listOf(
                Car("Car1", 3),
                Car("Car2", 30),
                Car("Car3", 30),
                Car("Car4", 30),
                Car("Car5", 10),
                Car("Car6", 4),
            )
        )
        val randomNumberCarRacingManager = CarRacingManagerForTest(racingCars, RacingMovementRoleForTest())
        val carRacingView = CarRacingView("-", "\n")

        // when
        val winnerViewString = carRacingView.getWinnerViewString(randomNumberCarRacingManager)

        // then
        winnerViewString shouldBe "Car2, Car3, Car4가 최종 우승했습니다."
    }

    "viewResult 는 자동차 경주 디스플레이하기 위한 데이터를 넘겨준다" {
        // given
        val carDistances = listOf(1, 3, 4)
        val racingCars = RacingCars(carDistances.mapIndexed { index, distance -> Car("Car$index", distance) })
        val randomNumberCarRacingManager = CarRacingManagerForTest(racingCars, RacingMovementRoleForTest())
        val carRacingView = CarRacingView("-", "\n")
        val monitoringValue = """Car0: --
Car1: ----
Car2: -----"""

        // whenÎ
        val viewResult = carRacingView.getViewString(randomNumberCarRacingManager)

        // then
        viewResult shouldBe monitoringValue
    }

    "경주에 참가한 자동차가 없는 경우 빈 문자열이 나온다" {
        // given
        val carRacingManager = CarRacingManagerForTest(RacingCars(), RacingMovementRoleForTest())
        val carRacingView = CarRacingView("-", "\n")
        val monitoringValue = ""

        // whenÎ
        val viewResult = carRacingView.getViewString(carRacingManager)

        // then
        viewResult shouldBe monitoringValue
        viewResult.length shouldBe 0
    }
})
