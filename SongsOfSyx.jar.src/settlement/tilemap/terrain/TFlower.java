/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.GrowableSprite;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.map.MAP_INTE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ public final class TFlower
/*     */   extends Terrain.TerrainTile
/*     */ {
/*  26 */   private static CharSequence ¤¤name = "Flower";
/*     */   private final GrowableSprite sprite;
/*     */   
/*     */   static {
/*  30 */     D.ts(TFlower.class);
/*     */   }
/*     */   
/*  33 */   private final TerrainClearing clearing = new TerrainClearing()
/*     */     {
/*  35 */       private final SoundRace sound = AUDIO.race("CLEAR");
/*     */ 
/*     */       
/*     */       public RESOURCE clear1(int tx, int ty) {
/*  39 */         TFlower.this.shared.NADA.placeFixed(tx, ty);
/*  40 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean can() {
/*  45 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public int clearAll(int tx, int ty) {
/*  50 */         TFlower.this.shared.NADA.placeFixed(tx, ty);
/*  51 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public SoundRace sound(int tx, int ty) {
/*  56 */         return this.sound;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isEasilyCleared() {
/*  61 */         return true;
/*     */       }
/*     */     };
/*     */   
/*     */   TFlower(Terrain t) throws IOException {
/*  66 */     super("FLOWER", t, ¤¤name, (SPRITE)(SPRITES.icons()).m.cancel, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 154 */     this.amount = new TAmount(16, "Flower")
/*     */       {
/*     */         public int get(int tile)
/*     */         {
/* 158 */           if (SETT.TERRAIN().get(tile) == TFlower.this) {
/* 159 */             return 1 + (TFlower.this.shared.data.get(tile) & 0xF);
/*     */           }
/* 161 */           return 0;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public MAP_INTE set(int tile, int value) {
/* 167 */           if (value == 0) {
/* 168 */             if (SETT.TERRAIN().get(tile) == TFlower.this)
/* 169 */               (SETT.TERRAIN()).NADA.placeFixed(tile % SETT.TWIDTH, tile / SETT.TWIDTH); 
/*     */           } else {
/* 171 */             if (SETT.TERRAIN().get(tile) != TFlower.this)
/* 172 */               TFlower.this.placeFixed(tile % SETT.TWIDTH, tile / SETT.TWIDTH); 
/* 173 */             TFlower.this.shared.data.set(tile, value - 1);
/*     */           } 
/* 175 */           return this;
/*     */         }
/*     */       };
/*     */     this.sprite = RESOURCES.growable().sprite("_Flower", 1.0D, 1.0D);
/*     */     this.sprite.trunk.sheight = 4.0D;
/*     */     this.sprite.trunk.sheightoverGround = 0.0D;
/*     */     this.sprite.trunk.setColors(null, (COLOR)new ColorImp(27, 90, 22), (COLOR)new ColorImp(19, 52, 15));
/*     */     this.sprite.growth.sheight = 0.0D;
/*     */     this.sprite.growth.sheightoverGround = 5.0D;
/*     */     this.sprite.growth.setColors(null, (COLOR)(new ColorImp(27, 90, 22)).shade(1.2D), null);
/*     */     for (int i = 0; i < this.sprite.growth.cripe.length; i++) {
/*     */       if (i % 4 == 0)
/*     */         this.sprite.growth.cripe[i] = new ColorImp(50 + RND.rInt(50), RND.rInt(25), 50 + RND.rInt(50)); 
/*     */     } 
/*     */     this.sprite.setPollenColor((COLOR)new ColorImp(110, 110, 100));
/*     */     this.sprite.makeSheet("_FLOWER");
/*     */   }
/*     */   
/*     */   public final TAmount amount;
/*     */   
/*     */   public TerrainClearing clearing() {
/*     */     return this.clearing;
/*     */   }
/*     */   
/*     */   protected boolean place(int tx, int ty) {
/*     */     if (!is(tx, ty)) {
/*     */       this.shared.data.set(tx, ty, 0);
/*     */       placeRaw(tx, ty);
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*     */     return false;
/*     */   }
/*     */   
/*     */   protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/*     */     double a = (data + 1) * this.amount.maxI;
/*     */     this.sprite.render(r, s, i, a, a);
/*     */     return false;
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i) {
/*     */     this.sprite.render(r, s, i, 1.0D, 1.0D);
/*     */   }
/*     */   
/*     */   public AVAILABILITY getAvailability(int x, int y) {
/*     */     return null;
/*     */   }
/*     */   
/*     */   public boolean isPlacable(int tx, int ty) {
/*     */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TFlower.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */