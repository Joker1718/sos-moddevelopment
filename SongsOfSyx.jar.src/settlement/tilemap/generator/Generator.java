/*     */ package settlement.tilemap.generator;
/*     */ 
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.CapitolArea;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AvailabilityListener;
/*     */ import settlement.tilemap.TileMap;
/*     */ import settlement.tilemap.floor.TGrowth;
/*     */ import settlement.tilemap.terrain.TGrowable;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Generator
/*     */ {
/*  25 */   private static CharSequence ¤¤Generating = "Generating"; private int printI;
/*     */   static {
/*  27 */     D.ts(Generator.class);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Generator(CapitolArea area) {
/* 147 */     this.printI = 0; AvailabilityListener.listenAll(false); SPRITES.loader().print(¤¤Generating); TileMap m = SETT.TILE_MAP(); GeneratorUtil util = new GeneratorUtil(); print("fertilizing"); LinkedList<COORDINATE> caves = new LinkedList(); print("mountainizing"); print("making caves"); print("Generating Rivers"); print("filling lakes"); print("filling oceans"); if (!area.isBattle); SPRITES.loader().print("fish..."); print("mineralizing"); print("fertilizing"); SPRITES.loader().print("fertilizing again..."); print("planting seeds"); if (!area.isBattle); for (COORDINATE c : SETT.TILE_BOUNDS) { if ((SETT.TERRAIN()).NADA.is(c) && (SETT.MINERALS()).amountInt.get(c) == 0) { TGrowth.Grower g = (SETT.TILE_MAP()).growth.type(c.x(), c.y()); if (g != null) { double a = (SETT.TILE_MAP()).growth.growMaxAmount(c.x(), c.y(), g); if (a > 0.0D) { g.setRoots(c.x(), c.y(), a); Terrain.TerrainTile t = (Terrain.TerrainTile)SETT.TERRAIN().get(c); if (t instanceof TGrowable) { TGrowable gg = (TGrowable)t; gg.resource.set(c, gg.size.get(c)); }  }  }  }  }  print("roads"); int y; for (y = 0; y < SETT.THEIGHT; y++) { for (int x = 0; x < SETT.TWIDTH; x++) { if ((SETT.TERRAIN()).NADA.is(x, y) && !(SETT.TERRAIN()).WATER.groundWater.is(x, y) && !(SETT.TERRAIN()).WATER.groundWaterSalt.is(x, y))
/*     */           if ((SETT.GROUND()).MOISTURE_BASE.get(x, y) + 0.5D + (SETT.ENV()).map.WATER_SWEET.get(x, y) > 0.2D) { if (RND.oneIn(50))
/*     */               (SETT.TERRAIN()).DECOR_MID.placeRaw(x, y);  } else if (RND.oneIn(200)) { (SETT.TERRAIN()).DECOR_NO.placeRaw(x, y); }   }  }  print("polishing.."); for (y = 0; y < SETT.THEIGHT; y++) { for (int x = 0; x < SETT.TWIDTH; x++) { m.topology.get(x, y).placeFixed(x, y); (SETT.PATH()).availability.updateAvailability(x, y); }
/*     */        }
/* 151 */      print("painting minimap..."); paintMinimap(); AvailabilityListener.listenAll(true); } private void print(String debug) { String s = String.valueOf(¤¤Generating);
/* 152 */     for (int i = 0; i < this.printI; i++)
/* 153 */       s = s + "."; 
/* 154 */     if ((S.get()).developer || (S.get()).debug) {
/* 155 */       s = s + " " + s;
/*     */     }
/* 157 */     this.printI++;
/* 158 */     this.printI %= 6;
/* 159 */     SPRITES.loader().print(s); }
/*     */ 
/*     */   
/*     */   public static void paintMinimap() {
/* 163 */     byte[] cs = Alloc.bb(SETT.TWIDTH * SETT.TWIDTH * 4);
/* 164 */     for (int y = 0; y < SETT.TWIDTH; y++) {
/* 165 */       for (int x = 0; x < SETT.TWIDTH; x++) {
/*     */         
/* 167 */         int i = (y * SETT.TWIDTH + x) * 4;
/*     */         
/* 169 */         COLOR c = SETT.TILE_MAP().miniC(x, y);
/*     */ 
/*     */         
/* 172 */         cs[i + 0] = c.red();
/* 173 */         cs[i + 1] = c.green();
/* 174 */         cs[i + 2] = c.blue();
/* 175 */         cs[i + 3] = -1;
/*     */       } 
/*     */     } 
/* 178 */     SETT.MINIMAP().putPixels(cs);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\Generator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */