package nhandler.conversion.jpf2jvm;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.DynamicElementInfo;
import gov.nasa.jpf.vm.JPF_java_io_File;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.StaticElementInfo;
import nhandler.conversion.ConversionException;
import nhandler.conversion.ConverterBase;

/**
 * JPF2JVM converter for java.io.File
 * 
 * @author Chinmay Dabral
 */
public class JPF2JVMjava_io_FileConverter extends JPF2JVMConverter {

  /**
   * No static fields to set
   */
  @Override
  protected void setStaticFields (Class<?> JVMCls, StaticElementInfo sei, MJIEnv env) throws ConversionException {

  }

  /**
   * All the work is done by the constructor called in instantiateFrom()
   */
  @Override
  protected void setInstanceFields (Object JVMObj, DynamicElementInfo dei, MJIEnv env) throws ConversionException {

  }

  /**
   * Similar to JPF_java_io_File.getFile()
   */
  @Override
  protected Object instantiateFrom (Class<?> cl, int JPFRef, MJIEnv env) {
    int fnref = env.getReferenceField(JPFRef, "filename");
    String fname = env.getStringObject(fnref);
    return new File(fname);
  }
}
