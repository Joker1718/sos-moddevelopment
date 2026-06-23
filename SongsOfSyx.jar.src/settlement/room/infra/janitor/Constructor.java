/*     */ package settlement.room.infra.janitor;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_JANITOR blue;
/*  28 */   final FurnisherStat workers = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*  29 */   final FurnisherStat efficiency = (FurnisherStat)new FurnisherStat.FurnisherStatEfficiency(this, this.workers);
/*     */   
/*     */   final FurnisherItemTile ta;
/*     */ 
/*     */   
/*     */   protected Constructor(final ROOM_JANITOR blue, RoomInitData init) throws IOException {
/*  35 */     super(init, 2, 2, 88, 44);
/*  36 */     this.blue = blue;
/*     */     
/*  38 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  40 */     RoomSpriteCombo roomSpriteCombo1 = new RoomSpriteCombo(sp, "TABLE_COMBO")
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/*  44 */           if ((SETT.ROOMS()).fData.candle.is(it.tile()))
/*     */             return; 
/*  46 */           JanitorInstance ins = (JanitorInstance)blue.getter.get(it.tile());
/*  47 */           if (ins != null) {
/*  48 */             int ri = (int)(ins.tableRes >> 8 * (it.tx() + it.ty()) % 8);
/*  49 */             ri &= 0xFF;
/*  50 */             if (ri != 0) {
/*  51 */               ((RESOURCE)RESOURCES.ALL().get(ri - 1)).renderLaying(r, it.x(), it.y(), it.ran(), ins.bits.resAm((RESOURCE)RESOURCES.ALL().getC(ri - 1)));
/*     */             }
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/*  57 */     RoomSpriteCombo roomSpriteCombo2 = new RoomSpriteCombo((RoomSprite)roomSpriteCombo1, sp) {
/*     */         final RoomSprite1x1 top;
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  61 */           this.top.renderRandom(r, s, it, it.ran(), degrade);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  66 */     final RoomSprite1x1 top = new RoomSprite1x1(sp, "MISC_1X1");
/*     */     
/*  68 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "STORAGE_1X1")
/*     */       {
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  74 */           super.render(r, s, data, it, degrade, isCandle);
/*  75 */           if (!isCandle) {
/*  76 */             top.renderRandom(r, s, it, it.ran(), degrade);
/*     */           }
/*  78 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  84 */     FurnisherItemTile tc = new FurnisherItemTile(
/*  85 */         this, 
/*  86 */         (RoomSprite)roomSpriteCombo2, 
/*  87 */         AVAILABILITY.ROOM_SOLID, 
/*  88 */         true);
/*     */     
/*  90 */     this.ta = (new FurnisherItemTile(
/*  91 */         this, 
/*  92 */         true, 
/*  93 */         (RoomSprite)roomSpriteCombo1, 
/*  94 */         AVAILABILITY.ROOM_SOLID, 
/*  95 */         false)).setData(1);
/*     */     
/*  97 */     FurnisherItemTile ng = new FurnisherItemTile(
/*  98 */         this, 
/*  99 */         (RoomSprite)roomSprite1x11, 
/* 100 */         AVAILABILITY.ROOM_SOLID, 
/* 101 */         true);
/*     */     
/* 103 */     FurnisherItemTile nn = new FurnisherItemTile(
/* 104 */         this, 
/* 105 */         (RoomSprite)top, 
/* 106 */         AVAILABILITY.ROOM_SOLID, 
/* 107 */         false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 113 */     flush(1, 3);
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
/* 127 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 132 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 137 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 142 */     return (Room)new JanitorInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 147 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 152 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\janitor\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */