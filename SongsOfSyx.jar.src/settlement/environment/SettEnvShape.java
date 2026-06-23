/*     */ package settlement.environment;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ public final class SettEnvShape
/*     */   extends SettEnvMap.Updatable
/*     */ {
/*     */   public final LIST<Type> all;
/*     */   public final Type round;
/*     */   public final Type square;
/*  27 */   public final double radius = 10.0D;
/*     */ 
/*     */   
/*  30 */   public static CharSequence ¤¤name = "Shape";
/*  31 */   private static CharSequence ¤¤square = "Squareness";
/*  32 */   private static CharSequence ¤¤round = "Roundness"; MAP_BOOLEAN wall;
/*     */   static {
/*  34 */     D.ts(SettEnvShape.class);
/*     */   }
/*     */   
/*     */   SettEnvShape(LISTE<SettEnvMap.Updatable> all) {
/*  38 */     super(all);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 217 */     this.wall = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 221 */           Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/*     */           
/* 223 */           if (t.clearing().isStructure() && t.getAvailability(tx, ty) != null && (t.getAvailability(tx, ty)).player < 0.0D) {
/* 224 */             return true;
/*     */           }
/*     */           
/* 227 */           return false;
/*     */         }
/*     */         
/*     */         public boolean is(int tile)
/*     */         {
/* 232 */           int tx = tile % SETT.TWIDTH;
/* 233 */           int ty = tile / SETT.TWIDTH;
/* 234 */           return is(tx, ty); } }; this.round = new Type("ROUND", ¤¤round, (SPRITE)(UI.icons()).l.dia)
/*     */       {
/*     */         protected boolean isBase(int tx, int ty, DIR dd) { if (dd.isOrtho()) return false;  DIR d = dd.next(2); DIR t = SettEnvShape.this.getWallDIR(tx + d.x(), ty + d.y()); if (t != null && !t.isOrtho()) return true;  d = dd.next(-2); t = SettEnvShape.this.getWallDIR(tx + d.x(), ty + d.y()); if (t != null && !t.isOrtho()) return true;  return false; }
/*     */       }; this.square = new Type("SQUARE", ¤¤square, (SPRITE)(UI.icons()).l.square)
/*     */       {
/*     */         private final DIR[] dir = new DIR[] { DIR.N, DIR.E }; protected boolean isBase(int tx, int ty, DIR dd) { byte b; int i; DIR[] arrayOfDIR; for (i = (arrayOfDIR = this.dir).length, b = 0; b < i; ) { DIR d = arrayOfDIR[b]; if (test(tx, ty, d, dd) && test(tx, ty, d.perpendicular(), dd)) return true;  b++; }  return false; } private boolean test(int tx, int ty, DIR d, DIR dd) { for (int i = 1; i < 3; i++) { if (SettEnvShape.this.getWallDIR(tx + d.x() * i, ty + d.y() * i) != dd) return false;  }  return true; }
/*     */       }; this.all = (LIST<Type>)new ArrayList((Object[])new Type[] { this.round, this.square });
/*     */   } protected void update(RECTANGLE bounds, RECTANGLE area) { for (COORDINATE c : area) { for (Type t : this.all) t.set(c, false);  }  for (COORDINATE c : bounds) GUTIL.flooder().setValue2(c, -1.0D);  for (int ti = 0; ti < this.all.size(); ti++) { GUTIL.flooder().init(this); for (COORDINATE c : bounds) { DIR d = getWallDIR(c.x(), c.y()); if (d != null && ((Type)this.all.get(ti)).isBase(c.x(), c.y(), d) && GUTIL.flooder().getValue2(c.x(), c.y()) == -1.0F) GUTIL.flooder().pushSloppy(c, 0.0D);  }  while (GUTIL.flooder().hasMore()) { PathTile t = GUTIL.flooder().pollSmallest(); if (!bounds.holdsPoint((COORDINATE)t)) continue;  if (t.getValue() > 10.0F) continue;  if (this.wall.is((COORDINATE)t)) continue;  if (t.getValue2() != -1.0F) continue;  t.setValue2(ti); if (area.holdsPoint((COORDINATE)t)) ((Type)this.all.get(ti)).set((COORDINATE)t, true);  for (DIR d : DIR.ALL) { int dx = t.x() + d.x(); int dy = t.y() + d.y(); if (SETT.IN_BOUNDS(dx, dy)) GUTIL.flooder().pushSmaller(dx, dy, t.getValue() + d.tileDistance());  }  }  GUTIL.flooder().done(); }  } public boolean isBase(int tx, int ty) { DIR d = getWallDIR(tx, ty); if (d != null) for (Type t : this.all) { if (t.isBase(tx, ty, d)) return true;  }   return false; } public DIR getWallDIR(int tx, int ty) { if (this.wall.is(tx, ty)) return null;  if (!SETT.IN_BOUNDS(tx, ty)) return null;  DIR res = null; for (int i = 0; i < DIR.ORTHO.size(); i++) { DIR d = (DIR)DIR.ORTHO.get(i); if (isWallMask(tx, ty, d)) { if (!isWallMask(tx, ty, d.next(2)) && !isWallMask(tx, ty, d.next(-2))) return d;  if (isWallMask(tx, ty, d.next(-2)) && isWallMask(tx, ty, d.next(-1)))
/*     */           return d.next(-1);  if (isWallMask(tx, ty, d.next(2)) && isWallMask(tx, ty, d.next(1)))
/*     */           return d.next(1);  return null; }  }  return res; } private boolean isWallMask(int tx, int ty, DIR d) { int dx = tx + d.x(); int dy = ty + d.y(); if (!SETT.IN_BOUNDS(dx, dy))
/*     */       return false;  Terrain.TerrainTile t = SETT.TERRAIN().get(dx, dy); if (t.clearing().isStructure() && t.getAvailability(dx, dy) != null && (t.getAvailability(dx, dy)).player < 0.0D)
/* 245 */       return true;  return false; } public static abstract class Type extends Bitmap2D { Type(String key, CharSequence name, SPRITE icon) { super((DIMENSION)SETT.TILE_BOUNDS, false);
/* 246 */       this.key = key;
/* 247 */       this.name = name;
/* 248 */       this.icon = icon; }
/*     */     
/*     */     public final CharSequence name;
/*     */     public final SPRITE icon;
/*     */     public final String key;
/*     */     
/*     */     protected abstract boolean isBase(int param1Int1, int param1Int2, DIR param1DIR); }
/*     */   
/*     */   public double getBaseValue(int tx, int ty) {
/* 257 */     return (isBase(tx, ty) ? true : false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean has(int tx, int ty) {
/* 262 */     return !(!this.round.is(tx, ty) && !this.square.is(tx, ty));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 267 */     for (Type t : this.all)
/* 268 */       t.clear(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\environment\SettEnvShape.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */