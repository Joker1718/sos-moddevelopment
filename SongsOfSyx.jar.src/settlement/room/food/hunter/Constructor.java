/*     */ package settlement.room.food.hunter;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
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
/*     */ import settlement.thing.ThingsCadavers;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.file.Json;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class Constructor extends Furnisher {
/*     */   private final ROOM_HUNTER blue;
/*     */   
/*  35 */   final FurnisherStat workers = new FurnisherStat(this, 1.0D)
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
/*     */   
/*  50 */   final FurnisherStat efficiency = (FurnisherStat)new FurnisherStat.FurnisherStatEfficiency(this, this.workers);
/*     */   
/*  52 */   final FurnisherStat output = new FurnisherStat(this, 0.0D)
/*     */     {
/*     */       public double get(AREA area, double[] fromItems)
/*     */       {
/*  56 */         double a = Constructor.this.workers.get(area, fromItems);
/*  57 */         return a * ((IndustryResource)((Industry)Constructor.this.blue.indus.get(0)).outs().get(0)).rate * Constructor.this.blue.bonus().get((BOOSTABLE_O)HCLASS_RACE.clP()) * Constructor.this.blue.eBonus((int)Math.ceil(a));
/*     */       }
/*     */ 
/*     */       
/*     */       public double get(AREA area, double fromItems) {
/*  62 */         double a = Constructor.this.workers.get(area, fromItems);
/*  63 */         return a * ((IndustryResource)((Industry)Constructor.this.blue.indus.get(0)).outs().get(0)).rate * Constructor.this.blue.bonus().get((BOOSTABLE_O)HCLASS_RACE.clP()) * Constructor.this.blue.eBonus((int)Math.ceil(a));
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  68 */         return GFORMAT.i(t, (int)value);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   final FurnisherItemTile ww;
/*     */   final FurnisherItemTile rr;
/*     */   
/*     */   protected Constructor(ROOM_HUNTER blue, RoomInitData init) throws IOException {
/*  77 */     super(init, 2, 3);
/*  78 */     this.blue = blue;
/*     */     
/*  80 */     Json j = init.data().json("SPRITES");
/*     */     
/*  82 */     RoomSpriteCombo table = new RoomSpriteCombo(j, "TABLE_COMBO")
/*     */       {
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  88 */           boolean ret = super.render(r, s, data, it, degrade, isCandle);
/*  89 */           if (isCandle)
/*  90 */             return ret; 
/*  91 */           ThingsCadavers.Cadaver ca = (ThingsCadavers.Cadaver)(SETT.THINGS()).cadavers.tGet.get(it.tx(), it.ty());
/*  92 */           if (ca != null) {
/*  93 */             (ca.spec()).blood.bind();
/*  94 */             long ran = it.bigRan();
/*  95 */             int a = Job.gore.get((SETT.ROOMS()).data.get(it.tile()));
/*  96 */             int cx = it.x() + 32;
/*  97 */             int cy = it.y() + 32;
/*  98 */             for (int i = 0; i < a; i++) {
/*  99 */               int xx = (int)(cx + (-4L + (ran & 0x7L)) * 4L);
/* 100 */               ran >>= 3L;
/* 101 */               int yy = (int)(cy + (-4L + (ran & 0x7L)) * 4L);
/* 102 */               ran >>= 3L;
/*     */               
/* 104 */               (SETT.THINGS()).sprites.bloodPool.render(r, (int)(ran & 0xFL), xx, yy);
/* 105 */               ran >>= 4L;
/*     */             } 
/* 107 */             COLOR.unbind();
/*     */           } 
/* 109 */           return ret;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 114 */     final RoomSprite1x1 sNick = new RoomSprite1x1(j, "NICKNACK_1X1");
/*     */     
/* 116 */     RoomSpriteCombo roomSpriteCombo1 = new RoomSpriteCombo((RoomSprite)table)
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/* 120 */           if (!(SETT.ROOMS()).fData.candle.is(it.tile())) {
/* 121 */             sNick.render(r, s, getData2(it), it, degrade, false);
/*     */           }
/*     */         }
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 126 */           return sNick.getData2(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 131 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(j, "STORAGE_1X1")
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/* 135 */           if (!(SETT.ROOMS()).fData.candle.is(it.tile())) {
/* 136 */             sNick.render(r, s, getData2(it), it, degrade, false);
/*     */           }
/*     */         }
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 141 */           return sNick.getData2(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 147 */     this.ww = new FurnisherItemTile(this, true, (RoomSprite)table, AVAILABILITY.ROOM_SOLID, false);
/* 148 */     this.rr = new FurnisherItemTile(this, true, (RoomSprite)table, AVAILABILITY.ROOM_SOLID, false);
/* 149 */     FurnisherItemTile mm = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo1, AVAILABILITY.ROOM_SOLID, true);
/* 150 */     FurnisherItemTile nn = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x12, AVAILABILITY.ROOM_SOLID, false);
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
/* 161 */     flush(3);
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
/* 204 */     flush(3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 211 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 216 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 221 */     return (Room)new HunterInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 226 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 231 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\hunter\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */