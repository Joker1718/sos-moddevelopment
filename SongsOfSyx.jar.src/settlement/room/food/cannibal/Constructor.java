/*     */ package settlement.room.food.cannibal;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
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
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
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
/*     */   private final ROOM_CANNIBAL blue;
/*     */   
/*  35 */   final FurnisherStat workers = new FurnisherStat(this)
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
/*     */   
/*     */   final FurnisherItemTile ww;
/*     */   final FurnisherItemTile rm;
/*     */   final FurnisherItemTile rr;
/*     */   final FurnisherItemTile cc;
/*     */   
/*     */   protected Constructor(final ROOM_CANNIBAL blue, RoomInitData init) throws IOException {
/*  55 */     super(init, 1, 1);
/*  56 */     this.blue = blue;
/*     */     
/*  58 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  60 */     RoomSpriteCombo roomSpriteCombo1 = new RoomSpriteCombo(sp, "TABLE_COMBO")
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  65 */           super.render(r, s, data, it, degrade, isCandle);
/*  66 */           if (blue.is(it.tile())) {
/*  67 */             (((Race)RACES.all().get(Job.race.get((SETT.ROOMS()).data.get(it.tile())))).appearance()).colors.blood.bind();
/*  68 */             long ran = it.bigRan();
/*  69 */             int a = Job.gore.get((SETT.ROOMS()).data.get(it.tile()));
/*  70 */             int cx = it.x() + 32;
/*  71 */             int cy = it.y() + 32;
/*  72 */             for (int i = 0; i < a; i++) {
/*  73 */               int xx = (int)(cx + (-4L + (ran & 0x7L)) * 4L);
/*  74 */               ran >>= 3L;
/*  75 */               int yy = (int)(cy + (-4L + (ran & 0x7L)) * 4L);
/*  76 */               ran >>= 3L;
/*  77 */               (SETT.THINGS()).sprites.bloodPool.render(r, (int)(ran & 0xFL), xx, yy);
/*  78 */               ran >>= 4L;
/*     */             } 
/*  80 */             COLOR.unbind();
/*     */           } 
/*  82 */           return false;
/*     */         }
/*     */       };
/*     */     
/*  86 */     final RoomSprite1x1 top = new RoomSprite1x1(sp, "ON_TABLE_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  89 */           return (item.get(rx, ry) == null);
/*     */         }
/*     */       };
/*     */     
/*  93 */     RoomSpriteCombo roomSpriteCombo2 = new RoomSpriteCombo((RoomSprite)roomSpriteCombo1)
/*     */       {
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/*  99 */           top.renderRandom(r, s, it, data, degrade);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 104 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "CAGE_1X1", sp)
/*     */       {
/*     */         RoomSprite top;
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 110 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 115 */           this.top.render(r, s, data, it, degrade, false);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 120 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "CANDLE_BASE_1X1")
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 123 */           if (!(SETT.ROOMS()).fData.candle.is(it.coo())) {
/* 124 */             top.renderRandom(r, s, it, data, degrade);
/*     */           }
/*     */         }
/*     */       };
/* 128 */     RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1(sp, "MISC_1X1");
/*     */     
/* 130 */     this.ww = new FurnisherItemTile(this, true, (RoomSprite)roomSpriteCombo1, AVAILABILITY.ROOM_SOLID, false);
/* 131 */     this.rm = new FurnisherItemTile(this, true, (RoomSprite)roomSpriteCombo1, AVAILABILITY.ROOM_SOLID, false);
/* 132 */     this.rr = new FurnisherItemTile(this, true, (RoomSprite)roomSpriteCombo1, AVAILABILITY.ROOM_SOLID, false);
/* 133 */     this.cc = new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x11, AVAILABILITY.AVOID_LIKE_FUCK, false);
/* 134 */     FurnisherItemTile ca = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x12, AVAILABILITY.ROOM_SOLID, true);
/*     */     
/* 136 */     FurnisherItemTile mm = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo2, AVAILABILITY.ROOM_SOLID, false);
/* 137 */     FurnisherItemTile nn = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x13, AVAILABILITY.ROOM_SOLID, false);
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
/* 155 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 161 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 166 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 171 */     return (Room)new CannibalInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 176 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 182 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\cannibal\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */