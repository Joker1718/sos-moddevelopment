/*     */ package world.map.road;
/*     */ 
/*     */ import game.GAME;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import world.WORLD;
/*     */ 
/*     */ public class WTRAV
/*     */ {
/*     */   public static final int PORT_PENALTY = 10;
/*     */   
/*     */   public static boolean can(int fromX, int fromY, DIR d, boolean roaded) {
/*  15 */     if (!d.isOrtho() && (WORLD.REGIONS()).map.get(fromX, fromY) != (WORLD.REGIONS()).map.get(fromX + d.x(), fromY + d.y())) {
/*  16 */       return false;
/*     */     }
/*  18 */     TravTile from = get(fromX, fromY, roaded);
/*  19 */     int toX = fromX + d.x();
/*  20 */     int toY = fromY + d.y();
/*  21 */     TravTile to = get(toX, toY, roaded);
/*  22 */     return (from.isPossible(fromX, fromY, toX, toY, to, d, roaded) && to.isPossible(toX, toY, fromX, fromY, from, d.perpendicular(), roaded));
/*     */   }
/*     */   
/*     */   public static boolean canLand(int fromX, int fromY, DIR d, boolean roaded) {
/*  26 */     if (!can(fromX, fromY, d, roaded))
/*  27 */       return false; 
/*  28 */     int toX = fromX + d.x();
/*  29 */     int toY = fromY + d.y();
/*     */     
/*  31 */     if ((WORLD.WATER()).isBig.is(fromX, fromY) && (WORLD.WATER()).isBig.is(toX, toY))
/*  32 */       return false; 
/*  33 */     return true;
/*     */   }
/*     */   
/*     */   public static int cost(int fromX, int fromY, DIR d) {
/*  37 */     if ((WORLD.WATER()).isBig.is(fromX, fromY)) {
/*  38 */       return 1;
/*     */     }
/*  40 */     int toX = fromX + d.x();
/*  41 */     int toY = fromY + d.y();
/*  42 */     if ((WORLD.WATER()).isBig.is(toX, toY)) {
/*  43 */       return 20;
/*     */     }
/*  45 */     if (WORLD.MOUNTAIN().coversTile(fromX, fromY))
/*  46 */       return 12; 
/*  47 */     if ((WORLD.FOREST()).amount.get(fromX, fromY) == 1.0D)
/*  48 */       return 4; 
/*  49 */     return 3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isHarbour(int tx, int ty) {
/*  55 */     return (get(tx, ty, false) == HARBOUR);
/*     */   }
/*     */   
/*     */   public static boolean isGoodLandTile(int tx, int ty) {
/*  59 */     return LAND.isPossible(tx, ty, false);
/*     */   }
/*     */   
/*     */   static abstract class TravTile
/*     */   {
/*     */     public final String name;
/*     */     
/*     */     TravTile(String name) {
/*  67 */       this.name = name;
/*     */     }
/*     */ 
/*     */     
/*     */     public abstract boolean isPossible(int param1Int1, int param1Int2, boolean param1Boolean);
/*     */     
/*     */     public int extraCost(TravTile to) {
/*  74 */       return 0;
/*     */     }
/*     */     public abstract boolean isPossible(int param1Int1, int param1Int2, int param1Int3, int param1Int4, TravTile param1TravTile, DIR param1DIR, boolean param1Boolean);
/*     */     public abstract void road(int param1Int1, int param1Int2, int param1Int3, int param1Int4, TravTile param1TravTile, DIR param1DIR); }
/*     */   
/*     */   static void makeRoad(PathTile dest) {
/*  80 */     PathTile t = dest;
/*  81 */     PathTile from = null;
/*     */     
/*  83 */     while (t != null) {
/*     */ 
/*     */ 
/*     */       
/*  87 */       if ((WORLD.ROADS()).placable.is((COORDINATE)t))
/*     */       {
/*  89 */         if ((WORLD.WATER()).isBig.is((COORDINATE)t)) {
/*  90 */           if ((from != null && !(WORLD.WATER()).isBig.is((COORDINATE)from)) || (t.getParent() != null && !(WORLD.WATER()).isBig.is((COORDINATE)t.getParent()))) {
/*  91 */             boolean bridge = false;
/*  92 */             if (!WORLD.ROADS().is((COORDINATE)t) && (WORLD.ROADS()).canBridge.is((COORDINATE)t) && from != null && t.getParent() != null && 
/*  93 */               !(WORLD.WATER()).isBig.is((COORDINATE)from) && !(WORLD.WATER()).isBig.is((COORDINATE)t.getParent())) {
/*  94 */               bridge = true;
/*     */             }
/*     */ 
/*     */             
/*  98 */             WORLD.ROADS().set((COORDINATE)t, true);
/*  99 */             if (bridge) {
/* 100 */               (WORLD.ROADS()).bridge.set((COORDINATE)t, true);
/*     */             }
/*     */           } 
/*     */         } else {
/* 104 */           WORLD.ROADS().set((COORDINATE)t, true);
/* 105 */           if (from != null) {
/* 106 */             DIR d = DIR.get((COORDINATE)from, (COORDINATE)t);
/*     */ 
/*     */             
/* 109 */             if (!d.isOrtho()) {
/* 110 */               DIR d1 = d.next(-1);
/* 111 */               DIR d2 = d.next(1);
/* 112 */               if (!LAND.isPossible(from.x() + d1.x(), from.y() + d1.y(), false) || !WORLD.ROADS().is((COORDINATE)from, d1))
/*     */               {
/* 114 */                 if (!LAND.isPossible(from.x() + d2.x(), from.y() + d2.y(), false) || !WORLD.ROADS().is((COORDINATE)from, d2))
/*     */                 {
/* 116 */                   if (LAND.isPossible(from.x() + d1.x(), from.y() + d1.y(), false)) {
/* 117 */                     WORLD.ROADS().set((COORDINATE)from, d1, true);
/* 118 */                   } else if (LAND.isPossible(from.x() + d2.x(), from.y() + d2.y(), false)) {
/* 119 */                     WORLD.ROADS().set((COORDINATE)from, d2, true);
/*     */                   } 
/*     */                 }
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 130 */       from = t;
/* 131 */       t = t.getParent();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 138 */     checkProblem(dest);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void checkProblem(PathTile dest) {
/* 144 */     PathTile to = dest;
/*     */     
/* 146 */     boolean problem = false;
/* 147 */     while (to.getParent() != null) {
/*     */       
/* 149 */       PathTile from = to;
/* 150 */       to = to.getParent();
/*     */       
/* 152 */       if (!can(from.x(), from.y(), DIR.get((COORDINATE)from, (COORDINATE)to), true)) {
/* 153 */         if (!problem) {
/*     */           
/* 155 */           TravTile ff = get(from.x(), from.y(), true);
/* 156 */           TravTile tt = get(to.x(), to.y(), true);
/* 157 */           GAME.Notify("here " + ff.name + " " + tt.name);
/* 158 */           problem = true;
/*     */         } 
/*     */         
/* 161 */         LOG.ln(String.valueOf(from) + " -> " + String.valueOf(from) + " (" + String.valueOf(to) + ")");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static int extracost(int fromX, int fromY, DIR d) {
/* 168 */     TravTile from = get(fromX, fromY, false);
/* 169 */     int toX = fromX + d.x();
/* 170 */     int toY = fromY + d.y();
/* 171 */     TravTile to = get(toX, toY, false);
/* 172 */     return from.extraCost(to);
/*     */   }
/*     */   
/*     */   static TravTile get(int tx, int ty, boolean roaded) {
/* 176 */     if (!WORLD.IN_BOUNDS(tx, ty))
/* 177 */       return NOTHING; 
/* 178 */     if (LAND.isPossible(tx, ty, roaded))
/* 179 */       return LAND; 
/* 180 */     if (HARBOUR.isPossible(tx, ty, roaded))
/* 181 */       return HARBOUR; 
/* 182 */     if (WATER.isPossible(tx, ty, roaded))
/* 183 */       return WATER; 
/* 184 */     return NOTHING;
/*     */   }
/*     */   
/* 187 */   static final TravTile LAND = new TravTile("Land")
/*     */     {
/*     */       public boolean isPossible(int fromX, int fromY, int tx, int ty, WTRAV.TravTile to, DIR d, boolean roaded)
/*     */       {
/* 191 */         if (!isPossible(fromX, fromY, roaded))
/* 192 */           return false; 
/* 193 */         if (to == WTRAV.LAND) {
/* 194 */           if (!WTRAV.LAND.isPossible(tx, ty, roaded))
/* 195 */             return false; 
/* 196 */           if (!d.isOrtho()) {
/* 197 */             if (isPossible(fromX, ty, false) && isPossible(tx, fromY, false)) {
/* 198 */               if (roaded)
/* 199 */                 return !(!isPossible(fromX, ty, true) && !isPossible(tx, fromY, true)); 
/* 200 */               return true;
/*     */             } 
/* 202 */             return false;
/*     */           } 
/* 204 */           return true;
/* 205 */         }  if (to == WTRAV.HARBOUR) {
/* 206 */           return (d.isOrtho() && WTRAV.HARBOUR.isPossible(tx, ty, roaded));
/*     */         }
/* 208 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isPossible(int tx, int ty, boolean roaded) {
/* 213 */         if (!WORLD.IN_BOUNDS(tx, ty))
/* 214 */           return false; 
/* 215 */         if (WORLD.MOUNTAIN().coversTile(tx, ty))
/* 216 */           return false; 
/* 217 */         if ((WORLD.WATER()).isBig.is(tx, ty)) {
/* 218 */           return false;
/*     */         }
/* 220 */         if (roaded && (!WORLD.ROADS().is(tx, ty) || (WORLD.ROADS()).minified.is(tx, ty)))
/* 221 */           return false; 
/* 222 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public int extraCost(WTRAV.TravTile to) {
/* 227 */         if (to == WTRAV.HARBOUR)
/* 228 */           return 10; 
/* 229 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public void road(int fromX, int fromY, int tx, int ty, WTRAV.TravTile to, DIR d) {
/* 234 */         if (to == WTRAV.LAND || to == WTRAV.HARBOUR) {
/* 235 */           WORLD.ROADS().set(fromX, fromY, true);
/* 236 */           WORLD.ROADS().set(tx, ty, true);
/* 237 */           if (!d.isOrtho()) {
/* 238 */             if (isPossible(tx, fromY, true))
/*     */               return; 
/* 240 */             if (isPossible(fromX, ty, true)) {
/*     */               return;
/*     */             }
/* 243 */             if (isPossible(tx, fromY, false) && (WORLD.REGIONS()).map.get(tx, fromY) == (WORLD.REGIONS()).map.get(fromX, fromY)) {
/* 244 */               WORLD.ROADS().set(tx, fromY, true);
/* 245 */             } else if (isPossible(fromX, ty, false)) {
/* 246 */               WORLD.ROADS().set(fromX, ty, true);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/* 255 */   static final TravTile HARBOUR = new TravTile("Harbour")
/*     */     {
/*     */ 
/*     */       
/*     */       public boolean isPossible(int fromX, int fromY, int tx, int ty, WTRAV.TravTile to, DIR d, boolean roaded)
/*     */       {
/* 261 */         if (!isPossible(fromX, fromY, roaded))
/* 262 */           return false; 
/* 263 */         if (to == WTRAV.LAND) {
/* 264 */           if (!d.isOrtho())
/* 265 */             return false; 
/* 266 */           return WTRAV.LAND.isPossible(tx, ty, roaded);
/*     */         } 
/* 268 */         if (to == WTRAV.WATER || to == this)
/* 269 */           return true; 
/* 270 */         if (roaded && WORLD.ROADS().is(fromX, fromY)) {
/* 271 */           return (to == WTRAV.LAND);
/*     */         }
/* 273 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isPossible(int tx, int ty, boolean roaded) {
/* 278 */         if ((WORLD.WATER()).isBig.is(tx, ty) && canBe(tx, ty)) {
/* 279 */           if (roaded)
/* 280 */             return WORLD.ROADS().is(tx, ty); 
/* 281 */           return true;
/*     */         } 
/* 283 */         return false;
/*     */       }
/*     */       
/*     */       private boolean canBe(int tx, int ty) {
/* 287 */         if (WORLD.MOUNTAIN().coversTile(tx, ty))
/* 288 */           return false; 
/* 289 */         if ((WORLD.WATER()).isBig.is(tx, ty)) {
/* 290 */           return !(!ok(tx, ty, DIR.N) && !ok(tx, ty, DIR.E));
/*     */         }
/* 292 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       private boolean ok(int tx, int ty, DIR d) {
/* 297 */         return ((WORLD.WATER()).isBig.is(tx, ty, d) && (WORLD.WATER()).isBig.is(tx, ty, d.perpendicular()) && (!(WORLD.WATER()).isBig.is(tx, ty, d.next(2)) || !(WORLD.WATER()).isBig.is(tx, ty, d.perpendicular().next(2))));
/*     */       }
/*     */ 
/*     */       
/*     */       public void road(int fromX, int fromY, int tx, int ty, WTRAV.TravTile to, DIR d) {
/* 302 */         if (to == WTRAV.LAND) {
/* 303 */           WORLD.ROADS().set(fromX, fromY, true);
/*     */         }
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 311 */   static final TravTile WATER = new TravTile("Water")
/*     */     {
/*     */       public boolean isPossible(int fromX, int fromY, int tx, int ty, WTRAV.TravTile to, DIR d, boolean roaded)
/*     */       {
/* 315 */         if (!isPossible(fromX, fromY, roaded))
/* 316 */           return false; 
/* 317 */         if (to == WTRAV.HARBOUR) {
/* 318 */           if (!WTRAV.HARBOUR.isPossible(tx, ty, roaded))
/* 319 */             return false; 
/* 320 */           if (!d.isOrtho()) {
/* 321 */             return ((WORLD.WATER()).isBig.is(fromX, ty) && (WORLD.WATER()).isBig.is(tx, fromY));
/*     */           }
/* 323 */           return true;
/* 324 */         }  if (to == WTRAV.WATER) {
/* 325 */           if (!WTRAV.WATER.isPossible(tx, ty, roaded))
/* 326 */             return false; 
/* 327 */           if (!d.isOrtho()) {
/* 328 */             return ((WORLD.WATER()).isBig.is(fromX, ty) && (WORLD.WATER()).isBig.is(tx, fromY));
/*     */           }
/* 330 */           return true;
/*     */         } 
/* 332 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isPossible(int tx, int ty, boolean roaded) {
/* 337 */         return (WORLD.WATER()).isBig.is(tx, ty);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void road(int fromX, int fromY, int tx, int ty, WTRAV.TravTile to, DIR d) {}
/*     */     };
/*     */ 
/*     */ 
/*     */   
/* 347 */   static final TravTile NOTHING = new TravTile("Nothing")
/*     */     {
/*     */       public boolean isPossible(int fromX, int fromY, int tx, int ty, WTRAV.TravTile to, DIR d, boolean roaded)
/*     */       {
/* 351 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isPossible(int tx, int ty, boolean roaded) {
/* 356 */         return false;
/*     */       }
/*     */       
/*     */       public void road(int fromX, int fromY, int tx, int ty, WTRAV.TravTile to, DIR d) {}
/*     */     };
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\WTRAV.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */