/*    */ package init;
/*    */ 
/*    */ import game.save.Savable;
/*    */ import java.io.IOException;
/*    */ import snake2d.CORE;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
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
/*    */ public class INIT
/*    */ {
/* 23 */   private static ArrayListGrower<Savable> savers = new ArrayListGrower();
/*    */   
/* 25 */   private final ArrayListGrower<InitResource> resses = new ArrayListGrower();
/*    */   
/*    */   public INIT() throws IOException {
/* 28 */     savers.clear();
/*    */ 
/*    */     
/* 31 */     CORE.checkIn();
/*    */     
/* 33 */     CORE.checkIn();
/*    */     
/* 35 */     CORE.checkIn();
/*    */     
/* 37 */     CORE.checkIn();
/*    */     
/* 39 */     CORE.checkIn();
/*    */     
/* 41 */     CORE.checkIn();
/*    */     
/* 43 */     CORE.checkIn();
/*    */     
/* 45 */     CORE.checkIn();
/*    */     
/* 47 */     CORE.checkIn();
/*    */     
/* 49 */     CORE.checkIn();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void addSaver(Savable s) {
/* 55 */     savers.add(s);
/*    */   }
/*    */   
/*    */   public static interface AfterInit {
/*    */     void exe() throws IOException; }
/*    */   
/*    */   public LIST<Savable> finish() throws IOException {
/* 62 */     for (InitResource ii : this.resses) {
/* 63 */       ii.finishSetup();
/*    */     }
/*    */     
/* 66 */     return (LIST<Savable>)savers;
/*    */   }
/*    */   
/*    */   public static class InitResource
/*    */   {
/*    */     protected InitResource(INIT init) {
/* 72 */       init.resses.add(this);
/*    */     }
/*    */     
/*    */     protected void finishSetup() throws IOException {}
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\INIT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */