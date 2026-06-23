/*     */ package settlement.maintenance;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class MFloor
/*     */   extends MType
/*     */ {
/*     */   public boolean degrade(int tx, int ty, int tile, double rate) {
/*  22 */     Floors.Floor f = (Floors.Floor)(SETT.FLOOR()).getter.get(tx, ty);
/*  23 */     if (f == null) {
/*  24 */       return false;
/*     */     }
/*  26 */     if ((SETT.PATH()).solidity.is(tx, ty)) {
/*  27 */       return false;
/*     */     }
/*  29 */     if ((SETT.ROOMS()).map.is(tx, ty)) {
/*  30 */       return false;
/*     */     }
/*  32 */     double r = rate;
/*  33 */     SETT.MAINTENANCE().getClass(); SETT.MAINTENANCE().getClass(); r *= 0.020833333333333332D + 0.25D * 0.015625D * f.resAmount;
/*  34 */     r *= 1.0D - f.durability;
/*  35 */     if (RND.rFloat() < r) {
/*  36 */       if (SETT.FLOOR().degrade(tx, ty) > 0) {
/*  37 */         SETT.FLOOR().degradeInc(tile, 1 + RND.rInt(3));
/*     */       } else {
/*  39 */         SETT.FLOOR().degradeInc(tile, 1);
/*  40 */       }  if (RND.oneIn(2))
/*  41 */         SETT.GRASS().grow(tx, ty); 
/*     */     } 
/*  43 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void vandalize(int tx, int ty) {
/*  48 */     SETT.FLOOR().degradeInc(tx + SETT.TWIDTH * ty, 3 + RND.rInt(2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int shouldPlaceResource(int tx, int ty) {
/*  55 */     Floors.Floor f = (Floors.Floor)(SETT.FLOOR()).getter.get(tx, ty);
/*     */     
/*  57 */     SETT.MAINTENANCE().getClass(); double res = 0.25D * 0.015625D * f.resAmount;
/*  58 */     SETT.MAINTENANCE().getClass(); double tot = res + 0.020833333333333332D;
/*     */     
/*  60 */     if (RND.rFloat() * tot < res)
/*  61 */       return 1; 
/*  62 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean validate(int tx, int ty) {
/*  68 */     Floors.Floor f = (Floors.Floor)(SETT.FLOOR()).getter.get(tx, ty);
/*  69 */     if (f != null && f.isRoad && !(SETT.PATH()).solidity.is(tx, ty) && !(SETT.ROOMS()).map.is(tx, ty)) {
/*  70 */       return true;
/*     */     }
/*  72 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void maintain(int tx, int ty) {
/*  78 */     if ((SETT.FLOOR()).getter.is(tx, ty)) {
/*  79 */       int i = tx + ty * SETT.TWIDTH;
/*  80 */       SETT.FLOOR().degradeInc(i, -SETT.FLOOR().degrade(tx, ty));
/*  81 */       (SETT.GRASS()).current.set(tx, ty, 0.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE res(int tx, int ty, int ri) {
/*  87 */     if (ri > 0)
/*  88 */       return ((Floors.Floor)(SETT.FLOOR()).getter.get(tx, ty)).resource; 
/*  89 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldPlace(int tx, int ty, boolean was) {
/*  94 */     Floors.Floor f = (Floors.Floor)(SETT.FLOOR()).getter.get(tx, ty);
/*  95 */     if (f != null && !f.reqs.passes(FACTIONS.player()))
/*  96 */       return false; 
/*  97 */     return (SETT.FLOOR().degrade(tx, ty) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public double resRate(int tx, int ty, int ri) {
/* 102 */     if (ri != 1) {
/* 103 */       return 0.0D;
/*     */     }
/* 105 */     if (!validate(tx, ty))
/* 106 */       return 0.0D; 
/* 107 */     Floors.Floor f = (Floors.Floor)(SETT.FLOOR()).getter.get(tx, ty);
/* 108 */     SETT.MAINTENANCE().getClass(); return 0.25D * f.resAmount * 0.015625D * (1.0D - f.durability);
/*     */   }
/*     */ 
/*     */   
/*     */   public double degrade(int tx, int ty) {
/* 113 */     return (SETT.FLOOR()).degrade.get(tx, ty);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\maintenance\MFloor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */