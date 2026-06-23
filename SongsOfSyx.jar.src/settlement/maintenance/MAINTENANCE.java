/*     */ package settlement.maintenance;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.map.MAP_BOOLEANE;
/*     */ import snake2d.util.map.MAP_DOUBLE;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.Bitsmap2D;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.keymap.MAPSAVE;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ public final class MAINTENANCE
/*     */   extends SETT.SettResource {
/*  34 */   private final Bitmap2D pisser = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/*  35 */   private final Bitmap2D preserved = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/*  36 */   private final Bitmap2D pdisabled = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/*  37 */   public final Bitmap2D pFreeFetch = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/*  38 */   private final Bitsmap2D bresource = new Bitsmap2D(0, 4, (DIMENSION)SETT.TILE_BOUNDS);
/*  39 */   public final PLACABLE enablePlacer = (PLACABLE)new PlacerDormant();
/*  40 */   private final MConsumption cons = new MConsumption(this);
/*     */   
/*  42 */   public final double tilesPerDay = 0.020833333333333332D;
/*  43 */   public final double resRate = 0.015625D;
/*  44 */   public final SPRITE icon = (SPRITE)(UI.icons()).s.degrade;
/*     */   
/*  46 */   final MType[] types = new MType[] {
/*  47 */       new MRoom(), 
/*  48 */       new MFloor() }; double sp; int upI; public MAP_BOOLEAN needs; public MAP_BOOLEAN isser; public MAP_BOOLEANE reserved; public MAP_BOOLEAN reservable;
/*     */   public MAP_BOOLEANE disabled;
/*     */   public final MAP_DOUBLE degrade;
/*     */   public MAP_OBJECT<RESOURCE> resource;
/*     */   
/*  53 */   public MAINTENANCE() { super("MAINTENANCE", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     this.sp = 1.0D;
/* 108 */     this.upI = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 175 */     this.needs = new MAP_BOOLEAN() { public boolean is(int tx, int ty) {
/*     */           byte b;
/*     */           int i;
/*     */           MType[] arrayOfMType;
/* 179 */           for (i = (arrayOfMType = MAINTENANCE.this.types).length, b = 0; b < i; ) { MType t = arrayOfMType[b];
/* 180 */             if (t.validate(tx, ty))
/* 181 */               return true;  b++; }
/*     */           
/* 183 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 188 */           return is(tile % SETT.TWIDTH, tile / SETT.THEIGHT);
/*     */         } }
/*     */       ;
/*     */     
/* 192 */     this.isser = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 196 */           if (MAINTENANCE.this.pisser.is(tx, ty)) {
/* 197 */             byte b; int i; MType[] arrayOfMType; for (i = (arrayOfMType = MAINTENANCE.this.types).length, b = 0; b < i; ) { MType t = arrayOfMType[b];
/* 198 */               if (t.validate(tx, ty))
/* 199 */                 return true;  b++; }
/*     */             
/* 201 */             MAINTENANCE.this.pisser.set(tx, ty, false);
/*     */           } 
/* 203 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 208 */           return is(tile % SETT.TWIDTH, tile / SETT.THEIGHT);
/*     */         }
/*     */       };
/*     */     
/* 212 */     this.reserved = new MAP_BOOLEANE()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 216 */           return (MAINTENANCE.this.isser.is(tx, ty) && MAINTENANCE.this.preserved.is(tx, ty));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 221 */           return is(tile % SETT.TWIDTH, tile / SETT.THEIGHT);
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_BOOLEANE set(int tx, int ty, boolean value) {
/* 226 */           (SETT.PATH()).finders.maintenance.remove(tx, ty);
/* 227 */           MAINTENANCE.this.preserved.set(tx, ty, value);
/* 228 */           (SETT.PATH()).finders.maintenance.add(tx, ty);
/* 229 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_BOOLEANE set(int tile, boolean value) {
/* 234 */           return set(tile % SETT.TWIDTH, tile / SETT.THEIGHT, value);
/*     */         }
/*     */       };
/*     */     
/* 238 */     this.reservable = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 242 */           return (MAINTENANCE.this.isser.is(tx, ty) && !MAINTENANCE.this.pdisabled.is(tx, ty) && !MAINTENANCE.this.reserved.is(tx, ty));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 247 */           return is(tile % SETT.TWIDTH, tile / SETT.THEIGHT);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 252 */     this.disabled = new MAP_BOOLEANE()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 256 */           return MAINTENANCE.this.pdisabled.is(tx, ty);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 261 */           return is(tile % SETT.TWIDTH, tile / SETT.THEIGHT);
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_BOOLEANE set(int tx, int ty, boolean value) {
/* 266 */           if (value == is(tx, ty))
/* 267 */             return this; 
/* 268 */           (SETT.PATH()).finders.maintenance.remove(tx, ty);
/* 269 */           MAINTENANCE.this.pdisabled.set(tx, ty, value);
/* 270 */           MAINTENANCE.this.preserved.set(tx, ty, false);
/* 271 */           (SETT.PATH()).finders.maintenance.add(tx, ty);
/* 272 */           MAINTENANCE.this.cons.change(tx, ty);
/* 273 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_BOOLEANE set(int tile, boolean value) {
/* 278 */           return set(tile % SETT.TWIDTH, tile / SETT.THEIGHT, value);
/*     */         }
/*     */       };
/*     */     
/* 282 */     this.degrade = new MAP_DOUBLE() { public double get(int tx, int ty) {
/*     */           byte b;
/*     */           int i;
/*     */           MType[] arrayOfMType;
/* 286 */           for (i = (arrayOfMType = MAINTENANCE.this.types).length, b = 0; b < i; ) { MType t = arrayOfMType[b];
/* 287 */             if (t.validate(tx, ty))
/* 288 */               t.degrade(tx, ty);  b++; }
/*     */           
/* 290 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(int tile) {
/* 295 */           return get(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */         } }
/*     */       ;
/*     */     
/* 299 */     this.resource = new MAP_OBJECT<RESOURCE>()
/*     */       {
/*     */         public RESOURCE get(int tile)
/*     */         {
/* 303 */           return get(tile % SETT.TWIDTH, tile / SETT.THEIGHT);
/*     */         } public void place(int tx, int ty, AREA area, PLACER_TYPE type) { MAINTENANCE.this.vandalise(tx, ty); } public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) { return null; } }
/*     */     ); IDebugPanelSett.add((PLACABLE)new PlacableMulti("MAINTENANCE_DEGRADE_X1") { public void place(int tx, int ty, AREA area, PLACER_TYPE type) { MAINTENANCE.this.updateTileDay(tx, ty, tx + ty * SETT.TWIDTH, 10.0D); }
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) { return null; }
/*     */       };
/* 308 */     IDebugPanelSett.add((PLACABLE)new PlacableMulti("MAINTENANCE_DEGRADEx4") { public RESOURCE get(int tx, int ty) { if (MAINTENANCE.this.pisser.is(tx, ty)) {
/* 309 */               int bi = MAINTENANCE.this.bresource.get(tx, ty);
/* 310 */               if (bi == 0)
/* 311 */                 return null;  byte b; int i; MType[] arrayOfMType;
/* 312 */               for (i = (arrayOfMType = MAINTENANCE.this.types).length, b = 0; b < i; ) { MType t = arrayOfMType[b];
/* 313 */                 if (t.validate(tx, ty))
/* 314 */                   return t.res(tx, ty, bi);  b++; }
/*     */               
/* 316 */               MAINTENANCE.this.pisser.set(tx, ty, false);
/*     */             } 
/* 318 */             return null; } }); IDebugPanelSett.add((PLACABLE)new PlacableMulti("MAINTENANCE_DEGRADE") {
/*     */           public void place(int tx, int ty, AREA area, PLACER_TYPE type) { MAINTENANCE.this.updateTileDay(tx, ty, tx + ty * SETT.TWIDTH); }
/*     */           public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) { return null; }
/*     */         }); IDebugPanelSett.add("MAINTENANCE ana", new ACTION() {
/*     */           public void exe() {}
/*     */         }); }
/* 324 */   public void updateTileDay(int tx, int ty, int tile) { if (this.upI != GAME.updateI()) { this.upI = GAME.updateI(); this.sp = speed(); }  updateTileDay(tx, ty, tile, this.sp); } private void updateTileDay(int tx, int ty, int tile, double speed) { byte b; int i; MType[] arrayOfMType; for (i = (arrayOfMType = this.types).length, b = 0; b < i; ) { MType t = arrayOfMType[b]; if (t.degrade(tx, ty, tile, speed)) { if (t.validate(tx, ty) && !this.pisser.is(tx, ty) && t.shouldPlace(tx, ty, false)) { (SETT.PATH()).finders.maintenance.remove(tx, ty); this.pisser.set(tx, ty, true); this.bresource.set(tx, ty, t.shouldPlaceResource(tx, ty)); this.preserved.set(tx, ty, false); (SETT.PATH()).finders.maintenance.add(tx, ty); }  break; }  b++; }  } public void setChanged(int tx, int ty) { this.cons.change(tx, ty); } public void save(FilePutter file) { this.pisser.save(file); this.preserved.save(file); this.bresource.save(file); this.pdisabled.save(file); MAPSAVE.saveMeta(file, RESOURCES.ALL()); } public void vandalise(int tx, int ty) { byte b; int i; MType[] arrayOfMType; for (i = (arrayOfMType = this.types).length, b = 0; b < i; ) { MType t = arrayOfMType[b];
/* 325 */       if (t.validate(tx, ty)) {
/* 326 */         t.vandalize(tx, ty);
/* 327 */         if (!this.pisser.is(tx, ty) && t.shouldPlace(tx, ty, false)) {
/* 328 */           (SETT.PATH()).finders.maintenance.remove(tx, ty);
/* 329 */           this.pisser.set(tx, ty, true);
/* 330 */           this.preserved.set(tx, ty, false);
/* 331 */           this.bresource.set(tx, ty, t.shouldPlaceResource(tx, ty));
/* 332 */           (SETT.PATH()).finders.maintenance.add(tx, ty);
/*     */         }  break;
/*     */       }  b++; }
/*     */      }
/*     */   public void load(FileGetter file) throws IOException { this.pisser.load(file); this.preserved.load(file); this.bresource.load(file); this.pdisabled.load(file); int[] oo = MAPSAVE.saveWash(file, RESOURCES.ALL(), 0); if (oo != null)
/*     */       clear();  }
/*     */   public void clear() { this.pisser.clear(); this.preserved.clear(); this.bresource.clear(); this.pdisabled.clear(); }
/*     */   protected void afterTick() { this.cons.update(); }
/* 340 */   protected void init(boolean loaded) { this.cons.init(); } public void maintain(int tx, int ty) { byte b; int i; MType[] arrayOfMType; for (i = (arrayOfMType = this.types).length, b = 0; b < i; ) { MType t = arrayOfMType[b];
/* 341 */       if (t.validate(tx, ty)) {
/* 342 */         t.maintain(tx, ty);
/* 343 */         (SETT.PATH()).finders.maintenance.remove(tx, ty);
/* 344 */         this.pisser.set(tx, ty, false);
/* 345 */         if (t.shouldPlace(tx, ty, true)) {
/* 346 */           this.pisser.set(tx, ty, true);
/* 347 */           this.bresource.set(tx, ty, t.shouldPlaceResource(tx, ty));
/* 348 */           this.preserved.set(tx, ty, false);
/*     */         } 
/* 350 */         (SETT.PATH()).finders.maintenance.add(tx, ty);
/*     */         return;
/*     */       } 
/*     */       b++; }
/*     */      }
/*     */ 
/*     */   
/*     */   public void initRoomDegrade(Room room, int mX, int mY) {
/* 358 */     MRoom.initRoom(room, mX, mY);
/*     */   }
/*     */   
/*     */   public double estimateGlobal(RESOURCE res) {
/* 362 */     return this.cons.get(res) * speed();
/*     */   }
/*     */   
/*     */   public double estimateGlobalRaw(RESOURCE res) {
/* 366 */     return this.cons.get(res);
/*     */   }
/*     */   
/*     */   public double speed() {
/* 370 */     double m = (BOOSTABLES.CIVICS()).MAINTENANCE.get((BOOSTABLE_O)HCLASS_RACE.clP(null, null));
/* 371 */     if (m <= 0.0D)
/* 372 */       return 10.0D; 
/* 373 */     return CLAMP.d(1.0D / m, 0.0D, 10.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\maintenance\MAINTENANCE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */