/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.thing.pointlight.LOS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Wall
/*     */   extends TBuilding.BuildingComponent
/*     */   implements TerrainDiagonal.Diagonalizer
/*     */ {
/*     */   private static final int SET = 16;
/*     */   private final TILE_SHEET sheet;
/* 389 */   private final int DIAGONAL = 64;
/* 390 */   private final int BROKEN = 128;
/* 391 */   private final int CORNERS = 192;
/* 392 */   private final int CORNERS_FAT = 208;
/* 393 */   private final int CORNERS_DIA = 224;
/* 394 */   private final int CORNERS_FAT_DIA = 240;
/* 395 */   private final int SINGLES = 256;
/* 396 */   private final int FULLS = 272;
/*     */   private final boolean broken;
/* 398 */   private int DIA = 8192;
/* 399 */   private int FAT = 16384;
/*     */   
/*     */   private Wall(String key, Terrain t, boolean broken) {
/* 402 */     super(key, t, paramTBuilding.structure.nameWall, paramTBuilding.iconWall, (COLOR)paramTBuilding.structure.miniColor.shade(0.9D), paramTBuilding.structure.resource);
/* 403 */     this.broken = broken;
/* 404 */     this.sheet = paramTBuilding.spriteWall;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean place(int x, int y) {
/* 410 */     boolean dia = (this.shared.get(x, y) instanceof TerrainDiagonal.Diagonalizer && ((TerrainDiagonal.Diagonalizer)this.shared.get(x, y)).getDia(x, y));
/* 411 */     placeRaw(x, y);
/*     */     
/* 413 */     int res = 0;
/* 414 */     if (isFat(x, y)) {
/* 415 */       res |= this.FAT;
/* 416 */       for (DIR d : DIR.ORTHO) {
/* 417 */         if (joins(x, y, d) && joins(x, y, d.next(1)) && joins(x, y, d.next(2)))
/* 418 */           res |= d.mask() | d.next(2).mask(); 
/*     */       } 
/*     */     } else {
/* 421 */       for (DIR d : DIR.ORTHO) {
/* 422 */         if (!isFat(x + d.x(), y + d.y()) && joins(x, y, d)) {
/* 423 */           res |= d.mask();
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 429 */     int cor = 0;
/* 430 */     for (DIR d : DIR.NORTHO) {
/* 431 */       if (!joins(x, y, d) && (res & d.next(1).mask()) != 0 && (res & d.next(-1).mask()) != 0)
/* 432 */         cor |= d.mask(); 
/*     */     } 
/* 434 */     res |= cor << 4;
/*     */     
/* 436 */     if (res != 0 && SETT.IN_BOUNDS(x, y, DIR.N)) {
/* 437 */       Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(x, y, DIR.N);
/* 438 */       if (t != this && t != TBuilding.this.roof.opening && t.wallIsWally() && t != TBuilding.this.broken && !t.roofIs() && (res & DIR.N.mask()) != 0) {
/* 439 */         res |= 0x100;
/*     */       }
/*     */     } 
/* 442 */     if (res != 0 && SETT.IN_BOUNDS(x, y, DIR.W)) {
/* 443 */       Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(x, y, DIR.W);
/* 444 */       if (t != this && t != TBuilding.this.roof.opening && t != TBuilding.this.broken && t.wallIsWally() && !t.roofIs() && (res & DIR.W.mask()) != 0) {
/* 445 */         res |= 0x200;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 459 */     this.shared.data.set(x, y, res);
/* 460 */     setDia(x, y, dia);
/* 461 */     return false;
/*     */   }
/*     */   
/*     */   private boolean joins(int x, int y, DIR d) {
/* 465 */     x += d.x();
/* 466 */     y += d.y();
/* 467 */     if (!SETT.IN_BOUNDS(x, y))
/* 468 */       return false; 
/* 469 */     return TBuilding.jwall.is(x, y);
/*     */   }
/*     */   
/*     */   private boolean isFat(int x, int y) {
/* 473 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 474 */       DIR d = (DIR)DIR.ORTHO.get(di);
/* 475 */       if (joins(x, y, d) && joins(x, y, d.next(1)) && joins(x, y, d.next(2)))
/* 476 */         return true; 
/*     */     } 
/* 478 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMassiveWall() {
/* 483 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 489 */     int code = data & 0xF;
/* 490 */     int cor = data >> 4 & 0xF;
/* 491 */     if (cor != 0) {
/* 492 */       if ((data & this.FAT) == 0) {
/* 493 */         cor += 192;
/*     */       } else {
/* 495 */         cor += 208;
/* 496 */       }  if ((data & this.DIA) != 0)
/* 497 */         cor += 32; 
/*     */     } 
/* 499 */     TBuilding.this.structure.tint.color.bind();
/* 500 */     if (code == 15) {
/* 501 */       int c = 272 + (i.ran() & 0x7);
/* 502 */       if (this.broken) {
/* 503 */         c += 8;
/*     */       }
/* 505 */       this.sheet.render(r, c, i.x(), i.y());
/* 506 */       if (cor != 0) {
/*     */         
/* 508 */         s.setHeight(3).setDistance2Ground(8.0D);
/* 509 */         this.sheet.render((SPRITE_RENDERER)s, c, i.x(), i.y());
/* 510 */         this.sheet.render(r, cor, i.x(), i.y());
/*     */       } 
/* 512 */       COLOR.unbind();
/* 513 */       renderEdges(r, s, i, data);
/* 514 */       return !this.broken;
/*     */     } 
/*     */     
/* 517 */     if (code == 0) {
/* 518 */       s.setHeight(3).setDistance2Ground(8.0D);
/*     */       
/* 520 */       int c = ((data & this.DIA) != 0) ? 4 : 0;
/* 521 */       c += i.ran() & 0x3;
/* 522 */       c += 256;
/* 523 */       if (this.broken)
/* 524 */         c += 8; 
/* 525 */       this.sheet.render(r, c, i.x(), i.y());
/* 526 */       this.sheet.render((SPRITE_RENDERER)s, c, i.x(), i.y());
/*     */     } else {
/*     */       
/* 529 */       int c = code + (i.ran() & 0x3) * 16;
/*     */       
/* 531 */       if (this.broken) {
/* 532 */         c += 128;
/* 533 */         s.setHeight(0).setDistance2Ground(8.0D);
/* 534 */         this.sheet.render((SPRITE_RENDERER)s, c, i.x(), i.y());
/* 535 */       } else if ((data & this.DIA) != 0) {
/* 536 */         c += 64;
/*     */       } 
/* 538 */       s.setHeight(12).setDistance2Ground(0.0D);
/* 539 */       this.sheet.render(r, c, i.x(), i.y());
/* 540 */       this.sheet.render((SPRITE_RENDERER)s, c, i.x(), i.y());
/*     */       
/* 542 */       if (cor != 0) {
/* 543 */         this.sheet.render(r, cor, i.x(), i.y());
/*     */       }
/*     */ 
/*     */       
/* 547 */       renderEdges(r, s, i, data);
/*     */     } 
/* 549 */     COLOR.unbind();
/*     */     
/* 551 */     return false;
/*     */   }
/*     */   
/*     */   private void renderEdges(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 555 */     int cor = data >> 4 & 0xF;
/* 556 */     if ((data & 0x100) != 0) {
/* 557 */       if ((data & DIR.W.mask()) == 0 || (cor & DIR.NW.mask()) != 0) {
/* 558 */         (SETT.TERRAIN()).wall_merge.render(r, 0, i.x(), i.y() - 4);
/*     */       } else {
/* 560 */         (SETT.TERRAIN()).wall_merge.render(r, 2, i.x(), i.y() - 4);
/* 561 */       }  if ((data & DIR.E.mask()) == 0 || (cor & DIR.NE.mask()) != 0) {
/* 562 */         (SETT.TERRAIN()).wall_merge.render(r, 1, i.x(), i.y() - 4);
/*     */       } else {
/* 564 */         (SETT.TERRAIN()).wall_merge.render(r, 3, i.x(), i.y() - 4);
/*     */       } 
/* 566 */     }  if ((data & 0x200) != 0) {
/* 567 */       if ((data & DIR.N.mask()) == 0 || (cor & DIR.NW.mask()) != 0) {
/* 568 */         (SETT.TERRAIN()).wall_merge.render(r, 5, i.x() - 4, i.y());
/*     */       } else {
/* 570 */         (SETT.TERRAIN()).wall_merge.render(r, 7, i.x() - 4, i.y());
/* 571 */       }  if ((data & DIR.S.mask()) == 0 || (cor & DIR.SW.mask()) != 0) {
/* 572 */         (SETT.TERRAIN()).wall_merge.render(r, 4, i.x() - 4, i.y());
/*     */       } else {
/* 574 */         (SETT.TERRAIN()).wall_merge.render(r, 6, i.x() - 4, i.y());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 581 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public AVAILABILITY getAvailability(int x, int y) {
/* 586 */     return this.broken ? null : AVAILABILITY.SOLID;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPlacable(int tx, int ty) {
/* 591 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean wallJoiner() {
/* 596 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean wallIsWally() {
/* 601 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int miniDepth() {
/* 606 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDia(int x, int y, boolean dia) {
/* 611 */     if (!is(x, y))
/*     */       return; 
/* 613 */     int data = this.shared.data.get(x, y);
/* 614 */     if (dia) {
/* 615 */       data |= this.DIA;
/*     */     } else {
/* 617 */       data &= this.DIA ^ 0xFFFFFFFF;
/* 618 */     }  this.shared.data.set(x, y, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getDia(int tx, int ty) {
/* 623 */     if (!is(tx, ty))
/* 624 */       return false; 
/* 625 */     return ((this.shared.data.get(tx, ty) & this.DIA) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int heightEnd(int tx, int ty) {
/* 630 */     return 3;
/*     */   }
/*     */ 
/*     */   
/*     */   public LOS los(int tx, int ty) {
/* 635 */     return LOS.SOLID;
/*     */   }
/*     */   
/*     */   public boolean isFull(int tx, int ty) {
/* 639 */     int data = this.shared.data.get(tx, ty);
/* 640 */     return ((data & 0xF) == 15 && (data >> 4 & 0xF) == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean coversCompletely(int tx, int ty) {
/* 645 */     return ((this.shared.data.get(tx, ty) & 0xF) == 15);
/*     */   }
/*     */ 
/*     */   
/*     */   void unplace(int tx, int ty) {
/* 650 */     if (!(SETT.ROOMS()).map.is(tx, ty)) {
/* 651 */       (SETT.FLOOR()).clearer.clear(tx, ty);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean wantsFloorUnderneath(int tx, int ty) {
/* 656 */     return ((this.shared.data.get(tx, ty) & 0xF) != 15);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TBuilding$Wall.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */