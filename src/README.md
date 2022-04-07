### 3장 함수

#### 3.3.4 확장함수는 오버라이드 할 수 없다.

확장함수는 클래스의 일부가 아니다. 확장 함수는 클래스 밖에 선언된다.   
확장 함수를 호출할 때 수신객체로 지정한 변수의 정적 타입에 의해 확장함수가 결정되지 않는다.  
어떤 클래스를 확장한 함수와 그 클래스의 멤버 함수의 이름과 시그니처가 같다면 확장 함수가 아니라 멤버 함수가 호출된다.(멤버 함수의 우선순위가 더 높다.)

#### 3.3.5 확장 프로퍼티

프로퍼티라는 이름으로 불리기는 하지만 상태를 저장할 적절한 방법이 없기 때문에 실제로 확장 프로퍼티는 아무 상태로 가질 수 없다.

```kotlin
val String.lastChar: Char
    get() = get(length - 1)
```

기본 게터구현을 제공할 수 없으므로 최소한 게터는 꼭 정의해주어야 한다.  
마찬가지로 초기화 코드에서 계산한 값을 담을 장소가 전혀 없으므로 초기화 코드로 쓸 수 없다.

```kotlin
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: char) {
        this.setCharAt(length - 1, value)
    }

val sb = StringBuilder("Kotlin?")
sb.lastChar = "!" // 셋터호출  => Kotlin!
```

#### 3.6 로컬함수와 저장

```kotlin
class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException(
                "Can't save user ${user.id} : empty Name"
        )
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException(
                "Can't save user ${user.id} : empty Address"
        )
    }
} 
```

중복코드 줄이기

```kotlin
fun saveUser(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                    "Can't save user ${user.id} : empty ${fieldName}"
            )
        }
    }

    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
} 
```

로컬함수에서 바깥 함수의 파라미터 접근하기

```kotlin
fun saveUser(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                    "Can't save user ${user.id} : empty ${fieldName}"
            )
        }
    }

    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
}
```

검증로직을 확장함수로 추출하기

```kotlin
class User(val id: Int, val name: String, val address: String)

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                    "Can't save user $id : empty $fieldName"
            )
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser(user: User) {
    user.validateBeforeSave()

    // user 데이터베이스에 저장 
}
```