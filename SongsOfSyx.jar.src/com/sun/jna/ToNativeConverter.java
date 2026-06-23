package com.sun.jna;

public interface ToNativeConverter {
  Object toNative(Object paramObject, ToNativeContext paramToNativeContext);
  
  Class<?> nativeType();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\com\sun\jna\ToNativeConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */