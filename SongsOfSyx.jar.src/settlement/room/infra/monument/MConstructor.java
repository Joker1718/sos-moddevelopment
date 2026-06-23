/*    */ package settlement.room.infra.monument;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.environment.SettEnvMap;
/*    */ import settlement.main.SETT;
/*    */ import settlement.overlay.Addable;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.TmpArea;
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import settlement.room.main.util.RoomInit;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ 
/*    */ 
/*    */ 
/*    */ class MConstructor
/*    */   extends Furnisher
/*    */ {
/*    */   private final ROOM_MONUMENT blue;
/*    */   
/*    */   MConstructor(ROOM_MONUMENT blue, RoomInitData init) throws IOException {
/* 25 */     super(init, (init.data().jsons("ITEMS")).length, 0);
/* 26 */     this.blue = blue;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean usesArea() {
/* 32 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean mustBeIndoors() {
/* 37 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public Room create(TmpArea area, RoomInit init) {
/* 42 */     return (Room)this.blue.instance.place(area);
/*    */   }
/*    */ 
/*    */   
/*    */   public RoomBlueprintImp blue() {
/* 47 */     return this.blue;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderExtra(SPRITE_RENDERER r, int x, int y, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 53 */     if (rx == 0 && ry == 0) {
/* 54 */       SETT.OVERLAY().monument(this.blue, item, tx, ty, 8);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public Addable overlay() {
/* 60 */     return SETT.OVERLAY().monument(this.blue);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean envValue(SettEnvMap.SettEnv e, SettEnvMap.SettEnvValue v, int tx, int ty) {
/* 65 */     if (this.envRadius[e.index()] != 0.0D) {
/* 66 */       v.radius = this.blue.radius((FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty)) / 16.0D;
/* 67 */       v.value = this.envValue[e.index()];
/* 68 */       return true;
/*    */     } 
/* 70 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 76 */     super.putFloor(tx, ty, upgrade, area);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\monument\MConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */