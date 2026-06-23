/*    */ package settlement.room.military.artillery;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.ROOMS;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PlacableFixed;
/*    */ 
/*    */ public final class Placer extends PlacableFixed {
/*    */   private final ROOM_ARTILLERY blue;
/*    */   private final PlacableFixed p;
/*    */   
/*    */   public Placer(ROOM_ARTILLERY blue, ROOMS r) {
/* 15 */     this.blue = blue;
/* 16 */     this.p = r.placement.placer.createItemPlacer((RoomBlueprintImp)blue, 0);
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
/* 28 */     (SETT.ROOMS()).construction.construct(tx, ty);
/* 29 */     ArtilleryInstance ins = (ArtilleryInstance)this.blue.get(tx, ty);
/* 30 */     if (ins != null) {
/* 31 */       ins.muster(true);
/* 32 */       ins.fireAtWill(true);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence placable(int tx, int ty, int rx, int ry) {
/* 38 */     return this.p.placable(tx, ty, rx, ry);
/*    */   }
/*    */ 
/*    */   
/*    */   public int height() {
/* 43 */     return this.p.height();
/*    */   }
/*    */ 
/*    */   
/*    */   public SPRITE getIcon() {
/* 48 */     return this.p.getIcon();
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence name() {
/* 53 */     return this.blue.info.name;
/*    */   }
/*    */ 
/*    */   
/*    */   public PLACABLE getUndo() {
/* 58 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public int rotations() {
/* 63 */     return this.p.rotations();
/*    */   }
/*    */ 
/*    */   
/*    */   public int sizes() {
/* 68 */     return this.p.sizes();
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence placableWhole(int tx1, int ty1) {
/* 73 */     return this.p.placableWhole(tx1, ty1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void rotSet(int rot) {
/* 78 */     this.p.rotSet(rot);
/*    */   }
/*    */ 
/*    */   
/*    */   public int rot() {
/* 83 */     return this.p.rot();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\artillery\Placer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */