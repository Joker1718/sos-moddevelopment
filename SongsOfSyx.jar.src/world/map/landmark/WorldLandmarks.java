/*     */ package world.map.landmark;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_OBJECTE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.text.D;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolManager;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class WorldLandmarks
/*     */   extends WORLD.WorldResource
/*     */ {
/*  26 */   private static CharSequence ¤¤name = "Landmark"; static final int nothing = 0; static final int MAX = 255;
/*     */   
/*     */   static {
/*  29 */     D.ts(WorldLandmarks.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  35 */   private final ArrayList<WorldLandmark> areas = new ArrayList(256);
/*  36 */   private final Bitsmap1D mapID = new Bitsmap1D(0, 8, WORLD.TAREA());
/*     */   public MAP_OBJECTE<WorldLandmark> setter;
/*     */   private final WORLD.WorldResourceManager saver;
/*     */   
/*     */   public WorldLandmarks(WORLD world) {
/*  41 */     super(¤¤name, "LANDMARKS");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  55 */     this.setter = new MAP_OBJECTE<WorldLandmark>()
/*     */       {
/*     */         public WorldLandmark get(int tile)
/*     */         {
/*  59 */           int i = WorldLandmarks.this.mapID.get(tile);
/*  60 */           return (WorldLandmark)WorldLandmarks.this.areas.get(i);
/*     */         }
/*     */ 
/*     */         
/*     */         public WorldLandmark get(int tx, int ty) {
/*  65 */           if (WORLD.IN_BOUNDS(tx, ty))
/*  66 */             return get(tx + ty * WORLD.TWIDTH()); 
/*  67 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int tile, WorldLandmark object) {
/*  72 */           if (object == null) {
/*  73 */             WorldLandmarks.this.mapID.set(tile, 0);
/*     */           } else {
/*  75 */             WorldLandmarks.this.mapID.set(tile, object.index());
/*     */           } 
/*     */         }
/*     */         
/*     */         public void set(int tx, int ty, WorldLandmark object) {
/*  80 */           if (WORLD.IN_BOUNDS(tx, ty)) {
/*  81 */             set(tx + ty * WORLD.TWIDTH(), object);
/*     */           }
/*     */         }
/*     */       };
/*     */     
/*  86 */     this.saver = new WORLD.WorldResourceManager()
/*     */       {
/*  88 */         private final PlacerOverlay overlay = new PlacerOverlay();
/*     */ 
/*     */         
/*     */         public void save(FilePutter file) {
/*  92 */           for (WorldLandmark a : WorldLandmarks.this.areas) {
/*  93 */             if (a != null)
/*  94 */               a.save(file); 
/*  95 */           }  WorldLandmarks.this.mapID.save(file);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 101 */           for (WorldLandmark a : WorldLandmarks.this.areas) {
/* 102 */             if (a != null)
/* 103 */               a.load(file); 
/* 104 */           }  WorldLandmarks.this.mapID.load(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/* 109 */           WorldLandmarks.this.mapID.setAll(0);
/* 110 */           for (WorldLandmark a : WorldLandmarks.this.areas) {
/* 111 */             if (a != null) {
/* 112 */               a.clear();
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void generate(ACTION loadPrint) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public void validateInit(WORLD.WorldError error) {}
/*     */ 
/*     */         
/*     */         public LIST<PLACABLE> makePlacers(ToolManager tm) {
/* 127 */           return (LIST<PLACABLE>)new Placers(WorldLandmarks.this, this.overlay);
/*     */         }
/*     */         
/*     */         public void addDebugView()
/*     */         {
/* 132 */           this.overlay.add(); }
/*     */       };
/*     */     this.areas.add(null);
/*     */     for (int i = 1; i <= 255; i++)
/*     */       this.areas.add(new WorldLandmark(i)); 
/*     */   } public WORLD.WorldResourceManager saver() {
/* 138 */     return this.saver;
/*     */   }
/*     */   
/*     */   public WorldLandmark getByIndex(int index) {
/*     */     return (WorldLandmark)this.areas.get(index);
/*     */   }
/*     */   
/*     */   public LIST<WorldLandmark> all() {
/*     */     return (LIST<WorldLandmark>)this.areas;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\landmark\WorldLandmarks.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */