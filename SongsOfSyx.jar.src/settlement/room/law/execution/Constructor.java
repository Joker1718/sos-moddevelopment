/*     */ package settlement.room.law.execution;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.environment.SettEnvMap;
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
/*     */ import settlement.room.sprite.RoomSpriteImp;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_EXECTUTION blue;
/*  33 */   final FurnisherStat prisoners = (FurnisherStat)new FurnisherStat.FurnisherStatI(this, 1);
/*     */   
/*     */   private final RoomSprite spritePedistal;
/*     */ 
/*     */   
/*     */   protected Constructor(ROOM_EXECTUTION blue, RoomInitData init) throws IOException {
/*  39 */     super(init, 4, 1);
/*  40 */     this.blue = blue;
/*     */     
/*  42 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  44 */     this.spritePedistal = (RoomSprite)new Pedistall(sp);
/*  45 */     gallows(sp);
/*  46 */     chop(sp);
/*  47 */     gibbet(sp);
/*  48 */     cross(sp);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void gallows(Json sp) throws IOException {
/*  54 */     final PSprite bedge = new PSprite(sp, "GALLOW_BEAM_LEFT_1X1");
/*  55 */     final PSprite bcentre = new PSprite(sp, "GALLOW_BEAM_CENTRE_1X1");
/*  56 */     final PSprite bBottom = new PSprite(sp, "GALLOW_BOTTOM_1X1");
/*  57 */     final PSprite bPillar = new PSprite(sp, "GALLOW_PILLAR_1X1");
/*  58 */     final RoomSprite1x1 bBox = new RoomSprite1x1(sp, "GALLOW_BOX_1X1");
/*     */     
/*  60 */     final RoomSpriteImp bNoose = (new PSprite(sp, "GALLOW_NOOSE_1X1")
/*     */       {
/*  62 */         final int[] animi = new int[] { 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, -1, -2, -3, -4, -5, -6, -7, -8, -7, -6, -5, -4, -3, -2, -1 };
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  67 */           int rot = ((FurnisherItem)(SETT.ROOMS()).fData.item.get(it.tile())).rotation;
/*  68 */           if (!Constructor.this.blue.stations.deadORDying(it.tx(), it.ty())) {
/*  69 */             DIR dir = (DIR)DIR.ORTHO.get(rot);
/*     */             
/*  71 */             int ran = it.ran();
/*  72 */             int speed = 4 + (ran & 0x7);
/*  73 */             ran >>= 3;
/*  74 */             double ww = 0.5D + (ran & 0xF) / 15.0D;
/*  75 */             ran >>= 4;
/*  76 */             int i = (ran & 0xFFFF) + (int)(TIME.currentSecond() * speed);
/*  77 */             int d = this.animi[i % this.animi.length];
/*     */             
/*  79 */             it.setOff((int)((dir.x() * d) * ww), (int)((dir.y() * d) * ww));
/*  80 */             super.render(r, s, data, it, degrade, isCandle);
/*  81 */             it.setOff(0, 0);
/*     */           } 
/*  83 */           return false;
/*     */         }
/*  85 */       }).sData(1);
/*     */     
/*  87 */     RoomSpriteImp roomSpriteImp2 = (new Pedistall(sp)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/*  94 */           bedge.render(r, s, getData2(it), it, degrade, false);
/*  95 */           bPillar.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 102 */           bBottom.render(r, s, getData2(it), it, degrade, false);
/* 103 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 108 */           return bedge.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/* 110 */       }).sData(1);
/*     */     
/* 112 */     RoomSpriteImp roomSpriteImp3 = (new Pedistall(sp)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/* 120 */           bNoose.render(r, s, getData2(it), it, degrade, false);
/* 121 */           bcentre.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 127 */           if (!Constructor.this.blue.stations.deadORDying(it.tx(), it.ty())) {
/* 128 */             bBox.render(r, s, getData2(it), it, degrade, false);
/*     */           }
/* 130 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 135 */           return bedge.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/* 137 */       }).sData(1);
/*     */     
/* 139 */     FurnisherItemTile xx = new FurnisherItemTile(
/* 140 */         this, 
/* 141 */         this.spritePedistal, 
/* 142 */         AVAILABILITY.ROOM, false);
/* 143 */     FurnisherItemTile aa = new FurnisherItemTile(
/* 144 */         this, 
/* 145 */         (RoomSprite)roomSpriteImp2, 
/* 146 */         AVAILABILITY.PENALTY4, false);
/* 147 */     FurnisherItemTile cc = (new FurnisherItemTile(
/* 148 */         this, 
/* 149 */         (RoomSprite)roomSpriteImp3, 
/* 150 */         AVAILABILITY.PENALTY4, false)).setData(2);
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
/* 190 */     flush(1);
/*     */   }
/*     */   
/*     */   private static class PSprite
/*     */     extends RoomSprite1x1
/*     */   {
/*     */     public PSprite(Json json, String key) throws IOException {
/* 197 */       super(json, key);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 202 */       return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 1);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class RSprite
/*     */     extends RoomSprite1x1
/*     */   {
/*     */     public RSprite(Json json, String key) throws IOException {
/* 210 */       super(json, key);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 215 */       return (d.orthoID() == item.rotation);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void chop(Json sp) throws IOException {
/* 222 */     RSprite rSprite = new RSprite(sp, "CHOP_TABLE_1X1");
/* 223 */     PSprite pSprite = new PSprite(sp, "CHOP_MAT_1X1");
/*     */     
/* 225 */     RoomSpriteImp roomSpriteImp = (new Pedistal(sp, (RoomSprite)rSprite)).sData(1);
/*     */     
/* 227 */     Pedistal pedistal = new Pedistal(sp, (RoomSprite)pSprite);
/*     */     
/* 229 */     FurnisherItemTile xx = new FurnisherItemTile(
/* 230 */         this, 
/* 231 */         this.spritePedistal, 
/* 232 */         AVAILABILITY.ROOM, false);
/* 233 */     FurnisherItemTile mm = new FurnisherItemTile(
/* 234 */         this, 
/* 235 */         (RoomSprite)pedistal, 
/* 236 */         AVAILABILITY.AVOID_PASS, false);
/* 237 */     FurnisherItemTile cc = (new FurnisherItemTile(
/* 238 */         this, 
/* 239 */         (RoomSprite)roomSpriteImp, 
/* 240 */         AVAILABILITY.AVOID_PASS, false)).setData(1);
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
/* 272 */     flush(1);
/*     */   }
/*     */ 
/*     */   
/*     */   private void gibbet(Json sp) throws IOException {
/* 277 */     RSprite rSprite = new RSprite(sp, "GIBBET_CAGE_1X1")
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 282 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 287 */           super.render(r, s, data, it, degrade, this.rotates);
/*     */         }
/*     */       };
/* 290 */     PSprite pSprite = new PSprite(sp, "GIBBET_DOOR_1X1")
/*     */       {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 293 */           DIR d = rot(data).perpendicular();
/* 294 */           if (!Constructor.this.blue.stations.deadORDying(it.tx() + d.x(), it.ty() + d.y())) {
/* 295 */             super.render(r, s, data, it, degrade, isCandle);
/*     */           }
/* 297 */           return false;
/*     */         }
/*     */       };
/*     */     
/* 301 */     Pedistal pedistal1 = new Pedistal(sp, (RoomSprite)rSprite);
/*     */     
/* 303 */     Pedistal pedistal2 = new Pedistal(sp, (RoomSprite)pSprite);
/*     */     
/* 305 */     FurnisherItemTile xx = new FurnisherItemTile(
/* 306 */         this, 
/* 307 */         this.spritePedistal, 
/* 308 */         AVAILABILITY.ROOM, false);
/* 309 */     FurnisherItemTile mm = new FurnisherItemTile(
/* 310 */         this, 
/* 311 */         (RoomSprite)pedistal2, 
/* 312 */         AVAILABILITY.AVOID_PASS, false);
/* 313 */     FurnisherItemTile cc = (new FurnisherItemTile(
/* 314 */         this, 
/* 315 */         (RoomSprite)pedistal1, 
/* 316 */         AVAILABILITY.AVOID_PASS, false)).setData(3);
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
/* 348 */     flush(1);
/*     */   }
/*     */ 
/*     */   
/*     */   private void cross(Json sp) throws IOException {
/* 353 */     Pedistal pedistal1 = new Pedistal(sp, (RoomSprite)new RSprite(sp, "CROSS_R_1X1"));
/* 354 */     Pedistal pedistal2 = new Pedistal(sp, (RoomSprite)new RSprite(sp, "CROSS_L_1X1"));
/* 355 */     Pedistal pedistal3 = new Pedistal(sp, (RoomSprite)new RSprite(sp, "CROSS_MID_1X1"));
/*     */     
/* 357 */     final PSprite bcrossp = new PSprite(sp, "CROSS_POLE_1X1");
/*     */     
/* 359 */     Pedistal pedistal4 = new Pedistal(sp, (RoomSprite)new RSprite(sp, "CROSS_C_1X1"))
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 364 */           super.render(r, s, data, it, degrade, isCandle);
/* 365 */           bcrossp.render(r, s, getData2(it), it, degrade, isCandle);
/* 366 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 371 */     FurnisherItemTile xx = new FurnisherItemTile(
/* 372 */         this, 
/* 373 */         this.spritePedistal, 
/* 374 */         AVAILABILITY.ROOM, false);
/* 375 */     FurnisherItemTile cc = (new FurnisherItemTile(
/* 376 */         this, 
/* 377 */         (RoomSprite)pedistal4, 
/* 378 */         AVAILABILITY.AVOID_PASS, false)).setData(4);
/*     */     
/* 380 */     FurnisherItemTile ll = new FurnisherItemTile(
/* 381 */         this, 
/* 382 */         (RoomSprite)pedistal2, 
/* 383 */         AVAILABILITY.AVOID_PASS, false);
/*     */     
/* 385 */     FurnisherItemTile rr = new FurnisherItemTile(
/* 386 */         this, 
/* 387 */         (RoomSprite)pedistal1, 
/* 388 */         AVAILABILITY.AVOID_PASS, false);
/*     */     
/* 390 */     FurnisherItemTile mm = new FurnisherItemTile(
/* 391 */         this, 
/* 392 */         (RoomSprite)pedistal3, 
/* 393 */         AVAILABILITY.AVOID_PASS, false);
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
/* 426 */     flush(1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 431 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 436 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeOutdoors() {
/* 441 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 447 */     return (Room)this.blue.instance.place(area);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 452 */     return this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Pedistall
/*     */     extends RoomSpriteBoxN
/*     */   {
/*     */     public Pedistall(Json json) throws IOException {
/* 460 */       super(json, "PODIUM_BOX");
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 465 */       super.render(r, s, data, it, degrade, false);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 471 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 477 */       type().renderOverlay(x, y, r, AVAILABILITY.ROOM, 
/* 478 */           data & 0xF, 0, false);
/* 479 */       (SPRITES.cons()).fullArrows.render(r, item.rotation, x, y);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Pedistal
/*     */     extends RoomSpriteBoxN
/*     */   {
/*     */     private final RoomSprite top;
/*     */     
/*     */     public Pedistal(Json json, RoomSprite top) throws IOException {
/* 489 */       super(json, "PODIUM_BOX");
/* 490 */       this.top = top;
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 495 */       super.render(r, s, data, it, degrade, false);
/* 496 */       this.top.renderBelow(r, s, data, it, degrade);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 502 */       if (!isCandle) {
/* 503 */         this.top.render(r, s, getData2(it), it, degrade, false);
/*     */       }
/* 505 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 510 */       this.top.renderAbove(r, s, data, it, degrade);
/*     */     }
/*     */ 
/*     */     
/*     */     public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 515 */       return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 521 */       type().renderOverlay(x, y, r, AVAILABILITY.ROOM, 
/* 522 */           data & 0xF, 0, false);
/* 523 */       (SPRITES.cons()).fullArrows.render(r, item.rotation, x, y);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderExtra(SPRITE_RENDERER r, int x, int y, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 531 */     if (item.get(rx, ry).data() > 0) {
/* 532 */       double v = this.envValue[(SETT.ENV()).map.PUNISHMENT.index()];
/* 533 */       double ra = this.envRadius[(SETT.ENV()).map.PUNISHMENT.index()];
/*     */       
/* 535 */       (SETT.ENV()).map.PUNISHMENT.addExtraView(v, ra, tx, ty, -1);
/* 536 */       SETT.OVERLAY().envThing((SETT.ENV()).map.PUNISHMENT).add();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean envValue(SettEnvMap.SettEnv e, SettEnvMap.SettEnvValue v, int tx, int ty) {
/* 543 */     if (this.envRadius[e.index()] == 0.0D)
/* 544 */       return false; 
/* 545 */     if ((SETT.ROOMS()).fData.tileData.get(tx, ty) > 0) {
/* 546 */       return super.envValue(e, v, tx, ty);
/*     */     }
/* 548 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\execution\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */