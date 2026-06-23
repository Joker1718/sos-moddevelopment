/*    */ package settlement.room.tests;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.military.artillery.ArtilleryInstance;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PlacableFixed;
/*    */ 
/*    */ final class ArtilleryTest
/*    */   extends PlacableFixed
/*    */ {
/*    */   private final PlacableFixed p;
/*    */   
/*    */   public ArtilleryTest(PlacableFixed p) {
/* 16 */     this.p = p;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int width() {
/* 22 */     return this.p.width();
/*    */   }
/*    */ 
/*    */   
/*    */   public void place(int tx, int ty, int rx, int ry) {
/* 27 */     this.p.place(tx, ty, rx, ry);
/* 28 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 29 */     if (r instanceof ArtilleryInstance) {
/* 30 */       ((ArtilleryInstance)r).setEnemy();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence placable(int tx, int ty, int rx, int ry) {
/* 36 */     return this.p.placable(tx, ty, rx, ry);
/*    */   }
/*    */ 
/*    */   
/*    */   public int height() {
/* 41 */     return this.p.height();
/*    */   }
/*    */ 
/*    */   
/*    */   public SPRITE getIcon() {
/* 46 */     return this.p.getIcon();
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence name() {
/* 51 */     return "enemy artillery " + String.valueOf(this.p.name());
/*    */   }
/*    */ 
/*    */   
/*    */   public PLACABLE getUndo() {
/* 56 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public int rotations() {
/* 61 */     return this.p.rotations();
/*    */   }
/*    */ 
/*    */   
/*    */   public int sizes() {
/* 66 */     return this.p.sizes();
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence placableWhole(int tx1, int ty1) {
/* 71 */     return this.p.placableWhole(tx1, ty1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void rotSet(int rot) {
/* 76 */     this.p.rotSet(rot);
/*    */   }
/*    */ 
/*    */   
/*    */   public int rot() {
/* 81 */     return this.p.rot();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\tests\ArtilleryTest.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */