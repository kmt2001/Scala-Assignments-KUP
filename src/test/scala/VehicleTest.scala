import org.scalatest.funsuite.AnyFunSuite

class VehicleTest extends AnyFunSuite {

  // Test cases for Car class
  test("A Car can be driven") {
    val car = new Car
    assert(car.drive === "Car can be driven")
  }

  test("A Car can move by driving") {
    val car = new Car
    assert(car.move === "Car can be driven")
  }

  // Test cases for Boat class
  test("A Boat can be sailed") {
    val boat = new Boat
    assert(boat.sail === "Boat can be sailed")
  }

  test("A Boat can move by sailing") {
    val boat = new Boat
    assert(boat.move === "Boat can be sailed")
  }

  // Test cases for Aeroplane class
  test("An Aeroplane can be flown") {
    val aeroplane = new Aeroplane
    assert(aeroplane.fly === "Aeroplane can be flown")
  }

  test("An Aeroplane can move by flying") {
    val aeroplane = new Aeroplane
    assert(aeroplane.move === "Aeroplane can be flown")
  }

  // Test cases for FlyingCar class
  test("A FlyingCar can be driven") {
    val flyingCar = new FlyingCar
    assert(flyingCar.drive === "FlyingCar can be driven")
  }

  test("A FlyingCar can be flown") {
    val flyingCar = new FlyingCar
    assert(flyingCar.fly === "FlyingCar can be flown")
  }

  test("A FlyingCar can move by driving and flying") {
    val flyingCar = new FlyingCar
    assert(flyingCar.move === "FlyingCar can be driven and FlyingCar can be flown")
  }

  // Test cases for Hovercraft class
  test("A Hovercraft can be driven") {
    val hovercraft = new Hovercraft
    assert(hovercraft.drive === "Hovercraft can be driven")
  }

  test("A Hovercraft can be sailed") {
    val hovercraft = new Hovercraft
    assert(hovercraft.sail === "Hovercraft can be sailed")
  }

  test("A Hovercraft can move by driving and sailing") {
    val hovercraft = new Hovercraft
    assert(hovercraft.move === "Hovercraft can be driven and Hovercraft can be sailed")
  }

  println("Success!")

}
