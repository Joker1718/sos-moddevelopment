/*     */ package settlement.room.infra.elderly;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherItemTools;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteBoxN;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ResthomeConstructor
/*     */   extends Furnisher
/*     */ {
/*  31 */   public final FurnisherStat stations = (FurnisherStat)new FurnisherStat.FurnisherStatI(this, 1);
/*  32 */   public final FurnisherStat quality = (FurnisherStat)new FurnisherStat.FurnisherStatRelative(this, this.stations);
/*     */   
/*     */   private final ROOM_RESTHOME blue;
/*     */   
/*     */   static final int ITABLE = 1;
/*     */   
/*     */   static final int ISTAGE = 2;
/*     */   
/*     */   static final int ICHAIR = 3;
/*     */   
/*     */   protected ResthomeConstructor(final ROOM_RESTHOME blue, RoomInitData init) throws IOException {
/*  43 */     super(init, 4, 2, 88, 44);
/*  44 */     this.blue = blue;
/*     */     
/*  46 */     Json js = init.data().json("SPRITES");
/*  47 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(js, "CHAIR_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  50 */           return (d.perpendicular().orthoID() == item.rotation);
/*     */         }
/*     */       };
/*     */     
/*  54 */     final RoomSprite1x1 sChair_table = new RoomSprite1x1((RoomSprite)roomSprite1x11)
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  57 */           return (item.get(rx, ry) != null && item.get(rx, ry).data() == 1);
/*     */         }
/*     */       };
/*     */     
/*  61 */     final RoomSprite1x1 sOnTopDecor = new RoomSprite1x1(js, "ON_TOP_DECOR_1X1");
/*  62 */     RoomSprite1x1 sTableSingle = new RoomSprite1x1(js, "TABLE_1X1")
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  67 */           boolean ret = super.render(r, s, data, it, degrade, isCandle);
/*  68 */           if (!isCandle) {
/*  69 */             sOnTopDecor.renderRandom(r, null, it, it.ran(), degrade);
/*     */           }
/*  71 */           return ret;
/*     */         }
/*     */       };
/*     */     
/*  75 */     final RoomSprite1x1 sOnTopCards = new RoomSprite1x1(js, "ON_TOP_CARDS_1X1");
/*  76 */     RoomSpriteCombo sTable_clean = new RoomSpriteCombo(js, "TABLES_COMBO")
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  81 */           super.render(r, s, data, it, degrade, isCandle);
/*  82 */           if (blue.job.used(it.tx(), it.ty())) {
/*  83 */             for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  84 */               if ((SETT.ROOMS()).fData.sprite.get(it.tx(), it.ty(), (DIR)DIR.ORTHO.get(i)) == sChair_table) {
/*  85 */                 sOnTopCards.render(r, s, i, it, degrade, isCandle);
/*     */               }
/*     */             } 
/*     */           }
/*     */           
/*  90 */           return false;
/*     */         }
/*     */       };
/*     */     
/*  94 */     RoomSpriteBoxN sStage = new RoomSpriteBoxN(js, "STAGE_COMBO");
/*     */     
/*  96 */     RoomSpriteCombo roomSpriteCombo1 = new RoomSpriteCombo((RoomSprite)sTable_clean)
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 101 */           super.render(r, s, data, it, degrade, isCandle);
/* 102 */           if (!isCandle) {
/* 103 */             sOnTopDecor.renderRandom(r, ShadowBatch.DUMMY, it, it.ran(), degrade);
/*     */           }
/* 105 */           return false;
/*     */         }
/*     */       };
/*     */     
/* 109 */     RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1(js, "SHELF_1X1", js)
/*     */       {
/*     */         final RoomSprite1x1 ontop;
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 115 */           return (d.orthoID() == item.rotation);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 120 */           this.ontop.render(r, s, data, it, degrade, false);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 125 */     RoomSprite1x1 roomSprite1x14 = new RoomSprite1x1(js, "NICKNACK_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 129 */           return (d.orthoID() == item.rotation);
/*     */         }
/*     */       };
/*     */     
/* 133 */     FurnisherItemTile __ = null;
/*     */     
/* 135 */     FurnisherItemTile cc = new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x11, AVAILABILITY.AVOID_PASS, false);
/* 136 */     cc.setData(3);
/* 137 */     FurnisherItemTile ch = new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x12, AVAILABILITY.AVOID_PASS, false);
/* 138 */     FurnisherItemTile ta = new FurnisherItemTile(this, false, (RoomSprite)sTable_clean, AVAILABILITY.ROOM_SOLID, false);
/* 139 */     ta.setData(1);
/* 140 */     FurnisherItemTile furnisherItemTile1 = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo1, AVAILABILITY.ROOM_SOLID, true);
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
/* 202 */     flush(1, 3);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 207 */     FurnisherItemTile tt = new FurnisherItemTile(this, false, (RoomSprite)sStage, AVAILABILITY.AVOID_LIKE_FUCK, false);
/* 208 */     tt.setData(2);
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
/* 237 */     flush(1, 3);
/*     */ 
/*     */ 
/*     */     
/* 241 */     FurnisherItemTile sh = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x13, AVAILABILITY.ROOM_SOLID, false);
/* 242 */     FurnisherItemTile ni = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x14, AVAILABILITY.ROOM_SOLID, false);
/* 243 */     ta = new FurnisherItemTile(this, false, (RoomSprite)sTableSingle, AVAILABILITY.ROOM_SOLID, false);
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
/* 268 */     flush(3);
/*     */ 
/*     */     
/* 271 */     FurnisherItemTools.makeUnder(this, js, "CARPET_COMBO");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 277 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 282 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 287 */     return (Room)new ResthomeInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 292 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 297 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\elderly\ResthomeConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */