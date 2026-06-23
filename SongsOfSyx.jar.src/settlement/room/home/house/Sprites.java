/*     */ package settlement.room.home.house;
/*     */ 
/*     */ import init.race.home.RaceHomeClass;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.game.SheetPair;
/*     */ import init.sprite.game.SheetType;
/*     */ import init.sprite.game.Sheets;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Sprites
/*     */ {
/*  28 */   private final SpriteCarpet carpet = new SpriteCarpet();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int renderAbsolute = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Sprite staU;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Sprite staD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final SpriteConfigs sp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Sprite bedN;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Sprite bedS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Sprite nSta;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Sprite tabl;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Sprite stor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Sprite chai;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Sprite nic1Top;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Sprite nic1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Sprite nic2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Sprite _mat;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final RoomSprite theDummy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Sprites(Json json) throws IOException {
/* 127 */     this.bedN = new Sprite()
/*     */       {
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 133 */           int ran = it.ran();
/* 134 */           Sheets a = (sp()).bedTop.get(this.house);
/* 135 */           Sprites.render1x1(ran, a, r, s, data, it, degrade);
/*     */           
/* 137 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 143 */           HomeInstance house = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(tx, ty);
/* 144 */           for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 145 */             DIR d = (DIR)DIR.ORTHO.get(i);
/* 146 */             if (house.sprite(tx + d.x(), ty + d.y()) == Sprites.this.bedS) {
/* 147 */               return (byte)i;
/*     */             }
/*     */           } 
/* 150 */           return 0;
/*     */         }
/*     */       };
/*     */     
/* 154 */     this.bedS = new Sprite(true, true, true)
/*     */       {
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 160 */           DIR dir = (DIR)DIR.ORTHO.get(data & 0x3);
/* 161 */           it.ranOffset(dir.x(), dir.y());
/* 162 */           int ran = it.ran();
/* 163 */           Sheets a = (sp()).bedBottom.get(this.house);
/* 164 */           Sprites.render1x1(ran, a, r, s, data, it, degrade);
/* 165 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 170 */           HomeInstance house = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(tx, ty);
/* 171 */           for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 172 */             DIR d = (DIR)DIR.ORTHO.get(i);
/* 173 */             if (house.sprite(tx + d.x(), ty + d.y()) == Sprites.this.bedN) {
/* 174 */               return (byte)i;
/*     */             }
/*     */           } 
/* 177 */           return 0;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 196 */     this.nSta = new Sprite()
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 201 */           Sheets a = (sp()).nightStand.get(this.house);
/* 202 */           Sprites.render1x1(it.ran(), a, r, s, data, it, degrade);
/*     */           
/* 204 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 209 */           return 0;
/*     */         }
/*     */       };
/*     */     
/* 213 */     this.tabl = new Sprite()
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 218 */           Sheets a = (sp()).table.get(this.house);
/* 219 */           if (a != null) {
/* 220 */             int vv = data >> 4 & 0xF;
/* 221 */             SheetPair sh = a.get(vv);
/* 222 */             if (sh != null) {
/* 223 */               sh.d.color(vv).bind();
/* 224 */               int ran = it.ran();
/* 225 */               int t = SheetType.sCombo.tile(sh.s, sh.d, data & 0xF, sh.d.frame(ran, 1.0D), 0);
/* 226 */               sh.s.render(sh.d, it.x(), it.y(), it, r, t, ran, 0.0D);
/* 227 */               COLOR.unbind();
/* 228 */               sh.s.renderShadow(sh.d, it.x(), it.y(), it, s, t, ran);
/*     */             } 
/*     */           } 
/*     */           
/* 232 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 238 */           HomeInstance house = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(tx, ty);
/* 239 */           int m = 0;
/* 240 */           for (DIR d : DIR.ORTHO) {
/* 241 */             if (house.sprite(tx + d.x(), ty + d.y()) == this)
/* 242 */               m |= d.mask(); 
/*     */           } 
/* 244 */           return (byte)(m | (itemRan & 0xF) << 4);
/*     */         }
/*     */       };
/*     */     
/* 248 */     this.stor = new Sprite.Rot()
/*     */       {
/*     */         Sheets a(RaceHomeClass it)
/*     */         {
/* 252 */           return it.storage.get(this.house);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 257 */     this.chai = new Sprite.Rot(true, false, true)
/*     */       {
/*     */         Sheets a(RaceHomeClass it)
/*     */         {
/* 261 */           return it.chair.get(this.house);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 267 */           HomeInstance house = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(tx, ty);
/*     */ 
/*     */           
/* 270 */           int r = RND.rInt(4); int i;
/* 271 */           for (i = 0; i < DIR.ORTHO.size(); i++) {
/* 272 */             DIR d = (DIR)DIR.ORTHO.getC(i + r);
/* 273 */             if (!house.isSame(tx, ty, tx + d.x(), ty + d.y())) {
/* 274 */               return (byte)((i + 2) % 4);
/*     */             }
/*     */           } 
/*     */           
/* 278 */           for (i = 0; i < DIR.ORTHO.size(); i++) {
/* 279 */             DIR d = (DIR)DIR.ORTHO.get(i);
/* 280 */             if (house.sprite(tx + d.x(), ty + d.y()) == (SETT.ROOMS()).HOME.constructor.sp.tabl) {
/* 281 */               return (byte)i;
/*     */             }
/*     */           } 
/*     */           
/* 285 */           return (byte)RND.rInt(4);
/*     */         }
/*     */       };
/*     */     
/* 289 */     this.nic1Top = new Sprite.Rot()
/*     */       {
/*     */         Sheets a(RaceHomeClass it)
/*     */         {
/* 293 */           return it.nickTop1.get(this.house);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 298 */     this.nic1 = new Sprite.Rot()
/*     */       {
/*     */         Sheets a(RaceHomeClass it)
/*     */         {
/* 302 */           return it.nick1.get(this.house);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 307 */           Sprites.this.nic1Top.house = this.house;
/* 308 */           Sprites.this.nic1Top.render(r, s, data, it, degrade, false);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 313 */     this.nic2 = new Sprite.Rot()
/*     */       {
/*     */         Sheets a(RaceHomeClass it)
/*     */         {
/* 317 */           return it.nick2.get(this.house);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 322 */     this._mat = new Sprite.Rot(false, false, false)
/*     */       {
/*     */         Sheets a(RaceHomeClass it)
/*     */         {
/* 326 */           return it.mat.get(this.house);
/*     */         }
/*     */       };
/*     */     
/* 330 */     this.theDummy = (RoomSprite)new RoomSprite.Dummy()
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/* 334 */           HomeInstance h = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(it.tile());
/* 335 */           if (h != null) {
/* 336 */             s.setSoft();
/* 337 */             s.setDistance2Ground(0.0D).setHeight(0);
/* 338 */             COLOR.BLACK.render((SPRITE_RENDERER)s, it.x(), it.x() + 64, it.y(), it.y() + 64);
/* 339 */             s.setPrev();
/*     */ 
/*     */             
/* 342 */             if (h.occupants() > 0) {
/* 343 */               Sprite sp = h.sprite(it.tx(), it.ty());
/* 344 */               if (sp != null) {
/* 345 */                 sp.house = h;
/* 346 */                 sp.renderAbove(r, s, data, it, degrade);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch shadowBatch, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 355 */           HomeInstance h = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(it.tile());
/* 356 */           if (h != null) {
/* 357 */             if (h.occupants() > 0) {
/*     */               
/* 359 */               RaceHomeClass stage = h.race().home().clas(h.occupant(0));
/* 360 */               Floors.Floor f = stage.floor(h);
/* 361 */               if (f != (SETT.FLOOR()).getter.get(it.tx(), it.ty())) {
/* 362 */                 if (stage.floor(h) == null) {
/* 363 */                   (SETT.FLOOR()).clearer.clear(it.tx(), it.ty());
/*     */                 } else {
/* 365 */                   stage.floor(h).placeFixed(it.tx(), it.ty());
/*     */                 } 
/*     */               }
/* 368 */               Sprite s = h.sprite(it.tx(), it.ty());
/* 369 */               if (s != null) {
/* 370 */                 s.house = h;
/* 371 */                 s.render(r, shadowBatch, data, it, degrade, isCandle);
/*     */               
/*     */               }
/*     */             
/*     */             }
/*     */             else {
/*     */               
/* 378 */               Sprite s = h.sprite(it.tx(), it.ty());
/* 379 */               if (s != null && s.sData() == 1) {
/* 380 */                 s.house = h;
/* 381 */                 s.render(r, shadowBatch, data, it, degrade, isCandle);
/*     */               } 
/* 383 */               if ((SETT.FLOOR()).getter.get(it.tx(), it.ty()) != (SETT.ROOMS()).HOME.constructor.flooring) {
/* 384 */                 (SETT.ROOMS()).HOME.constructor.flooring.placeFixed(it.tx(), it.ty());
/*     */               }
/*     */             } 
/*     */           }
/* 388 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch shadow, int data, RenderData.RenderIterator it, double degrade) {
/* 394 */           HomeInstance h = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(it.tile());
/* 395 */           if (h != null) {
/* 396 */             if (h.occupants() > 0) {
/*     */               
/* 398 */               Sprite s = h.sprite(it.tx(), it.ty());
/* 399 */               if (s != null) {
/* 400 */                 s.house = h;
/* 401 */                 s.renderBelow(r, shadow, data, it, degrade);
/*     */               } 
/*     */               
/* 404 */               renderCarpet(r, shadow, data, it, degrade, h);
/*     */             } else {
/* 406 */               Sprite s = h.sprite(it.tx(), it.ty());
/* 407 */               if (s != null && s.sData() == 1) {
/* 408 */                 s.house = h;
/* 409 */                 s.renderBelow(r, shadow, data, it, degrade);
/*     */               } 
/*     */             } 
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         private void renderCarpet(SPRITE_RENDERER r, ShadowBatch shadow, int data, RenderData.RenderIterator it, double degrade, HomeInstance h) {
/* 417 */           DIR dd = h.dir();
/*     */           
/* 419 */           Room room = (SETT.ROOMS()).map.get(it.tile());
/* 420 */           int rx = it.tx() - room.x1(it.tx(), it.ty());
/* 421 */           int ry = it.ty() - room.y1(it.tx(), it.ty());
/* 422 */           int c = Sprites.this.carpet.get(rx, ry, h.it());
/* 423 */           if (c == 0) {
/*     */             return;
/*     */           }
/* 426 */           Sheets a = (h.race().home().clas(h.occupant(0))).carpet.get(h);
/* 427 */           if (a == null) {
/*     */             return;
/*     */           }
/* 430 */           int ran = it.ran(room.x1(it.tx(), it.ty()) + c, room.y1(it.tx(), it.ty()));
/* 431 */           SheetPair ts = a.get(ran);
/*     */ 
/*     */           
/* 434 */           int t = 0;
/* 435 */           for (DIR d : DIR.ORTHO) {
/* 436 */             if (Sprites.this.carpet.get(rx, ry, d, h.it()) == c) {
/* 437 */               t |= d.mask();
/*     */             }
/*     */           } 
/*     */           
/* 441 */           ran >>= 4;
/* 442 */           t = SheetType.sCombo.tile(ts.s, ts.d, t, ts.d.frame(ran, 1.0D), 0);
/*     */           
/* 444 */           int dx = 16 + (ran & 0x3F) / 2;
/* 445 */           if (dd.x() > 0) {
/* 446 */             dx = 0;
/* 447 */           } else if (dd.x() < 0) {
/* 448 */             dx = 48;
/*     */           } 
/* 450 */           ran >>= 6;
/* 451 */           int dy = 16 + (ran & 0x3F) / 2;
/* 452 */           if (dd.y() > 0) {
/* 453 */             dy = 0;
/* 454 */           } else if (dd.y() < 0) {
/* 455 */             dy = 48;
/*     */           } 
/* 457 */           ts.s.render(ts.d, it.x() - dx, it.y() - dy, it, r, t, ran, 0.0D);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 463 */           if (item.get(rx, ry).data() == 2) {
/*     */             return;
/*     */           }
/* 466 */           int m = 0;
/* 467 */           for (DIR d : DIR.ORTHO) {
/* 468 */             if (item.is(rx, ry, d))
/* 469 */               m |= d.mask(); 
/* 470 */           }  (SPRITES.cons()).BIG.outline.render(r, m, x, y);
/*     */         } private final Sheets sheets; public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { if (this.house.upgrade() < 2)
/*     */             return false;  int ran = it.ran(); Sprites.render1x1(ran, this.sheets, r, s, data, it, degrade);
/* 473 */           return false; } private final Rec tmp = new Rec(); public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) { HomeInstance room = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(tx, ty); int r = RND.rInt(4); int i; for (i = 0; i < DIR.ORTHO.size(); i++) { DIR d = (DIR)DIR.ORTHO.getC(i + r); if (room.serviceX() == tx + d.x() && room.serviceY() == ty + d.y() && !room.isSame(tx, ty, tx - d.x(), ty - d.y()))
/*     */               return (byte)d.orthoID();  }  for (i = 0; i < DIR.ORTHO.size(); i++) { DIR d = (DIR)DIR.ORTHO.getC(i + r); if (room.sprite(tx + d.x(), ty + d.y()) == null && room.isSame(tx, ty, tx + d.x(), ty + d.y()))
/*     */               return (byte)d.orthoID();  }  for (i = 0; i < DIR.ORTHO.size(); i++) { DIR d = (DIR)DIR.ORTHO.getC(i + r); if (!room.isSame(tx, ty, tx + d.x(), ty + d.y()))
/*     */               return (byte)d.orthoID();  }  return (byte)RND.rInt(4); } }; this.staD = new Sprite(js) {
/* 477 */         private final Sheets sheets; }; Json js = json.json("SPRITES"); this.staU = new Sprite(js) { public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) { byte m = 0;
/*     */           
/* 479 */           int w = item.group().item(0, item.rotation).width();
/* 480 */           int h = item.group().item(0, item.rotation).height();
/* 481 */           this.tmp.setDim(w, h);
/*     */           
/* 483 */           this.tmp.moveX1Y1((w * rx / w), (h * ry / h));
/*     */           
/* 485 */           for (DIR d : DIR.ORTHO) {
/* 486 */             if (this.tmp.holdsPoint(rx, ry, d))
/* 487 */               m = (byte)(m | d.mask()); 
/*     */           } 
/* 489 */           return m; } public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { return false; } public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) { if (this.house.upgrade() == 0)
/*     */             return;  int ran = it.ran(); Sprites.render1x1(ran, this.sheets, r, s, data, it, degrade); } public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) { return Sprites.this.staU.getData(tx, ty, rx, ry, item, itemRan); }
/*     */       }; this.sp = new SpriteConfigs();
/*     */   }
/*     */   static void render1x1(int ran, Sheets a, SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) { if (a != null) { SheetPair sh = a.get(ran); if (sh != null) {
/*     */         sh.d.color(ran).bind(); ran >>= 4; int i = SheetType.s1x1.tile(sh.s, sh.d, 0, sh.d.frame(ran, 1.0D), data & 0x3); ran >>= 4; sh.s.render(sh.d, it.x(), it.y(), it, r, i, ran, 0.0D); COLOR.unbind(); sh.s.renderShadow(sh.d, it.x(), it.y(), it, s, i, ran);
/*     */       }  }
/*     */      }
/* 497 */   final class SpriteConfigs { final SpriteConfig[][] sprites = new SpriteConfig[4][];
/*     */     
/*     */     public SpriteConfigs() {
/* 500 */       this.sprites[0] = mirror(new SpriteConfig[] {
/* 501 */             new SpriteConfig(new Sprite[][] {
/* 502 */                 { this$0.bedN, this$0.bedS, this$0.nic2
/* 503 */                 }, { this$0.nSta, this$0.nic1
/* 504 */                 }, { this$0.staU, this$0._mat, this$0.staD }
/* 505 */               }), new SpriteConfig(new Sprite[][] {
/* 506 */                 { this$0.nic2, this$0.bedS, this$0.bedN
/* 507 */                 }, { this$0.nic1, this$0.nSta
/* 508 */                 }, { this$0.staD, this$0._mat, this$0.staU }
/* 509 */               }), new SpriteConfig(new Sprite[][] {
/* 510 */                 { this$0.bedN, this$0.nSta, this$0.nic2
/* 511 */                 }, { this$0.bedS, this$0.nic1
/* 512 */                 }, { this$0.staU, this$0._mat, this$0.staD }
/* 513 */               }), new SpriteConfig(new Sprite[][] {
/* 514 */                 { this$0.nic2, this$0.nSta, this$0.bedN
/* 515 */                 }, { this$0.nic1, this$0.bedS
/* 516 */                 }, { this$0.staU, this$0._mat, this$0.staD }
/* 517 */               }), new SpriteConfig(new Sprite[][] {
/* 518 */                 { this$0.nSta, this$0.stor, this$0.bedN
/* 519 */                 }, { this$0.chai, this$0.bedS
/* 520 */                 }, { this$0.staU, this$0._mat, this$0.staD }
/* 521 */               }), new SpriteConfig(new Sprite[][] {
/* 522 */                 { this$0.bedN, this$0.nSta, this$0.stor
/* 523 */                 }, { this$0.bedS, this$0.chai
/* 524 */                 }, { this$0.staD, this$0._mat, this$0.staU }
/*     */               })
/*     */           });
/*     */       
/* 528 */       this.sprites[1] = mirror(new SpriteConfig[] { 
/* 529 */             new SpriteConfig(new Sprite[][] {
/* 530 */                 { this$0.bedN, this$0.nSta, this$0.bedN
/* 531 */                 }, { this$0.bedS, this$0.bedS
/* 532 */                 }, { this$0.chai, this$0.nic1
/* 533 */                 }, { this$0.tabl, this$0.nic2
/* 534 */                 }, { this$0.staU, this$0._mat, this$0.staD }
/* 535 */               }), new SpriteConfig(new Sprite[][] {
/* 536 */                 { this$0.bedN, this$0.nSta, this$0.bedN
/* 537 */                 }, { this$0.bedS, this$0.bedS
/* 538 */                 }, { this$0.nic1, this$0.chai
/* 539 */                 }, { this$0.nic2, this$0.stor
/* 540 */                 }, { this$0.staU, this$0._mat, this$0.staD }
/* 541 */               }), new SpriteConfig(new Sprite[][] {
/* 542 */                 { this$0.bedN, this$0.nSta, this$0.bedN
/* 543 */                 }, { this$0.bedS, this$0.bedS
/* 544 */                 }, { this$0.chai, this$0.nic2
/* 545 */                 }, { this$0.stor, this$0.nic1
/* 546 */                 }, { this$0.staU, this$0._mat, this$0.staD }
/* 547 */               }), new SpriteConfig(new Sprite[][] {
/* 548 */                 { this$0.bedN, this$0.nSta, this$0.bedN
/* 549 */                 }, { this$0.bedS, this$0.bedS
/* 550 */                 }, { this$0.nic1, this$0.nic2
/* 551 */                 }, { this$0.nic1, this$0.nic2
/* 552 */                 }, { this$0.staU, this$0._mat, this$0.staD }
/* 553 */               }), new SpriteConfig(new Sprite[][] {
/* 554 */                 { this$0.bedN, this$0.nSta, this$0.bedN
/* 555 */                 }, { this$0.bedS, this$0.bedS
/* 556 */                 }, { this$0.nic1, this$0.stor
/* 557 */                 }, { this$0.chai, this$0.chai
/* 558 */                 }, { this$0.staU, this$0._mat, this$0.staD }
/* 559 */               }), new SpriteConfig(new Sprite[][] {
/* 560 */                 { this$0.bedN, this$0.nSta, this$0.stor
/* 561 */                 }, { this$0.bedS, this$0.nic1
/* 562 */                 }, { this$0.staD, this$0.chai
/* 563 */                 }, { this$0.bedN, this$0.tabl
/* 564 */                 }, { this$0.bedS, this$0._mat, this$0.staU }
/* 565 */               }), new SpriteConfig(new Sprite[][] {
/* 566 */                 { this$0.nic1, this$0.nSta, this$0.bedN
/* 567 */                 }, { null, null, this$0.bedS
/* 568 */                 }, { this$0.chai, this$0.bedS
/* 569 */                 }, { this$0.tabl, this$0.bedN
/* 570 */                 }, { this$0.staD, this$0._mat, this$0.staU }
/* 571 */               }), new SpriteConfig(new Sprite[][] {
/* 572 */                 { this$0.bedN, this$0.stor, this$0.tabl
/* 573 */                 }, { this$0.bedS, this$0.nic1
/* 574 */                 }, { this$0.bedS, this$0.chai
/* 575 */                 }, { this$0.bedN
/* 576 */                 }, { this$0.staD, this$0._mat, this$0.staU }
/* 577 */               }), new SpriteConfig(new Sprite[][] {
/* 578 */                 { this$0.tabl, this$0.stor, this$0.bedN
/* 579 */                 }, { this$0.nic2, this$0.bedS
/* 580 */                 }, { this$0.nSta, this$0.bedS
/* 581 */                 }, { this$0.chai, this$0.bedN
/* 582 */                 }, { this$0.staD, this$0._mat, this$0.staU }
/* 583 */               }), new SpriteConfig(new Sprite[][] {
/* 584 */                 { this$0.bedN, this$0.nSta, this$0.nic1
/* 585 */                 }, { this$0.bedS, this$0.nic2
/* 586 */                 }, { this$0.bedS, this$0.chai
/* 587 */                 }, { this$0.bedN, this$0.tabl
/* 588 */                 }, { this$0.staD, this$0._mat, this$0.staU } }), 
/* 589 */             new SpriteConfig(new Sprite[][] {
/* 590 */                 { this$0.nic1, this$0.nSta, this$0.bedN
/* 591 */                 }, { this$0.chai, this$0.bedS
/* 592 */                 }, { this$0.nic2, this$0.bedS
/* 593 */                 }, { this$0.tabl, this$0.bedN
/* 594 */                 }, { this$0.staD, this$0._mat, this$0.staU }
/* 595 */               }), new SpriteConfig(new Sprite[][] {
/* 596 */                 { this$0.bedN, this$0.stor, this$0.tabl
/* 597 */                 }, { this$0.bedS, this$0.nSta
/* 598 */                 }, { this$0.bedS, this$0.nic2
/* 599 */                 }, { this$0.bedN, this$0.chai
/* 600 */                 }, { this$0.staD, this$0._mat, this$0.staU }
/* 601 */               }), new SpriteConfig(new Sprite[][] {
/* 602 */                 { this$0.tabl, this$0.stor, this$0.bedN
/* 603 */                 }, { this$0.nic2, this$0.bedS
/* 604 */                 }, { this$0.nSta, this$0.bedS
/* 605 */                 }, { this$0.chai, this$0.bedN
/* 606 */                 }, { this$0.staD, this$0._mat, this$0.staU }
/*     */               }) });
/*     */       
/* 609 */       this.sprites[2] = mirror(new SpriteConfig[] { 
/* 610 */             new SpriteConfig(new Sprite[][] {
/* 611 */                 { this$0.tabl, this$0.nic1, this$0.nic1, this$0.nic1, this$0.nSta
/* 612 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 613 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 614 */                 }, { this$0.nic2, this$0.stor
/* 615 */                 }, { this$0.nic2, this$0.nic2
/* 616 */                 }, { this$0.stor, this$0.staD, this$0._mat, this$0.staU, this$0.tabl }
/* 617 */               }), new SpriteConfig(new Sprite[][] {
/* 618 */                 { this$0.nSta, this$0.nic2, this$0.stor, this$0.nic2, this$0.nic2
/* 619 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 620 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 621 */                 }, { this$0.chai, this$0.chai
/* 622 */                 }, { this$0.nic1, this$0.nic2
/* 623 */                 }, { this$0.nic1, this$0.staD, this$0._mat, this$0.staU, this$0.tabl }
/* 624 */               }), new SpriteConfig(new Sprite[][] {
/* 625 */                 { this$0.nSta, this$0.nic2, this$0.nic2, this$0.nic2, this$0.nic1
/* 626 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 627 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 628 */                 }, { this$0.stor, this$0.nic1
/* 629 */                 }, { this$0.chai, this$0.chai
/* 630 */                 }, { this$0.tabl, this$0.staD, this$0._mat, this$0.staU, this$0.nSta }
/* 631 */               }), new SpriteConfig(new Sprite[][] {
/* 632 */                 { this$0.nSta, this$0.tabl, this$0.nic1, this$0.nic1, this$0.nSta
/* 633 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 634 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 635 */                 }, { this$0.chai, this$0.chai
/* 636 */                 }, { this$0.nic2, this$0.nic2
/* 637 */                 }, { this$0.stor, this$0.staD, this$0._mat, this$0.staU, this$0.stor }
/* 638 */               }), new SpriteConfig(new Sprite[][] {
/* 639 */                 { this$0.stor, this$0.nic2, this$0.nic2, this$0.stor
/* 640 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 641 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 642 */                 }, { this$0.nSta, this$0.nSta
/* 643 */                 }, { this$0.chai, this$0.chai
/* 644 */                 }, { this$0.nic1, this$0.staD, this$0._mat, this$0.staU, this$0.tabl
/*     */                 }
/*     */               
/* 647 */               }), new SpriteConfig(new Sprite[][] {
/* 648 */                 { this$0.tabl, this$0.stor, this$0.nic1, this$0.nic1, this$0.nic1
/* 649 */                 }, { this$0.chai, this$0.chai
/* 650 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 651 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 652 */                 }, { this$0.nSta, this$0.nSta
/* 653 */                 }, { this$0.tabl, this$0.staU, this$0._mat, this$0.staD, this$0.nic2 }
/* 654 */               }), new SpriteConfig(new Sprite[][] {
/* 655 */                 { this$0.nic1, this$0.chai, this$0.chai, this$0.nic1, this$0.tabl
/* 656 */                 }, { this$0.nSta, this$0.stor
/* 657 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 658 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 659 */                 }, { this$0.nic1, this$0.nSta
/* 660 */                 }, { this$0.tabl, this$0.staU, this$0._mat, this$0.staD, this$0.nic1 }
/* 661 */               }), new SpriteConfig(new Sprite[][] {
/* 662 */                 { this$0.nic2, this$0.nic1, this$0.nic1, this$0.nic2, this$0.nSta
/* 663 */                 }, { this$0.nSta, this$0.chai
/* 664 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 665 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 666 */                 }, { this$0.chai, this$0.stor
/* 667 */                 }, { this$0.tabl, this$0.staU, this$0._mat, this$0.staD, this$0.stor }
/* 668 */               }), new SpriteConfig(new Sprite[][] {
/* 669 */                 { this$0.nic2, this$0.chai, this$0.chai, this$0.stor, this$0.tabl
/* 670 */                 }, { this$0.stor, this$0.nSta
/* 671 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 672 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 673 */                 }, { this$0.nSta, this$0.nic1
/* 674 */                 }, { this$0.nic1, this$0.staU, this$0._mat, this$0.staD, this$0.nic1 }
/* 675 */               }), new SpriteConfig(new Sprite[][] {
/* 676 */                 { this$0.stor, this$0.stor, this$0.nic2, this$0.nic2, this$0.nic2
/* 677 */                 }, { this$0.nic1, this$0.chai
/* 678 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 679 */                 }, { this$0.bedN, this$0.bedS, this$0.bedS, this$0.bedN
/* 680 */                 }, { this$0.chai, this$0.tabl
/* 681 */                 }, { this$0.nic1, this$0.staU, this$0._mat, this$0.staD, this$0.nic1 }
/*     */               }), 
/* 683 */             new SpriteConfig(new Sprite[][] {
/* 684 */                 { this$0.nSta, this$0.bedN, this$0.bedN, this$0.bedN, this$0.nSta
/* 685 */                 }, { this$0.nic1, this$0.bedS, this$0.bedS, this$0.bedS, this$0.nic2
/* 686 */                 }, { this$0.nic1, this$0.stor
/* 687 */                 }, { this$0.nic2, this$0.bedN
/* 688 */                 }, { this$0.stor, this$0.bedS
/* 689 */                 }, { this$0.tabl, this$0.staU, this$0._mat, this$0.staD, this$0.nic2 }
/* 690 */               }), new SpriteConfig(new Sprite[][] {
/* 691 */                 { this$0.nSta, this$0.bedN, this$0.bedN, this$0.bedN, this$0.tabl
/* 692 */                 }, { this$0.nic2, this$0.bedS, this$0.bedS, this$0.bedS, this$0.nic1
/* 693 */                 }, { this$0.nic2, this$0.chai
/* 694 */                 }, { this$0.stor, this$0.bedN
/* 695 */                 }, { this$0.chai, this$0.bedS
/* 696 */                 }, { this$0.nic1, this$0.staU, this$0._mat, this$0.staD, this$0.nSta }
/* 697 */               }), new SpriteConfig(new Sprite[][] {
/* 698 */                 { this$0.stor, this$0.bedN, this$0.bedN, this$0.bedN, this$0.nSta
/* 699 */                 }, { this$0.nic2, this$0.bedS, this$0.bedS, this$0.bedS, this$0.nic1
/* 700 */                 }, { this$0.chai, this$0.nic2
/* 701 */                 }, { this$0.chai, this$0.bedN
/* 702 */                 }, { this$0.nic1, this$0.bedS
/* 703 */                 }, { this$0.nSta, this$0.staU, this$0._mat, this$0.staD, this$0.tabl }
/* 704 */               }), new SpriteConfig(new Sprite[][] {
/* 705 */                 { this$0.nSta, this$0.bedN, this$0.bedN, this$0.bedN, this$0.nic2
/* 706 */                 }, { this$0.nic2, this$0.bedS, this$0.bedS, this$0.bedS, this$0.stor
/* 707 */                 }, { this$0.nic1, this$0.chai
/* 708 */                 }, { this$0.nic1, this$0.bedN
/* 709 */                 }, { this$0.chai, this$0.bedS
/* 710 */                 }, { this$0.tabl, this$0.staU, this$0._mat, this$0.staD, this$0.nSta }
/* 711 */               }), new SpriteConfig(new Sprite[][] {
/* 712 */                 { this$0.nic2, this$0.bedN, this$0.bedN, this$0.bedN, this$0.nSta
/* 713 */                 }, { this$0.tabl, this$0.bedS, this$0.bedS, this$0.bedS, this$0.nic1
/* 714 */                 }, { this$0.chai, this$0.nic2
/* 715 */                 }, { this$0.chai, this$0.bedN
/* 716 */                 }, { this$0.tabl, this$0.bedS
/* 717 */                 }, { this$0.nSta, this$0.staU, this$0._mat, this$0.staD, this$0.stor
/*     */                 }
/*     */               
/* 720 */               }), new SpriteConfig(new Sprite[][] {
/* 721 */                 { this$0.nSta, this$0.bedN, this$0.bedN, this$0.nSta, this$0.bedN
/* 722 */                 }, { this$0.nic2, this$0.bedS, this$0.bedS, this$0.bedS
/* 723 */                 }, { this$0.nic1, this$0.chai
/* 724 */                 }, { this$0.nic1, this$0.bedS
/* 725 */                 }, { this$0.chai, this$0.bedN
/* 726 */                 }, { this$0.stor, this$0.staU, this$0._mat, this$0.staD, this$0.nic2 }
/* 727 */               }), new SpriteConfig(new Sprite[][] {
/* 728 */                 { this$0.tabl, this$0.bedN, this$0.bedN, this$0.nic2, this$0.bedN
/* 729 */                 }, { this$0.nSta, this$0.bedS, this$0.bedS, this$0.bedS
/* 730 */                 }, { this$0.chai, this$0.nic2
/* 731 */                 }, { this$0.chai, this$0.bedS
/* 732 */                 }, { this$0.nic1, this$0.bedN
/* 733 */                 }, { this$0.nic1, this$0.staU, this$0._mat, this$0.staD, this$0.nSta }
/* 734 */               }), new SpriteConfig(new Sprite[][] {
/* 735 */                 { this$0.nic1, this$0.bedN, this$0.bedN, this$0.nic2, this$0.bedN
/* 736 */                 }, { this$0.nic1, this$0.bedS, this$0.bedS, this$0.bedS
/* 737 */                 }, { this$0.chai, this$0.tabl
/* 738 */                 }, { this$0.stor, this$0.bedS
/* 739 */                 }, { this$0.chai, this$0.bedN
/* 740 */                 }, { this$0.nSta, this$0.staU, this$0._mat, this$0.staD, this$0.nSta }
/* 741 */               }), new SpriteConfig(new Sprite[][] {
/* 742 */                 { this$0.stor, this$0.bedN, this$0.bedN, this$0.nic2, this$0.bedN
/* 743 */                 }, { this$0.nic2, this$0.bedS, this$0.bedS, this$0.bedS
/* 744 */                 }, { this$0.chai, this$0.nSta
/* 745 */                 }, { this$0.chai, this$0.bedS
/* 746 */                 }, { this$0.nSta, this$0.bedN
/* 747 */                 }, { this$0.tabl, this$0.staU, this$0._mat, this$0.staD, this$0.nic1 }
/* 748 */               }), new SpriteConfig(new Sprite[][] {
/* 749 */                 { this$0.tabl, this$0.bedN, this$0.bedN, this$0.nSta, this$0.bedN
/* 750 */                 }, { this$0.nic2, this$0.bedS, this$0.bedS, this$0.bedS
/* 751 */                 }, { this$0.chai, this$0.stor
/* 752 */                 }, { this$0.nic2, this$0.bedS
/* 753 */                 }, { this$0.chai, this$0.bedN
/* 754 */                 }, { this$0.nic1, this$0.staU, this$0._mat, this$0.staD, this$0.nSta }
/*     */               }) });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private SpriteConfig[] mirror(SpriteConfig[] o) {
/* 766 */       SpriteConfig[] res = new SpriteConfig[o.length * 2];
/*     */       
/* 768 */       for (int i = 0; i < o.length; i++) {
/* 769 */         res[i] = o[i];
/* 770 */         Sprite[][] org = (o[i]).spri;
/*     */         
/* 772 */         int h = org.length;
/* 773 */         int w = (org[0]).length;
/*     */         
/* 775 */         Sprite[][] nn = new Sprite[h][w];
/*     */         
/* 777 */         for (int y = 0; y < h; y++) {
/* 778 */           for (int x = 0; x < w; x++) {
/* 779 */             nn[y][w - x - 1] = org[y][x];
/*     */           }
/*     */         } 
/*     */         
/* 783 */         res[i + o.length] = new SpriteConfig(nn);
/*     */       } 
/*     */       
/* 786 */       if (res.length > 255) {
/* 787 */         throw new RuntimeException();
/*     */       }
/* 789 */       return res;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\house\Sprites.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */