/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ public final class TerrainDiagonal {
/*  14 */   private static CharSequence ¤¤name = "¤Make Diagonal";
/*  15 */   private static CharSequence ¤¤desc = "¤Turns walls diagonal, only for aesthetic purposes.";
/*     */   
/*  17 */   private static CharSequence ¤¤undo = "¤Make Rectangular";
/*  18 */   private static CharSequence ¤¤undoDesc = "¤Turns walls rectangular, only for aesthetic purposes.";
/*     */   
/*  20 */   private static CharSequence ¤¤problem = "¤Must be placed on a wall like structure or a road.";
/*     */   
/*     */   static {
/*  23 */     D.ts(TerrainDiagonal.class);
/*     */   }
/*     */   
/*  26 */   public final PlacableMulti placer = new PlacableMulti(¤¤name, ¤¤desc, (SPRITE)(SPRITES.icons()).l.dia)
/*     */     {
/*     */       public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */       {
/*  30 */         Room ff = (SETT.ROOMS()).map.get(tx, ty);
/*  31 */         if (ff != null && ff.constructor() != null && ff.constructor().dia(tx, ty) != null) {
/*  32 */           ff.constructor().dia(tx, ty).setDia(tx, ty, true);
/*     */         }
/*  34 */         if (!(SETT.ROOMS()).map.is(tx, ty) && (SETT.FLOOR()).getter.get(tx, ty) != null)
/*  35 */           (SETT.FLOOR()).square.set(tx, ty, false); 
/*  36 */         if (SETT.TERRAIN().get(tx, ty) instanceof TerrainDiagonal.Diagonalizer) {
/*  37 */           TerrainDiagonal.Diagonalizer t = (TerrainDiagonal.Diagonalizer)SETT.TERRAIN().get(tx, ty);
/*  38 */           t.setDia(tx, ty, true);
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  44 */         Room ff = (SETT.ROOMS()).map.get(tx, ty);
/*  45 */         if (ff != null && ff.constructor() != null && ff.constructor().dia(tx, ty) != null) {
/*  46 */           return null;
/*     */         }
/*  48 */         if (!(SETT.ROOMS()).map.is(tx, ty) && (SETT.FLOOR()).getter.get(tx, ty) != null)
/*  49 */           return null; 
/*  50 */         if (SETT.TERRAIN().get(tx, ty) instanceof TerrainDiagonal.Diagonalizer)
/*  51 */           return null; 
/*  52 */         return TerrainDiagonal.¤¤problem;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public PLACABLE getUndo() {
/*  58 */         return (PLACABLE)TerrainDiagonal.this.undo;
/*     */       }
/*     */     };
/*     */   
/*  62 */   public final PlacableMulti undo = new PlacableMulti(¤¤undo, ¤¤undoDesc, (SPRITE)(SPRITES.icons()).l.square)
/*     */     {
/*     */       public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */       {
/*  66 */         Room ff = (SETT.ROOMS()).map.get(tx, ty);
/*  67 */         if (ff != null && ff.constructor() != null && ff.constructor().dia(tx, ty) != null) {
/*  68 */           ff.constructor().dia(tx, ty).setDia(tx, ty, false);
/*     */         }
/*  70 */         if (!(SETT.ROOMS()).map.is(tx, ty) && (SETT.FLOOR()).getter.get(tx, ty) != null)
/*  71 */           (SETT.FLOOR()).square.set(tx, ty, true); 
/*  72 */         if (SETT.TERRAIN().get(tx, ty) instanceof TerrainDiagonal.Diagonalizer) {
/*  73 */           TerrainDiagonal.Diagonalizer t = (TerrainDiagonal.Diagonalizer)SETT.TERRAIN().get(tx, ty);
/*  74 */           t.setDia(tx, ty, false);
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  81 */         Room ff = (SETT.ROOMS()).map.get(tx, ty);
/*  82 */         if (ff != null && ff.constructor() != null && ff.constructor().dia(tx, ty) != null) {
/*  83 */           return null;
/*     */         }
/*  85 */         if (!(SETT.ROOMS()).map.is(tx, ty) && (SETT.FLOOR()).getter.get(tx, ty) != null)
/*  86 */           return null; 
/*  87 */         if (SETT.TERRAIN().get(tx, ty) instanceof TerrainDiagonal.Diagonalizer)
/*  88 */           return null; 
/*  89 */         return TerrainDiagonal.¤¤problem;
/*     */       }
/*     */       
/*     */       public PLACABLE getUndo() {
/*  93 */         return (PLACABLE)TerrainDiagonal.this.placer;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public boolean is(int tx, int ty) {
/*  99 */     Room ff = (SETT.ROOMS()).map.get(tx, ty);
/* 100 */     if (ff != null && ff.constructor() != null && ff.constructor().dia(tx, ty) != null) {
/* 101 */       return true;
/*     */     }
/* 103 */     if (ff == null && (SETT.FLOOR()).getter.get(tx, ty) != null)
/* 104 */       return true; 
/* 105 */     if (SETT.TERRAIN().get(tx, ty) instanceof Diagonalizer)
/* 106 */       return true; 
/* 107 */     return false;
/*     */   }
/*     */   
/*     */   public static interface Diagonalizer {
/*     */     void setDia(int param1Int1, int param1Int2, boolean param1Boolean);
/*     */     
/*     */     boolean getDia(int param1Int1, int param1Int2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TerrainDiagonal.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */