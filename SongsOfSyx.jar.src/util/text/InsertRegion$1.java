/*    */ package util.text;
/*    */ 
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends Inserter<Region>.II
/*    */ {
/*    */   null(Inserter paramInserter, String $anonymous0) {
/* 15 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void set(Region t, Str str) {
/* 19 */     if (t == null)
/*    */       return; 
/* 21 */     str.add((CharSequence)t.info.name());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertRegion$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */