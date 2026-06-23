/*    */ package META-INF.versions.25.org.lwjgl.system.ffm;
/*    */ 
/*    */ import java.lang.foreign.Arena;
/*    */ import java.lang.foreign.FunctionDescriptor;
/*    */ import java.lang.foreign.Linker;
/*    */ import java.lang.foreign.MemoryLayout;
/*    */ import java.lang.foreign.MemorySegment;
/*    */ import java.lang.invoke.MethodHandle;
/*    */ import java.util.Objects;
/*    */ import org.lwjgl.system.ffm.BCUtil;
/*    */ import org.lwjgl.system.ffm.Binder;
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
/*    */ public interface UpcallBinder<T>
/*    */   extends Binder<T>
/*    */ {
/*    */   FunctionDescriptor descriptor();
/*    */   
/*    */   MethodHandle handle();
/*    */   
/*    */   MemoryLayout stack();
/*    */   
/*    */   default MemorySegment allocate(Arena arena, T upcall) {
/* 55 */     return allocate(arena, upcall, BCUtil.EMPTY_OPTIONS);
/*    */   }
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
/*    */   MemorySegment allocate(Arena arena, T upcall, Linker.Option... options) {
/* 68 */     Objects.requireNonNull(upcall);
/*    */ 
/*    */     
/* 71 */     MethodHandle handle = handle().bindTo(upcall);
/*    */     
/* 73 */     MemoryLayout stack = stack();
/* 74 */     if (stack != null) {
/* 75 */       handle = handle.bindTo(arena.allocate(stack));
/*    */     }
/*    */     
/* 78 */     return Linker.nativeLinker()
/* 79 */       .upcallStub(handle, 
/*    */         
/* 81 */         descriptor(), arena, options);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\UpcallBinder.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */