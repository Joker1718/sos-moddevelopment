/*    */ package view.sett;
/*    */ 
/*    */ import view.interrupter.InterGuisection;
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
/*    */ public class Inters
/*    */ {
/*    */   public final InterGuisection section;
/*    */   public final InterGuisection debugsection;
/*    */   
/*    */   public Inters() {
/* 62 */     this.section = new InterGuisection(paramSettView.uiManager);
/* 63 */     this.debugsection = new InterGuisection(paramSettView.uiManager);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\sett\SettView$Inters.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */