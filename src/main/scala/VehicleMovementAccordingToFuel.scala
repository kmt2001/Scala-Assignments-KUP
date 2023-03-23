// Author: Krishna Mohan Tiwari
// Date: March 23, 2023

/**
 * This object contains a Vehicle class that simulates vehicle movement according to fuel level.
 */
object VehicleMovementAccordingToFuel {

  /**
   * This class represents a vehicle with a fuel level and a fuel capacity.
   * @param initialFuel The initial fuel level of the vehicle.
   */
  class Vehicle(val initialFuel: Int) {

    // The maximum fuel capacity of the vehicle
    private val maxFuelCapacity = 50

    /**
     * This method moves the vehicle 20 kilometers, if it has enough fuel.
     * @return A tuple containing a new Vehicle object with the updated fuel level and a message describing the movement.
     */
    def moveVehicle(): (Vehicle, String) = {
      try {
        if (initialFuel >= 20) {
          val updatedFuel = initialFuel - 20
          val message = s"Vehicle moved 20 km. Fuel remaining: $updatedFuel"
          (new Vehicle(updatedFuel), message)
        } else {
          (this, "Vehicle has insufficient fuel.")
        }
      } catch {
        case e: Exception => (this, e.getMessage)
      }
    }

    /**
     * This method refuels the vehicle to its maximum fuel capacity.
     * @return A tuple containing a new Vehicle object with the updated fuel level and a message describing the refueling.
     */
    def refuelVehicle(): (Vehicle, String) = {
      try {
        val fuelToAdd = maxFuelCapacity - initialFuel
        val message = s"Refueled vehicle with $fuelToAdd liters of fuel."
        (new Vehicle(initialFuel + fuelToAdd), message)
      } catch {
        case e: Exception => (this, e.getMessage)
      }
    }
  }
}

//Test cases are in test folder.
