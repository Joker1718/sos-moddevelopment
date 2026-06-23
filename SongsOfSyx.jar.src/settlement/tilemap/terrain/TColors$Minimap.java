/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Json;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Minimap
/*     */ {
/*     */   public final COLOR tree;
/*     */   public final COLOR water;
/*     */   public final COLOR water_deep;
/*     */   public final COLOR rock;
/*     */   public final COLOR growable;
/*     */   public final COLOR mountain;
/*     */   
/*     */   private Minimap(Json j) throws IOException {
/* 161 */     j = j.json("MINIMAP");
/* 162 */     this.tree = (COLOR)(new ColorImp(j, "TREE")).shadeSelf(2.0D);
/* 163 */     this.water = (COLOR)(new ColorImp(j, "WATER")).shadeSelf(2.0D);
/* 164 */     this.water_deep = (COLOR)(new ColorImp(j, "WATER_DEEP")).shadeSelf(2.0D);
/* 165 */     this.rock = (COLOR)(new ColorImp(j, "ROCK")).shadeSelf(2.0D);
/* 166 */     this.growable = (COLOR)(new ColorImp(j, "GROWABLE")).shadeSelf(2.0D);
/* 167 */     this.mountain = (COLOR)(new ColorImp(j, "MOUNTAIN")).shadeSelf(2.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TColors$Minimap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */