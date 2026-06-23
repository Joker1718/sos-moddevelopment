/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.game.SheetPair;
/*     */ import init.sprite.game.SheetType;
/*     */ import init.sprite.game.Sheets;
/*     */ import java.io.IOException;
/*     */ import java.util.Locale;
/*     */ import settlement.job.Job;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Errors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMAP;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TFence
/*     */   implements MAPPED
/*     */ {
/*     */   private final int index;
/*     */   private final String key;
/*     */   public final TFenceTile tile;
/*     */   
/*     */   static final RMAP<TFence> get(Terrain t) throws IOException {
/*  46 */     String KEY = "FENCE";
/*  47 */     String f = KEY.toLowerCase(Locale.ROOT);
/*  48 */     PATH data = PATHS.INIT_SETTLEMENT().getFolder(f);
/*  49 */     PATH text = PATHS.TEXT_SETTLEMENT().getFolder(f);
/*     */ 
/*     */     
/*  52 */     String[] keys = data.getFiles();
/*  53 */     ArrayList arrayList = new ArrayList(keys.length); byte b; int i;
/*     */     String[] arrayOfString1;
/*  55 */     for (i = (arrayOfString1 = keys).length, b = 0; b < i; ) { String key = arrayOfString1[b];
/*  56 */       Json da = new Json(data.gets(key));
/*  57 */       Json te = new Json(text.gets(key));
/*     */       
/*  59 */       final Sheets sSquare = new Sheets((SheetType)SheetType.sCombo, da.json("SPRITE_SQUARE_COMBO"));
/*  60 */       Sheets sRound = new Sheets((SheetType)SheetType.sCombo, da.json("SPRITE_ROUND_COMBO"));
/*     */ 
/*     */       
/*  63 */       SPRITE.Imp imp = new SPRITE.Imp(32)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  67 */             SheetPair da = sSquare.get(0);
/*  68 */             int z = CORE.renderer().getZoomout();
/*  69 */             CORE.renderer().setZoom(Integer.numberOfTrailingZeros(4));
/*  70 */             X1 *= 4;
/*  71 */             Y1 *= 4;
/*  72 */             int d = 64;
/*  73 */             da.s.render(da.d, X1, Y1, null, r, DIR.S.mask() | DIR.E.mask(), 0, 0.0D);
/*  74 */             da.s.render(da.d, X1 + d, Y1, null, r, DIR.S.mask() | DIR.W.mask(), 0, 0.0D);
/*  75 */             da.s.render(da.d, X1, Y1 + d, null, r, DIR.N.mask() | DIR.E.mask(), 0, 0.0D);
/*  76 */             da.s.render(da.d, X1 + d, Y1 + d, null, r, DIR.N.mask() | DIR.W.mask(), 0, 0.0D);
/*  77 */             CORE.renderer().setZoom(z);
/*     */           }
/*     */         };
/*     */       
/*     */       b++; }
/*     */     
/*  83 */     if (arrayList.size() > 16) {
/*  84 */       throw new Errors.GameError("Too many fences have been declared. Maximum is 16");
/*     */     }
/*     */     
/*  87 */     return new RMAP(KEY, (LIST)arrayList);
/*     */   }
/*     */   
/*     */   public static class TFenceTile
/*     */     extends Terrain.TerrainTile
/*     */     implements TDestroyed.TDestoryable, TerrainDiagonal.Diagonalizer
/*     */   {
/*  94 */     private final TerrainClearing clearing = new TerrainClearing()
/*     */       {
/*     */         public RESOURCE clear1(int tx, int ty)
/*     */         {
/*  98 */           TFence.TFenceTile.this.shared.NADA.placeFixed(tx, ty);
/*  99 */           return RND.oneIn(3) ? TFence.TFenceTile.this.resource : null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean can() {
/* 104 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public int clearAll(int tx, int ty) {
/* 109 */           TFence.TFenceTile.this.shared.NADA.placeFixed(tx, ty);
/* 110 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public SoundRace sound(int tx, int ty) {
/* 115 */           return TFence.TFenceTile.this.sound;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isEasilyCleared() {
/* 120 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isStructure() {
/* 125 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void destroy(int tx, int ty) {
/* 130 */           TFence.TFenceTile.this.shared.DESTROYED.place(tx, ty, TFence.TFenceTile.this, TFence.TFenceTile.this.getDia(tx, ty) ? 1 : 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public double strength() {
/* 135 */           return 640.0D;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*     */     private final SoundRace sound;
/*     */     
/*     */     public final COLOR miniColor;
/*     */     
/*     */     public final CharSequence name;
/*     */     
/*     */     public final CharSequence desc;
/*     */     private final Sheets sSquare;
/*     */     private final Sheets sRound;
/*     */     public final RESOURCE resource;
/*     */     public final int resAmount;
/* 151 */     private final int DIA = 256;
/*     */     public final TFence fence;
/*     */     
/*     */     TFenceTile(TFence fence, Terrain t, Json data, Json text, SPRITE icon, Sheets sSquare, Sheets sRound) throws IOException {
/* 155 */       super("FENCE_" + fence.key(), t, text.text("NAME"), icon, (COLOR)new ColorImp(data, "MINIMAP_COLOR"));
/* 156 */       this.sSquare = sSquare;
/* 157 */       this.sRound = sRound;
/* 158 */       this.miniColor = (COLOR)new ColorImp(data, "MINIMAP_COLOR");
/* 159 */       this.name = text.text("NAME");
/* 160 */       this.desc = text.text("DESC");
/* 161 */       this.resource = (RESOURCE)RESOURCES.map().read(data);
/* 162 */       this.resAmount = data.i("RESOURCE_AMOUNT");
/* 163 */       this.sound = AUDIO.race("BUILD_FENCE_" + fence.key);
/* 164 */       this.fence = fence;
/*     */     }
/*     */ 
/*     */     
/*     */     public TerrainClearing clearing() {
/* 169 */       return this.clearing;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean place(int tx, int ty) {
/* 176 */       boolean dia = (this.shared.get(tx, ty) instanceof TerrainDiagonal.Diagonalizer && ((TerrainDiagonal.Diagonalizer)this.shared.get(tx, ty)).getDia(tx, ty));
/*     */       
/* 178 */       int res = 0;
/* 179 */       Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 180 */       if (r != null) {
/* 181 */         for (DIR d : DIR.ORTHO) {
/* 182 */           if (is(tx, ty, d)) {
/* 183 */             Room r2 = (Room)(SETT.ROOMS()).map.get(tx, ty, d);
/* 184 */             if (r2 == null || r2 == r)
/* 185 */               res |= d.mask(); 
/*     */           } 
/*     */         } 
/*     */       } else {
/* 189 */         for (DIR d : DIR.ORTHO) {
/* 190 */           if (is(tx, ty, d))
/* 191 */             res |= d.mask(); 
/*     */         } 
/*     */       } 
/* 194 */       placeRaw(tx, ty);
/* 195 */       this.shared.data.set(tx, ty, res);
/* 196 */       setDia(tx, ty, dia);
/*     */       
/* 198 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 204 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 210 */       Sheets sh = this.sSquare;
/*     */       
/* 212 */       if ((data & 0x100) != 0) {
/* 213 */         sh = this.sRound;
/*     */       }
/*     */       
/* 216 */       int k = data >> 4 & 0xF;
/* 217 */       SheetPair sheet = sh.get(i.ran());
/* 218 */       if (sheet == null)
/* 219 */         return false; 
/* 220 */       sheet.d.color(k).bind();
/* 221 */       int ran = i.ran();
/*     */       
/* 223 */       int tile = SheetType.sCombo.tile(this.sSquare.get(0), data & 0xF, 0, 0);
/*     */       
/* 225 */       sheet.s.render(sheet.d, i.x(), i.y(), i, r, tile, ran, 0.0D);
/* 226 */       COLOR.unbind();
/* 227 */       if (s != null)
/* 228 */         sheet.s.renderShadow(sheet.d, i.x(), i.y(), i, s, tile, ran); 
/* 229 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public AVAILABILITY getAvailability(int x, int y) {
/* 235 */       return AVAILABILITY.SOLID;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isPlacable(int tx, int ty) {
/* 240 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public int miniDepth() {
/* 245 */       return 2;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setDia(int tx, int ty, boolean dia) {
/* 250 */       if (is(tx, ty)) {
/* 251 */         int d = this.shared.data.get(tx, ty);
/* 252 */         if (dia) {
/* 253 */           d |= 0x100;
/*     */         } else {
/* 255 */           d &= 0xFFFFFEFF;
/* 256 */         }  this.shared.data.set(tx, ty, d);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean getDia(int tx, int ty) {
/* 263 */       if (is(tx, ty)) {
/* 264 */         return ((this.shared.data.get(tx, ty) & 0x100) != 0);
/*     */       }
/* 266 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Job fixJob() {
/* 271 */       return (Job)(SETT.JOBS()).fences.get(this.fence.index());
/*     */     }
/*     */ 
/*     */     
/*     */     public int resAmount() {
/* 276 */       return 2;
/*     */     }
/*     */ 
/*     */     
/*     */     public RESOURCE breakableRes() {
/* 281 */       return this.resource;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean wantsFloorUnderneath(int tx, int ty) {
/* 286 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TFence(String key, Terrain t, LISTE<TFence> all, Json data, Json text, SPRITE icon, Sheets sSquare, Sheets sRound) throws IOException {
/* 296 */     this.key = key;
/* 297 */     this.index = all.add(this);
/* 298 */     this.tile = new TFenceTile(this, t, data, text, icon, sSquare, sRound);
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 303 */     return this.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public String key() {
/* 308 */     return this.key;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TFence.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */