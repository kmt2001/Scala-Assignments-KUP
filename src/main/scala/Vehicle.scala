//@uthor: Krishna Mohan Tiwari
// Here, i believe, there is no need of Exception Handling as per the assignment.

// Define traits for different types of movement
trait Drivable {
  def drive: String
}

trait Sailable {
  def sail: String
}

trait Flyable {
  def fly: String
}

// Define a trait for vehicles that can move
trait Vehicle {
  def move: String
}

// Define specific vehicle classes and mix in the appropriate traits to specify how they can move
class Car extends Vehicle with Drivable {
  override def move: String = drive
  override def drive: String = "Car can be driven"
}

class Boat extends Vehicle with Sailable {
  override def move: String = sail
  override def sail: String = "Boat can be sailed"
}

class Aeroplane extends Vehicle with Flyable {
  override def move: String = fly
  override def fly: String = "Aeroplane can be flown"
}

class FlyingCar extends Vehicle with Drivable with Flyable {
  override def move: String = drive + " and " + fly
  override def drive: String = "FlyingCar can be driven"
  override def fly: String = "FlyingCar can be flown"
}

class Hovercraft extends Vehicle with Drivable with Sailable {
  override def move: String = drive + " and " + sail
  override def drive: String = "Hovercraft can be driven"
  override def sail: String = "Hovercraft can be sailed"
}

//Test cases are in src/Test folder with name VehicleTest.scala