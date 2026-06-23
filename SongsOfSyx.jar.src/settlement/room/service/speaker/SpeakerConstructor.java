/*    */ package settlement.room.service.speaker;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.path.AVAILABILITY;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.TmpArea;
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.furnisher.FurnisherItemTile;
/*    */ import settlement.room.main.furnisher.FurnisherStat;
/*    */ import settlement.room.main.util.RoomInit;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import settlement.room.service.module.RoomService;
/*    */ import settlement.room.sprite.RoomSprite;
/*    */ import settlement.room.sprite.RoomSpriteCombo;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.file.Json;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ 
/*    */ 
/*    */ final class SpeakerConstructor
/*    */   extends Furnisher
/*    */ {
/*    */   private final ROOM_SPEAKER blue;
/*    */   final FurnisherStat workers;
/*    */   final FurnisherStat spectators;
/*    */   
/*    */   protected SpeakerConstructor(ROOM_SPEAKER blue, RoomInitData init) throws IOException {
/* 32 */     super(init, 1, 2, 88, 44);
/* 33 */     this.blue = blue;
/* 34 */     this.workers = (FurnisherStat)new FurnisherStat.FurnisherStatEmployees(this);
/* 35 */     this.spectators = (FurnisherStat)new FurnisherStat.FurnisherStatServices(this, (RoomService.ROOM_SERVICE_HASER)blue);
/*    */     
/* 37 */     Json sp = init.data().json("SPRITES");
/*    */     
/* 39 */     final RoomSpriteCombo sSprite = new RoomSpriteCombo(sp, "CENTER_COMBO");
/*    */     
/* 41 */     RoomSpriteCombo roomSpriteCombo2 = new RoomSpriteCombo(sp, "FRAME_COMBO")
/*    */       {
/*    */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 44 */           super.render(r, s, data, it, degrade, isCandle);
/* 45 */           if ((data & 0xF) == 15) {
/* 46 */             for (DIR d : DIR.NORTHO) {
/* 47 */               it.setOff(d.x() * 32, d.y() * 32);
/* 48 */               d = d.perpendicular();
/* 49 */               int m = d.next(-1).mask() | d.next(1).mask();
/*    */               
/* 51 */               sSprite.render(r, s, m, it, degrade, isCandle);
/*    */             } 
/*    */           }
/* 54 */           return false;
/*    */         }
/*    */       };
/*    */ 
/*    */ 
/*    */     
/* 60 */     FurnisherItemTile bb = new FurnisherItemTile(
/* 61 */         this, 
/* 62 */         (RoomSprite)roomSpriteCombo2, 
/* 63 */         AVAILABILITY.PENALTY4, 
/* 64 */         false);
/* 65 */     FurnisherItemTile b1 = new FurnisherItemTile(
/* 66 */         this, 
/* 67 */         (RoomSprite)roomSpriteCombo2, 
/* 68 */         AVAILABILITY.ROOM, 
/* 69 */         false);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 77 */     flush(1, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean usesArea() {
/* 82 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean mustBeIndoors() {
/* 87 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public Room create(TmpArea area, RoomInit init) {
/* 92 */     return (Room)new SpeakerInstance(this.blue, area, init);
/*    */   }
/*    */ 
/*    */   
/*    */   public RoomBlueprintImp blue() {
/* 97 */     return (RoomBlueprintImp)this.blue;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\speaker\SpeakerConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */