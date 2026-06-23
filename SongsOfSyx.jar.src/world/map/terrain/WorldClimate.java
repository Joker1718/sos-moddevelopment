/*     */ package world.map.terrain;
/*     */ 
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.map.MAP_DOUBLEE;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.map.MAP_OBJECTE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ import view.tool.ToolManager;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class WorldClimate
/*     */   extends WorldTerrain.WorldTerrainResource
/*     */ {
/*  35 */   private final Bitsmap1D map = new Bitsmap1D(0, CLIMATES.ALL().size(), WORLD.TAREA());
/*  36 */   private final Bitsmap1D offmap = new Bitsmap1D(0, 3, WORLD.TAREA());
/*     */   
/*     */   final MAP_OBJECTE<CLIMATE> setter;
/*     */   
/*     */   final MAP_DOUBLEE offset;
/*     */   public final MAP_OBJECT<CLIMATE> getter;
/*     */   
/*     */   WorldClimate() {
/*  44 */     this.setter = new MAP_OBJECTE<CLIMATE>()
/*     */       {
/*     */         public CLIMATE get(int tile)
/*     */         {
/*  48 */           return (CLIMATE)CLIMATES.ALL().get(WorldClimate.this.map.get(tile));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public CLIMATE get(int tx, int ty) {
/*  54 */           return get(tx + ty * WORLD.TWIDTH());
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int tile, CLIMATE object) {
/*  59 */           WorldClimate.this.map.set(tile, object.index());
/*  60 */           WORLD.changeTile(tile % WORLD.TWIDTH(), tile / WORLD.TWIDTH());
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int tx, int ty, CLIMATE object) {
/*  65 */           if (WORLD.IN_BOUNDS(tx, ty)) {
/*  66 */             set(tx + ty * WORLD.TWIDTH(), object);
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  72 */     this.offset = new MAP_DOUBLEE()
/*     */       {
/*     */         public double get(int tx, int ty)
/*     */         {
/*  76 */           if (WORLD.IN_BOUNDS(tx, ty))
/*  77 */             return get(tx + ty * WORLD.TWIDTH()); 
/*  78 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(int tile) {
/*  83 */           return (WorldClimate.this.offmap.get(tile) - 3);
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tx, int ty, double value) {
/*  88 */           if (WORLD.IN_BOUNDS(tx, ty))
/*  89 */             return set(tx + ty * WORLD.TWIDTH(), value); 
/*  90 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tile, double value) {
/*  95 */           int v = (int)(value * 4.0D);
/*  96 */           v = CLAMP.i(v, -3, 4);
/*  97 */           v += 3;
/*  98 */           WorldClimate.this.offmap.set(tile, v);
/*  99 */           return this;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 104 */     this.getter = (MAP_OBJECT<CLIMATE>)this.setter;
/*     */   }
/*     */   
/*     */   protected void save(FilePutter saveFile) {
/* 108 */     this.map.save(saveFile);
/* 109 */     this.offmap.save(saveFile);
/*     */   }
/*     */   
/*     */   protected void load(FileGetter saveFile) throws IOException {
/* 113 */     this.map.load(saveFile);
/* 114 */     this.offmap.load(saveFile);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<PLACABLE> placers(ToolManager tm) {
/* 120 */     ArrayListGrower<PLACABLE> placers = new ArrayListGrower();
/* 121 */     final GETTER.GETTER_IMP<CLIMATE> pg = new GETTER.GETTER_IMP(CLIMATES.COLD());
/* 122 */     final LinkedList<CLICKABLE> butts = new LinkedList();
/*     */     
/* 124 */     for (CLIMATE c : CLIMATES.ALL()) {
/* 125 */       butts.add(new GButt.ButtPanel(c.name)
/*     */           {
/*     */             protected void clickA() {
/* 128 */               pg.set(c);
/*     */             }
/*     */             
/*     */             protected void renAction() {
/* 132 */               selectedSet((pg.get() == c));
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 140 */     placers.add(new PlacableMulti((CLIMATES.INFO()).name, "", (CLIMATES.COLD()).icon)
/*     */         {
/*     */           public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */           {
/* 144 */             WorldClimate.this.setter.set(tx, ty, pg.get());
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 151 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public void updateRegardless(GameWindow window, AREA selected) {
/* 156 */             (WORLD.OVERLAY()).climate.add();
/*     */           }
/*     */ 
/*     */           
/*     */           public LIST<CLICKABLE> getAdditionalButt() {
/* 161 */             return (LIST<CLICKABLE>)butts;
/*     */           }
/*     */         });
/*     */     
/* 165 */     return (LIST<PLACABLE>)placers;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldClimate.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */