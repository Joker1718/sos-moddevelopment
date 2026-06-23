/*    */ package settlement.room.home.house;
/*    */ 
/*    */ import snake2d.util.map.MAP_OBJECT;
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
/*    */ class Getter
/*    */   implements MAP_OBJECT<Sprite>
/*    */ {
/*    */   private final Sprite[][] sp;
/*    */   
/*    */   Getter(Sprite[][] sp) {
/* 35 */     this.sp = sp;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Sprite get(int tile) {
/* 41 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Sprite get(int tx, int ty) {
/* 46 */     if (tx < 0 || tx >= (this.sp[0]).length)
/* 47 */       return null; 
/* 48 */     if (ty < 0 || ty >= this.sp.length)
/* 49 */       return null; 
/* 50 */     return this.sp[ty][tx];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\house\SpriteConfig$Getter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */