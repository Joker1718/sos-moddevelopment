/*     */ package world.map.fow;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.CORE;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import util.GUTIL;
/*     */ import util.data.BOOLEAN;
/*     */ import util.rendering.RenderData;
/*     */ import view.world.panel.IDebugPanelWorld;
/*     */ import world.WORLD;
/*     */ import world.WRenContext;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ public final class FOW
/*     */   extends WORLD.WorldResource
/*     */   implements MAP_BOOLEAN
/*     */ {
/*  33 */   private final Bitmap2D tmp = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/*  34 */   private final Bitmap2D visible = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/*     */   
/*  36 */   public BOOLEAN.BOOLEANImp toggled = new BOOLEAN.BOOLEANImp(true)
/*     */     {
/*     */       public BOOLEAN.BOOLEANImp set(boolean b)
/*     */       {
/*  40 */         FOW.this.dirty = true;
/*  41 */         super.set(b);
/*  42 */         return this;
/*     */       }
/*     */     };
/*     */   
/*     */   private boolean dirty = true;
/*     */   private final WORLD.WorldResourceManager saver;
/*     */   
/*  49 */   public FOW() { super("Fog of War", "FOW");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 167 */     this.saver = new WORLD.WorldResourceManager()
/*     */       {
/*     */         public void save(FilePutter file) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 177 */           FOW.this.dirty = true;
/*     */         }
/*     */         
/*     */         public void clear()
/*     */         {
/* 182 */           FOW.this.dirty = true; }
/*     */       }; IDebugPanelWorld.add("toggle fow", (BOOLEAN.BOOLEAN_MUTABLE)this.toggled); }
/*     */   public void setDirty() { this.dirty = true; } void update() { this.visible.clear(); PathUtilOnline.Flooder f = GUTIL.flooder(); f.init(this); for (int i = 0; i < FACTIONS.player().realm().regions(); i++) { Region reg = FACTIONS.player().realm().region(i); f.pushSloppy(reg.cx(), reg.cy(), 0.0D); }  while (f.hasMore()) { PathTile t = f.pollSmallest(); this.visible.set((COORDINATE)t, true); Region from = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t); for (DIR d : DIR.ALL) { if (from == null && (WORLD.REGIONS()).map.get((COORDINATE)t, d) == null) { this.visible.set((COORDINATE)t, d, true); }
/*     */         else if (from != null && from.is((COORDINATE)t, d)) { this.visible.set((COORDINATE)t, d, true); }
/*     */          if ((WORLD.PATH()).map.can((COORDINATE)t, d)) { Region to = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t, d); if (to == null || from == null || from == to || from.faction() == FACTIONS.player() || (from.faction() != null && (DIP.get((FactionNPC)from.faction())).transit))
/*     */             GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance());  }
/*     */          }
/*     */        }
/* 190 */      f.done(); } public WORLD.WorldResourceManager saver() { return this.saver; }
/*     */   public void render(WRenContext data) { if (!this.toggled.b) return;  CORE.renderer().shadowDepthSet((byte)-1); (WORLD.CENTRE()).sprite.renderAboveTerrain(data); RenderData.RenderIterator it = data.data.onScreenTiles(0, 0, 0, 0); while (it.has()) { render(data, it); it.next(); }  }
/*     */   public void render(WRenContext con, RenderData.RenderIterator it) { if (!is(it.tile())) return;  if (WORLD.REGIONS().centreTile().is(it.tile()) && is(it.tile())) { CORE.renderer().shadowDepthSet(127); } else { CORE.renderer().shadowDepthSet((byte)-1); }  CORE.renderer().renderShadow(it.x(), it.x() + 64, it.y(), it.y() + 64, COLOR.WHITE100.texture(), (byte)0); this.tmp.set(it.tile(), false); }
/*     */   public void enlighten(int tx, int ty, int radius) { if (!this.toggled.b) return;  for (int i = 0; GUTIL.circle().radius(i) <= radius; i++) this.tmp.set(tx + GUTIL.circle().get(i).x(), ty + GUTIL.circle().get(i).y(), true);  }
/*     */   public boolean is(int tile) { if (!this.toggled.b) return false;  if (this.tmp.is(tile)) return false;  if (this.visible.is(tile)) return false;  Region reg = (Region)(WORLD.REGIONS()).map.get(tile); if (reg != null && RD.DIST().reachable(reg)) return false;  if (reg != null && reg.faction() == FACTIONS.player()) return false;  return true; }
/* 195 */   public boolean is(int tx, int ty) { return is(tx + ty * WORLD.TWIDTH()); } protected void update(double ds, Profiler prof) { prof.logStart(this); if (FACTIONS.player().capitolRegion() == null || !SETT.exists()) return;  if (this.dirty) update();  this.dirty = false; super.update(ds, prof); prof.logEnd(this); } protected void initBeforePlay() { this.dirty = true; }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\fow\FOW.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */