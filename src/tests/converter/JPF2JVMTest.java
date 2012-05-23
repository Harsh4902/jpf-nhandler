package converter;

import gov.nasa.jpf.jvm.MJIEnv;
import gov.nasa.jpf.util.test.TestJPF;

import java.util.HashMap;

import org.junit.Test;

/**
 * This class tests the conversion form JPF to JVM, and it works along its
 * corresponding native peer which is JPF_converter_JPF2JVMTest.
 * 
 * The methods of this class create JPF objects and classes, and by invoking
 * native methods, the JPF object/class is converted to the JVM ones in the
 * native peer which if the object/class is created as expected.
 * 
 * @author Nastaran Shafiei
 * @author Franck van Breugel
 */
public class JPF2JVMTest extends TestJPF {
  private final static String[] JPF_ARGS = {};

  private static MJIEnv env;

  public static void main (String[] args){
    runTestsOfThisClass(args);
  }

  public static void setEnv (MJIEnv env){
    JPF2JVMTest.env = env;
  }

  private native void convertStringTest (String s);

  @Test
  public void convertStringTest (){
    if (verifyNoPropertyViolation()){
      String s = new String("Hello World");
      convertStringTest(s);
    }
  }

  private native void convertIntegerTest (Integer i);

  @Test
  public void convertIntegerTest (){
    if (verifyNoPropertyViolation()){
      Integer i = new Integer(100);
      convertIntegerTest(i);
    }
  }

  private native void convertArrayTest (String[] arr);

  @Test
  public void convertArrayTest (){
    if (verifyNoPropertyViolation()){
      String[] arr = { "e1", "e2", "e3" };
      convertArrayTest(arr);
    }
  }

  private native void convertHashMapTest (HashMap<Integer, String> map);

  @Test
  public void convertHashMapTest (){
    if (verifyNoPropertyViolation()){
      HashMap<Integer, String> map = new HashMap<Integer, String>();
      map.put(0, "zero");
      map.put(1, "one");
      map.put(2, "two");
      convertHashMapTest(map);
    }
  }

  public static class TestConversion {
    protected static int i = 0;

    protected static void inc (int amount){
      i += amount;
    }
  }

  private native void convertClassTest (Class<?> cls);

  @Test
  public void convertClassTest (){
    if (verifyNoPropertyViolation()){
      TestConversion.inc(10);
      convertClassTest(TestConversion.class);
    }
  }
}
