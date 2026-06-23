/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import game.time.TIME;
/*     */ import init.paths.PATHS;
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class TMushroom
/*     */   extends Terrain.TerrainTile
/*     */ {
/*     */   private final TILE_SHEET sheet;
/*     */   private static final int SET = 16;
/*     */   public static final double TARGET_FERTILITY = 0.55D;
/*     */   public static final double DELTA_FERTILITY = 0.25D;
/*  31 */   private static CharSequence ¤¤name = "¤Shrooms";
/*     */   
/*     */   static {
/*  34 */     D.ts(TMushroom.class);
/*     */   }
/*     */   
/*  37 */   private final TerrainClearing clearing = new TerrainClearing()
/*     */     {
/*  39 */       private final SoundRace sound = AUDIO.race("CLEAR_BUSH");
/*     */ 
/*     */       
/*     */       public RESOURCE clear1(int tx, int ty) {
/*  43 */         TMushroom.this.shared.NADA.placeFixed(tx, ty);
/*  44 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean can() {
/*  49 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public int clearAll(int tx, int ty) {
/*  54 */         TMushroom.this.shared.NADA.placeFixed(tx, ty);
/*  55 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public SoundRace sound(int tx, int ty) {
/*  60 */         return this.sound;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isEasilyCleared() {
/*  65 */         return true;
/*     */       }
/*     */     };
/*     */   
/*     */   TMushroom(Terrain t) throws IOException {
/*  70 */     super("MUSHROOM", t, ¤¤name, (SPRITE)(SPRITES.icons()).m.cancel, null);
/*  71 */     this.sheet = (new ComposerThings.ITileSheet(PATHS.SPRITE_SETTLEMENT_MAP().get("Mushroom"), 716, 94)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*  74 */           s.singles.init(0, 0, 1, 1, 16, 4, (ComposerDests.Dest)d.s16);
/*  75 */           s.singles.paste(true);
/*  76 */           return d.s16.saveGame();
/*     */         }
/*  78 */       }).get();
/*     */   }
/*     */ 
/*     */   
/*     */   public TerrainClearing clearing() {
/*  83 */     return this.clearing;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean place(int tx, int ty) {
/*  88 */     placeRaw(tx, ty);
/*  89 */     this.shared.data.set(tx, ty, RND.rInt(3));
/*  90 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*  96 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 104 */     if (TIME.seasons().current() == (TIME.seasons()).AUTUMN) {
/* 105 */       int x = i.x();
/* 106 */       int y = i.y();
/* 107 */       int t = i.ran() & 0xF;
/*     */       
/* 109 */       data = (int)Math.round((i.ran() >> 4 & 0x3) * TIME.seasons().bitPartOfC());
/* 110 */       t += data * 16;
/* 111 */       this.sheet.render(r, t, x, y);
/* 112 */       s.setDistance2Ground(0.0D).setHeight(2);
/* 113 */       this.sheet.render((SPRITE_RENDERER)s, t, x, y);
/* 114 */       i.countVegetation();
/*     */     } 
/*     */     
/* 117 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AVAILABILITY getAvailability(int x, int y) {
/* 124 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPlacable(int tx, int ty) {
/* 129 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TMushroom.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */