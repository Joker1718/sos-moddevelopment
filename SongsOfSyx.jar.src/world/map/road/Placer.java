/*     */ package world.map.road;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ class Placer
/*     */ {
/*  16 */   public final LinkedList<PLACABLE> placers = new LinkedList();
/*     */ 
/*     */   
/*     */   public Placer() {
/*  20 */     final PlacableMulti undo = new PlacableMulti("remove", "", (SPRITE)(UI.icons()).m.cancel)
/*     */       {
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/*  24 */           if ((WORLD.ROADS()).placable.is(tx, ty)) {
/*  25 */             return null;
/*     */           }
/*  27 */           return E;
/*     */         }
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  32 */           WORLD.ROADS().set(tx, ty, false);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  40 */     PlacableMulti road = new PlacableMulti("road", "", (WORLD.BUILDINGS()).sprites.roads.makeSprite(15))
/*     */       {
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/*  44 */           if ((WORLD.ROADS()).placable.is(tx, ty)) {
/*  45 */             return null;
/*     */           }
/*  47 */           return E;
/*     */         }
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  52 */           WORLD.ROADS().set(tx, ty, true);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public PLACABLE getUndo() {
/*  58 */           return (PLACABLE)undo;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  63 */     PlacableMulti harbour = new PlacableMulti("bridge", "", (WORLD.BUILDINGS()).sprites.harbour.makeSprite(0))
/*     */       {
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/*  68 */           if (!(WORLD.ROADS()).canBridge.is(tx, ty))
/*  69 */             return E; 
/*  70 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  75 */           (WORLD.ROADS()).bridge.set(tx, ty, true);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public PLACABLE getUndo() {
/*  81 */           return (PLACABLE)undo;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     final PlacableMulti roadMiniUndo = new PlacableMulti("magnify", "", (WORLD.BUILDINGS()).sprites.roads.makeSprite(15).resized(32).twin((SPRITE)(UI.icons()).s.arrowUp, DIR.N, 0))
/*     */       {
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/* 116 */           if (WORLD.ROADS().is(tx, ty)) {
/* 117 */             return null;
/*     */           }
/* 119 */           return E;
/*     */         }
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 124 */           (WORLD.ROADS()).minified.set(tx, ty, false);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 130 */     PlacableMulti roadMini = new PlacableMulti("minify", "", (WORLD.BUILDINGS()).sprites.roads.makeSprite(15).resized(32).twin((SPRITE)(UI.icons()).s.arrowDown, DIR.S, 0))
/*     */       {
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/* 134 */           if (WORLD.ROADS().is(tx, ty)) {
/* 135 */             return null;
/*     */           }
/* 137 */           return E;
/*     */         }
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 142 */           (WORLD.ROADS()).minified.set(tx, ty, true);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public PLACABLE getUndo() {
/* 148 */           return (PLACABLE)roadMiniUndo;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 153 */     this.placers.add(road);
/* 154 */     this.placers.add(harbour);
/*     */     
/* 156 */     this.placers.add(undo);
/* 157 */     this.placers.add(roadMini);
/* 158 */     this.placers.add(roadMiniUndo);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\Placer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */