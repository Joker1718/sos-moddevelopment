/*     */ package init.resources;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GrowableGroup
/*     */   extends ResGroup<Growable>
/*     */ {
/*     */   private final KeyMap<TILE_SHEET> sheetMap;
/*     */   
/*     */   GrowableGroup(KeyMap<TILE_SHEET> sheetMap, ArrayList<Growable> res) {
/*  95 */     super("GROWABLE", (LIST<Growable>)res);
/*  96 */     this.sheetMap = sheetMap;
/*     */   }
/*     */ 
/*     */   
/*     */   public GrowableSprite sprite(String ssheet, double wind, double pollen) throws IOException {
/* 101 */     return new GrowableSprite(ssheet, wind, pollen, this.sheetMap);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\Growable$GrowableGroup.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */