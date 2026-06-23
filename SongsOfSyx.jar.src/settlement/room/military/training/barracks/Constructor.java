/*     */ package settlement.room.military.training.barracks;
/*     */ 
/*     */ import game.GAME;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteBoxN;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   final FurnisherItemTile manikin;
/*     */   final FurnisherItemTile work;
/*     */   private final ROOM_BARRACKS blue;
/*     */   
/*  35 */   final FurnisherStat men = new FurnisherStat(this, 0.0D)
/*     */     {
/*     */       public double get(AREA area, double fromItems)
/*     */       {
/*  39 */         return fromItems;
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  44 */         return GFORMAT.i(t, (int)value);
/*     */       }
/*     */     };
/*     */   
/*     */   protected Constructor(final ROOM_BARRACKS blue, RoomInitData init) throws IOException {
/*  49 */     super(init, 1, 1, 88, 44);
/*  50 */     this.blue = blue;
/*  51 */     Json js = init.data().json("SPRITES");
/*  52 */     final RoomSpriteBoxN sPedi = new RoomSpriteBoxN(js, "PODEUM_BOX")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  55 */           return (item.sprite(rx, ry) != null);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  60 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  66 */           return false;
/*     */         }
/*     */       };
/*     */     
/*  70 */     RoomSprite1x1 sMani = new RoomSprite1x1(js, "MANAKIN_A_1X1", js)
/*     */       {
/*     */         RoomSprite1x1 sMani2;
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  75 */           sPedi.renderBelow(r, s, getData2(it), it, degrade);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  81 */           int rot = it.ran() >> 4;
/*  82 */           if (blue.is(it.tile()) && BarracksThing.used.is((SETT.ROOMS()).data.get(it.tile())))
/*  83 */             rot += GAME.intervals().get05(); 
/*  84 */           rot &= 0x7;
/*  85 */           if ((rot & 0x1) == 1) {
/*  86 */             return this.sMani2.render(r, s, rot >> 1, it, degrade, false);
/*     */           }
/*  88 */           return super.render(r, s, rot >> 1, it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  93 */           return sPedi.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  98 */     RoomSprite1x1 sCandle = new RoomSprite1x1(js, "TABLE_1X1")
/*     */       {
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 101 */           sPedi.renderBelow(r, s, getData2(it), it, degrade);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 106 */           return sPedi.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 111 */     FurnisherItemTile ma = new FurnisherItemTile(this, false, (RoomSprite)sMani, AVAILABILITY.ROOM_SOLID, false);
/* 112 */     FurnisherItemTile ca = new FurnisherItemTile(this, false, (RoomSprite)sCandle, AVAILABILITY.ROOM_SOLID, true);
/* 113 */     FurnisherItemTile st = new FurnisherItemTile(this, true, (RoomSprite)sPedi, AVAILABILITY.AVOID_PASS, false);
/* 114 */     FurnisherItemTile ee = new FurnisherItemTile(this, false, (RoomSprite)sPedi, AVAILABILITY.AVOID_PASS, false);
/*     */     
/* 116 */     this.manikin = ma;
/* 117 */     this.work = st;
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
/* 215 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 220 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 225 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_BARRACKS blue() {
/* 230 */     return this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 235 */     return (Room)new BarracksInstance(this.blue, area, init);
/*     */   }
/*     */   
/*     */   public boolean isHeavy() {
/* 239 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\training\barracks\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */