import org.scalatest.funsuite.AnyFunSuite
import VehicleMovementAccordingToFuel._

class VehicleMovementAccordingToFuelTest extends AnyFunSuite {

 test("Vehicle should move successfully twice with 50 fuel, refuel, and display remaining fuel") {
    val vehicle = new Vehicle(50)
    val (car, message1) = vehicle.moveVehicle()
    val (sameCar, message2) = car.moveVehicle()
    val (refueledCar, message3) = sameCar.refuelVehicle()
    val (finalCar, message4) = refueledCar.moveVehicle()
    assert(car.initialFuel == 30)
    assert(sameCar.initialFuel == 10)
    assert(refueledCar.initialFuel == 50)
    assert(finalCar.initialFuel == 30)
    assert(message1 == "Vehicle moved 20 km. Fuel remaining: 30")
    assert(message2 == "Vehicle moved 20 km. Fuel remaining: 10")
    assert(message3 == "Refueled vehicle with 40 liters of fuel.")
    assert(message4 == "Vehicle moved 20 km. Fuel remaining: 30")
  }
}
