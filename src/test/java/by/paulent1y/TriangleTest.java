package by.paulent1y;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class TriangleTest {

    //1) Напишите функцию, вычисляющую площадь треугольника по трём сторонам (int a, int b, int c). Разместите класс с функцией в src/main/java.
    //src/main/.../Triangle.java - класс треугольника. Конструктор позволяет создать треугольник по трем сторонам с проверкой на невозможность построения


    //2) Разместите тесты на эту функцию в классе src/test/java/.../TriangleTest.java.
    //10 тестов ниже, собственно


    //3) Настройте генерацию отчета и по желанию — логирование.
    //Отчет о тестах сохраняется в target/surefire-reports. С алюром пока не получилось подружиться
    //Плагин подключен из меню мавен, запускается после билда и создает отчет. Надеюсь так и должно быть
    //Логгирование самое простое через ванильный java.util.logging.
    //Даже что то пишет. Но куча красного текста в консоли конечно такое себе

    private final static Logger logger = Logger.getLogger("TriangleTest");
    @DisplayName("Test for RuntimeError when Triangle is impossible")
    @ParameterizedTest
    @CsvSource({"10,20,30", "3,4,7", "5,3,-1", "0,2,3"})
    public void testConstructorException(int a, int b, int c) {
        //Треугольник не может существовать если какая то из его сторон больше суммы двух других
        //так что тут тест на эксепшен при попытке создания таких треугольников
        logger.log(Level.INFO, "Testing triangle with sides " + a + "," + b + "," + c);
        Assertions.assertThrows(RuntimeException.class, () -> new Triangle(a,b,c));
    }

    @DisplayName("Constructor test with adequate triangles")
    @ParameterizedTest
    @MethodSource("testConstructorResources")
    void testConstructor(int a, int b, int c){
        //тут попытка взять источником значений метод.
        logger.log(Level.INFO, "Testing triangle with sides " + a + "," + b + "," + c);
        new Triangle(a,b,c);
    }

    static Stream<Arguments> testConstructorResources(){
        //собственно метод со значениями
        return Stream.of(
                Arguments.of(3,4,5),
                Arguments.of(6,4,3),
                Arguments.of(5,6,8),
                Arguments.of(405,17,395)
        );
    }

    @Test
    @DisplayName("Area test with 3,4,5 triangle")
    void testArea1(){
        //т.к. уже попробовал с CSV и методами для значений, это просто тест
        int a=3,b=4,c=5;
        logger.log(Level.INFO, "Testing triangle with sides " + a + "," + b + "," + c);
        Triangle t = new Triangle(a,b,c);
        Assertions.assertEquals(6.0, t.getArea(), 0.0001);
    }
    @Test
    @DisplayName("Area test with 70,70,10 triangle with 1.0 approximation")
    void testArea2(){
        //этот тоже, с "примерным" высчитываением значения, прикольно работает если лень досконально считать сколько там должно выйти)
        //Думается мне что это непрофессионально, но тоже имеет место быть
        int a=70, b=70, c=10;
        logger.log(Level.INFO, "Testing triangle with sides " + a + "," + b + "," + c);
        Triangle t = new Triangle(70,70,10);
        Assertions.assertEquals(350.0, t.getArea(), 1.0);
    }

    @Test
    @Disabled // если убрать, в отчет положится что тест упал
    @DisplayName("Test that fails anyway but disabled")
    void testThatFails(){
        Assertions.assertEquals(10,9);
    }

    @Test
    @Disabled
    @DisplayName("Disabled test")
    void testThatDisabled(){
        throw new RuntimeException("Exception that should be thrown");
    }


}
