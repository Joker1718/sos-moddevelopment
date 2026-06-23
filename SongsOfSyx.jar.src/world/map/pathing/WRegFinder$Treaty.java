/*     */ package world.map.pathing;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Treaty
/*     */ {
/* 246 */   public static final Treaty REG_NEIGHS = new Treaty()
/*     */     {
/*     */       public boolean can(Region origin, Region prevReg, Region to, int tx, int ty, double dist)
/*     */       {
/* 250 */         if (prevReg == null)
/* 251 */           return true; 
/* 252 */         if (prevReg == origin)
/* 253 */           return true; 
/* 254 */         return (prevReg == to);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 264 */   public static final Treaty FACTION_REACHABLE = new Treaty()
/*     */     {
/*     */       public boolean can(Region origin, Region from, Region to, int tx, int ty, double dist)
/*     */       {
/* 268 */         if (origin == null)
/* 269 */           return false; 
/* 270 */         if (from == null)
/* 271 */           return false; 
/* 272 */         if (to == null)
/* 273 */           return true; 
/* 274 */         Faction o = origin.faction();
/*     */         
/* 276 */         if (o == null) {
/* 277 */           return (to.faction() == null);
/*     */         }
/*     */         
/* 280 */         if (to.faction() == null) {
/* 281 */           return false;
/*     */         }
/* 283 */         if (from.faction() == origin.faction()) {
/* 284 */           return true;
/*     */         }
/* 286 */         if (from.faction() == to.faction()) {
/* 287 */           return true;
/*     */         }
/* 289 */         if (origin.faction() == null) {
/* 290 */           return false;
/*     */         }
/* 292 */         if ((DIP.get(origin.faction(), from.faction())).transit)
/* 293 */           return true; 
/* 294 */         return false;
/*     */       }
/*     */     };
/*     */   
/* 298 */   public static final Treaty FACTION_CAN_ATTACK = new Treaty()
/*     */     {
/*     */       public boolean can(Region origin, Region from, Region to, int tx, int ty, double dist)
/*     */       {
/* 302 */         if (origin == null)
/* 303 */           return false; 
/* 304 */         Faction o = origin.faction();
/* 305 */         if (o == null) {
/* 306 */           return false;
/*     */         }
/*     */         
/* 309 */         if (from == null) {
/* 310 */           return true;
/*     */         }
/* 312 */         if (from.faction() == null) {
/* 313 */           return false;
/*     */         }
/* 315 */         if (from.faction() == o) {
/* 316 */           return true;
/*     */         }
/*     */         
/* 319 */         if ((DIP.get(o, from.faction())).ally) {
/* 320 */           return true;
/*     */         }
/*     */         
/* 323 */         if (to == null) {
/* 324 */           return false;
/*     */         }
/* 326 */         if (to.faction() == null) {
/* 327 */           return false;
/*     */         }
/* 329 */         return (from.faction() == to.faction());
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 337 */   public static final Treaty FACTION_REACHABLE_NPC_TRADE = new Treaty()
/*     */     {
/*     */       public boolean can(Region origin, Region from, Region to, int tx, int ty, double dist)
/*     */       {
/* 341 */         if (origin == null)
/* 342 */           return false; 
/* 343 */         if (to == null)
/* 344 */           return true; 
/* 345 */         Faction o = origin.faction();
/*     */         
/* 347 */         if (o == null) {
/* 348 */           return (to.faction() == null);
/*     */         }
/*     */         
/* 351 */         if (to.faction() == null) {
/* 352 */           return !(from.faction() != null && from.faction() != o);
/*     */         }
/* 354 */         if (from.faction() == null || from.faction() == o) {
/* 355 */           return true;
/*     */         }
/*     */         
/* 358 */         if (from.faction() == origin.faction()) {
/* 359 */           return true;
/*     */         }
/* 361 */         if (from.faction() == to.faction()) {
/* 362 */           return true;
/*     */         }
/* 364 */         if (from.faction() == FACTIONS.player()) {
/* 365 */           return true;
/*     */         }
/*     */         
/* 368 */         return false;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 375 */   public static final Treaty FACTION_BORDERS = new Treaty()
/*     */     {
/*     */       public boolean can(Region origin, Region from, Region to, int tx, int ty, double dist)
/*     */       {
/* 379 */         if (origin == null)
/* 380 */           return false; 
/* 381 */         if (from == null) {
/* 382 */           return false;
/*     */         }
/* 384 */         if (to == null)
/* 385 */           return true; 
/* 386 */         if (from == to) {
/* 387 */           return true;
/*     */         }
/* 389 */         Faction o = origin.faction();
/* 390 */         if (from.faction() == o) {
/* 391 */           return true;
/*     */         }
/* 393 */         return false;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 400 */   public static final Treaty FACTION = new Treaty()
/*     */     {
/*     */       public boolean can(Region origin, Region from, Region to, int tx, int ty, double dist)
/*     */       {
/* 404 */         if (origin == null)
/* 405 */           return false; 
/* 406 */         if (from == null) {
/* 407 */           return false;
/*     */         }
/* 409 */         if (to == null)
/* 410 */           return true; 
/* 411 */         if (from == to) {
/* 412 */           return true;
/*     */         }
/* 414 */         Faction o = origin.faction();
/* 415 */         if (from.faction() == o && to.faction() == o) {
/* 416 */           return true;
/*     */         }
/* 418 */         return false;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 425 */   public static final Treaty DUMMY = new Treaty()
/*     */     {
/*     */       public boolean can(Region origin, Region from, Region to, int tx, int ty, double dist)
/*     */       {
/* 429 */         return true;
/*     */       }
/*     */     };
/*     */   
/*     */   public abstract boolean can(Region paramRegion1, Region paramRegion2, Region paramRegion3, int paramInt1, int paramInt2, double paramDouble);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\WRegFinder$Treaty.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */