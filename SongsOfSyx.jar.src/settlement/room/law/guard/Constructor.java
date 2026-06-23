/*     */ package settlement.room.law.guard;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSpriteBoxN;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import settlement.room.sprite.RoomSpriteImp;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.tool.PlacableMessages;
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_GUARD blue;
/*     */   static final int codeLight = 3;
/*     */   static final int codeStand = 4;
/*     */   private final FurnisherItemTile xx;
/*     */   private final FurnisherItemTile gg;
/*     */   
/*  43 */   final FurnisherStat guards = new FurnisherStat(this)
/*     */     {
/*     */       public double get(AREA area, double acc)
/*     */       {
/*  47 */         return Math.ceil(acc);
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  52 */         GFORMAT.i(t, (int)value);
/*  53 */         return t;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   protected Constructor(ROOM_GUARD blue, RoomInitData init) throws IOException {
/*  59 */     super(init, 2, 1, 88, 44);
/*  60 */     this.blue = blue;
/*     */     
/*  62 */     Json js = init.data().json("SPRITES");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  68 */     RoomSpriteBoxN roomSpriteBoxN = new RoomSpriteBoxN(js, "FLOOR_BOX")
/*     */       {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  72 */           return false;
/*     */         }
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  76 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */       };
/*     */     
/*  80 */     final RoomSpriteCombo top = new RoomSpriteCombo(js, "CARPET_COMBO")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  83 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 3);
/*     */         }
/*     */       };
/*     */     
/*  87 */     RoomSpriteImp roomSpriteImp1 = (new RoomSpriteBoxN((RoomSprite)roomSpriteBoxN)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  95 */           return top.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 100 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 105 */           return top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/* 109 */       }).sData(3);
/*     */     
/* 111 */     RoomSpriteImp roomSpriteImp2 = (new RoomSpriteBoxN((RoomSprite)roomSpriteBoxN)
/*     */       {
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 117 */           return top.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 122 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 127 */           return top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 132 */           super.renderPlaceholder(r, x, y, data, tx, ty, rx, ry, item);
/* 133 */           DIR d = (DIR)DIR.ORTHO.getC(item.rotation + 1);
/* 134 */           (SPRITES.cons()).fullArrows.render(r, d.orthoID(), x, y);
/*     */         }
/* 138 */       }).sData(3);
/*     */     
/* 140 */     RoomSpriteImp roomSpriteImp3 = (new RoomSpriteBoxN((RoomSprite)roomSpriteBoxN, js)
/*     */       {
/*     */         RoomSprite sBottom;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         RoomSprite top;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 163 */           return this.top.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 168 */           super.render(r, s, data, it, degrade, false);
/* 169 */           this.sBottom.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 174 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/* 178 */       }).sData(2);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 183 */     RoomSpriteImp roomSpriteImp4 = (new RoomSpriteBoxN((RoomSprite)roomSpriteBoxN, js)
/*     */       {
/*     */         RoomSprite top;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 197 */           return this.top.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 202 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 207 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/* 210 */       }).sData(1);
/*     */ 
/*     */     
/* 213 */     this.xx = new FurnisherItemTile(
/* 214 */         this, 
/* 215 */         (RoomSprite)roomSpriteImp4, 
/* 216 */         AVAILABILITY.SOLID, 
/* 217 */         false);
/*     */     
/* 219 */     FurnisherItemTile op = new FurnisherItemTile(
/* 220 */         this, 
/* 221 */         (RoomSprite)roomSpriteBoxN, 
/* 222 */         AVAILABILITY.ROOM, 
/* 223 */         false);
/*     */     
/* 225 */     FurnisherItemTile __ = (new FurnisherItemTile(
/* 226 */         this, 
/* 227 */         (RoomSprite)roomSpriteImp1, 
/* 228 */         AVAILABILITY.ROOM, 
/* 229 */         false)).setData(4);
/*     */     
/* 231 */     this.gg = (new FurnisherItemTile(
/* 232 */         this, 
/* 233 */         (RoomSprite)roomSpriteImp2, 
/* 234 */         AVAILABILITY.ROOM, 
/* 235 */         false)).setData(4);
/*     */     
/* 237 */     FurnisherItemTile i1 = (new FurnisherItemTile(
/* 238 */         this, 
/* 239 */         (RoomSprite)roomSpriteImp3, 
/* 240 */         AVAILABILITY.SOLID, 
/* 241 */         false)).setData(3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 320 */     flush(1, 3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 356 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderExtra(SPRITE_RENDERER r, int x, int y, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 363 */     if (item.get(rx, ry) == this.gg) {
/* 364 */       DIR d = (DIR)DIR.ORTHO.getC(item.rotation + 1);
/* 365 */       int approvedDirs = d.bit | (d.next(-1)).bit | (d.next(1)).bit;
/* 366 */       (SETT.ENV()).map.GUARD.addExtraView(0.13333333333333333D, 1.0D, tx, ty, approvedDirs);
/* 367 */       SETT.OVERLAY().envThing((SETT.ENV()).map.GUARD).add();
/* 368 */     } else if (item.get(rx, ry).data() == 4) {
/* 369 */       (SETT.ENV()).map.GUARD.addExtraView(0.06666666666666667D, 0.75D, tx, ty, -1);
/* 370 */       SETT.OVERLAY().envThing((SETT.ENV()).map.GUARD).add();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean envValue(SettEnvMap.SettEnv e) {
/* 377 */     return super.envValue(e);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean envValue(SettEnvMap.SettEnv e, SettEnvMap.SettEnvValue v, int tx, int ty) {
/* 382 */     if (this.envRadius[e.index()] == 0.0D)
/* 383 */       return false; 
/* 384 */     if ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 4) {
/* 385 */       GuardInstance ins = (GuardInstance)this.blue.get(tx, ty);
/* 386 */       if (ins != null && ins.eff > 0.0F) {
/* 387 */         if ((SETT.ROOMS()).fData.tile.get(tx, ty) == this.gg) {
/* 388 */           DIR d = (DIR)DIR.ORTHO.getC(((FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty)).rotation + 1);
/* 389 */           v.approvedDirs = d.bit | (d.next(-1)).bit | (d.next(1)).bit;
/* 390 */           v.value = 0.13333333333333333D;
/* 391 */           v.radius = ins.eff * 1.0D;
/*     */         } else {
/* 393 */           v.radius = ins.eff * 0.75D;
/* 394 */           v.value = 0.06666666666666667D;
/*     */         } 
/* 396 */         return true;
/*     */       } 
/* 398 */       v.value = 0.0D;
/* 399 */       v.radius = 0.0D;
/* 400 */       return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 407 */     return false;
/*     */   }
/*     */   
/*     */   public DIR gaurdDir(int tx, int ty) {
/* 411 */     if ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 4) {
/*     */       
/* 413 */       if ((SETT.ROOMS()).fData.tile.get(tx, ty) == this.gg) {
/* 414 */         DIR d = (DIR)DIR.ORTHO.getC(((FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty)).rotation + 1);
/* 415 */         return d;
/*     */       } 
/* 417 */       RoomInstance ins = this.blue.get(tx, ty);
/* 418 */       return DIR.get(ins.body().cX(), ins.body().cY(), tx, ty).next(-1 + RND.rInt(3));
/*     */     } 
/*     */ 
/*     */     
/* 422 */     return DIR.N;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeTerrain(int tx, int ty) {
/* 427 */     if (SETT.TERRAIN().get(tx, ty) instanceof settlement.tilemap.terrain.TFortification.Normal && ((SETT.PATH()).availability.get(tx, ty)).player >= 0.0D)
/* 428 */       return false; 
/* 429 */     return super.removeTerrain(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence placable(int tx, int ty, FurnisherItem item, FurnisherItemTile tile) {
/* 434 */     if (SETT.TERRAIN().get(tx, ty) instanceof settlement.tilemap.terrain.TFortification.Normal && ((SETT.PATH()).availability.get(tx, ty)).player < 0.0D)
/* 435 */       return PlacableMessages.¤¤STRUCTURE_BLOCK; 
/* 436 */     return super.placable(tx, ty, item, tile);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 442 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 447 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeOutdoors() {
/* 452 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 457 */     return (Room)new GuardInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 462 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 467 */     super.putFloor(tx, ty, upgrade, area);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\guard\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */