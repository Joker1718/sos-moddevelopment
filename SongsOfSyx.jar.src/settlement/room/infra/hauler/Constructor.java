/*     */ package settlement.room.infra.hauler;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   protected Constructor(RoomInitData init) throws IOException {
/*  33 */     super(init, 1, 0, 88, 44);
/*     */     
/*  35 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  37 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "CRATE_1X1")
/*     */       {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  41 */           super.render(r, s, data, it, degrade, isCandle);
/*  42 */           HaulerInstance ins = (HaulerInstance)Constructor.this.blue().get(it.tx(), it.ty());
/*  43 */           if (ins != null && (Constructor.this.blue()).crate.get(it.tx(), it.ty(), ins, ins.sdata).resource() != null)
/*     */           {
/*  45 */             (Constructor.this.blue()).crate.resource().renderLaying(r, it.x(), it.y(), it.ran(), (Constructor.this.blue()).crate.amount());
/*     */           }
/*  47 */           return false;
/*     */         }
/*     */       };
/*  50 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1((RoomSprite)roomSprite1x11)
/*     */       {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  54 */           super.render(r, s, data, it, degrade, isCandle);
/*     */           
/*  56 */           HaulerInstance ins = (HaulerInstance)(SETT.ROOMS()).HAULER.getter.get(it.tile());
/*  57 */           if (ins == null) {
/*  58 */             return false;
/*     */           }
/*  60 */           Icon icon = (ins.resource() == null) ? (SPRITES.icons()).m.cancel : ins.resource().icon();
/*  61 */           OPACITY.O99.bind();
/*  62 */           icon.render(r, it.x(), it.x() + 64, it.y(), it.y() + 64);
/*  63 */           OPACITY.unbind();
/*     */           
/*  65 */           return false;
/*     */         }
/*     */       };
/*     */     
/*  69 */     RoomSpriteCombo spriteFence = new RoomSpriteCombo(sp, "FENCE_COMBO")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  72 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  77 */     FurnisherItemTile tt = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x12, AVAILABILITY.AVOID_PASS, false);
/*     */     
/*  79 */     FurnisherItemTile ff = new FurnisherItemTile(this, false, (RoomSprite)spriteFence, AVAILABILITY.AVOID_PASS, false);
/*  80 */     FurnisherItemTile __ = (new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x11, AVAILABILITY.ROOM, false)).setData(1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     flush(3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 122 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 127 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeOutdoors() {
/* 132 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 137 */     return (Room)new HaulerInstance(blue(), area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_HAULER blue() {
/* 142 */     return (SETT.ROOMS()).HAULER;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\hauler\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */