package nhandler.conversion.jpf2jvm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import gov.nasa.jpf.vm.DynamicElementInfo;
import gov.nasa.jpf.vm.JPF_java_text_SimpleDateFormat;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.StaticElementInfo;
import nhandler.conversion.ConversionException;

public class JPF2JVMjava_text_SimpleDateFormatConverter extends JPF2JVMConverter {

  @Override
  protected void setStaticFields (Class<?> JVMCls, StaticElementInfo sei, MJIEnv env) throws ConversionException {
    // TODO Auto-generated method stub

  }

  /**
   * No instance fields to set. We just have to return the delegatee.
   */
  @Override
  protected void setInstanceFields (Object JVMObj, DynamicElementInfo dei, MJIEnv env) throws ConversionException {

  }

  @Override
  protected Object instantiateFrom (Class<?> cl, int jPFRef, MJIEnv env) {
    assert cl == SimpleDateFormat.class : "Not the right converter!";
    Object JVMObj = null;
    JVMObj = getInstanceFromNativePeer(jPFRef, env);
    return JVMObj;
  }

  private SimpleDateFormat getInstanceFromNativePeer (int JPFRef, MJIEnv env) {
    SimpleDateFormat obj = null;
    JPF_java_text_SimpleDateFormat nativePeer = (JPF_java_text_SimpleDateFormat) env.getClassInfo(JPFRef).getNativePeer();
    Method getInstance = null;
    try {
      getInstance = JPF_java_text_SimpleDateFormat.class.getDeclaredMethod("getInstance", MJIEnv.class, int.class);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (SecurityException e) {
      e.printStackTrace();
    }
    getInstance.setAccessible(true);
    try {
      obj = (SimpleDateFormat) getInstance.invoke(nativePeer, env, JPFRef);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return obj;
  }

}
