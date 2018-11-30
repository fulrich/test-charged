---
layout: home
section: "generators"
title: "Generators"
position: 2
---

## Generators
One of the main features of TestCharged is Generators.

Generators are a way for you to create test data without relying on fixtures.
In large applications fixtures often start to become a crux where multiple tests are relying on the same fixtures due to test data being complex and difficult to create.
This leads to tests being brittle and difficult to change.  
The fixtures themselves become almost impossible to change without effecting multiple tests which leads to us making an increasing number of fixtures to the point nobody can track them anymore.

The major advantage of switching to Generators is we no longer need to track all our fixtures.
An even larger benefit that came from this for us was it forced us to test **behaviour** instead of **data**.
This lead to much better tests that actually testing what we needed 

### Example
Take the below test as an example
```scala
class UserPersistenceTest extends FunSuite {
  val userRepository = new UserRepository()
  val testUser = User(
    id = None,
    name = "Han Solo",
    organization = "Alliance",
    role = "Smuggler"
  )

  test("A user can be created in the database") {
    val storedUser = userRepository.save(testUser)
    val fetchedUser = userRepository.getById(storedUser.id)
    
    fetchedUser shouldBe storedUser
  }
}
```

If the User structure ever changes every test that follows a similar pattern will need to be updated.
If there was a fixture instead each fixture would need to be updated.
If you instead use a generator you simply update the generator and your tests are updated everywhere:

```scala
class UserPersistenceTest extends FunSuite {
  val userRepository = new UserRepository()

  test("A user can be created in the database") {
    val testUser = UserGenerator.value
  
    val storedUser = userRepository.save(testUser)
    val fetchedUser = userRepository.getById(storedUser.id)
    
    fetchedUser shouldBe storedUser
  }
}
```
