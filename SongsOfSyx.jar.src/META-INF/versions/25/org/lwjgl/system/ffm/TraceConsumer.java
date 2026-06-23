/*    */ package META-INF.versions.25.org.lwjgl.system.ffm;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.Objects;
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
/*    */ public interface TraceConsumer
/*    */ {
/*    */   void accept(Method paramMethod, Object paramObject, Object... paramVarArgs);
/*    */   
/*    */   default org.lwjgl.system.ffm.TraceConsumer andThen(org.lwjgl.system.ffm.TraceConsumer after) {
/* 29 */     Objects.requireNonNull(after);
/* 30 */     return (method, returnValue, args) -> {
/*    */         accept(method, returnValue, args);
/*    */         after.accept(method, returnValue, args);
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\TraceConsumer.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */