package com.github.fulrich.testcharged.generators.locations


trait LocationGenerators {
  val street = StreetGenerators
  val city = CityGenerators
  val country = CountryGenerators
}
