/*     */ package settlement.job;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ public final class PlacerRemoveSmart
/*     */   extends PlacableMulti
/*     */ {
/*  18 */   private static CharSequence ¤¤remove = "¤Smart Remove";
/*  19 */   private static CharSequence ¤¤desc = "¤Removes jobs if any selected, else removes structures and rooms.";
/*     */   static {
/*  21 */     D.ts(PlacerRemoveSmart.class);
/*     */   }
/*     */   
/*  24 */   private int stage = -1;
/*     */   
/*     */   PlacerRemoveSmart() {
/*  27 */     super(¤¤remove, ¤¤desc, (SPRITE)(SPRITES.icons()).l.demolish.twin((SPRITE)(UI.icons()).s.allRight, DIR.NE, 2));
/*     */   }
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/*  32 */     return (PLACABLE)(SETT.JOBS()).tool_clear;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/*  37 */     if (this.stage == 1) {
/*  38 */       if ((SETT.ROOMS()).map.get(tx, ty) == null && (SETT.JOBS()).getter.get(tx, ty) != null) {
/*  39 */         return null;
/*     */       }
/*  41 */       if ((SETT.ROOMS()).construction.isser.is(tx, ty) && (SETT.ROOMS()).DELETE.isPlacable(tx, ty, null, null) == null) {
/*  42 */         return null;
/*     */       }
/*  44 */     } else if (this.stage == 2) {
/*     */       
/*  46 */       if ((SETT.ROOMS()).DELETE.isPlacable(tx, ty, a, t) == null)
/*  47 */         return null; 
/*  48 */       if ((SETT.JOBS()).clearss.structure.problem(tx, ty, false) == null) {
/*  49 */         return null;
/*     */       }
/*     */     } 
/*     */     
/*  53 */     return E;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(AREA area, PLACER_TYPE type) {
/*  59 */     this.stage = -1;
/*  60 */     for (COORDINATE c : area.body()) {
/*  61 */       if (area.is(c)) {
/*  62 */         if ((SETT.ROOMS()).map.get(c) == null && (SETT.JOBS()).getter.get(c) != null) {
/*  63 */           this.stage = 1;
/*  64 */           return null;
/*     */         } 
/*  66 */         if ((SETT.ROOMS()).construction.isser.is(c.x(), c.y()) && (SETT.ROOMS()).DELETE.isPlacable(c.x(), c.y(), null, null) == null) {
/*  67 */           this.stage = 1;
/*  68 */           return null;
/*     */         } 
/*  70 */         if ((SETT.JOBS()).clearss.structure.problem(c.x(), c.y(), false) == null) {
/*  71 */           this.stage = 2;
/*  72 */           return null;
/*     */         } 
/*  74 */         if ((SETT.ROOMS()).DELETE.isPlacable(c.x(), c.y(), null, null) == null) {
/*  75 */           this.stage = 2;
/*  76 */           return null;
/*     */         } 
/*     */       } 
/*     */     } 
/*  80 */     return E;
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/*  85 */     if (this.stage == 1) {
/*  86 */       if ((SETT.ROOMS()).map.get(tx, ty) == null && (SETT.JOBS()).getter.get(tx, ty) != null) {
/*  87 */         Job j = (Job)(SETT.JOBS()).getter.get(tx, ty);
/*  88 */         if (j != null)
/*  89 */           j.cancel(tx, ty); 
/*  90 */         (SETT.JOBS()).clearer.set(tx, ty);
/*     */       } 
/*  92 */       if ((SETT.ROOMS()).construction.isser.is(tx, ty) && (SETT.ROOMS()).DELETE.isPlacable(tx, ty, null, null) == null) {
/*  93 */         (SETT.ROOMS()).DELETE.place(tx, ty, a, t);
/*     */       }
/*  95 */     } else if (this.stage == 2) {
/*  96 */       if ((SETT.ROOMS()).DELETE.isPlacable(tx, ty, a, t) == null) {
/*  97 */         (SETT.ROOMS()).DELETE.place(tx, ty, a, t);
/*     */       }
/*  99 */       if ((SETT.JOBS()).clearss.structure.problem(tx, ty, false) == null) {
/* 100 */         (SETT.JOBS()).clearss.structure.placer().place(tx, ty, a, t);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 108 */     if (this.stage == 1) {
/* 109 */       return ((SETT.ROOMS()).construction.isser.is(fromX, fromY) && (SETT.ROOMS()).map.get(fromX, fromY).isSame(fromX, fromY, toX, toY));
/*     */     }
/* 111 */     if (this.stage == 2) {
/* 112 */       return ((SETT.ROOMS()).DELETE.isPlacable(fromX, fromY, null, null) == null && (SETT.ROOMS()).map.get(fromX, fromY).isSame(fromX, fromY, toX, toY));
/*     */     }
/* 114 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\PlacerRemoveSmart.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */