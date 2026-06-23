package com.sun.jna;

public interface NativeMapped {
  Object fromNative(Object paramObject, FromNativeContext paramFromNativeContext);
  
  Object toNative();
  
  Class<?> nativeType();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\com\sun\jna\NativeMapped.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */