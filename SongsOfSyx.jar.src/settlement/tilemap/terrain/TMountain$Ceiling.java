/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RESOURCE;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.thing.pointlight.LOS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Ceiling
/*     */   extends Terrain.TerrainTile
/*     */ {
/*     */   private static final int SET = 16;
/*     */   private final TILE_SHEET sheet;
/*     */   private final int SHEET_CORNER;
/*     */   private final int SHEET_FIX;
/*     */   final Opening opening;
/*     */   private final TerrainClearing clear;
/*     */   
/*     */   private Ceiling(Terrain t, TILE_SHEET s, SPRITE icon) {
/* 508 */     super("CAVE", t, "cave", icon, (COLOR)t.colors.minimap.mountain.shade(1.5D));
/* 509 */     this.sheet = s;
/* 510 */     this.SHEET_CORNER = 96;
/* 511 */     this.SHEET_FIX = this.SHEET_CORNER + 16;
/* 512 */     this.opening = new Opening(t, this.sheet, icon, this.SHEET_FIX + 32);
/* 513 */     this.clear = new TerrainClearing()
/*     */       {
/*     */         
/*     */         public RESOURCE clear1(int tx, int ty)
/*     */         {
/* 518 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean can() {
/* 523 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public int clearAll(int tx, int ty) {
/* 528 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public SoundRace sound(int tx, int ty) {
/* 533 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean isStructure() {
/* 539 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean needs() {
/* 544 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean canDestroy(int tx, int ty) {
/* 549 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public double strength() {
/* 554 */           return 0.0D;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public TERRAIN terrain(int tx, int ty) {
/* 561 */     return TERRAINS.MOUNTAIN();
/*     */   }
/*     */ 
/*     */   
/*     */   public TerrainClearing clearing() {
/* 566 */     return this.clear;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean place(int x, int y) {
/* 572 */     if (this.opening.isPlacable(x, y)) {
/* 573 */       return this.opening.place(x, y);
/*     */     }
/*     */     
/* 576 */     placeRaw(x, y);
/* 577 */     int data = 0;
/* 578 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 579 */       DIR d = (DIR)DIR.ORTHO.get(i);
/* 580 */       Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(x, y, d);
/* 581 */       if (t.wallIsWally()) {
/* 582 */         data |= d.mask();
/*     */       }
/*     */     } 
/*     */     
/* 586 */     data = setCorners(x, y, data);
/*     */     
/* 588 */     this.shared.data.set(x, y, data);
/* 589 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private int setCorners(int x, int y, int res) {
/* 594 */     int corner = 0;
/* 595 */     for (int i = 0; i < DIR.NORTHO.size(); i++) {
/* 596 */       DIR d = (DIR)DIR.NORTHO.get(i);
/* 597 */       if (joins(x, y, d) && !joins(x, y, d.next(-1)) && !joins(x, y, d.next(1))) {
/* 598 */         corner |= d.mask();
/*     */       }
/*     */     } 
/* 601 */     res |= corner << 4;
/* 602 */     return res;
/*     */   }
/*     */   
/*     */   private boolean joins(int x, int y, DIR d) {
/* 606 */     Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(x, y, d);
/* 607 */     return t.wallIsWally();
/*     */   }
/*     */ 
/*     */   
/*     */   private int getCorners(int data) {
/* 612 */     return data >> 4 & 0xF;
/*     */   }
/*     */   
/*     */   private int getData(int data, RenderData.RenderIterator i) {
/* 616 */     int res = data;
/* 617 */     Room r = (SETT.ROOMS()).map.get(i.tx(), i.ty());
/* 618 */     if (r != null)
/* 619 */       res |= 0x100; 
/* 620 */     if (r != null && r.constructor() != null && r.constructor().mustBeIndoors()) {
/* 621 */       res |= 0x100;
/* 622 */       for (DIR d : DIR.ORTHO) {
/* 623 */         if (!r.isSame(i.tx(), i.ty(), i.tx() + d.x(), i.ty() + d.y()))
/* 624 */           res |= d.mask(); 
/*     */       } 
/*     */     } else {
/* 627 */       for (DIR d : DIR.ORTHO) {
/* 628 */         r = (Room)(SETT.ROOMS()).map.get(i.tx(), i.ty(), d);
/* 629 */         if (r != null && r.constructor() != null && r.constructor().mustBeIndoors()) {
/* 630 */           res |= d.mask();
/* 631 */           res |= 0x100;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 636 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 643 */     int x = i.x();
/* 644 */     int y = i.y();
/* 645 */     int ran = i.ran();
/*     */     
/* 647 */     data = getData(data, i);
/*     */     
/* 649 */     int a = data & 0xF;
/*     */     
/* 651 */     if ((data & 0x100) != 0) {
/* 652 */       if (a != 0) {
/* 653 */         int j = this.SHEET_FIX + a;
/* 654 */         this.sheet.render(r, j, x, y);
/*     */       } 
/*     */ 
/*     */       
/* 658 */       a = getCorners(data);
/* 659 */       if (a != 0) {
/* 660 */         this.sheet.render(r, this.SHEET_FIX + 16 + a, x, y);
/*     */       }
/*     */     } else {
/* 663 */       if (a != 0) {
/* 664 */         int j = a + ran % 5 * 16;
/* 665 */         this.sheet.render(r, j, x, y);
/*     */       } 
/*     */ 
/*     */       
/* 669 */       a = getCorners(data);
/* 670 */       if (a != 0) {
/* 671 */         this.sheet.render(r, this.SHEET_CORNER + a, x, y);
/*     */       }
/*     */     } 
/*     */     
/* 675 */     s.setDistance2Ground(0.0D).setHeight(0);
/* 676 */     if (!(SETT.OVERLAY()).added) {
/*     */       
/* 678 */       s.setHard();
/* 679 */       (SETT.TERRAIN()).MOUNTAIN.sheet.render((SPRITE_RENDERER)s, 15, x, y);
/* 680 */       s.setSoft();
/*     */     } else {
/* 682 */       s.setSoft();
/* 683 */       (SETT.TERRAIN()).MOUNTAIN.sheet.render((SPRITE_RENDERER)s, 15, x, y);
/*     */     } 
/* 685 */     i.countCave();
/* 686 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 692 */     return false;
/*     */   }
/*     */   
/*     */   public boolean canFix(int tx, int ty) {
/* 696 */     if (!super.is(tx, ty))
/* 697 */       return false; 
/* 698 */     int d = this.shared.data.get(tx, ty);
/* 699 */     return ((d & 0x100) == 0 && d != 0);
/*     */   }
/*     */   
/*     */   public void fix(int tx, int ty) {
/* 703 */     if (!is(tx, ty))
/*     */       return; 
/* 705 */     int d = this.shared.data.get(tx, ty);
/* 706 */     d |= 0x100;
/* 707 */     this.shared.data.set(tx, ty, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public AVAILABILITY getAvailability(int x, int y) {
/* 712 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPlacable(int tx, int ty) {
/* 717 */     for (int i = 0; i < DIR.ALL.size(); i++) {
/* 718 */       DIR d = (DIR)DIR.ALL.get(i);
/* 719 */       if (!joins(tx, ty, d) && !is(tx, ty, d))
/* 720 */         return this.opening.isPlacable(tx, ty); 
/*     */     } 
/* 722 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean wallJoiner() {
/* 727 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean wallIsWally() {
/* 732 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean roofIs() {
/* 737 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public COLOR miniC(int x, int y) {
/* 742 */     if ((SETT.MINERALS()).getter.is(x, y))
/* 743 */       return (SETT.GROUND()).minimap.miniC(x, y); 
/* 744 */     return super.miniC(x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tx, int ty) {
/* 749 */     return !(!super.is(tx, ty) && !this.opening.is(tx, ty));
/*     */   }
/*     */ 
/*     */   
/*     */   public int heightStart(int tx, int ty) {
/* 754 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int heightEnd(int tx, int ty) {
/* 759 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public LOS los(int tx, int ty) {
/* 764 */     return LOS.CEILING;
/*     */   }
/*     */   
/*     */   public class Opening
/*     */     extends Terrain.TerrainTile
/*     */   {
/*     */     private final TILE_SHEET sheet;
/*     */     private final int SHEET_START;
/*     */     private final int SINGLES;
/*     */     
/*     */     private Opening(Terrain t, TILE_SHEET sheet, SPRITE icon, int sheetStart) {
/* 775 */       super("CAVE_ENTRANCE", t, "cave entrance", icon, (COLOR)t.colors.minimap.mountain.shade(1.5D));
/* 776 */       this.sheet = sheet;
/* 777 */       this.SHEET_START = sheetStart;
/* 778 */       this.SINGLES = this.SHEET_START + 64;
/*     */     }
/*     */     
/*     */     private boolean joins(int x, int y, DIR d) {
/* 782 */       Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(x, y, d);
/* 783 */       return !(!t.wallIsWally() && !t.roofIs());
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean place(int tx, int ty) {
/* 788 */       if (!isPlacable(tx, ty))
/* 789 */         return this.shared.CAVE.place(tx, ty); 
/* 790 */       placeRaw(tx, ty);
/*     */ 
/*     */       
/* 793 */       placeRaw(tx, ty);
/* 794 */       int res = 0;
/* 795 */       for (int i = 0; i < DIR.NORTHO.size(); i++) {
/* 796 */         DIR d = (DIR)DIR.NORTHO.get(i);
/* 797 */         if (joins(tx, ty, d) && joins(tx, ty, d.next(-1)) && joins(tx, ty, d.next(1))) {
/* 798 */           res |= d.mask();
/*     */         }
/*     */       } 
/* 801 */       if (res != 15 && res != 0 && SETT.IN_BOUNDS(tx, ty, DIR.N)) {
/* 802 */         Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(tx, ty, DIR.N);
/* 803 */         if (t != this && t != this.shared.MOUNTAIN && t.wallIsWally() && !t.roofIs()) {
/* 804 */           if ((res & DIR.NW.mask()) != 0)
/* 805 */             res |= 0x20; 
/* 806 */           if ((res & DIR.NE.mask()) != 0)
/* 807 */             res |= 0x10; 
/*     */         } 
/*     */       } 
/* 810 */       if (res != 15 && res != 0 && SETT.IN_BOUNDS(tx, ty, DIR.W)) {
/* 811 */         Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(tx, ty, DIR.W);
/* 812 */         if (t != this && t != this.shared.MOUNTAIN && t.wallIsWally() && !t.roofIs()) {
/* 813 */           if ((res & DIR.SW.mask()) != 0)
/* 814 */             res |= 0x80; 
/* 815 */           if ((res & DIR.NW.mask()) != 0) {
/* 816 */             res |= 0x40;
/*     */           }
/*     */         } 
/*     */       } 
/* 820 */       this.shared.data.set(tx, ty, res);
/* 821 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 827 */       int x = i.x();
/* 828 */       int y = i.y();
/* 829 */       int ran = i.ran();
/*     */       
/* 831 */       TILE_SHEET sheets = (SETT.TERRAIN()).MOUNTAIN.sheet;
/*     */ 
/*     */       
/* 834 */       int code = data & 0xF;
/* 835 */       if (code == 0) {
/* 836 */         s.setHeight(3).setDistance2Ground(0.0D);
/* 837 */         this.sheet.render(r, this.SINGLES + (ran & 0xF), x, y);
/* 838 */         sheets.render((SPRITE_RENDERER)s, this.shared.MOUNTAIN.SINGLES + (ran & 0xF), x, y);
/*     */       } else {
/* 840 */         s.setHeight(10).setDistance2Ground(0.0D);
/* 841 */         this.sheet.render(r, this.SHEET_START + code + (ran & 0x3) * 16, x, y);
/* 842 */         sheets.render((SPRITE_RENDERER)s, code + (ran & 0x3) * 16, x, y);
/* 843 */         if ((data & 0x30) != 0)
/* 844 */           (SETT.TERRAIN()).wall_merge.render(r, (data >> 4 & 0x3) - 1, i.x(), i.y() - 4); 
/* 845 */         if ((data & 0xC0) != 0)
/* 846 */           (SETT.TERRAIN()).wall_merge.render(r, (data >> 6 & 0x3) + 2, i.x() - 4, i.y()); 
/*     */       } 
/* 848 */       i.countCave();
/* 849 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 854 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public AVAILABILITY getAvailability(int x, int y) {
/* 859 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isPlacable(int tx, int ty) {
/* 865 */       for (DIR d : DIR.ALL) {
/* 866 */         if (SETT.IN_BOUNDS(tx, ty, d) && !((Terrain.TerrainTile)this.shared.get(tx, ty, d)).wallIsWally() && !((Terrain.TerrainTile)this.shared.get(tx, ty, d)).roofIs())
/* 867 */           return true; 
/*     */       } 
/* 869 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     boolean wallJoiner() {
/* 874 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean wallIsWally() {
/* 879 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean roofIs() {
/* 884 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public TerrainClearing clearing() {
/* 890 */       return TMountain.Ceiling.this.clear;
/*     */     }
/*     */ 
/*     */     
/*     */     public TERRAIN terrain(int tx, int ty) {
/* 895 */       return TERRAINS.MOUNTAIN();
/*     */     }
/*     */ 
/*     */     
/*     */     public int heightStart(int tx, int ty) {
/* 900 */       return 3;
/*     */     }
/*     */ 
/*     */     
/*     */     public int heightEnd(int tx, int ty) {
/* 905 */       return 200;
/*     */     }
/*     */ 
/*     */     
/*     */     public LOS los(int tx, int ty) {
/* 910 */       return LOS.CEILING;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TMountain$Ceiling.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */