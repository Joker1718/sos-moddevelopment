/*     */ package settlement.room.service.breeder;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.sprite.SPRITES;
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
/*     */ import settlement.room.sprite.RoomSpriteXxX;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class BreederConstructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_BREEDER blue;
/*     */   final FurnisherStat workers;
/*     */   final FurnisherStat coziness;
/*     */   static final int WORK = 1;
/*     */   
/*     */   protected BreederConstructor(final ROOM_BREEDER blue, RoomInitData init) throws IOException {
/*  39 */     super(init, 2, 2);
/*  40 */     this.blue = blue;
/*     */     
/*  42 */     this.workers = (FurnisherStat)new FurnisherStat.FurnisherStatEmployees(this);
/*  43 */     this.coziness = (FurnisherStat)new FurnisherStat.FurnisherStatRelative(this, this.workers);
/*     */     
/*  45 */     Json sData = init.data().json("SPRITES");
/*     */     
/*  47 */     final RoomSprite1x1 bug = new RoomSprite1x1(sData, "1x1_WORM")
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  52 */           int ll = (int)(it.ran() + TIME.currentSecond());
/*  53 */           double sp = (ll >> 4 & 0x3) / 3.0D;
/*  54 */           animate(sp);
/*  55 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  60 */     SRim sRim1 = new SRim(sData, "1x1_RIM_CORNER", (RoomSprite)roomSprite1x11, 3);
/*  61 */     SRim sRim2 = new SRim(sData, "1x1_RIM_EDGE", (RoomSprite)roomSprite1x11, 2);
/*  62 */     RoomSprite.Imp imp = (new RoomSprite.Imp()
/*     */       {
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  68 */           long rr = it.bigRan();
/*     */           
/*  70 */           for (int i = 0; i < 4; i++) {
/*  71 */             int ran = (int)(rr & 0xFFL);
/*  72 */             rr >>= 16L;
/*     */             
/*  74 */             if (blue.station.worm(it.tx(), it.ty(), ran)) {
/*  75 */               bug.render(r, s, ran, it, degrade, false);
/*     */               
/*  77 */               DIR d = (DIR)DIR.ALL.getC(ran & 0x7);
/*  78 */               ran >>= 3;
/*  79 */               it.setOff(d.x() * 32 / 2, d.y() * 32 / 2);
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/*  84 */           int am = blue.station.resources(it.tx(), it.ty(), it.ran());
/*  85 */           if (am > 0) {
/*  86 */             ((IndustryResource)((Industry)blue.indus.get(0)).ins().get(0)).resource.renderLaying(r, it.x(), it.y(), it.ran(), am);
/*     */           }
/*     */           
/*  89 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  94 */           return bug.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 100 */           return 0;
/*     */         }
/* 103 */       }).sDataSet(2);
/*     */ 
/*     */     
/* 106 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sData, "1x1_RIM_DECOR")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 110 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 1);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 116 */           animate(blue.station.aSpeed(it.tx(), it.ty()));
/* 117 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 122 */     RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1(sData, "1x1_CORNER");
/*     */     
/* 124 */     RoomSprite1x1 roomSprite1x14 = new RoomSprite1x1(sData, "1x1_DECOR");
/* 125 */     RoomSpriteXxX roomSpriteXxX = new RoomSpriteXxX(sData, "2x2_DECOR", 2);
/*     */     
/* 127 */     FurnisherItemTile ee = new FurnisherItemTile(
/* 128 */         this, 
/* 129 */         (RoomSprite)sRim1, 
/* 130 */         AVAILABILITY.SOLID, 
/* 131 */         false);
/* 132 */     FurnisherItemTile cc = new FurnisherItemTile(
/* 133 */         this, 
/* 134 */         (RoomSprite)sRim2, 
/* 135 */         AVAILABILITY.SOLID, 
/* 136 */         false);
/* 137 */     FurnisherItemTile mm = new FurnisherItemTile(
/* 138 */         this, 
/* 139 */         (RoomSprite)imp, 
/* 140 */         AVAILABILITY.ROOM_SOLID, 
/* 141 */         false);
/*     */     
/* 143 */     FurnisherItemTile xx = new FurnisherItemTile(
/* 144 */         this, 
/* 145 */         false, 
/* 146 */         (RoomSprite)roomSprite1x12, 
/* 147 */         AVAILABILITY.SOLID, 
/* 148 */         false);
/*     */     
/* 150 */     FurnisherItemTile ww = new FurnisherItemTile(
/* 151 */         this, 
/* 152 */         true, 
/* 153 */         (RoomSprite)roomSprite1x12, 
/* 154 */         AVAILABILITY.AVOID_PASS, 
/* 155 */         false);
/*     */     
/* 157 */     ww.setData(1);
/*     */ 
/*     */     
/* 160 */     FurnisherItemTile __ = new FurnisherItemTile(
/* 161 */         this, 
/* 162 */         (RoomSprite)roomSprite1x13, 
/* 163 */         AVAILABILITY.ROOM_SOLID, 
/* 164 */         true);
/*     */     
/* 166 */     FurnisherItemTile ex = new FurnisherItemTile(
/* 167 */         this, 
/* 168 */         (RoomSprite)roomSpriteXxX, 
/* 169 */         AVAILABILITY.ROOM_SOLID, 
/* 170 */         false);
/*     */     
/* 172 */     FurnisherItemTile e1 = new FurnisherItemTile(
/* 173 */         this, 
/* 174 */         (RoomSprite)roomSprite1x14, 
/* 175 */         AVAILABILITY.ROOM_SOLID, 
/* 176 */         false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 215 */     flush(3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 226 */     flush(3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 232 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 237 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 242 */     return (Room)new BreederInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 247 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 252 */     return true;
/*     */   }
/*     */   
/*     */   private class SRim extends RoomSprite1x1 {
/*     */     private final RoomSprite worm;
/*     */     private final int dirOff;
/*     */     private final Coo coo;
/*     */     
/*     */     public SRim(Json json, String key, RoomSprite worm, int dirOff) throws IOException {
/* 261 */       super(json, key);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 279 */       this.coo = new Coo();
/*     */       this.worm = worm;
/*     */       this.dirOff = dirOff;
/*     */       sData(1);
/* 283 */     } public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) { COORDINATE c = (SETT.ROOMS()).fData.itemX1Y1(it.tx(), it.ty(), this.coo);
/* 284 */       if (c != null) {
/* 285 */         it.ranOffset(c.x() - it.tx(), c.y() - it.ty());
/*     */       }
/* 287 */       super.render(r, s, data, it, degrade, false); }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 293 */       long ran = it.bigRan();
/*     */       
/* 295 */       DIR d = rot(data);
/* 296 */       d = d.next(this.dirOff);
/*     */       
/* 298 */       if (BreederConstructor.this.blue.station.worm(it.tx(), it.ty(), (int)ran)) {
/* 299 */         it.setOff(d.x() * 32 / 2, d.y() * 32 / 2);
/* 300 */         this.worm.render(r, s, (int)ran, it, degrade, false);
/*     */       } 
/* 302 */       ran >>= 32L;
/* 303 */       if (BreederConstructor.this.blue.station.worm(it.tx(), it.ty(), (int)ran)) {
/* 304 */         it.setOff(d.x() * 32, d.y() * 32);
/* 305 */         it.ranOffset(data, data);
/* 306 */         it.ranSwap();
/* 307 */         this.worm.render(r, s, (int)ran, it, degrade, false);
/*     */       } 
/* 309 */       return false;
/*     */     } protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) { rx -= d.x();
/*     */       ry -= d.y();
/*     */       d = d.next(this.dirOff);
/*     */       rx += d.x();
/*     */       ry += d.y();
/* 315 */       return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 2); } public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) { return this.worm.getData(tx, ty, rx, ry, item, itemRan); }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 321 */       DIR d = rot(data);
/* 322 */       int s = 0;
/* 323 */       if ((this.dirOff & 0x1) != 0) {
/* 324 */         s |= d.next(2).mask();
/* 325 */         s |= d.next(4).mask();
/*     */       } else {
/*     */         
/* 328 */         s |= d.mask();
/* 329 */         s |= d.next(2).mask();
/* 330 */         s |= d.next(4).mask();
/*     */       } 
/* 332 */       (SPRITES.cons()).BIG.outline.render(r, s, x, y);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\breeder\BreederConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */