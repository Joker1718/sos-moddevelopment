/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import init.paths.PATHS;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
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
/*     */ public final class TRock
/*     */   extends Terrain.TerrainTile
/*     */ {
/*     */   private final TILE_SHEET sheet;
/*  36 */   public final int MAX_AMOUNT = 15;
/*     */   
/*     */   private static final int SET = 16;
/*  39 */   private final TerrainClearing clearing = new TerrainClearing()
/*     */     {
/*  41 */       private final SoundRace sound = AUDIO.race("CLEAR_STONE");
/*     */ 
/*     */       
/*     */       public RESOURCE clear1(int tx, int ty) {
/*  45 */         TRock.this.amountDecrease(tx, ty);
/*  46 */         return RESOURCES.STONE();
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean can() {
/*  51 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public int clearAll(int tx, int ty) {
/*  56 */         int a = TRock.this.amountGet(TRock.this.shared.data.get(tx, ty));
/*  57 */         TRock.this.shared.NADA.placeFixed(tx, ty);
/*  58 */         return a;
/*     */       }
/*     */ 
/*     */       
/*     */       public SoundRace sound(int tx, int ty) {
/*  63 */         return this.sound;
/*     */       }
/*     */     };
/*     */   
/*     */   private final SPRITE icon;
/*     */   
/*     */   TRock(Terrain t) throws IOException {
/*  70 */     super("ROCK", t, "rock", (SPRITE)(SPRITES.icons()).m.cancel, t.colors.minimap.rock);
/*  71 */     this.sheet = (new ComposerThings.ITileSheet(PATHS.SPRITE_SETTLEMENT_MAP().get("Rock"), 716, 182)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*  74 */           ComposerDests.Tile t = d.s16;
/*  75 */           s.singles.init(0, 0, 1, 1, 16, 8, (ComposerDests.Dest)t);
/*     */           
/*  77 */           for (int i = 0; i < 8; i++)
/*  78 */             s.singles.setSkip(i * 16, 16).paste(true); 
/*  79 */           return t.saveGame();
/*     */         }
/*  81 */       }).get();
/*     */     
/*  83 */     this.icon = (SPRITE)new SPRITE.Imp(32)
/*     */       {
/*  85 */         private COLOR bg = (COLOR)new ColorImp(102, 87, 65);
/*  86 */         private COLOR bg2 = (COLOR)this.bg.shade(0.6D);
/*     */ 
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/*  91 */           this.bg2.render(r, X1, X2, Y1, Y2);
/*  92 */           this.bg.render(r, X1 + 2, X2 - 2, Y1 + 2, Y2 - 2);
/*     */           
/*  94 */           int x = X1 + 4;
/*  95 */           int y = Y1 + 4;
/*  96 */           int dd = 8;
/*  97 */           int w = 16;
/*     */ 
/*     */ 
/*     */           
/* 101 */           TRock.this.sheet.render(r, 19, x, x + w, y, y + w);
/*     */           
/* 103 */           int tile = 32;
/* 104 */           TRock.this.sheet.render(r, tile, x + dd, x + dd + w, y, y + w);
/*     */           
/* 106 */           tile = 33;
/* 107 */           TRock.this.sheet.render(r, tile, x, x + w, y + dd, y + dd + w);
/*     */           
/* 109 */           tile = 34;
/* 110 */           TRock.this.sheet.render(r, tile, x + dd, x + dd + w, y + dd, y + dd + w);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/* 118 */     return this.icon;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TerrainClearing clearing() {
/* 124 */     return this.clearing;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean place(int tx, int ty) {
/* 129 */     if (!is(tx, ty)) {
/* 130 */       this.shared.data.set(tx, ty, 0);
/* 131 */       setCode(tx, ty);
/* 132 */       return true;
/*     */     } 
/* 134 */     int ro = this.shared.data.get(tx, ty);
/* 135 */     setCode(tx, ty);
/* 136 */     return (ro != this.shared.data.get(tx, ty));
/*     */   }
/*     */ 
/*     */   
/*     */   private void setCode(int x, int y) {
/* 141 */     int am = 0;
/* 142 */     if (is(x, y))
/* 143 */       am = amountGet(this.shared.data.get(x, y)); 
/* 144 */     placeRaw(x, y);
/*     */     
/* 146 */     if (am == 0) {
/* 147 */       am = 1;
/*     */     }
/* 149 */     this.shared.data.set(x, y, 0);
/* 150 */     amoutSet(x, y, am);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 158 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 164 */     int x = i.x();
/* 165 */     int y = i.y();
/* 166 */     int ran = i.ran() & 0xF;
/* 167 */     int a = amountGet(data);
/*     */ 
/*     */     
/* 170 */     s.setHeight(1).setDistance2Ground(0.0D);
/*     */ 
/*     */     
/* 173 */     if (a >= 5) {
/*     */ 
/*     */       
/* 176 */       if (a >= 5) {
/* 177 */         ran = i.ran() >> 2 & 0xF;
/* 178 */         int j = 32 + ran;
/* 179 */         this.sheet.render(r, j, x + 32, y);
/* 180 */         this.sheet.render((SPRITE_RENDERER)s, j, x + 32, y);
/* 181 */         a -= 5;
/* 182 */       } else if (a > 0) {
/* 183 */         ran = i.ran() >> 2 & 0xF;
/* 184 */         int j = (7 - a % 7) * 16 + ran;
/* 185 */         this.sheet.render(r, j, x + 32, y);
/* 186 */         this.sheet.render((SPRITE_RENDERER)s, j, x + 32, y);
/*     */       } 
/*     */       
/* 189 */       if (a >= 5) {
/* 190 */         ran = i.ran() >> 1 & 0xF;
/* 191 */         int j = 32 + ran;
/* 192 */         this.sheet.render(r, j, x, y + 32);
/* 193 */         this.sheet.render((SPRITE_RENDERER)s, j, x, y + 32);
/* 194 */         a -= 5;
/* 195 */       } else if (a > 0) {
/* 196 */         ran = i.ran() >> 1 & 0xF;
/* 197 */         int j = (7 - a % 7) * 16 + ran;
/* 198 */         this.sheet.render(r, j, x, y + 32);
/* 199 */         this.sheet.render((SPRITE_RENDERER)s, j, x, y + 32);
/*     */       } 
/*     */       
/* 202 */       if (a >= 5) {
/* 203 */         ran = i.ran() & 0xF;
/* 204 */         int j = 32 + ran;
/* 205 */         this.sheet.render(r, j, x + 32, y + 32);
/* 206 */         this.sheet.render((SPRITE_RENDERER)s, j, x + 32, y + 32);
/* 207 */         a -= 5;
/* 208 */       } else if (a > 0) {
/* 209 */         ran = i.ran() & 0xF;
/* 210 */         int j = (7 - a % 7) * 16 + ran;
/* 211 */         this.sheet.render(r, j, x + 32, y + 32);
/* 212 */         this.sheet.render((SPRITE_RENDERER)s, j, x + 32, y + 32);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 219 */     a = amountGet(data);
/*     */ 
/*     */     
/* 222 */     int tile = a >> 3;
/* 223 */     if (tile > 7)
/* 224 */       tile = 7; 
/* 225 */     tile = (7 - tile) * 16 + ran;
/* 226 */     this.sheet.render(r, tile, x, y);
/* 227 */     this.sheet.render((SPRITE_RENDERER)s, tile, x, y);
/*     */ 
/*     */     
/* 230 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AVAILABILITY getAvailability(int x, int y) {
/* 239 */     return AVAILABILITY.PENALTY2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPlacable(int tx, int ty) {
/* 244 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void placeAmount(int tx, int ty, double amount) {
/* 249 */     int a = (int)Math.ceil(15.0D * amount);
/* 250 */     if (a < 1)
/* 251 */       a = 1; 
/* 252 */     if (a > 15)
/* 253 */       a = 15; 
/* 254 */     placeRaw(tx, ty);
/* 255 */     amoutSet(tx, ty, a);
/*     */   }
/*     */   
/*     */   public void amountIncrease(int tx, int ty) {
/* 259 */     if (is(tx, ty)) {
/* 260 */       int a = amountGet(this.shared.data.get(tx, ty));
/* 261 */       amoutSet(tx, ty, a + 1);
/*     */     } 
/* 263 */     placeFixed(tx, ty);
/*     */   }
/*     */   
/*     */   public void amountDecrease(int tx, int ty) {
/* 267 */     if (!is(tx, ty))
/*     */       return; 
/* 269 */     int a = amountGet(this.shared.data.get(tx, ty));
/* 270 */     if (a > 1) {
/* 271 */       amoutSet(tx, ty, a - 1);
/* 272 */       placeFixed(tx, ty);
/*     */     } else {
/* 274 */       this.shared.NADA.placeFixed(tx, ty);
/*     */     } 
/*     */   }
/*     */   private int amountGet(int data) {
/* 278 */     return (data & 0x3F00) >> 8;
/*     */   }
/*     */   
/*     */   public int amountGet(int tx, int ty) {
/* 282 */     if (!is(tx, ty))
/* 283 */       return 0; 
/* 284 */     return amountGet(this.shared.data.get(tx, ty)) / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   private void amoutSet(int tx, int ty, int a) {
/* 289 */     if (a < 0)
/* 290 */       a = 0; 
/* 291 */     if (a > 15)
/* 292 */       a = 15; 
/* 293 */     a <<= 8;
/* 294 */     int d = this.shared.data.get(tx, ty);
/* 295 */     d &= 0xFFFFC0FF;
/* 296 */     d |= a;
/* 297 */     this.shared.data.set(tx, ty, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfo(GBox box, int tx, int ty) {
/* 302 */     box.add((SPRITE)RESOURCES.STONE().icon());
/* 303 */     box.textLL((RESOURCES.STONE()).name);
/* 304 */     super.hoverInfo(box, tx, ty);
/* 305 */     int d = amountGet(tx, ty);
/* 306 */     box.tab(6);
/* 307 */     box.add((SPRITE)GFORMAT.i(box.text(), d));
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
/*     */   public COLOR miniC(int x, int y) {
/* 321 */     return super.miniC(x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public int miniDepth() {
/* 326 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public COLOR miniColorPimped(ColorImp c, int x, int y, boolean northern, boolean southern) {
/* 331 */     COLOR col = (SETT.GROUND()).minimap.miniC(x, y);
/* 332 */     c.interpolate(col, this.miniC, 0.5D + 0.5D * amountGet(this.shared.data.get(x + y * SETT.TWIDTH)) / 15.0D);
/* 333 */     return (COLOR)c;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TRock.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */