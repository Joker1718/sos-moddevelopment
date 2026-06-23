/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import init.paths.PATHS;
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.game.SheetPair;
/*     */ import init.sprite.game.SheetType;
/*     */ import java.io.IOException;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TDecor
/*     */   extends Terrain.TerrainTile
/*     */ {
/*     */   private final LIST<SheetPair> sheets;
/*  26 */   private final TerrainClearing clearing = new TerrainClearing()
/*     */     {
/*  28 */       private final SoundRace sound = AUDIO.race("CLEAR");
/*     */ 
/*     */       
/*     */       public RESOURCE clear1(int tx, int ty) {
/*  32 */         TDecor.this.shared.NADA.placeFixed(tx, ty);
/*  33 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean can() {
/*  38 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public int clearAll(int tx, int ty) {
/*  43 */         TDecor.this.shared.NADA.placeFixed(tx, ty);
/*  44 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public SoundRace sound(int tx, int ty) {
/*  49 */         return this.sound;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isEasilyCleared() {
/*  54 */         return true;
/*     */       }
/*     */     };
/*     */   
/*     */   TDecor(Terrain t, CharSequence name, String sKey) throws IOException {
/*  59 */     super("DECORD_" + sKey, t, name, (SPRITE)(SPRITES.icons()).m.cancel, null);
/*  60 */     this.sheets = SPRITES.GAME().sheets((SheetType)SheetType.s1x1, (new Json((PATHS.CONFIG()).init.gets("SETT_MAP_DECORATION"))).json(sKey));
/*     */   }
/*     */ 
/*     */   
/*     */   public TerrainClearing clearing() {
/*  65 */     return this.clearing;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean place(int tx, int ty) {
/*  70 */     placeRaw(tx, ty);
/*  71 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*  77 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, int data) {
/*  83 */     if (this.sheets.size() == 0) {
/*  84 */       return false;
/*     */     }
/*  86 */     int ran = it.ran();
/*  87 */     SheetPair sheet = (SheetPair)this.sheets.getC(ran);
/*  88 */     if (sheet == null)
/*  89 */       return false; 
/*  90 */     ran >>= 5;
/*  91 */     sheet.d.color(ran).bind();
/*  92 */     ran >>= 4;
/*     */     
/*  94 */     int frame = sheet.d.frame(ran, 1.0D);
/*  95 */     int tile = SheetType.s1x1.tile(sheet.s, sheet.d, 0, frame, ran & 0x3);
/*     */     
/*  97 */     sheet.s.render(sheet.d, it.x(), it.y(), it, r, tile, ran, 0.0D);
/*  98 */     COLOR.unbind();
/*  99 */     if (s != null)
/* 100 */       sheet.s.renderShadow(sheet.d, it.x(), it.y(), it, s, tile, ran); 
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AVAILABILITY getAvailability(int x, int y) {
/* 108 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPlacable(int tx, int ty) {
/* 113 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TDecor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */