/*     */ package settlement.room.service.hygine.well;
/*     */ 
/*     */ import game.time.TIME;
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
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_WELL blue;
/*  36 */   final FurnisherStat services = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*  37 */   private static final Founatain fountain = new Founatain();
/*     */   
/*     */   static final int codeService = 1;
/*     */   
/*     */   protected Constructor(final ROOM_WELL blue, RoomInitData init) throws IOException {
/*  42 */     super(init, 1, 1, 88, 44);
/*  43 */     this.blue = blue;
/*     */     
/*  45 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  47 */     final RoomSpriteCombo sStencil = new RoomSpriteCombo(sp, "STONE_RING_STENCIL_COMBO");
/*  48 */     final RoomSprite1x1 sRoof = new RoomSprite1x1(sp, "ROOF_EDGE_1X1")
/*     */       {
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  54 */           FurnisherItem i = (FurnisherItem)(SETT.ROOMS()).fData.item.get(it.tile());
/*  55 */           if ((i.width() & 0x1) == 0)
/*  56 */             it.setOff(0, -32); 
/*  57 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  62 */           if (rx - d.x() >= item.width() / 2)
/*  63 */             return (d.x() < 0); 
/*  64 */           return (d.x() > 0);
/*     */         }
/*     */       };
/*     */     
/*  68 */     final RoomSprite1x1 sRoofMid = new RoomSprite1x1(sp, "ROOF_MID_1X1")
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  73 */           FurnisherItem i = (FurnisherItem)(SETT.ROOMS()).fData.item.get(it.tile());
/*  74 */           if ((i.width() & 0x1) == 0)
/*  75 */             it.setOff(0, -32); 
/*  76 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  81 */           return (d.x() > 0);
/*     */         }
/*     */       };
/*     */     
/*  85 */     final RoomSprite1x1 sFountain = new RoomSprite1x1(sp, "FOUNTAIN_1X1")
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  90 */           Constructor.fountain.render(r, s, it.x() + 32, it.y() + 32);
/*  91 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  96 */     RoomSpriteCombo roomSpriteCombo1 = new RoomSpriteCombo(sp, "STONE_RING_COMBO")
/*     */       {
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 103 */           if (blue.is(it.tile())) {
/* 104 */             sStencil.render(r, s, data, it, degrade, false);
/* 105 */             (SETT.TERRAIN()).WATER.renderOverlayed(it);
/*     */           } 
/* 107 */           it.countWater();
/* 108 */           it.countWater();
/* 109 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 114 */           super.render(r, s, data, it, degrade, false);
/* 115 */           int up = (blue.is(it.tile()) && ((WellInstance)blue.getter.get(it.tile())).upgrade() > 0) ? 1 : 0;
/* 116 */           RoomSprite roo = eSprite((FurnisherItem)(SETT.ROOMS()).fData.item.get(it.tile()), data, up);
/* 117 */           if (roo != null) {
/* 118 */             roo.render(r, s, getData2(it), it, degrade, false);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 124 */           RoomSprite roo = eSprite(item, getData(tx, ty, rx, ry, item, itemRan), 0);
/* 125 */           if (roo != null)
/* 126 */             return roo.getData(tx, ty, rx, ry, item, itemRan); 
/* 127 */           return 0;
/*     */         }
/*     */         
/*     */         private RoomSprite eSprite(FurnisherItem item, int data, int up) {
/* 131 */           if (item.width() == 4) {
/* 132 */             if ((data & DIR.S.mask()) == 0) {
/* 133 */               return sRoof;
/*     */             }
/* 135 */           } else if (item.width() == 5) {
/* 136 */             if (up > 0) {
/* 137 */               if ((data & 0xF) == 15) {
/* 138 */                 return sFountain;
/*     */               }
/* 140 */             } else if ((data & DIR.S.mask()) != 0 && (data & DIR.N.mask()) != 0) {
/* 141 */               if ((data & 0xF) == 15)
/* 142 */                 return sRoofMid; 
/* 143 */               return sRoof;
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 150 */           return null;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 157 */     RoomSprite1x1 roomSprite1x14 = new RoomSprite1x1(sp, "BUCKET_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 161 */           rx -= d.x() * 2;
/* 162 */           ry -= d.y() * 2;
/* 163 */           return (item.get(rx, ry) == null);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 169 */           if (blue.is(it.tile()) && 
/* 170 */             blue.bed.isUsed(it.tile())) {
/* 171 */             return super.render(r, s, data, it, degrade, isCandle);
/*     */           }
/* 173 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 178 */     FurnisherItemTile ww = new FurnisherItemTile(
/* 179 */         this, 
/* 180 */         (RoomSprite)roomSpriteCombo1, 
/* 181 */         AVAILABILITY.SOLID, 
/* 182 */         false);
/* 183 */     FurnisherItemTile ss = (new FurnisherItemTile(
/* 184 */         this, 
/* 185 */         false, 
/* 186 */         (RoomSprite)roomSprite1x14, 
/* 187 */         AVAILABILITY.ROOM, 
/* 188 */         false)).setData(1);
/*     */     
/* 190 */     FurnisherItemTile __ = new FurnisherItemTile(
/* 191 */         this, 
/* 192 */         false, 
/* 193 */         null, 
/* 194 */         AVAILABILITY.ROOM, 
/* 195 */         false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 218 */     flush(1, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 224 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 229 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 234 */     return (Room)new WellInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 239 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Founatain
/*     */   {
/* 263 */     private final int AM = 64;
/*     */     
/* 265 */     private byte[] xs = Alloc.bb(64);
/* 266 */     private byte[] ys = Alloc.bb(64);
/* 267 */     private double[] rans = new double[64];
/* 268 */     private COLOR[] cols = new COLOR[64];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Founatain() {
/* 274 */       for (int i = 0; i < 64; i++) {
/* 275 */         double rad = RND.rFloat() * Math.PI * 0.5D;
/* 276 */         double dx = Math.cos(rad);
/* 277 */         double dy = Math.sin(rad);
/* 278 */         this.xs[i] = (byte)(int)(dx * (16.0F + RND.rFloat() * 64.0F));
/* 279 */         this.ys[i] = (byte)(int)(dy * (16.0F + RND.rFloat() * 64.0F));
/* 280 */         this.rans[i] = (RND.rInt(128) + RND.rFloat());
/*     */       } 
/*     */       
/* 283 */       this.cols = (COLOR[])COLOR.interpolate((COLOR)new ColorImp(20, 60, 127), COLOR.WHITE100, 64);
/*     */     }
/*     */ 
/*     */     
/*     */     void render(SPRITE_RENDERER r, ShadowBatch s, int cx, int cy) {
/* 288 */       double time = TIME.currentSecond() * 1.5D;
/* 289 */       render(r, s, cx, cy, time, 1, 1);
/* 290 */       time += 0.3D;
/* 291 */       render(r, s, cx - 4, cy, time, -1, 1);
/* 292 */       time += 0.3D;
/* 293 */       render(r, s, cx, cy - 4, time, 1, -1);
/* 294 */       time += 0.3D;
/* 295 */       render(r, s, cx - 4, cy - 4, time, -1, -1);
/*     */     }
/*     */     void render(SPRITE_RENDERER r, ShadowBatch s, int cx, int cy, double time, int dx, int dy) {
/* 298 */       int a = 64;
/* 299 */       if (TIME.light().nightIs()) {
/* 300 */         a = (int)(a * (1.0D - TIME.light().partOf() * 10.0D));
/*     */       }
/* 302 */       for (int i = 0; i < a; i++) {
/* 303 */         double d = this.rans[i] + time;
/* 304 */         int k = (int)d;
/* 305 */         d -= k;
/* 306 */         int x = (int)(this.xs[i] * d);
/* 307 */         int y = (int)(this.ys[i] * d);
/* 308 */         this.cols[k & 0x3F].bind();
/* 309 */         CORE.renderer().renderParticle(cx + x * dx, cy + y * dy);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hygine\well\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */