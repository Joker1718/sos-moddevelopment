/*     */ package world.map.buildings;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.debug.Profiler;
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import snake2d.CORE;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.rendering.RenderData;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolManager;
/*     */ import world.WORLD;
/*     */ import world.WRenContext;
/*     */ import world.map.regions.Region;
/*     */ import world.map.regions.centre.WorldRaceSheet;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ public class WorldBuildings
/*     */   extends WORLD.WorldResource
/*     */ {
/*  33 */   final Bitmap2D village = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/*  34 */   public final WorldBuildingSprites sprites = new WorldBuildingSprites();
/*  35 */   private final OPACITY[] ops = new OPACITY[16]; boolean debugVisible = false;
/*     */   private final WORLD.WorldResourceManager saver;
/*     */   
/*     */   public WorldBuildings() throws IOException {
/*  39 */     super("buildings", "BUILDINGS");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  45 */     this.saver = new WORLD.WorldResourceManager()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  49 */           WorldBuildings.this.village.save(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  54 */           WorldBuildings.this.village.load(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/*  59 */           WorldBuildings.this.village.clear();
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<PLACABLE> makePlacers(ToolManager tm) {
/*  64 */           ArrayListGrower<PLACABLE> placers = new ArrayListGrower();
/*  65 */           Placer p = new Placer();
/*  66 */           placers.add(p);
/*  67 */           placers.add(p.getUndo());
/*  68 */           return (LIST<PLACABLE>)placers;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void generate(ACTION loadPrint) {
/*  74 */           loadPrint.exe();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void addDebugView() {
/*  80 */           WorldBuildings.this.debugVisible = true;
/*     */         }
/*     */       };
/*     */     for (int i = 0; i < this.ops.length; i++)
/*     */       this.ops[i] = (OPACITY)new OpacityImp((int)(255.0D * (0.4D + 0.4D * RND.rFloat()))); 
/*     */   } public WORLD.WorldResourceManager saver() {
/*  86 */     return this.saver;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAboveGround(WRenContext con, RenderData.RenderIterator it) {
/*  93 */     if (this.village.is(it.tile())) {
/*  94 */       WorldRaceSheet.Village sh = isVisible(it.ran(), it.tile());
/*     */       
/*  96 */       if (sh != null) {
/*  97 */         int ran = it.ran() >> 4;
/*  98 */         this.ops[ran >> 5 & 0xF].bind();
/*  99 */         WorldRaceSheet.Farm farm = (((RDRace)(RD.RACES()).all.getC(it.ran())).race.appearance()).world.farm;
/* 100 */         farm.render(con, ran, it.x(), it.y());
/* 101 */         OPACITY.unbind();
/* 102 */         COLOR.unbind();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAbove(WRenContext con, RenderData.RenderIterator it) {
/* 111 */     if (this.village.is(it.tile()) && (
/* 112 */       it.ran() & 0x2) == 0) {
/* 113 */       WorldRaceSheet.Village sh = isVisible(it.ran(), it.tile());
/* 114 */       if (sh != null) {
/* 115 */         int ran = it.ran() >> 16 & 0x1F;
/* 116 */         int x = it.x() + (it.ran() >> 20 & 0x7) * 4;
/* 117 */         int y = it.y() + (it.ran() >> 24 & 0x7) * 4;
/* 118 */         int li = it.ran() >> 28 & 0x7;
/* 119 */         sh.render(con.r, con.s, ran, x, y);
/*     */         
/* 121 */         if (TIME.light().nightIs() && TIME.light().partOfCircular() * 16.0D > li) {
/* 122 */           x += 16 + (GAME.intervals().get05() + it.ran() & 0x3);
/* 123 */           y += 16 + (GAME.intervals().get05() + (it.ran() >> 4) & 0x3);
/* 124 */           CORE.renderer().renderUniLight(x, y, 2, 128);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAboveTerrain(WRenContext con, RenderData.RenderIterator it) {
/* 133 */     Region reg = (Region)(WORLD.REGIONS()).map.get(it.tile());
/* 134 */     if (reg != null && (RD.BUILDINGS()).levelMine.get(reg) * 7.0D > (it.ran() & 0xFF) && !WORLD.WATER().is(it.tile())) {
/* 135 */       int i = it.ran() & 0x1;
/* 136 */       i *= 4;
/*     */       
/* 138 */       int m = GAME.intervals().get02() + (it.ran() >> 1) & 0x7;
/* 139 */       if (m >= 4) {
/* 140 */         m -= 4;
/* 141 */         m = 3 - m;
/*     */       } 
/* 143 */       i += m;
/* 144 */       this.sprites.mines.render(con.r, i, it.x(), it.y());
/*     */     } 
/*     */   }
/*     */   
/*     */   private WorldRaceSheet.Village isVisible(int ran, int tile) {
/* 149 */     if ((WORLD.FOREST()).amount.get(tile) == 1.0D)
/* 150 */       return null; 
/* 151 */     if ((WORLD.WATER()).isBig.is(tile))
/* 152 */       return null; 
/* 153 */     Region r = (Region)(WORLD.REGIONS()).map.get(tile);
/* 154 */     if (this.debugVisible)
/* 155 */       return (((RDRace)(RD.RACES()).all.getC(ran)).race.appearance()).world.village; 
/* 156 */     if (r != null) {
/* 157 */       double v = RD.RACES().popSizeD(r) * (1.0D - (RD.DEVASTATION()).current.getD(r));
/* 158 */       int k = (int)(65535.0D * v);
/* 159 */       if ((ran & 0xFFFF) <= k) {
/* 160 */         return ((RD.RACES()).visuals.vRace(r, ran).appearance()).world.village;
/*     */       }
/*     */     } 
/*     */     
/* 164 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void afterRender() {
/* 169 */     this.debugVisible = false;
/*     */   }
/*     */   
/*     */   protected void update(double ds, Profiler prof) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\buildings\WorldBuildings.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */