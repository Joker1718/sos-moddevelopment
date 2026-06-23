/*    */ package META-INF.versions.11.org.lwjgl.system;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import org.lwjgl.system.APIUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class CheckIntrinsics
/*    */ {
/*    */   static {
/* 15 */     APIUtil.apiLog("Java 11 check intrinsics enabled");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int checkIndex(int index, int length) {
/* 22 */     return Objects.checkIndex(index, length);
/*    */   }
/*    */   
/*    */   public static int checkFromToIndex(int fromIndex, int toIndex, int length) {
/* 26 */     return Objects.checkFromToIndex(fromIndex, toIndex, length);
/*    */   }
/*    */   
/*    */   public static int checkFromIndexSize(int fromIndex, int size, int length) {
/* 30 */     return Objects.checkFromIndexSize(fromIndex, size, length);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\11\org\lwjgl\system\CheckIntrinsics.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */