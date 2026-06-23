/*     */ package settlement.room.service.arena.grand;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemGroup;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteBoxN;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.Json;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ final class CUtil
/*     */ {
/*     */   private final ArenaConstructor c;
/*     */   public final FurnisherItemTile iTorch;
/*     */   public final FurnisherItemTile iWall;
/*     */   public final FurnisherItemTile iTower;
/*     */   public final FurnisherItemTile iSeat1;
/*     */   public final FurnisherItemTile iSeat2;
/*     */   public final FurnisherItemTile iEntrance;
/*     */   public final FurnisherItemTile iRim;
/*     */   public final FurnisherItemTile iArena;
/*     */   public final FurnisherItemTile[] iStairs;
/*     */   
/*     */   public CUtil(ArenaConstructor c, Json sp) throws IOException {
/*  43 */     this.c = c;
/*  44 */     RoomSpriteBoxN roomSpriteBoxN1 = new RoomSpriteBoxN(sp, "SEAT_BOX")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  48 */           return (CUtil.this.getLevel(tx, ty) >= CUtil.this.getLevel(tx - d.x(), ty - d.y()));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  54 */           boolean ret = super.render(r, s, data, it, degrade, isCandle);
/*  55 */           CUtil.this.renderLevel(r, getData2(it), it);
/*  56 */           return ret;
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  61 */           return (byte)CUtil.this.getLevel(tx, ty);
/*     */         }
/*     */       };
/*     */     
/*  65 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "WALL_1X1", (RoomSprite)roomSpriteBoxN1)
/*     */       {
/*     */         final RoomSprite ss;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  77 */           return (CUtil.this.getLevel(tx, ty) == -1);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  83 */           return this.ss.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  88 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  93 */           return this.ss.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */     
/*  97 */     RoomSpriteBoxN roomSpriteBoxN2 = new RoomSpriteBoxN(sp, "RIM_BOX")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 101 */           return (CUtil.this.getLevel(tx, ty) >= CUtil.this.getLevel(tx - d.x(), ty - d.y()));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 107 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 112 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 117 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "TOWER_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 121 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 127 */           return false;
/*     */         }
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 131 */           super.render(r, s, data, it, degrade, this.rotates);
/*     */         }
/*     */       };
/*     */     
/* 135 */     RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1(sp, "TORCH_1X1", sp)
/*     */       {
/*     */         RoomSprite1x1 tt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 147 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 153 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 158 */           super.render(r, s, data, it, degrade, false);
/* 159 */           this.tt.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 164 */           return this.tt.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */     
/* 168 */     this.iWall = new FurnisherItemTile(
/* 169 */         c, 
/* 170 */         (RoomSprite)roomSprite1x11, 
/* 171 */         AVAILABILITY.SOLID, 
/* 172 */         false);
/*     */     
/* 174 */     this.iTorch = new FurnisherItemTile(
/* 175 */         c, 
/* 176 */         (RoomSprite)roomSprite1x13, 
/* 177 */         AVAILABILITY.SOLID, 
/* 178 */         false);
/*     */     
/* 180 */     this.iTower = new FurnisherItemTile(
/* 181 */         c, 
/* 182 */         (RoomSprite)roomSprite1x12, 
/* 183 */         AVAILABILITY.SOLID, 
/* 184 */         false);
/*     */     
/* 186 */     this.iStairs = new FurnisherItemTile[] {
/* 187 */         new FurnisherItemTile(
/* 188 */           c, 
/* 189 */           (RoomSprite)new SStairs(sp, "STAIRS_SINGLE_1X1"), 
/* 190 */           AVAILABILITY.ROOM, 
/* 191 */           false), 
/* 192 */         new FurnisherItemTile(
/* 193 */           c, 
/* 194 */           (RoomSprite)new SStairs(sp, "STAIRS_LEFT_1X1"), 
/* 195 */           AVAILABILITY.ROOM, 
/* 196 */           false), 
/* 197 */         new FurnisherItemTile(
/* 198 */           c, 
/* 199 */           (RoomSprite)new SStairs(sp, "STAIRS_RIGHT_1X1"), 
/* 200 */           AVAILABILITY.ROOM, 
/* 201 */           false), 
/* 202 */         new FurnisherItemTile(
/* 203 */           c, 
/* 204 */           (RoomSprite)new SStairs(sp, "STAIRS_CENTRE_1X1"), 
/* 205 */           AVAILABILITY.ROOM, 
/* 206 */           false)
/*     */       };
/*     */     
/* 209 */     this.iSeat1 = new FurnisherItemTile(
/* 210 */         c, 
/* 211 */         (RoomSprite)roomSpriteBoxN1, 
/* 212 */         AVAILABILITY.ROOM, 
/* 213 */         false);
/*     */     
/* 215 */     this.iSeat2 = new FurnisherItemTile(
/* 216 */         c, 
/* 217 */         (RoomSprite)roomSpriteBoxN1, 
/* 218 */         AVAILABILITY.PENALTY4, 
/* 219 */         false);
/*     */     
/* 221 */     this.iEntrance = new FurnisherItemTile(
/* 222 */         c, 
/* 223 */         (RoomSprite)roomSpriteBoxN1, 
/* 224 */         AVAILABILITY.ROOM, 
/* 225 */         false);
/*     */     
/* 227 */     this.iRim = new FurnisherItemTile(
/* 228 */         c, 
/* 229 */         (RoomSprite)roomSpriteBoxN2, 
/* 230 */         AVAILABILITY.SOLID, 
/* 231 */         false);
/*     */     
/* 233 */     this.iArena = new FurnisherItemTile(
/* 234 */         c, 
/* 235 */         (RoomSprite)RoomSprite1x1.DUMMY, 
/* 236 */         AVAILABILITY.ROOM, 
/* 237 */         false);
/*     */   }
/*     */   
/*     */   public boolean service(int tx, int ty) {
/* 241 */     FurnisherItemTile t = tile(tx, ty);
/* 242 */     return !(t != this.iSeat1 && t != this.iSeat2);
/*     */   }
/*     */   
/*     */   Rec init(TmpArea ins) {
/* 246 */     Rec res = new Rec(0.0D);
/* 247 */     for (COORDINATE c : ins.body()) {
/* 248 */       if (ins.is(c)) {
/* 249 */         FurnisherItemTile it = get(c.x(), c.y(), (AREA)ins);
/* 250 */         if (it == this.iArena)
/* 251 */           if (res.width() == 0) {
/* 252 */             res.setDim(1.0D).moveX1Y1(c.x(), c.y());
/*     */           } else {
/* 254 */             res.unify(c.x(), c.y());
/*     */           }  
/* 256 */         set(ins, it, c.x(), c.y());
/*     */       } 
/*     */     } 
/*     */     
/* 260 */     int x1 = ins.body().x1();
/* 261 */     int x2 = ins.body().x2() - 1;
/* 262 */     int y1 = ins.body().y1();
/* 263 */     int y2 = ins.body().y2() - 1;
/* 264 */     int w = x2 - x1;
/* 265 */     int h = y2 - y1;
/* 266 */     setStairs(ins, x1, y2, DIR.E, ins.body().width());
/* 267 */     setStairs(ins, x2, y2, DIR.N, ins.body().height());
/* 268 */     setStairs(ins, x2, y1, DIR.W, ins.body().width());
/* 269 */     setStairs(ins, x1, y1, DIR.S, ins.body().height());
/*     */     
/* 271 */     set(ins, this.iTower, x1, y1);
/* 272 */     set(ins, this.iTower, x2, y1);
/* 273 */     set(ins, this.iTower, x1, y2);
/* 274 */     set(ins, this.iTower, x1, y2);
/*     */     
/* 276 */     int t = 3;
/*     */ 
/*     */     
/* 279 */     setTorch(ins, x1 + t, y2 - t, DIR.E, w - t * 2);
/* 280 */     setTorch(ins, x2 - t, y2 - t, DIR.N, h - t * 2);
/* 281 */     setTorch(ins, x2 - t, y1 + t, DIR.W, w - t * 2);
/* 282 */     setTorch(ins, x1 + t, y1 + t, DIR.S, h - t * 2);
/*     */     
/* 284 */     int seats = seatDepth((AREA)ins);
/* 285 */     if (seats > 6) {
/*     */       
/* 287 */       t = seats - 2;
/* 288 */       setTorch(ins, x1 + t, y2 - t, DIR.E, w - t * 2);
/* 289 */       setTorch(ins, x2 - t, y2 - t, DIR.N, h - t * 2);
/* 290 */       setTorch(ins, x2 - t, y1 + t, DIR.W, w - t * 2);
/* 291 */       setTorch(ins, x1 + t, y1 + t, DIR.S, h - t * 2);
/*     */     } 
/* 293 */     return res;
/*     */   }
/*     */   
/*     */   private void setStairs(TmpArea ins, int x1, int y1, DIR dir, int dim) {
/* 297 */     FurnisherItem st = ((FurnisherItemGroup)this.c.groups().get(0)).item(0, 0);
/* 298 */     for (int i = 0; i < dim; i++) {
/* 299 */       int x = x1 + dir.x() * i;
/* 300 */       int y = y1 + dir.y() * i;
/* 301 */       if ((SETT.ROOMS()).fData.item.get(x, y) == st) {
/* 302 */         int bb = 0;
/* 303 */         if ((SETT.ROOMS()).fData.item.get(x + dir.x(), y + dir.y()) == st) {
/* 304 */           bb |= 0x1;
/*     */         } else {
/* 306 */           set(ins, this.iTower, x + dir.x(), y + dir.y());
/* 307 */         }  if ((SETT.ROOMS()).fData.item.get(x - dir.x(), y - dir.y()) == st) {
/* 308 */           bb |= 0x2;
/*     */         } else {
/* 310 */           set(ins, this.iTower, x - dir.x(), y - dir.y());
/* 311 */         }  FurnisherItemTile s = this.iStairs[bb];
/* 312 */         set(ins, this.iEntrance, x, y);
/* 313 */         DIR in = dir.next(-2);
/* 314 */         for (int k = 1; k < 100; k++) {
/* 315 */           int dx = x + in.x() * k;
/* 316 */           int dy = y + in.y() * k;
/* 317 */           FurnisherItemTile ttt = get(dx, dy, (AREA)ins);
/* 318 */           if (ttt != this.iSeat2 && ttt != this.iRim && ttt != this.iSeat1)
/*     */             break; 
/* 320 */           set(ins, s, dx, dy);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setTorch(TmpArea ins, int x, int y, DIR dir, int dim) {
/* 331 */     set(ins, this.iTorch, x, y);
/* 332 */     set(ins, this.iTorch, x + dir.x() * dim, y + dir.y() * dim);
/*     */ 
/*     */     
/* 335 */     int left = 5;
/* 336 */     int right = 5;
/*     */     
/* 338 */     for (int i = 4; i <= dim / 2; i++) {
/* 339 */       int x1 = x + dir.x() * i;
/* 340 */       int y1 = y + dir.y() * i;
/* 341 */       int x2 = x + dir.x() * (dim - i);
/* 342 */       int y2 = y + dir.y() * (dim - i);
/*     */       
/* 344 */       if (tile(x1, y1) == this.iSeat2 && (
/* 345 */         left > 10 || (left >= 5 && tile(x1 + dir.x(), y1 + dir.y()) != this.iSeat2))) {
/* 346 */         set(ins, this.iTorch, x1, y1);
/* 347 */         left = 0;
/*     */       } 
/*     */ 
/*     */       
/* 351 */       if (tile(x2, y2) == this.iSeat2 && (
/* 352 */         right > 10 || (right >= 5 && tile(x2 - dir.x(), y2 - dir.y()) != this.iSeat2))) {
/* 353 */         set(ins, this.iTorch, x2, y2);
/* 354 */         right = 0;
/*     */       } 
/*     */       
/* 357 */       right++;
/* 358 */       left++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void set(TmpArea ins, FurnisherItemTile it, int tx, int ty) {
/* 366 */     FurnisherItem tt = ((FurnisherItemGroup)this.c.groups().get(0)).item(0, 0);
/* 367 */     byte dd = it.sprite.getData(tx, ty, ty - ins.body().x1(), ty - ins.body().y1(), tt, GUTIL.ran2().get(tx, ty));
/* 368 */     (SETT.ROOMS()).fData.spriteData.set(tx, ty, dd);
/* 369 */     dd = it.sprite.getData2(tx, ty, tx - ins.body().x1(), ty - ins.body().y1(), tt, GUTIL.ran2().get(tx, ty));
/* 370 */     (SETT.ROOMS()).fData.spriteData2.set(tx, ty, dd);
/* 371 */     (SETT.ROOMS()).data.set((ROOMA)ins, tx, ty, it.index());
/* 372 */     (SETT.PATH()).availability.updateAvailability(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public FurnisherItemTile tile(int tile) {
/* 377 */     int d = (SETT.ROOMS()).data.get(tile);
/* 378 */     d &= 0x1F;
/* 379 */     return this.c.tile(d);
/*     */   }
/*     */   
/*     */   public FurnisherItemTile tile(int tx, int ty) {
/* 383 */     int d = (SETT.ROOMS()).data.get(tx, ty);
/* 384 */     d &= 0x1F;
/* 385 */     return this.c.tile(d);
/*     */   }
/*     */   
/*     */   private int seatDepth(AREA ins) {
/* 389 */     int dim = Math.min(ins.body().width(), ins.body().height());
/* 390 */     int arena = (int)(dim * 0.4D);
/* 391 */     arena = Math.max(arena, 4);
/* 392 */     return arena;
/*     */   }
/*     */   
/*     */   public FurnisherItemTile get(int tx, int ty, AREA ins) {
/* 396 */     int l = getLevel(tx, ty);
/*     */     
/* 398 */     int arena = seatDepth(ins);
/* 399 */     if (l == 0)
/* 400 */       return this.iWall; 
/* 401 */     if (l == 1)
/* 402 */       return this.iSeat1; 
/* 403 */     if (l < arena - 1)
/* 404 */       return this.iSeat2; 
/* 405 */     if (l < arena)
/* 406 */       return this.iRim; 
/* 407 */     return this.iArena;
/*     */   }
/*     */   
/*     */   public FurnisherItemTile get(int tx, int ty) {
/* 411 */     Room rr = (SETT.ROOMS()).map.get(tx, ty);
/* 412 */     if (!(rr instanceof AREA)) {
/* 413 */       return null;
/*     */     }
/* 415 */     if (rr.constructor() != this.c) {
/* 416 */       return null;
/*     */     }
/* 418 */     return get(tx, ty, (AREA)rr);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeEntrance(int tx, int ty) {
/* 423 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 424 */     if (r == null || !(r instanceof AREA))
/* 425 */       return false; 
/* 426 */     AREA a = (AREA)r;
/* 427 */     int arena = seatDepth(a);
/*     */     
/* 429 */     if (ty == a.body().y1() || ty == a.body().y2() - 1) {
/* 430 */       if (tx - a.body().x1() <= arena)
/* 431 */         return false; 
/* 432 */       if (a.body().x2() - 1 - tx <= arena) {
/* 433 */         return false;
/*     */       }
/* 435 */     } else if (tx == a.body().x1() || tx == a.body().x2() - 1) {
/* 436 */       if (ty - a.body().y1() <= arena)
/* 437 */         return false; 
/* 438 */       if (a.body().y2() - 1 - ty <= arena)
/* 439 */         return false; 
/*     */     } 
/* 441 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLevel(int tx, int ty) {
/* 448 */     Room rr = (SETT.ROOMS()).map.get(tx, ty);
/* 449 */     if (!(rr instanceof AREA)) {
/* 450 */       return -1;
/*     */     }
/* 452 */     if (rr.constructor() != this.c) {
/* 453 */       return -1;
/*     */     }
/* 455 */     AREA a = (AREA)rr;
/*     */     
/* 457 */     int distX = Math.min(Math.abs(a.body().x1() - tx), Math.abs(a.body().x2() - tx - 1));
/* 458 */     int distY = Math.min(Math.abs(a.body().y1() - ty), Math.abs(a.body().y2() - ty - 1));
/*     */     
/* 460 */     if (distX == 0 && distY == 0) {
/* 461 */       return 0;
/*     */     }
/*     */     
/* 464 */     int dist = Math.min(distX, distY);
/*     */     
/* 466 */     return dist;
/*     */   }
/*     */   
/*     */   private void renderLevel(SPRITE_RENDERER r, int level, RenderData.RenderIterator it) {
/* 470 */     int cc = level & 0xF;
/* 471 */     OpacityImp.TMP.set(cc * 8);
/* 472 */     OpacityImp.TMP.bind();
/* 473 */     COLOR.BLACK.render(r, it.x(), it.x() + 64, it.y(), it.y() + 64);
/* 474 */     OPACITY.unbind();
/*     */   }
/*     */   
/*     */   private class SStairs
/*     */     extends RoomSprite1x1 {
/*     */     public SStairs(Json json, String key) throws IOException {
/* 480 */       super(json, key);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 485 */       return (CUtil.this.getLevel(tx, ty) > CUtil.this.getLevel(tx - d.x(), ty - d.y()));
/*     */     }
/*     */ 
/*     */     
/*     */     public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 490 */       return (byte)CUtil.this.getLevel(tx, ty);
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 495 */       super.render(r, s, data & 0xF, it, degrade, false);
/* 496 */       CUtil.this.renderLevel(r, getData2(it), it);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 502 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\grand\CUtil.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */