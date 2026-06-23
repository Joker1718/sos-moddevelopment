/*     */ package settlement.stats.equip;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class HumanSprite
/*     */ {
/*     */   public final double offsetX;
/*     */   public final double offsetY;
/*     */   public final double animationX;
/*     */   public final double animationY;
/*     */   private TILE_SHEET sheet;
/* 171 */   public LIST<ColorImp> cols = (LIST<ColorImp>)new ArrayListGrower();
/*     */   
/*     */   private HumanSprite(Json json, KeyMap<TILE_SHEET> map) throws IOException {
/* 174 */     json = json.json("SPRITE");
/*     */     
/* 176 */     this.offsetX = json.d("OFFSET_X", -100.0D, 100.0D);
/* 177 */     this.offsetY = json.d("OFFSET_Y", -100.0D, 100.0D);
/* 178 */     this.animationX = json.d("ANIMATION_DX", -100.0D, 100.0D);
/* 179 */     this.animationY = json.d("ANIMATION_DY", -100.0D, 100.0D);
/*     */     
/* 181 */     String file = json.value("FILE");
/* 182 */     if (!map.containsKey(file)) {
/*     */       
/* 184 */       TILE_SHEET sheet = (new ComposerThings.ITileSheet(PATHS.SPRITE().getFolder("race").getFolder("battle").get(file), 132, 
/* 185 */           36)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 189 */             s.singles.init(0, 0, 1, 1, 2, 1, (ComposerDests.Dest)d.s24);
/* 190 */             s.singles.setSkip(0, 2).paste(3, true);
/* 191 */             return d.s24.saveGame();
/*     */           }
/* 193 */         }).get();
/* 194 */       map.put(file, sheet);
/*     */     } 
/*     */     
/* 197 */     this.sheet = (TILE_SHEET)map.get(file);
/* 198 */     this.cols = ColorImp.cols(json);
/*     */   }
/*     */   
/*     */   public void render(Induvidual a, SPRITE_RENDERER r, DIR dir, double forward, int x, int y, ShadowBatch s) {
/* 202 */     double am = EquipBattle.this.get(a);
/* 203 */     if (am == 0.0D) {
/*     */       return;
/*     */     }
/* 206 */     ColorImp.TMP.interpolate(this.cols, am / EquipBattle.this.max());
/* 207 */     ColorImp.TMP.bind();
/*     */     
/* 209 */     int t = dir.id();
/*     */     
/* 211 */     x += 48;
/* 212 */     y += 48;
/*     */ 
/*     */     
/* 215 */     double rotY = dir.xN() * this.offsetX + dir.yN() * this.offsetY;
/* 216 */     double rotX = -dir.yN() * this.offsetX + dir.xN() * this.offsetY;
/*     */     
/* 218 */     double aY = dir.xN() * this.animationX + dir.yN() * this.animationY;
/* 219 */     double aX = -dir.yN() * this.animationX + dir.xN() * this.animationY;
/*     */     
/* 221 */     int cx = (int)((rotX + aX * forward) * (a.race()).physics.hitBoxsize());
/* 222 */     int cy = (int)((rotY + aY * forward) * (a.race()).physics.hitBoxsize());
/*     */     
/* 224 */     this.sheet.renderC(r, t, x + cx, y + cy);
/* 225 */     s.setHeight(0).setDistance2Ground((a.race()).physics.height() / 2.0D);
/*     */     
/* 227 */     this.sheet.renderC((SPRITE_RENDERER)s, t, x + cx, y + cy);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\equip\EquipBattle$HumanSprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */