package carracing

import carracing.util.CarRacingManagerForTest
import carracing.util.RacingMovementRoleForTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarRacingManagerTest : StringSpec({
    "getWinnerCars 는 자동차 경우 우승자 리스트를 가져옵니다" {
        // given
        val racingCars = RacingCars(
            listOf<Car>(
                Car("TestCar1", 3),
                Car("TestCar2", 4),
                Car("TestCar3", 10),
                Car("TestCar4", 0),
                Car("TestCar5"),
            )
        )
        val carRacingManager = CarRacingManagerForTest(racingCars, RacingMovementRoleForTest())

        // when
        val maxDistanceCars = carRacingManager.getWinnerCars()

        // then
        maxDistanceCars.size shouldBe 1
        maxDistanceCars[0].name shouldBe "TestCar3"
        maxDistanceCars[0].distance shouldBe 10
    }

    "tryMoveCar 는 RacingMovementRole 가 판단한 이동 거리 만큼 자동차가 이동한다" {
        // given
        val moveDistance = 4
        val nowDistance = 10
        val racingCars = RacingCars(listOf(Car("testCar", nowDistance)))
        val racingMovementRoleForTest = RacingMovementRoleForTest()
        val randomIntCarRacingManager = CarRacingManagerForTest(racingCars, racingMovementRoleForTest)

        // when
        randomIntCarRacingManager.tryMoveCar(0, moveDistance)
        val nowCarDistance = racingCars.getCarDistance(0)
        val movementRoleMoveDistance = racingMovementRoleForTest.getMoveDistance(moveDistance)

        // then
        movementRoleMoveDistance shouldBe moveDistance
        nowCarDistance shouldBe moveDistance + nowDistance
    }

    "getCarSize 는 CarList.Size 를 가져온다" {
        // given
        val cars = listOf(
            Car("TestCar1"),
            Car("TestCar2"),
            Car("TestCar3"),
            Car("TestCar4"),
            Car("TestCar5")
        )
        val carList = RacingCars(cars)
        val carRacingManagerForTest = CarRacingManagerForTest(carList, RacingMovementRoleForTest())

        // when
        val carListSize = carRacingManagerForTest.getCarSize()

        // then
        carListSize shouldBe cars.size
    }

    "getCarList 는 CarList 데이터 가져온다" {
        // given
        val distance = 3
        val racingCarsManager = RacingCars(listOf(Car("testCar", distance)))
        val carRacingManagerForTest = CarRacingManagerForTest(racingCarsManager, RacingMovementRoleForTest())

        // when
        val carList = carRacingManagerForTest.getCarList()

        // then
        carList.size shouldBe 1
        carList[0].distance shouldBe distance
    }
})
