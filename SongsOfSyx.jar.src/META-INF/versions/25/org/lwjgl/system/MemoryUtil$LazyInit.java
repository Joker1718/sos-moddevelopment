/*    */ package META-INF.versions.25.org.lwjgl.system;
/*    */ 
/*    */ import org.lwjgl.system.APIUtil;
/*    */ import org.lwjgl.system.Configuration;
/*    */ import org.lwjgl.system.MemoryManage;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class LazyInit
/*    */ {
/*    */   static {
/* 70 */     boolean debug = ((Boolean)Configuration.DEBUG_MEMORY_ALLOCATOR.get(Boolean.valueOf(false))).booleanValue();
/*    */   }
/* 72 */   static final MemoryUtil.MemoryAllocator ALLOCATOR_IMPL = MemoryManage.getInstance(); static final MemoryUtil.MemoryAllocator ALLOCATOR;
/*    */   
/*    */   static {
/* 75 */     ALLOCATOR = debug ? (MemoryUtil.MemoryAllocator)new MemoryManage.DebugAllocator(ALLOCATOR_IMPL) : ALLOCATOR_IMPL;
/*    */     
/* 77 */     APIUtil.apiLog("MemoryUtil allocator: " + ALLOCATOR.getClass().getSimpleName());
/* 78 */     if (debug && !((Boolean)Configuration.DEBUG_MEMORY_ALLOCATOR_FAST.get(Boolean.valueOf(false))).booleanValue())
/* 79 */       APIUtil.apiLogMore("Reminder: enable Configuration.DEBUG_MEMORY_ALLOCATOR_FAST for low overhead allocation tracking."); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\MemoryUtil$LazyInit.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */