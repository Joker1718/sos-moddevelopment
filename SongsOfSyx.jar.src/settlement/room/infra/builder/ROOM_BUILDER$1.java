/*    */ package settlement.room.infra.builder;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.AVAILABILITY;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.TmpArea;
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import settlement.room.main.furnisher.FurnisherItemTile;
/*    */ import settlement.room.main.util.RoomInit;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import settlement.room.sprite.RoomSprite;
/*    */ import settlement.room.sprite.RoomSprite1x1;
/*    */ import snake2d.util.file.Json;
/*    */ import view.tool.PlacableMessages;
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
/*    */   extends Furnisher
/*    */ {
/*    */   null(RoomInitData $anonymous0, int $anonymous1, int $anonymous2, int $anonymous3, int $anonymous4, RoomInitData paramRoomInitData1) throws IOException {
/* 37 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4);
/*    */ 
/*    */     
/* 40 */     Json sp = paramRoomInitData1.data().json("SPRITES");
/* 41 */     RoomSprite1x1 roomSprite1x1 = new RoomSprite1x1(sp, "1x1");
/* 42 */     FurnisherItemTile t = new FurnisherItemTile(this, (RoomSprite)roomSprite1x1, AVAILABILITY.AVOID_PASS, false);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 47 */     flushSingle(paramROOM_BUILDER.info);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean usesArea() {
/* 52 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean mustBeIndoors() {
/* 57 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public Room create(TmpArea area, RoomInit init) {
/* 62 */     return (Room)new BuilderInstance(ROOM_BUILDER.this, area, init);
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence placable(int tx, int ty, FurnisherItem item, FurnisherItemTile tile) {
/* 67 */     if (SETT.TERRAIN().get(tx, ty).roofIs())
/* 68 */       return super.placable(tx, ty, item, tile); 
/* 69 */     if (SETT.TERRAIN().get(tx, ty) != (SETT.TERRAIN()).NADA && !SETT.TERRAIN().get(tx, ty).clearing().isEasilyCleared()) {
/* 70 */       return PlacableMessages.¤¤TERRAIN_BLOCK;
/*    */     }
/* 72 */     return super.placable(tx, ty, item, tile);
/*    */   }
/*    */ 
/*    */   
/*    */   public RoomBlueprintImp blue() {
/* 77 */     return (RoomBlueprintImp)ROOM_BUILDER.this;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean needFlooring() {
/* 82 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\builder\ROOM_BUILDER$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */