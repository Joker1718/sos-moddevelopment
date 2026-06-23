/*    */ package org.lwjgl.stb;
/*    */ 
/*    */ import org.lwjgl.system.Configuration;
/*    */ import org.lwjgl.system.Library;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.Platform;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class LibSTB
/*    */ {
/*    */   static {
/* 16 */     String libName = Platform.mapLibraryNameBundled("lwjgl_stb");
/* 17 */     Library.loadSystem(System::load, System::loadLibrary, LibSTB.class, "org.lwjgl.stb", libName);
/*    */     
/* 19 */     MemoryUtil.MemoryAllocator allocator = MemoryUtil.getAllocator(((Boolean)Configuration.DEBUG_MEMORY_ALLOCATOR_INTERNAL.get(Boolean.valueOf(true))).booleanValue());
/* 20 */     setupMalloc(allocator
/* 21 */         .getMalloc(), allocator
/* 22 */         .getCalloc(), allocator
/* 23 */         .getRealloc(), allocator
/* 24 */         .getFree(), allocator
/* 25 */         .getAlignedAlloc(), allocator
/* 26 */         .getAlignedFree());
/*    */   }
/*    */   
/*    */   private static native void setupMalloc(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*    */   
/*    */   static void initialize() {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\LibSTB.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */