/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Opening
/*     */   extends Terrain.TerrainTile
/*     */ {
/*     */   private final TILE_SHEET sheet;
/*     */   private final int SHEET_START;
/*     */   private final int SINGLES;
/*     */   
/*     */   private Opening(Terrain t, TILE_SHEET sheet, SPRITE icon, int sheetStart) {
/* 775 */     super("CAVE_ENTRANCE", t, "cave entrance", icon, (COLOR)t.colors.minimap.mountain.shade(1.5D));
/* 776 */     this.sheet = sheet;
/* 777 */     this.SHEET_START = sheetStart;
/* 778 */     this.SINGLES = this.SHEET_START + 64;
/*     */   }
/*     */   
/*     */   private boolean joins(int x, int y, DIR d) {
/* 782 */     Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(x, y, d);
/* 783 */     return !(!t.wallIsWally() && !t.roofIs());
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean place(int tx, int ty) {
/* 788 */     if (!isPlacable(tx, ty))
/* 789 */       return this.shared.CAVE.place(tx, ty); 
/* 790 */     placeRaw(tx, ty);
/*     */ 
/*     */     
/* 793 */     placeRaw(tx, ty);
/* 794 */     int res = 0;
/* 795 */     for (int i = 0; i < DIR.NORTHO.size(); i++) {
/* 796 */       DIR d = (DIR)DIR.NORTHO.get(i);
/* 797 */       if (joins(tx, ty, d) && joins(tx, ty, d.next(-1)) && joins(tx, ty, d.next(1))) {
/* 798 */         res |= d.mask();
/*     */       }
/*     */     } 
/* 801 */     if (res != 15 && res != 0 && SETT.IN_BOUNDS(tx, ty, DIR.N)) {
/* 802 */       Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(tx, ty, DIR.N);
/* 803 */       if (t != this && t != this.shared.MOUNTAIN && t.wallIsWally() && !t.roofIs()) {
/* 804 */         if ((res & DIR.NW.mask()) != 0)
/* 805 */           res |= 0x20; 
/* 806 */         if ((res & DIR.NE.mask()) != 0)
/* 807 */           res |= 0x10; 
/*     */       } 
/*     */     } 
/* 810 */     if (res != 15 && res != 0 && SETT.IN_BOUNDS(tx, ty, DIR.W)) {
/* 811 */       Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(tx, ty, DIR.W);
/* 812 */       if (t != this && t != this.shared.MOUNTAIN && t.wallIsWally() && !t.roofIs()) {
/* 813 */         if ((res & DIR.SW.mask()) != 0)
/* 814 */           res |= 0x80; 
/* 815 */         if ((res & DIR.NW.mask()) != 0) {
/* 816 */           res |= 0x40;
/*     */         }
/*     */       } 
/*     */     } 
/* 820 */     this.shared.data.set(tx, ty, res);
/* 821 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 827 */     int x = i.x();
/* 828 */     int y = i.y();
/* 829 */     int ran = i.ran();
/*     */     
/* 831 */     TILE_SHEET sheets = (SETT.TERRAIN()).MOUNTAIN.sheet;
/*     */ 
/*     */     
/* 834 */     int code = data & 0xF;
/* 835 */     if (code == 0) {
/* 836 */       s.setHeight(3).setDistance2Ground(0.0D);
/* 837 */       this.sheet.render(r, this.SINGLES + (ran & 0xF), x, y);
/* 838 */       sheets.render((SPRITE_RENDERER)s, this.shared.MOUNTAIN.SINGLES + (ran & 0xF), x, y);
/*     */     } else {
/* 840 */       s.setHeight(10).setDistance2Ground(0.0D);
/* 841 */       this.sheet.render(r, this.SHEET_START + code + (ran & 0x3) * 16, x, y);
/* 842 */       sheets.render((SPRITE_RENDERER)s, code + (ran & 0x3) * 16, x, y);
/* 843 */       if ((data & 0x30) != 0)
/* 844 */         (SETT.TERRAIN()).wall_merge.render(r, (data >> 4 & 0x3) - 1, i.x(), i.y() - 4); 
/* 845 */       if ((data & 0xC0) != 0)
/* 846 */         (SETT.TERRAIN()).wall_merge.render(r, (data >> 6 & 0x3) + 2, i.x() - 4, i.y()); 
/*     */     } 
/* 848 */     i.countCave();
/* 849 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 854 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public AVAILABILITY getAvailability(int x, int y) {
/* 859 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPlacable(int tx, int ty) {
/* 865 */     for (DIR d : DIR.ALL) {
/* 866 */       if (SETT.IN_BOUNDS(tx, ty, d) && !((Terrain.TerrainTile)this.shared.get(tx, ty, d)).wallIsWally() && !((Terrain.TerrainTile)this.shared.get(tx, ty, d)).roofIs())
/* 867 */         return true; 
/*     */     } 
/* 869 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean wallJoiner() {
/* 874 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean wallIsWally() {
/* 879 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean roofIs() {
/* 884 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TerrainClearing clearing() {
/* 890 */     return TMountain.Ceiling.this.clear;
/*     */   }
/*     */ 
/*     */   
/*     */   public TERRAIN terrain(int tx, int ty) {
/* 895 */     return TERRAINS.MOUNTAIN();
/*     */   }
/*     */ 
/*     */   
/*     */   public int heightStart(int tx, int ty) {
/* 900 */     return 3;
/*     */   }
/*     */ 
/*     */   
/*     */   public int heightEnd(int tx, int ty) {
/* 905 */     return 200;
/*     */   }
/*     */ 
/*     */   
/*     */   public LOS los(int tx, int ty) {
/* 910 */     return LOS.CEILING;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TMountain$Ceiling$Opening.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */