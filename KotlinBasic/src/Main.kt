import java.util.*;
import kotlin.math.max
import kotlin.random.Random

// Main 함수가 없으면 프로그램이 실행되지 않음
// ; 필수 X

// Top Level 상수, java의 static final과 같음
val outNum = 20

// Compile Time 상수 - main 실행 이전 값이 할당된다, 성능상 이점이 있음
const val topNum = 30

fun main() {
    print("Hello kotlin")
    println("Hello World!")

    // 타입 지정 여부와 관계없이 값의 변경은 같은 자료형에서 가능

    // Kotlin은 변수의 자동 타입 추론
    type1()

    // 변수에 타입 지정
    type2()

    // 상수 지정 Java의 final과 같음
    constant()

    // 자동 형변환 지원 X
    autoTypeTrans()

    // String 기능
    stringFunction()

    // Int 기능
    intFunction()

    // Input값 받기
    inputLine()

    // 조건문
    condition()

    // 반복문
    loop()

    // List와 Array 생성
    list()

    // try-catch문
    except()

    //null - safety
//    nullUse()

    // function
    makeFunction1(5, 6)
    makeFunction2(5, 6)
    makeFunction3(5, 6)
    // 아래와 같이 Parameter의 변수명에 값을 지정할 수 있음
    makeFunction3(b = 5, a = 6, c = 6)

    // class
    val kotlin = Person("Kotlin", 20)
    println(kotlin.name)
    println(kotlin.age)

    // private field class
    val java = Person("Java", 20);
    println(java.name)
    println(java.age)

    // data class
    var human = Person("Human", 20)
    var human2 = Person("Human", 20)
    println(human == human2)

    // init class
    val initTest = Init("test")

    val hobby = Hobby("Hobby", 20)

    // 외부에서 class 멤버 변수를 조작하는 상황
    // hobby.hobby = "야구"
}


// ----------------------------------------Abstract & Interface---------------------------------------
interface Drawable{
    fun draw()
}


// open keyword를 통해서 상속이 가능
open class Bird

class Swallow : Bird()

abstract class Animal {
    // open keyword를 통해 override를 허용
    open fun move(){
        println("move")
    }
}

// interface의 구현체의 경우 override method를 정의해야함
class Dog : Animal(), Drawable {
    override fun move() {
        println("run")
    }

    override fun draw() {
        TODO("Not yet implemented")
    }
}

class Cat: Animal() {

}
// ---------------------------------------------------------------------------------------------------

// getter, setter 제어
class Hobby(val name: String, val age: Int) {
    // private set, getter 구현으로 class 멤버 변수의 조작을 차단
    // get 메서드는 field 값으로 구현
    var hobby = "축구"
        private set
        get() = "취미 : $field"

    init{
        println("create habit")
    }

    fun some(){
        hobby = "농구"
    }
}

// init문을 통해 객체 생성시 별도의 작업을 지정 가능
class Init(val name: String){
    init{
        println("Init")
    }
}

// toSring과 hashcode, equals가 정의 되어있음, data class가 아닐경우 2개의 필드가 같은 객체는 다른 객체
data class Human(var name: String, var age: Int)

// 생성이후 값의 변경이나 조회를 하지 않는다면 private 접근제한자 설정
class People(private var name: String, private var age: Int) {}

// 내용이 없다면 중괄호는 생략 가능
// var, val을 적절히 사용하여 data의 변경과 수정이 여부를 결정
class Person(var name: String, var age: Int) {}

// Default 값을 통해 Parameter를 필수로 넣지 않아도 된다.
fun makeFunction3(a: Int, b: Int, c: Int = 0) = a * b * c

// Overloading
//fun makeFunction3(a: Int, b: Int, c: Int) = a * b * c

// Return Type 생략가능, parameter의 타입은 지정해야함
fun makeFunction3(a: Int, b: Int) = a * b

// 한줄의 Function은 중괄호 블록을 생략할 수 있다.
fun makeFunction2(a: Int, b: Int): Int = a - b

fun makeFunction1(a: Int, b: Int): Int {
    return a + b
}

fun nullUse() {
    // 아래와 같이 사용시 어떤 타입의 null 값인지 알 수 없음
    var name = null

    // Kotlin은 기본적으로 null값을 허용하지 않음
//    var name2 : String = null

    // 아래와 같이 String Type에 null값을 허용할 수 있음
    var name3: String? = null

    // null을 허용했다면 다시 null을 대입해도 Error가 발생하지 않음
    name3 = "Kotlin"
    name3 = null

    var name2: String = ""

    //  Error 발생 null을 허용한 변수와 허용하지 않은 변수는 별개의 타입
    // name2 = name

    // null check를 통해 null이 아닌경우 대입
    if (name3 != null) {
        name2 = name3
    }

    // !!를 통해 null 허용을 해제할 수 있음 but null을 허용한 뒤 Error 발생 시 개발자 책임
    name2 = name3!!

    // if를 통해 null check를 한것과 같음 null이 아니라면 중괄호 내부 블럭을 실행
    name3?.let {
        name2 = name3
    }
}

fun except() {
    val iter = listOf(1, 2, 3);
    try {
        val item = iter[6]
    } catch (e: Exception) {
        print(e.message)
    }

}

fun list() {
    // listOf의 경우 변경이 불가능하다
    val items = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // mutableList로 생성해야 변경이 가능하다
    val modifyList = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    modifyList.add(11)
    modifyList.remove(11)

    // 배열의 선언
    val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    array.set(2, 1);
    // 해당 방법이 권장됨
    array[2] = 1;
}

fun loop() {
    val items = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // 기본적인 for문
    for (i in 0..(items.size - 1)) {
        println(items[i])
    }

    // 기본값은 이하이고 부등호를 통해 미만의 값을 표시한다.
    for (i in 0..<3) {
        println(i)
    }

    // Java의 향상된 for문과 같음
    for (item in items) {
        println(item)
    }

    // forEach문
    items.forEach { it ->
        println(it)
    }

    // forEach문 Stream
    items.forEach(::println)

    // while문의 경우 java와 동일함
    var cnt = 5
    while (cnt-- > 0) {
        println("while")

        if (cnt == 2) {
            break
        }
    }

}

fun condition() {
    var i = 5

    if (i > 10) {
        print("10보다 크다")
    } else if (i > 5) {
        print("5보다 크다")
    } else {
        print("5보다 작다")
    }

    when {
        i > 10 -> {
            print("10보다 크다")
        }

        i > 5 -> {
            print("5보다 크다")
        }

        else -> {
            print("5보다 작다")
        }
    }

    // if문이 수식으로 취급되기 때문에 변수에 대입할 수 있다.
    var res = if (i > 10) {
        "10보다 크다"
    } else if (i > 5) {
        "5보다 크다"
    } else {
        "5보다 작다"
    }
    println(res)

    // Kotlin의 삼항 연산자
    res = if (i > 10) "10보다 큼" else "10보다 작음"
    println(res)
}

fun inputLine() {
    // in은 Kotlin에서 사용할 수 없는 문자로 ``로 감싸서 사용
    // Scanner는 Java와 사용이 동일함
    val reader = Scanner(System.`in`)
}

fun intFunction() {
    var i = 10
    var j = 20

    var max = max(i, j)

    // 0 ~ 99까지
    val randomNumber = Random.nextInt(0, 100)
    println(randomNumber)
}

fun stringFunction() {
    var name = "Kotlin"

    println(name[0])
    println(name.lowercase())
    println(name.uppercase())

    // String interpolation
    // 공백을 제거시 Error
    println("$name 을 학습 중 입니다.")

    // 중괄호를 사용해 수식을 사용할 수 있음
    println("${name + 50}을 학습 중 입니다.")
}

fun autoTypeTrans() {
    var a = 10
    var b = 20L

    // Java와 같은 자동 형변환을 지원하지 않는다
    // a = b;

    // 아래와 같이 형 변환을 해야한다.
    a = b.toInt()
}

fun constant() {
    // 초기화 이후 값의 변경 X
    val num = 20
    // num = 30
}

fun type2() {
    var int: Int = 10
    var name: String = "Kotlin"
    var double: Double = 3.141592
}

fun type1() {
    var int = 10
    var name = "Kotlin"
    var double = 3.141592
}
