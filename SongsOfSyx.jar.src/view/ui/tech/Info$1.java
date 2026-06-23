/*    */ package view.ui.tech;
/*    */ 
/*    */ import game.faction.player.PTech;
/*    */ import java.util.Comparator;
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
/*    */ class null
/*    */   implements Comparator<PTech.TechCurr>
/*    */ {
/*    */   public int compare(PTech.TechCurr o1, PTech.TechCurr o2) {
/* 48 */     return o1.cu.bo.key.compareTo(o2.cu.bo.key);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\Info$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */