/*    */ package game.battle;
/*    */ 
/*    */ import game.battle.div.Div;
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
/*    */   extends Army.Cache
/*    */ {
/*    */   protected int count() {
/* 25 */     int a = 0;
/* 26 */     for (int di = 0; di < Army.this.divisions.size(); di++) {
/* 27 */       Div d = (Div)Army.this.divisions.get(di);
/* 28 */       a += d.menNrOf();
/*    */     } 
/* 30 */     return a;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\Army$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */