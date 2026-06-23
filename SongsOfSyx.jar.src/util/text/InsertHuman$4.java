/*    */ package util.text;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.sprite.text.Str;
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
/*    */   extends Inserter<Humanoid>.II
/*    */ {
/*    */   null(Inserter paramInserter, String $anonymous0) {
/* 33 */     super($anonymous0);
/*    */   }
/*    */   public void set(Humanoid b, Str str) {
/* 36 */     if (b != null) {
/* 37 */       DIR d = DIR.get(SETT.TWIDTH / 2, SETT.THEIGHT / 2, b.tc().x(), b.tc().y());
/* 38 */       if (COORDINATE.tileDistance((SETT.TWIDTH / 2), (SETT.THEIGHT / 2), b.tc().x(), b.tc().y()) < 150.0D)
/* 39 */         d = DIR.C; 
/* 40 */       str.add(Dic.get(d));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertHuman$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */