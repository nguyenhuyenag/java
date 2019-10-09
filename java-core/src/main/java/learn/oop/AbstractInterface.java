package learn.oop;

/*-
 * - Khi một class kế thừa một abstract class thì có nghĩa là ta đang thể hiện
 * mối quan hệ is-a (là)
 * 
 * - Khi một class implement một interface, thì ta đang thể hiện mối quan hệ
 * has-a (có, hay thực hiện)
 */

/**
 * Rectangle là Shape, có Width, Height
 */
class Rectangles extends Shapes implements Width, Height {

}

/**
 * Programmer là Person, thực hiện việc Programming, Debugging
 */
class Programmer extends Person implements Programming, Debugging {

}

abstract class Person {

}

abstract class Shapes {

}

interface Programming {

}

interface Debugging {

}

interface Width {

}

interface Height {

}
