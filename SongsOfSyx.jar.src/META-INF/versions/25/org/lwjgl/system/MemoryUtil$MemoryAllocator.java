package META-INF.versions.25.org.lwjgl.system;

public interface MemoryAllocator {
  long getMalloc();
  
  long getCalloc();
  
  long getRealloc();
  
  long getFree();
  
  long getAlignedAlloc();
  
  long getAlignedFree();
  
  long malloc(long paramLong);
  
  long calloc(long paramLong1, long paramLong2);
  
  long realloc(long paramLong1, long paramLong2);
  
  void free(long paramLong);
  
  long aligned_alloc(long paramLong1, long paramLong2);
  
  void aligned_free(long paramLong);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\MemoryUtil$MemoryAllocator.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */