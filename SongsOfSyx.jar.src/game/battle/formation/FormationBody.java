/*    */ package game.battle.formation;
/*    */ 
/*    */ import snake2d.util.datatypes.Rec;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FormationBody
/*    */   extends Rec
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public boolean init(DivPosition d) {
/* 13 */     clear();
/*    */ 
/*    */     
/* 16 */     int cx = 0;
/* 17 */     int cy = 0;
/* 18 */     int am = 0;
/* 19 */     for (int i = 0; i < d.deployed(); i++) {
/* 20 */       int x = d.px(i);
/* 21 */       int y = d.py(i);
/* 22 */       cx += x;
/* 23 */       cy += y;
/* 24 */       am++;
/*    */     } 
/*    */     
/* 27 */     if (am == 0) {
/* 28 */       return false;
/*    */     }
/* 30 */     cx /= am;
/* 31 */     cy /= am;
/*    */     
/* 33 */     int width = 0;
/* 34 */     int height = 0;
/* 35 */     am = 0;
/* 36 */     for (int j = 0; j < d.deployed(); j++) {
/* 37 */       int x = d.px(j);
/* 38 */       int y = d.py(j);
/*    */       
/* 40 */       width += Math.abs(cx - x);
/* 41 */       height += Math.abs(cy - y);
/* 42 */       am++;
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 47 */     if (am == 0) {
/* 48 */       return false;
/*    */     }
/* 50 */     width /= am;
/* 51 */     height /= am;
/* 52 */     width *= 4;
/* 53 */     height *= 4;
/* 54 */     setDim(width, height);
/* 55 */     moveC(cx, cy);
/*    */ 
/*    */     
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\formation\FormationBody.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */