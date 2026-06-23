/*     */ package world.map.regions.centre;
/*     */ 
/*     */ import init.paths.PATH;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import world.WRenContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class WallSteriods
/*     */ {
/*     */   private static final int VARS = 5;
/*     */   private final Size[] sizes;
/*     */   public final COLOR color;
/*     */   public static final int maxSize = 4;
/*     */   private final int sh;
/* 194 */   private final SPRITE_RENDERER[] rens = new SPRITE_RENDERER[2];
/*     */   
/*     */   public WallSteriods(int shadow, String t, PATH getter, Json json) throws IOException {
/* 197 */     String f = json.value(t);
/* 198 */     String k = "WALL_" + f;
/* 199 */     this.sh = shadow;
/* 200 */     this.color = (COLOR)new ColorImp(json, t + "_COLOR");
/* 201 */     if (WorldRaceSheet.mapW.containsKey(k)) {
/* 202 */       this.sizes = ((WallSteriods)WorldRaceSheet.mapW.get(k)).sizes;
/*     */       return;
/*     */     } 
/* 205 */     this.sizes = new Size[5];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 216 */     for (int i = 0; i < 5; i++)
/* 217 */       this.sizes[i] = new Size(i); 
/* 218 */     WorldRaceSheet.mapW.put(k, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(WRenContext con, double size, int dim, int cx, int cy) {
/* 225 */     this.color.bind();
/* 226 */     con.s.setHard();
/* 227 */     con.s.setHeight(this.sh).setDistance2Ground(0.0D);
/*     */     
/* 229 */     this.rens[0] = con.r;
/* 230 */     this.rens[1] = (SPRITE_RENDERER)con.s;
/* 231 */     Size s = this.sizes[CLAMP.i((int)Math.round(size * 5.0D - 1.0D), 0, 4)];
/*     */     
/* 233 */     int dd = 32;
/* 234 */     int x1 = cx - dim;
/* 235 */     int y1 = cy - dim;
/* 236 */     dim = dim * 2 - dd;
/* 237 */     int x2 = x1 + dim;
/* 238 */     int y2 = y1 + dim;
/* 239 */     for (int i = 0; i < this.rens.length; i++) {
/* 240 */       SPRITE_RENDERER r = this.rens[i];
/*     */       
/* 242 */       int off = i * 8;
/* 243 */       double am = (dim - dd * 3.0D) / (dd * 2);
/*     */       
/* 245 */       for (int k = 0; k <= am; k++) {
/*     */         
/* 247 */         int kk = dd + k * dd;
/*     */ 
/*     */         
/* 250 */         s.walls.render(r, 0 + off, x1 + kk, y1);
/* 251 */         s.walls.render(r, 1 + off, x2 - kk, y1);
/*     */         
/* 253 */         s.walls.render(r, 2 + off, x1, y1 + kk);
/* 254 */         s.walls.render(r, 3 + off, x2, y1 + kk);
/*     */         
/* 256 */         s.walls.render(r, 4 + off, x1, y2 - kk);
/* 257 */         s.walls.render(r, 5 + off, x2, y2 - kk);
/*     */         
/* 259 */         s.walls.render(r, 6 + off, x1 + kk, y2);
/* 260 */         s.walls.render(r, 7 + off, x2 - kk, y2);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 268 */       off = i * 4;
/* 269 */       s.corners.render(r, 0 + off, x1, y1);
/* 270 */       s.corners.render(r, 1 + off, x2, y1);
/* 271 */       s.corners.render(r, 2 + off, x1, y2);
/* 272 */       s.corners.render(r, 3 + off, x2, y2);
/*     */ 
/*     */       
/* 275 */       off = i * 8;
/* 276 */       s.gate.render(r, 0 + off, cx - dd, y1);
/* 277 */       s.gate.render(r, 1 + off, cx, y1);
/* 278 */       s.gate.render(r, 2 + off, x1, cy - dd);
/* 279 */       s.gate.render(r, 3 + off, x1, cy);
/* 280 */       s.gate.render(r, 4 + off, x2, cy - dd);
/* 281 */       s.gate.render(r, 5 + off, x2, cy);
/* 282 */       s.gate.render(r, 6 + off, cx - dd, y2);
/* 283 */       s.gate.render(r, 7 + off, cx, y2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Size
/*     */   {
/* 304 */     private final TILE_SHEET corners = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 308 */           ComposerSources.Full f = s.full;
/* 309 */           for (int i = 0; i <= 1; i++) {
/* 310 */             f.setVar(var + 5 * i);
/* 311 */             f.setSkip(1, 0).paste(true);
/* 312 */             f.setSkip(1, 5).paste(true);
/* 313 */             f.setSkip(1, 30).paste(true);
/* 314 */             f.setSkip(1, 35).paste(true);
/*     */           } 
/*     */           
/* 317 */           return d.s8.saveGame();
/*     */         }
/* 320 */       }).get();
/*     */     
/* 322 */     private final TILE_SHEET gate = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 326 */           ComposerSources.Full f = s.full;
/* 327 */           for (int i = 0; i <= 1; i++) {
/* 328 */             f.setVar(var + 5 * i);
/* 329 */             f.setSkip(1, 2).paste(true);
/* 330 */             f.setSkip(1, 3).paste(true);
/* 331 */             f.setSkip(1, 12).paste(true);
/* 332 */             f.setSkip(1, 18).paste(true);
/* 333 */             f.setSkip(1, 17).paste(true);
/* 334 */             f.setSkip(1, 23).paste(true);
/* 335 */             f.setSkip(1, 32).paste(true);
/* 336 */             f.setSkip(1, 33).paste(true);
/*     */           } 
/*     */           
/* 339 */           return d.s8.saveGame();
/*     */         }
/* 342 */       }).get();
/*     */     
/* 344 */     private final TILE_SHEET walls = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 348 */           ComposerSources.Full f = s.full;
/* 349 */           for (int i = 0; i <= 1; i++) {
/* 350 */             f.setVar(var + 5 * i);
/* 351 */             f.setSkip(1, 1).paste(true);
/* 352 */             f.setSkip(1, 4).paste(true);
/* 353 */             f.setSkip(1, 6).paste(true);
/* 354 */             f.setSkip(1, 11).paste(true);
/* 355 */             f.setSkip(1, 24).paste(true);
/* 356 */             f.setSkip(1, 29).paste(true);
/* 357 */             f.setSkip(1, 31).paste(true);
/* 358 */             f.setSkip(1, 34).paste(true);
/*     */           } 
/*     */           
/* 361 */           return d.s8.saveGame();
/*     */         }
/* 364 */       }).get();
/*     */     
/*     */     Size(final int var) throws IOException {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\centre\WorldRaceSheet$WallSteriods.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */