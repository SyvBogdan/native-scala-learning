package com.learning.basics.imports

// basic imports as in java
import com.learning.basics.helper.Case

// import all classes from package
import com.learning.basics.imports.testimportpkg._

// import all classes from package except just one
import com.learning.basics.imports.testimportpkghide.{HideClass => _, _}

// import all selected classes
import com.learning.basics.imports.selectedimport.{Class1,Class2}

// import making alias for our convenient usage of different class's names from sources
import com.learning.basics.imports.aliaspkg.{ ToLongScalaClassIBoredWhileReadIt => ShortAlias }

object TestImports {

  def main(args: Array[String]): Unit = {

    val case1 = Case.createNewCase("test imports", 1)

    val testCaseClass = new TestCaseClass

    val testCaseClass2 = new TestCaseClass2

    case1.endOfCase

    val case2 = Case.createNewCase("except import", 2)

    // class can't be imported due to its exception in imports pattern
    // val hideClass = new HideClass

    val anotherOneClass = new AnotherOneClass
    val visible = new VisibleClass
    case2.endOfCase

    val case3 = Case.createNewCase(" import alias ", 3)
    val shortAlias = new ShortAlias

    case3.endOfCase

    val case4 =  Case.createNewCase(" selected import ", 4)

    val class1 = new Class1

    val class2 = new Class2

    // not selected so can't be used
    //val class3 = new Class3

    case4.endOfCase

    val case5 =  Case.createNewCase(" inner import ", 4)

    def getClass3Path(): String ={
      // import inside function and hide in outer scope
      import com.learning.basics.imports.selectedimport.Class3
      val class3Path = (new Class3).getClass.getName
      class3Path

    }

    class TestInnerClass{
      import com.learning.basics.imports.selectedimport.Class3
      val class3 = new Class3

    }

    val func = (int : Int ) => {
      import com.learning.basics.imports.selectedimport.Class3
      val class3 = new Class3
      int
    }

    println(getClass3Path)
    case5.endOfCase
  }

}
