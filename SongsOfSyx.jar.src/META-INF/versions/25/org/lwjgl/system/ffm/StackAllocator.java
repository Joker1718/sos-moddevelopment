package META-INF.versions.25.org.lwjgl.system.ffm;

import java.lang.foreign.SegmentAllocator;

public interface StackAllocator<T extends org.lwjgl.system.ffm.StackAllocator<T>> extends SegmentAllocator {
  T push();
  
  T pop();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\StackAllocator.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */