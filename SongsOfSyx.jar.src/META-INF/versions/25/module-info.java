module org.lwjgl {
  requires java.base;
  requires transitive jdk.unsupported;
  
  exports org.lwjgl;
  exports org.lwjgl.system;
  exports org.lwjgl.system.ffm;
  exports org.lwjgl.system.freebsd;
  exports org.lwjgl.system.jni;
  exports org.lwjgl.system.libc;
  exports org.lwjgl.system.libffi;
  exports org.lwjgl.system.linux;
  exports org.lwjgl.system.macosx;
  exports org.lwjgl.system.windows;
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\module-info.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */